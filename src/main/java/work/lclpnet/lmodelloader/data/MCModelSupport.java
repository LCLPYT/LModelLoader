package work.lclpnet.lmodelloader.data;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.vector.Vector3f;
import work.lclpnet.lmodelloader.asm.type.IConstructData;

public class MCModelSupport {

	public static <E extends Entity> LModel convertMCModelToLMF(SegmentedModel<E> model, String modelName, Vector3f initialTranslation) {
		List<LModelRenderer> renderers = new ArrayList<>();

		model.getParts().forEach(mr -> renderers.add(convertModelRenderer(mr)));

		LModel lmf = new LModel(modelName, renderers, initialTranslation);
		return lmf;
	}

	private static LModelRenderer convertModelRenderer(ModelRenderer mr) {
		List<Cube> cubes = new ArrayList<>();
		mr.cubeList.forEach(mb -> {
			try {
				IConstructData data = IConstructData.cast(mb);
				cubes.add(data.getConstructData().copy());
			} catch (ClassCastException e) {
				throw new IllegalStateException("Mixins have not been applied.");
			}
		});
		
		List<LModelRenderer> children = new ArrayList<>();
		mr.childModels.forEach(child -> children.add(convertModelRenderer(child)));
		
		Vector3f rotationPoint = new Vector3f(mr.rotationPointX, mr.rotationPointY, mr.rotationPointZ);
		Vector3f rotation = new Vector3f(mr.rotateAngleX, mr.rotateAngleY, mr.rotateAngleZ);
		
		LModelRenderer lmr = new LModelRenderer("Entity Part", cubes, children, rotationPoint, rotation, mr.showModel);
		return lmr;
	}
	

}

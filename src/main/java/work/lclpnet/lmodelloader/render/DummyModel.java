package work.lclpnet.lmodelloader.render;

import java.util.Arrays;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import work.lclpnet.lmodelloader.entity.DummyEntity;

public class DummyModel extends SegmentedModel<DummyEntity> {

	public ModelRenderer main;
	
	public DummyModel() {
		add();
	}
	
	@Override
	public Iterable<ModelRenderer> getParts() {
		return Arrays.asList(main);
	}

	@Override
	public void setRotationAngles(DummyEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		add();
//		System.out.println(LModelSerializer.toJson(MCModelSupport.convertMCModelToLMF(this, "dummy", DefaultTranslations.LIVING)));
	}
	
	public void add() {
		textureHeight = 64;
		textureWidth = 64;
		
		main = new ModelRenderer(this, 0, 0);
		main.addBox(0F, -1F, 0F, 1.0F, 1.0F, 0.5F, 0.0F);
		main.setRotationPoint(0F, 24F, 0F);
//		main.rotateAngleY = ((float)Math.PI / 4F);
	}
	
}

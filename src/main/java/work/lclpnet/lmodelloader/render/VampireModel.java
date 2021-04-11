package work.lclpnet.lmodelloader.render;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import work.lclpnet.lmodelloader.LModelLoader;
import work.lclpnet.lmodelloader.entity.VampireEntity;

public class VampireModel extends AnimatedGeoModel<VampireEntity> {

	@Override
	public ResourceLocation getAnimationFileLocation(VampireEntity animatable) {
		return new ResourceLocation(LModelLoader.MODID, "animations/vampire.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(VampireEntity object) {
		return new ResourceLocation(LModelLoader.MODID, "geo/vampire.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(VampireEntity object) {
		return new ResourceLocation(LModelLoader.MODID, "textures/entity/vampire.png");
	}

}

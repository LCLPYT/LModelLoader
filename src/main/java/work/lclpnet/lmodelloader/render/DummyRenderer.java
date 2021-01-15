package work.lclpnet.lmodelloader.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import work.lclpnet.lmodelloader.LModelLoader;
import work.lclpnet.lmodelloader.entity.DummyEntity;

public class DummyRenderer extends MobRenderer<DummyEntity, DummyModel>{

	public DummyRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new DummyModel(), 0.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(DummyEntity entity) {
		return new ResourceLocation(LModelLoader.MODID, "textures/entity/dummy.png");
	}
	
}

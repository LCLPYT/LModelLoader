package work.lclpnet.lmodelloader.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import work.lclpnet.lmodelloader.entity.VampireEntity;

public class VampireRenderer extends GeoEntityRenderer<VampireEntity> {

	protected VampireRenderer(EntityRendererManager renderManager) {
		super(renderManager, new VampireModel());
		this.shadowSize = 0.7F;
	}

}

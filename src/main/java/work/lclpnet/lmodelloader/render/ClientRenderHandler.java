package work.lclpnet.lmodelloader.render;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import work.lclpnet.lmodelloader.entity.LModelEntities;

@OnlyIn(Dist.CLIENT)
public class ClientRenderHandler {

	public static void setup() {
		RenderingRegistry.registerEntityRenderingHandler(LModelEntities.DUMMY, DummyRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(LModelEntities.VAMPIRE, VampireRenderer::new);
	}
	
}

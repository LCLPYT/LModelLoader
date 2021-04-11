package work.lclpnet.lmodelloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.renderer.entity.model.RavagerModel;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;
import work.lclpnet.lmodelloader.data.DefaultTranslations;
import work.lclpnet.lmodelloader.data.LModel;
import work.lclpnet.lmodelloader.data.LModelSerializer;
import work.lclpnet.lmodelloader.data.MCModelSupport;
import work.lclpnet.lmodelloader.entity.LModelEntities;
import work.lclpnet.lmodelloader.render.ClientRenderHandler;

@Mod(LModelLoader.MODID)
public class LModelLoader {

	public static final String MODID = "lmodelloader";
	private static final Logger LOGGER = LogManager.getLogger();
	
	public LModelLoader() {
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		modBus.addListener(this::setup);
		modBus.addListener(this::clientSetup);
		
		IEventBus bus = MinecraftForge.EVENT_BUS;
		bus.register(this);
		
		GeckoLib.initialize();
	}
	
	private void setup(final FMLCommonSetupEvent event) { //preinit
		LModelEntities.registerEntityTypeAttributes();
		
		LOGGER.info("LModelLoader initialized.");
	}
	
	@OnlyIn(Dist.CLIENT)
	private void clientSetup(final FMLClientSetupEvent event) {
		ClientRenderHandler.setup();
		
		try {
			saveModel("ravager", new RavagerModel(), DefaultTranslations.LIVING);
		} catch (IOException e) {
			IllegalStateException ex = new IllegalStateException("unexpected");
			ex.addSuppressed(e);
			throw ex;
		}
	}

	private void saveModel(String name, SegmentedModel<?> model, Vector3f initialTranslation) throws IOException {
		LModel lmf = MCModelSupport.convertMCModelToLMF(model, name, initialTranslation);
		String json = LModelSerializer.toJson(lmf);
		System.out.println(json);
		
		File file = new File("savedmodels", URLEncoder.encode(name, "UTF-8") + ".json");
		
		file.getParentFile().mkdirs();
		
		try (OutputStream out = new FileOutputStream(file)) {
			out.write(json.getBytes(StandardCharsets.UTF_8));
		}
	}
	
}

package work.lclpnet.lmodelloader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.renderer.entity.model.CreeperModel;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import work.lclpnet.lmodelloader.data.LModel;
import work.lclpnet.lmodelloader.data.LModelSerializer;
import work.lclpnet.lmodelloader.data.MCModelSupport;

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
	}
	
	private void setup(final FMLCommonSetupEvent event) { //preinit
		LOGGER.info("LModelLoader initialized.");
	}
	
	@OnlyIn(Dist.CLIENT)
	private void clientSetup(final FMLClientSetupEvent event) {
		CreeperModel<CreeperEntity> model = new CreeperModel<>();
		LModel lmf = MCModelSupport.convertMCModelToLMF(model, "Creeper");
		System.out.println(LModelSerializer.toJson(lmf));
	}
	
}

package work.lclpnet.lmodelloader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LModelLoader.MODID)
public class LModelLoader {

	public static final String MODID = "lmodelloader";
	private static final Logger LOGGER = LogManager.getLogger();
	
	public LModelLoader() {
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		modBus.addListener(this::setup);
		
		IEventBus bus = MinecraftForge.EVENT_BUS;
		bus.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) { //preinit
		LOGGER.info("LModelLoader initialized.");
	}
	
}

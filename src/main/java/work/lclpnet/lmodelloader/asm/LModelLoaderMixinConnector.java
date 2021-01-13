package work.lclpnet.lmodelloader.asm;

import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;

public class LModelLoaderMixinConnector implements IMixinConnector {

	@Override
	public void connect() {
		System.out.println("Invoking LModelLoader Mixin Connectors...");
		Mixins.addConfiguration("mixins.lmodelloader.json");
	}
	
}

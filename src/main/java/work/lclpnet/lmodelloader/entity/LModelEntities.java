package work.lclpnet.lmodelloader.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import work.lclpnet.lmodelloader.LModelLoader;

@EventBusSubscriber(bus = Bus.MOD, modid = LModelLoader.MODID)
public class LModelEntities {

	private static final List<EntityType<?>> ENTITY_TYPES = new ArrayList<>();

	public static final EntityType<DummyEntity> DUMMY = register("lmodelloader:dummy", DummyEntity::new, 1F, 1F);
	public static final EntityType<VampireEntity> VAMPIRE = register("lmodelloader:vampire", VampireEntity::new, 1F, 2F);
	
	private static <T extends Entity> EntityType<T> register(String name, Function<World, T> function, float width, float height) {
		EntityType<T> type = EntityType.Builder.<T>create((entityType, world) -> function.apply(world), EntityClassification.CREATURE).size(width, height).setCustomClientFactory((spawnEntity, world) -> function.apply(world)).build(name);
		type.setRegistryName(name);
		ENTITY_TYPES.add(type);
		return type;
	}

	@SubscribeEvent
	public static void registerTypes(final RegistryEvent.Register<EntityType<?>> event) {
		ENTITY_TYPES.forEach(event.getRegistry()::register);
		ENTITY_TYPES.clear();
	}
	
    public static void registerEntityTypeAttributes() {
        GlobalEntityTypeAttributes.put(DUMMY, DummyEntity.prepareAttributes().create());
        GlobalEntityTypeAttributes.put(VAMPIRE, VampireEntity.prepareAttributes().create());
    }
	
}

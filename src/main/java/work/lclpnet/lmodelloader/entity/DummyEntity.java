package work.lclpnet.lmodelloader.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class DummyEntity extends CreatureEntity {

	public DummyEntity(World worldIn) {
		super(LModelEntities.DUMMY, worldIn);
	}

	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	protected int getExperiencePoints(PlayerEntity player) {
		return 1 + this.world.rand.nextInt(2);
	}


	public static AttributeModifierMap.MutableAttribute prepareAttributes() {
		return MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 8D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.7D)
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 48D);
	}

}

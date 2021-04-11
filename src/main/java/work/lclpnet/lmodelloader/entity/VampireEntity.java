package work.lclpnet.lmodelloader.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class VampireEntity extends CreatureEntity implements IAnimatable {

	private AnimationFactory factory = new AnimationFactory(this);
	
	protected VampireEntity(World worldIn) {
		super(LModelEntities.VAMPIRE, worldIn);
		this.ignoreFrustumCheck = true;
	}

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.vampire.nod", true));
		return PlayState.CONTINUE;
	}
	
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<IAnimatable>(this, "controller", 0F, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
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

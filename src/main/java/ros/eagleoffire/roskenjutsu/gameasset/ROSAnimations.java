package ros.eagleoffire.roskenjutsu.gameasset;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import ros.eagleoffire.roskenjutsu.ROSKenjutsu;
import yesman.epicfight.api.animation.AnimationManager.AnimationBuilder;
import yesman.epicfight.api.animation.AnimationManager.AnimationRegistryEvent;
import yesman.epicfight.api.animation.AnimationManager.AnimationAccessor;
import yesman.epicfight.api.animation.property.AnimationProperty.AttackAnimationProperty;
import yesman.epicfight.api.animation.types.BasicAttackAnimation;
import yesman.epicfight.gameasset.Armatures;

@Mod.EventBusSubscriber(modid = ROSKenjutsu.MODID, bus = Bus.MOD)
public class ROSAnimations {
    public static AnimationAccessor<BasicAttackAnimation> KATANA_AUTO1;

    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event){
        event.newBuilder(ROSKenjutsu.MODID, ROSAnimations::build);
    }

    public static void build(AnimationBuilder builder){
        //TODO change frame value
		KATANA_AUTO1 = builder.nextAccessor("biped/combat/katana_auto1", (accessor) ->
			new BasicAttackAnimation(0.05F, 0.15F, 0.25F, 0.3F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
				.addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.0F));
    }
}

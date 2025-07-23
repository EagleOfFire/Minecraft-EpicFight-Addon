package ros.eagleoffire.roskenjutsu.world.capabilities.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ros.eagleoffire.roskenjutsu.ROSKenjutsu;
import ros.eagleoffire.roskenjutsu.gameasset.ROSColliderPreset;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.skill.SkillDataKeys;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.CapabilityItem.WeaponCategories;
import yesman.epicfight.world.capabilities.item.CapabilityItem.Styles;
import yesman.epicfight.world.capabilities.item.WeaponCapability;
import ros.eagleoffire.roskenjutsu.gameasset.ROSAnimations;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = ROSKenjutsu.MODID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class ROSWeaponCapabilityPresets {
	public static final Function<Item, CapabilityItem.Builder> KATANA = (item) -> {
		CapabilityItem.Builder builder = WeaponCapability.builder()
				.category(WeaponCategories.UCHIGATANA)
				.styleProvider((entitypatch) -> {
					if (entitypatch instanceof PlayerPatch<?> playerpatch && (playerpatch.getSkill(SkillSlots.WEAPON_PASSIVE).getDataManager().hasData(SkillDataKeys.SHEATH.get()) &&
							playerpatch.getSkill(SkillSlots.WEAPON_PASSIVE).getDataManager().getDataValue(SkillDataKeys.SHEATH.get()))) {
						return Styles.SHEATH;
					}
					return Styles.TWO_HAND;
				})
				.passiveSkill(EpicFightSkills.BATTOJUTSU_PASSIVE)
				.collider(ROSColliderPreset.KATANA)
				.hitSound(EpicFightSounds.BLADE_HIT.get())
				.canBePlacedOffhand(false)
				.newStyleCombo(Styles.SHEATH, ROSAnimations.KATANA_AUTO1, Animations.UCHIGATANA_SHEATHING_DASH, Animations.UCHIGATANA_SHEATH_AIR_SLASH)
				.newStyleCombo(Styles.TWO_HAND, ROSAnimations.KATANA_AUTO1, Animations.UCHIGATANA_DASH, Animations.UCHIGATANA_AIR_SLASH)
				.newStyleCombo(Styles.MOUNT, Animations.SWORD_MOUNT_ATTACK)
				.innateSkill(Styles.SHEATH, (itemstack) -> EpicFightSkills.BATTOJUTSU)
				.innateSkill(Styles.TWO_HAND, (itemstack) -> EpicFightSkills.BATTOJUTSU)
				.comboCancel((style) -> {
					return false;
				})
				.livingMotionModifier(Styles.TWO_HAND, LivingMotions.IDLE, Animations.BIPED_HOLD_UCHIGATANA)
				.livingMotionModifier(Styles.TWO_HAND, LivingMotions.KNEEL, Animations.BIPED_HOLD_UCHIGATANA)
				.livingMotionModifier(Styles.TWO_HAND, LivingMotions.WALK, Animations.BIPED_WALK_UCHIGATANA)
				.livingMotionModifier(Styles.TWO_HAND, LivingMotions.CHASE, Animations.BIPED_WALK_UCHIGATANA)
				.livingMotionModifier(Styles.TWO_HAND, LivingMotions.RUN, Animations.BIPED_RUN_UCHIGATANA)
				.livingMotionModifier(Styles.TWO_HAND, LivingMotions.SNEAK, Animations.BIPED_WALK_UCHIGATANA)
				.livingMotionModifier(Styles.TWO_HAND, LivingMotions.SWIM, Animations.BIPED_HOLD_UCHIGATANA)
				.livingMotionModifier(Styles.TWO_HAND, LivingMotions.FLOAT, Animations.BIPED_HOLD_UCHIGATANA)
				.livingMotionModifier(Styles.TWO_HAND, LivingMotions.FALL, Animations.BIPED_HOLD_UCHIGATANA)
				.livingMotionModifier(Styles.SHEATH, LivingMotions.IDLE, Animations.BIPED_HOLD_UCHIGATANA_SHEATHING)
				.livingMotionModifier(Styles.SHEATH, LivingMotions.KNEEL, Animations.BIPED_HOLD_UCHIGATANA_SHEATHING)
				.livingMotionModifier(Styles.SHEATH, LivingMotions.WALK, Animations.BIPED_WALK_UCHIGATANA_SHEATHING)
				.livingMotionModifier(Styles.SHEATH, LivingMotions.CHASE, Animations.BIPED_HOLD_UCHIGATANA_SHEATHING)
				.livingMotionModifier(Styles.SHEATH, LivingMotions.RUN, Animations.BIPED_RUN_UCHIGATANA_SHEATHING)
				.livingMotionModifier(Styles.SHEATH, LivingMotions.SNEAK, Animations.BIPED_HOLD_UCHIGATANA_SHEATHING)
				.livingMotionModifier(Styles.SHEATH, LivingMotions.SWIM, Animations.BIPED_HOLD_UCHIGATANA_SHEATHING)
				.livingMotionModifier(Styles.SHEATH, LivingMotions.FLOAT, Animations.BIPED_HOLD_UCHIGATANA_SHEATHING)
				.livingMotionModifier(Styles.SHEATH, LivingMotions.FALL, Animations.BIPED_HOLD_UCHIGATANA_SHEATHING)
				.livingMotionModifier(Styles.TWO_HAND, LivingMotions.BLOCK, Animations.UCHIGATANA_GUARD);
		return builder;
	};

	@SubscribeEvent
	public static void register(WeaponCapabilityPresetRegistryEvent event){
		event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(ROSKenjutsu.MODID, "katana"), KATANA);
	}
}

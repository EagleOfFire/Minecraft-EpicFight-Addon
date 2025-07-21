package ros.eagleoffire.roskenjutsu.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import ros.eagleoffire.roskenjutsu.ROSKenjutsu;
import yesman.epicfight.world.item.EpicFightItemTier;
import yesman.epicfight.world.item.WeaponItem;

import java.util.List;

public class KatanaItem extends WeaponItem {
    public KatanaItem(Item.Properties build){
        super(EpicFightItemTier.UCHIGATANA, 0, -2.0F, build);
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return toRepair.getItem() == Items.IRON_BARS;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.literal(""));
        //tooltip.add(Component.translatable("item." + ROSKenjutsu.MODID + ".katana.tooltip"));
        tooltip.add(Component.literal("§7A traditional Japanese sword, known for its curved, single-edged blade, circular or squared guard, and long grip to accommodate two hands.").withStyle(ChatFormatting.GRAY));
    }
}

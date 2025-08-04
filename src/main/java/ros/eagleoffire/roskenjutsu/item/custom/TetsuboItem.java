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

public class TetsuboItem extends WeaponItem {
    public TetsuboItem(Item.Properties build){
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
        tooltip.add(Component.literal("§7A Traditional Japanese club-like weapon, characterized by its massive wooden or metal body, studded or spiked surface, and use in powerful, crushing strikes.").withStyle(ChatFormatting.GRAY));
    }
}

package ros.eagleoffire.roskenjutsu.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ObjSwordItem extends SwordItem {
    public ObjSwordItem(Tier tier, int attackDamageModifier, float attackSPeedModifier, Item.Properties properties){
        super(tier, attackDamageModifier, attackSPeedModifier, properties);
    }
}

package ros.eagleoffire.roskenjutsu.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ros.eagleoffire.roskenjutsu.ROSKenjutsu;
import ros.eagleoffire.roskenjutsu.item.custom.ObjSwordItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ROSKenjutsu.MODID);

    public static final RegistryObject<Item> KATANA = ITEMS.register("katana",
            () -> new ObjSwordItem(Tiers.NETHERITE, 3, -2.4F, new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

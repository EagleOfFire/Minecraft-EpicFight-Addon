package ros.eagleoffire.roskenjutsu.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import ros.eagleoffire.roskenjutsu.ROSKenjutsu;

public class ModCreativeTabs {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ROSKenjutsu.MODID);

    public static final RegistryObject<CreativeModeTab> ROS_KENJUTSU = CREATIVE_MODE_TABS.register("ros_kenjutsu_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KATANA.get()))
                    .title(Component.translatable("creativetab.ros_kenjutsu_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.KATANA.get());
                        pOutput.accept(ModItems.TETSUBO.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

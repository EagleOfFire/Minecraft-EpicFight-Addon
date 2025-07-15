package ros.eagleoffire.roskenjutsu.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ros.eagleoffire.roskenjutsu.ROSKenjutsu;
import ros.eagleoffire.roskenjutsu.renderer.RenderKatana;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = ROSKenjutsu.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PatchedRendererRegisterEvents {
    @SubscribeEvent
    public static void registerRenderer(PatchedRenderersEvent.RegisterItemRenderer event) {
        System.out.println("ROS PatchedRendererRegisterEvents");
        event.addItemRenderer(ResourceLocation.tryBuild(ROSKenjutsu.MODID, "katana"), RenderKatana::new);
    }
}

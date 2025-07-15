package ros.eagleoffire.roskenjutsu.renderer;

import com.google.gson.JsonElement;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Math;
import ros.eagleoffire.roskenjutsu.item.ModItems;
import yesman.epicfight.api.utils.math.MathUtils;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.client.renderer.patched.item.RenderItemBase;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

@OnlyIn(Dist.CLIENT)
public class RenderKatana extends RenderItemBase {
    private final ItemStack sheathStack;

    public RenderKatana(JsonElement jsonElement){
        super(jsonElement);
        this.sheathStack = new ItemStack(ModItems.SAYA.get());
        System.out.println("ROS sheath init");
        System.out.println(this.sheathStack);
    }

    @Override
    public void renderItemInHand(ItemStack stack, LivingEntityPatch<?> entitypatch, InteractionHand hand, OpenMatrix4f[] poses, MultiBufferSource buffer, PoseStack poseStack, int packedLight, float partialTicks) {
		OpenMatrix4f modelMatrix = this.getCorrectionMatrix(entitypatch, InteractionHand.MAIN_HAND, poses);
		poseStack.pushPose();
		MathUtils.mulStack(poseStack, modelMatrix);
        itemRenderer.renderStatic(stack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.NO_OVERLAY, poseStack, buffer, null, 0);
        poseStack.popPose();

		modelMatrix = this.getCorrectionMatrix(entitypatch, InteractionHand.OFF_HAND, poses);

		poseStack.pushPose();
		MathUtils.mulStack(poseStack, modelMatrix);
        System.out.println("ROS sheath");
        System.out.println(this.sheathStack);
		itemRenderer.renderStatic(this.sheathStack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.NO_OVERLAY, poseStack, buffer, null, 0);
        poseStack.popPose();
    }
}

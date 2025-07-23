package ros.eagleoffire.roskenjutsu.gameasset;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import ros.eagleoffire.roskenjutsu.ROSKenjutsu;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.MultiOBBCollider;
import yesman.epicfight.api.collider.OBBCollider;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class ROSColliderPreset implements PreparableReloadListener {
    private static final BiMap<ResourceLocation, Collider> PRESETS = HashBiMap.create();

    public static Collider registerCollider(ResourceLocation rl, Collider collider) {
        if (PRESETS.containsKey(rl)) {
            throw new IllegalStateException("Collider named " + rl + " already registered.");
        }

        PRESETS.put(rl, collider);

        return collider;
    }

    public static Set<Map.Entry<ResourceLocation, Collider>> entries() {
        return Collections.unmodifiableSet(PRESETS.entrySet());
    }

    public static ResourceLocation getKey(Collider collider) {
        return PRESETS.inverse().get(collider);
    }

    public static Collider get(ResourceLocation rl) {
        return PRESETS.get(rl);
    }

    public static final Collider KATANA = registerCollider(ResourceLocation.fromNamespaceAndPath(ROSKenjutsu.MODID, "katana"), new MultiOBBCollider(5, 0.4D, 0.4D, 0.7D, 0D, 0D, -0.7D));

    public static Collider deserializeSimpleCollider(CompoundTag tag) throws IllegalArgumentException {
        int number = tag.getInt("number");

        if (number < 1) {
            throw new IllegalArgumentException("Datapack deserialization error: the number of colliders must bigger than 0!");
        }

        ListTag sizeVector = tag.getList("size", 6);
        ListTag centerVector = tag.getList("center", 6);

        if (sizeVector.size() != 3) {
            throw new IllegalArgumentException("The size list tag must consist of three double elements.");
        }

        if (centerVector.size() != 3) {
            throw new IllegalArgumentException("The center list tag must consist of three double elements.");
        }

        double sizeX = sizeVector.getDouble(0);
        double sizeY = sizeVector.getDouble(1);
        double sizeZ = sizeVector.getDouble(2);

        double centerX = centerVector.getDouble(0);
        double centerY = centerVector.getDouble(1);
        double centerZ = centerVector.getDouble(2);

        if (sizeX < 0.0D || sizeY < 0.0D || sizeZ < 0.0D || (sizeX == 0.0D && sizeY == 0.0D && sizeZ == 0.0D)) {
            throw new IllegalArgumentException("Datapack deserialization error: the size of the collider must be non-negative value!");
        }

        if (number == 1) {
            return new OBBCollider(sizeX, sizeY, sizeZ, centerX, centerY, centerZ);
        } else {
            return new MultiOBBCollider(number, sizeX, sizeY, sizeZ, centerX, centerY, centerZ);
        }
    }

	@Override
	public CompletableFuture<Void> reload(PreparationBarrier stage, ResourceManager resourceManager, ProfilerFiller preparationsProfiler, ProfilerFiller reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
		return CompletableFuture.runAsync(() -> {
			//Collider newCOllider = new OBBCollider(0.4D, 0.4D, 0.5D, 0D, 1.25D, -0.85D)
			//((AttackAnimation)Animations.FATAL_DRAW_DASH).changeCollider(newCOllider, 0);
		}, gameExecutor).thenCompose(stage::wait);
	}
}

package de.janschuri.SurvivalDebugStick;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;
import ru.beykerykt.minecraft.lightapi.common.LightAPI;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockClickListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static void setBlockLighting(World world, Block block, int lightLevel) {

        int blockX = block.getX();
        int blockY = block.getY();
        int blockZ = block.getZ();

        String worldName = world.getName();

        LightAPI.get().setLightLevel(worldName, blockX, blockY, blockZ, lightLevel);
    }

    public static int getBlockLighting(World world, Block block) {

        int blockX = block.getX();
        int blockY = block.getY();
        int blockZ = block.getZ();

        String worldName = world.getName();

        return LightAPI.get().getLightLevel(worldName, blockX, blockY, blockZ);
    }
}

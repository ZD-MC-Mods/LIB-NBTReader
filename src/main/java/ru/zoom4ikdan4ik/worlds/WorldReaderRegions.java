package ru.zoom4ikdan4ik.worlds;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class WorldReaderRegions {
    private final World world;

    public WorldReaderRegions(final World world) {
        this.world = world;
    }

    public final List<File> getRegionFiles() {
        final List<File> regions = new ArrayList<>();
        final File directory = this.getDirectory();

        for (final File file : directory.listFiles())
            if (file.getName().endsWith("mca"))
                regions.add(file);
            else FMLLog.info("File %s will skipping...", file.getAbsolutePath());

        return regions;
    }

    public final File getDirectory() {
        if (this.world.provider.getSaveFolder() != null)
            return Paths.get(MinecraftServer.getServer().getFolderName(), this.world.provider.getSaveFolder(), "region").toFile();
        else return Paths.get(MinecraftServer.getServer().getFolderName(), "region").toFile();
    }
}

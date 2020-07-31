package ru.zoom4ikdan4ik.nbt.abstracts;

import net.minecraft.world.World;

import java.io.File;

public abstract class NBTAbstractEntities extends NBTAbstractFile {
    private final World world;

    public NBTAbstractEntities(final File file, final World world) {
        super(file);

        this.world = world;
    }

    public final World getWorld() {
        return this.world;
    }
}

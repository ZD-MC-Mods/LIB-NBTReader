package ru.zoom4ikdan4ik.nbt.abstracts;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.nbt.NBTTagCompound;

import java.io.File;

public abstract class NBTAbstractFile {
    private final File file;

    public NBTAbstractFile(final File file) {
        this.file = file;
    }

    public final File getFile() {
        return this.file;
    }

    public final void printNBTTagCompound(final NBTTagCompound nbtTagCompound) {
        FMLLog.info("%s -> %s", this.getFile().getAbsolutePath(), nbtTagCompound.toString());
    }
}

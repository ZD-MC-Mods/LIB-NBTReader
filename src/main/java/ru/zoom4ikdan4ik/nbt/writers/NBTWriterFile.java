package ru.zoom4ikdan4ik.nbt.writers;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import ru.zoom4ikdan4ik.nbt.abstracts.NBTAbstractFile;
import ru.zoom4ikdan4ik.nbt.enums.NBTTagType;
import ru.zoom4ikdan4ik.nbt.readers.NBTReaderFile;

import java.io.File;
import java.io.IOException;

public final class NBTWriterFile extends NBTAbstractFile {
    public NBTWriterFile(final File file) {
        super(file);
    }

    public final void setNBTTagCompound(final NBTTagCompound nbtTagCompound) throws IOException {
        CompressedStreamTools.write(nbtTagCompound, this.getFile());
    }

    public final void setNBTTagCompoundLevel(final NBTTagCompound nbtTagCompoundLevel) throws IOException {
        final NBTReaderFile nbtReaderFile = new NBTReaderFile(this.getFile());
        final NBTTagCompound nbtTagCompound = nbtReaderFile.getNBTTagCompound();

        nbtTagCompound.setTag(NBTTagType.LEVEL.getName(), nbtTagCompoundLevel);

        this.setNBTTagCompound(nbtTagCompound);
    }
}

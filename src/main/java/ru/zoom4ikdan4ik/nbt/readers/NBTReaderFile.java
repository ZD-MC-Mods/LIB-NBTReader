package ru.zoom4ikdan4ik.nbt.readers;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import ru.zoom4ikdan4ik.nbt.abstracts.NBTAbstractFile;
import ru.zoom4ikdan4ik.nbt.enums.NBTTagType;
import ru.zoom4ikdan4ik.nbt.exceptions.MissingChunkException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class NBTReaderFile extends NBTAbstractFile {
    public NBTReaderFile(final File file) {
        super(file);
    }

    public final NBTTagCompound getNBTTagCompound() throws IOException {
        return CompressedStreamTools.readCompressed(new FileInputStream(this.getFile()));
    }

    public final NBTTagCompound getNBTTagCompoundLevel() throws IOException, MissingChunkException {
        final NBTTagCompound nbtTagCompound = this.getNBTTagCompound();

        if (!nbtTagCompound.hasKey(NBTTagType.LEVEL.getName())) throw new MissingChunkException(this.getFile());

        return nbtTagCompound.getCompoundTag(NBTTagType.LEVEL.getName());
    }
}

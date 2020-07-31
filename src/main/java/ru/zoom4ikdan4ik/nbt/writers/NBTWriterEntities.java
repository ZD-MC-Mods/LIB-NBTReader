package ru.zoom4ikdan4ik.nbt.writers;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import ru.zoom4ikdan4ik.nbt.abstracts.NBTAbstractEntities;
import ru.zoom4ikdan4ik.nbt.enums.NBTTagType;
import ru.zoom4ikdan4ik.nbt.exceptions.MissingChunkException;
import ru.zoom4ikdan4ik.nbt.readers.NBTReaderFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class NBTWriterEntities extends NBTAbstractEntities {
    public NBTWriterEntities(final File file, final World world) {
        super(file, world);
    }

    public final void setEntities(final List<Entity> entities) throws IOException, MissingChunkException {
        final NBTTagList nbtTagList = new NBTTagList();

        for (final Entity entity : entities) {
            final NBTTagCompound nbtTagCompoundEntity = new NBTTagCompound();

            entity.writeToNBTOptional(nbtTagCompoundEntity);

            nbtTagList.appendTag(nbtTagCompoundEntity);
        }

        final NBTReaderFile nbtReaderFile = new NBTReaderFile(this.getFile());
        final NBTTagCompound nbtTagCompoundLevel = nbtReaderFile.getNBTTagCompoundLevel();

        nbtTagCompoundLevel.setTag(NBTTagType.ENTITIES.getName(), nbtTagList);

        final NBTWriterFile nbtWriterFile = new NBTWriterFile(this.getFile());

        nbtWriterFile.setNBTTagCompoundLevel(nbtTagCompoundLevel);
    }
}

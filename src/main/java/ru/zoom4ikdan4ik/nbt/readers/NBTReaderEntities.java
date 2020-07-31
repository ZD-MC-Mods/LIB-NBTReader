package ru.zoom4ikdan4ik.nbt.readers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import ru.zoom4ikdan4ik.nbt.abstracts.NBTAbstractEntities;
import ru.zoom4ikdan4ik.nbt.enums.NBTTagType;
import ru.zoom4ikdan4ik.nbt.exceptions.MissingChunkException;
import ru.zoom4ikdan4ik.nbt.exceptions.MissingTagCompoundException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class NBTReaderEntities extends NBTAbstractEntities {
    public NBTReaderEntities(final File file, final World world) {
        super(file, world);
    }

    public final NBTTagList getNBTTagListEntities() throws IOException, MissingChunkException, MissingTagCompoundException {
        final NBTReaderFile nbtReaderFile = new NBTReaderFile(this.getFile());
        final NBTTagCompound nbtTagCompound = nbtReaderFile.getNBTTagCompoundLevel();

        if (!nbtTagCompound.hasKey(NBTTagType.ENTITIES.getName()))
            throw new MissingTagCompoundException(this.getFile(), NBTTagType.ENTITIES.getName());

        return nbtTagCompound.getTagList(NBTTagType.ENTITIES.getName());
    }

    public final List<Entity> getEntities() throws IOException, MissingChunkException, MissingTagCompoundException {
        final List<Entity> entities = new ArrayList<>();
        final NBTTagList nbtTagList = this.getNBTTagListEntities();

        for (int i = 0; i < nbtTagList.tagCount(); i++) {
            final NBTTagCompound nbtTagCompoundEntity = (NBTTagCompound) nbtTagList.tagAt(i);
            final Entity entity = EntityList.createEntityFromNBT(nbtTagCompoundEntity, this.getWorld());

            for (NBTTagCompound nbtTagCompoundEntityRiding = nbtTagCompoundEntity; nbtTagCompoundEntityRiding.hasKey("Riding"); nbtTagCompoundEntityRiding = nbtTagCompoundEntityRiding.getCompoundTag("Riding")) {
                final Entity entityRiding = EntityList.createEntityFromNBT(nbtTagCompoundEntityRiding.getCompoundTag("Riding"), this.getWorld());

                entities.add(entityRiding);
            }

            entities.add(entity);
        }

        return entities;
    }
}

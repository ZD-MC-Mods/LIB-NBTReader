package ru.zoom4ikdan4ik.nbt.enums;

public enum NBTTagType {
    LEVEL("Level"),
    ENTITIES("Entities");

    private final String name;

    NBTTagType(final String name) {
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }
}

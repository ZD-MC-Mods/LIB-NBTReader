package ru.zoom4ikdan4ik.nbt.exceptions;

import java.io.File;

public final class MissingChunkException extends Exception {
    public MissingChunkException(final File file) {
        super(String.format("Chunk is missing of file %s", file.getAbsolutePath()));
    }
}

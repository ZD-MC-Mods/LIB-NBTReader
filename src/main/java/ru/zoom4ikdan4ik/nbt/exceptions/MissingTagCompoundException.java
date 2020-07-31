package ru.zoom4ikdan4ik.nbt.exceptions;

import java.io.File;

public final class MissingTagCompoundException extends Exception {
    public MissingTagCompoundException(final File file, final String tag) {
        super(String.format("Missing tag %s in file %s", tag, file.getAbsolutePath()));
    }
}

package com.badlogic.gdx.backend.sdl;

import java.io.File;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class SdlFileHandle extends FileHandle {
	public SdlFileHandle (String fileName, FileType type) {
		super(fileName, type);
	}

	public SdlFileHandle (File file, FileType type) {
		super(file, type);
	}

	public FileHandle child (String name) {
		if (file.getPath().length() == 0) return new SdlFileHandle(new File(name), type);
		return new SdlFileHandle(new File(file, name), type);
	}

	public FileHandle sibling (String name) {
		if (file.getPath().length() == 0) throw new GdxRuntimeException("Cannot get the sibling of the root.");
		return new SdlFileHandle(new File(file.getParent(), name), type);
	}

	public FileHandle parent () {
		File parent = file.getParentFile();
		if (parent == null) {
			if (type == FileType.Absolute)
				parent = new File("/");
			else
				parent = new File("");
		}
		return new SdlFileHandle(parent, type);
	}

	public File file () {
		if (type == FileType.External) return new File(SdlFiles.externalPath, file.getPath());
		return file;
	}
}

package com.badlogic.gdx.backend.sdl;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.files.FileHandle;

public class SdlFiles implements Files {
	// FIXME
	public static String externalPath = "./";


	@Override
	public FileHandle getFileHandle (String fileName, FileType type) {
		return new SdlFileHandle(fileName, type);
	}

	@Override
	public FileHandle classpath (String path) {
		return new SdlFileHandle(path, FileType.Classpath);
	}

	@Override
	public FileHandle internal (String path) {
		return new SdlFileHandle(path, FileType.Internal);
	}

	@Override
	public FileHandle external (String path) {
		return new SdlFileHandle(path, FileType.External);
	}

	@Override
	public FileHandle absolute (String path) {
		return new SdlFileHandle(path, FileType.Absolute);
	}

	@Override
	public FileHandle local (String path) {
		return new SdlFileHandle(path, FileType.Local);
	}

	@Override
	public String getExternalStoragePath () {
		return externalPath;
	}

	@Override
	public boolean isExternalStorageAvailable () {
		return true;
	}

	@Override
	public String getLocalStoragePath () {
		return "";
	}

	@Override
	public boolean isLocalStorageAvailable () {
		return true;
	}
}

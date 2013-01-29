package com.badlogic.gdx.backend.sdl;

import com.badlogic.gdx.jnigen.AntScriptGenerator;
import com.badlogic.gdx.jnigen.BuildConfig;
import com.badlogic.gdx.jnigen.BuildExecutor;
import com.badlogic.gdx.jnigen.BuildTarget;
import com.badlogic.gdx.jnigen.BuildTarget.TargetOs;
import com.badlogic.gdx.jnigen.NativeCodeGenerator;

public class SdlBuild {
	public static void main(String[] args) throws Exception {
		// generate C/C++ code
		new NativeCodeGenerator().generate();

		// generate build scripts, for win32 only
		// custom target for testing purposes
		BuildTarget lin32 = BuildTarget.newDefaultTarget(TargetOs.Linux, false);
		lin32.libraries ="-L../../sdl/linux32 -lSDL";
		BuildTarget lin64 = BuildTarget.newDefaultTarget(TargetOs.Linux, true);
		lin64.libraries ="-L../../sdl/linux64 -lSDL";
		new AntScriptGenerator().generate(new BuildConfig("gdx-backend-sdl"), lin32, lin64);
		BuildExecutor.executeAnt("jni/build-linux64.xml", "-v");
		BuildExecutor.executeAnt("jni/build.xml", "pack-natives -v");
	}
}

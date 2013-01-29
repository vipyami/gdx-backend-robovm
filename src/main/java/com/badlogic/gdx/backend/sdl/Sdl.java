package com.badlogic.gdx.backend.sdl;

import com.badlogic.gdx.utils.GdxRuntimeException;

public class Sdl {
	
	/**
	 * Opaque handle to an SDL surface
	 * @author badlogic
	 *
	 */
	public static class SdlSurface {
		private long pointer;
		
		SdlSurface(long pointer) {
			this.pointer = pointer;
		}
	}
	
	public static class SdlEvent {
	}
	
	public static final int SDL_INIT_TIMER	=	0x00000001;
	public static final int SDL_INIT_AUDIO	=	0x00000010;
	public static final int SDL_INIT_VIDEO	=	0x00000020;
	public static final int SDL_INIT_CDROM	=	0x00000100;
	public static final int SDL_INIT_JOYSTICK = 0x00000200;
	public static final int SDL_INIT_NOPARACHUTE = 0x00100000;	/**< Don't catch fatal signals */
	public static final int SDL_INIT_EVENTTHREAD = 0x01000000;	/**< Not supported on all OS's */
	public static final int SDL_INIT_EVERYTHING	= 0x0000FFFF;
	
	public static final int SDL_SWSURFACE	= 0x00000000;	/**< Surface is in system memory */
	public static final int SDL_HWSURFACE	= 0x00000001;	/**< Surface is in video memory */
	public static final int SDL_ASYNCBLIT	= 0x00000004;	/**< Use asynchronous blits if possible */
	/*@}*/

	/** Available for SDL_SetVideoMode() */
	/*@{*/
	public static final int SDL_ANYFORMAT	= 0x10000000;	/**< Allow any video depth/pixel-format */
	public static final int SDL_HWPALETTE	= 0x20000000;	/**< Surface has exclusive palette */
	public static final int SDL_DOUBLEBUF	= 0x40000000;	/**< Set up double-buffered video mode */
	public static final int SDL_FULLSCREEN	= 0x80000000;	/**< Surface is a full screen display */
	public static final int SDL_OPENGL      = 0x00000002;      /**< Create an OpenGL rendering context */
	public static final int SDL_OPENGLBLIT	= 0x0000000A;	/**< Create an OpenGL rendering context and use it for blitting */
	public static final int SDL_RESIZABLE	= 0x00000010;	/**< This video mode may be resized */
	public static final int SDL_NOFRAME	= 0x00000020;
	
	public static final int SDL_GL_RED_SIZE = 0;
	public static final int SDL_GL_GREEN_SIZE = 1;
	public static final int SDL_GL_BLUE_SIZE = 2;
	public static final int SDL_GL_ALPHA_SIZE = 3;
	public static final int SDL_GL_BUFFER_SIZE = 4;
	public static final int SDL_GL_DOUBLEBUFFER = 5;
	public static final int SDL_GL_DEPTH_SIZE = 6;
	public static final int SDL_GL_STENCIL_SIZE = 7;
	public static final int SDL_GL_ACCUM_RED_SIZE = 8;
	public static final int SDL_GL_ACCUM_GREEN_SIZE = 9;
	public static final int SDL_GL_ACCUM_BLUE_SIZE = 10;
	public static final int SDL_GL_ACCUM_ALPHA_SIZE = 11;
	public static final int SDL_GL_STEREO = 12;
	public static final int SDL_GL_MULTISAMPLEBUFFERS = 13;
	public static final int SDL_GL_MULTISAMPLESAMPLES = 14;
	public static final int SDL_GL_ACCELERATED_VISUAL = 15;
	public static final int SDL_GL_SWAP_CONTROL = 16;
	
	// @off
	/*JNI
	#include <sdl/include/SDL.h>
	#include <GL/gl.h>
	#include <stdlib.h>
	 */
	
	public static native int init(int flags); /*
		return SDL_Init(flags);
	*/
	
	public static native int initSubSystem(int system); /*
		return SDL_InitSubSystem(system);
	*/
	
	public static native void quitSubSystem(int system); /*
		SDL_QuitSubSystem(system);
	*/
	
	public static native void quit(); /*
		SDL_Quit();
	*/
	
	public static native int wasInit(int system); /*
		return SDL_WasInit(system);
	*/
	
	public static native String getError(); /*
		return env->NewStringUTF(SDL_GetError());
	*/
	
	public static SdlSurface setVideoMode(int width, int height, int bits, int flags) {
		SdlSurface surface = new SdlSurface(setVideoModeJni(width, height, bits, flags));
		if(surface.pointer == 0) throw new GdxRuntimeException("Couldn't create surface");
		return surface;
	}
	
	private static native long setVideoModeJni(int width, int height, int bits, int flags); /*
		return (jlong)SDL_SetVideoMode(width, height, bits, flags);
	*/
	
	public static native int glSetAttribute(int attribute, int value); /*
		return SDL_GL_SetAttribute((SDL_GLattr)attribute, value);
	*/
	
	public static native void glSwapBuffers(); /*
		glClearColor(1, 0, 0, 1);
		glClear(GL_COLOR_BUFFER_BIT);
		SDL_GL_SwapBuffers();
	*/
	
	public static native int getBitsPerPixel(); /*
		const SDL_VideoInfo* info = SDL_GetVideoInfo( );
		return info->vfmt->BitsPerPixel;
	*/
	
	int[] eventBuffer;
	SdlEvent event = new SdlEvent();
	public static SdlEvent pollEvent() {
		
		return null;
	}
	
	private static native void pollEvent(int[] event); /*
	
	*/
	
	public static native int version(); /*
		SDL_version version;
		SDL_VERSION(&version);
		return version.major << 16 | version.minor;
	*/
}

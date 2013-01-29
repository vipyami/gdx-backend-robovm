#include <com.badlogic.gdx.backend.sdl.Sdl.h>

//@line:64

	#include <sdl/include/SDL.h>
	#include <GL/gl.h>
	#include <stdlib.h>
	 JNIEXPORT jint JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_init(JNIEnv* env, jclass clazz, jint flags) {


//@line:70

		return SDL_Init(flags);
	

}

JNIEXPORT jint JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_initSubSystem(JNIEnv* env, jclass clazz, jint system) {


//@line:74

		return SDL_InitSubSystem(system);
	

}

JNIEXPORT void JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_quitSubSystem(JNIEnv* env, jclass clazz, jint system) {


//@line:78

		SDL_QuitSubSystem(system);
	

}

JNIEXPORT void JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_quit(JNIEnv* env, jclass clazz) {


//@line:82

		SDL_Quit();
	

}

JNIEXPORT jint JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_wasInit(JNIEnv* env, jclass clazz, jint system) {


//@line:86

		return SDL_WasInit(system);
	

}

JNIEXPORT jstring JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_getError(JNIEnv* env, jclass clazz) {


//@line:90

		return env->NewStringUTF(SDL_GetError());
	

}

JNIEXPORT jlong JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_setVideoModeJni(JNIEnv* env, jclass clazz, jint width, jint height, jint bits, jint flags) {


//@line:100

		return (jlong)SDL_SetVideoMode(width, height, bits, flags);
	

}

JNIEXPORT jint JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_glSetAttribute(JNIEnv* env, jclass clazz, jint attribute, jint value) {


//@line:104

		return SDL_GL_SetAttribute((SDL_GLattr)attribute, value);
	

}

JNIEXPORT void JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_glSwapBuffers(JNIEnv* env, jclass clazz) {


//@line:108

		glClearColor(1, 0, 0, 1);
		glClear(GL_COLOR_BUFFER_BIT);
		SDL_GL_SwapBuffers();
	

}

JNIEXPORT jint JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_getBitsPerPixel(JNIEnv* env, jclass clazz) {


//@line:114

		const SDL_VideoInfo* info = SDL_GetVideoInfo( );
		return info->vfmt->BitsPerPixel;
	

}

JNIEXPORT jint JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_version(JNIEnv* env, jclass clazz) {


//@line:119

		SDL_version version;
		SDL_VERSION(&version);
		return version.major << 16 | version.minor;
	

}


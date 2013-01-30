#include <com.badlogic.gdx.backend.sdl.Sdl.h>

//@line:67

	#include <sdl/include/SDL.h>
	#include <GL/gl.h>
	#include <stdlib.h>
	 JNIEXPORT jint JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_init(JNIEnv* env, jclass clazz, jint flags) {


//@line:73

		return SDL_Init(flags);
	

}

JNIEXPORT jint JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_initSubSystem(JNIEnv* env, jclass clazz, jint system) {


//@line:77

		return SDL_InitSubSystem(system);
	

}

JNIEXPORT void JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_quitSubSystem(JNIEnv* env, jclass clazz, jint system) {


//@line:81

		SDL_QuitSubSystem(system);
	

}

JNIEXPORT void JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_quit(JNIEnv* env, jclass clazz) {


//@line:85

		SDL_Quit();
	

}

JNIEXPORT jint JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_wasInit(JNIEnv* env, jclass clazz, jint system) {


//@line:89

		return SDL_WasInit(system);
	

}

JNIEXPORT jstring JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_getError(JNIEnv* env, jclass clazz) {


//@line:93

		return env->NewStringUTF(SDL_GetError());
	

}

JNIEXPORT jlong JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_setVideoModeJni(JNIEnv* env, jclass clazz, jint width, jint height, jint bits, jint flags) {


//@line:103

		return (jlong)SDL_SetVideoMode(width, height, bits, flags);
	

}

JNIEXPORT jint JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_glSetAttribute(JNIEnv* env, jclass clazz, jint attribute, jint value) {


//@line:107

		return SDL_GL_SetAttribute((SDL_GLattr)attribute, value);
	

}

JNIEXPORT void JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_glSwapBuffers(JNIEnv* env, jclass clazz) {


//@line:111

		glClearColor(1, 1, 0, 1);
		glClear(GL_COLOR_BUFFER_BIT);
		SDL_GL_SwapBuffers();
	

}

JNIEXPORT jint JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_getBitsPerPixel(JNIEnv* env, jclass clazz) {


//@line:117

		const SDL_VideoInfo* info = SDL_GetVideoInfo( );
		return info->vfmt->BitsPerPixel;
	

}

JNIEXPORT void JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_pollEvent(JNIEnv* env, jclass clazz, jintArray obj_event) {
	int* event = (int*)env->GetPrimitiveArrayCritical(obj_event, 0);


//@line:129

	
	
	env->ReleasePrimitiveArrayCritical(obj_event, event, 0);

}

JNIEXPORT jint JNICALL Java_com_badlogic_gdx_backend_sdl_Sdl_version(JNIEnv* env, jclass clazz) {


//@line:133

		SDL_version version;
		SDL_VERSION(&version);
		return version.major << 16 | version.minor;
	

}


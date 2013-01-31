import com.badlogic.gdx.backend.sdl.Sdl;
import com.badlogic.gdx.backend.sdl.Sdl.SdlSurface;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.SharedLibraryLoader;


public class SdlTest {
	public static void main(String[] args) throws InterruptedException {
		new SharedLibraryLoader("libs/gdx-backend-sdl-natives.jar").load("gdx-backend-sdl");
		System.out.println(Integer.toHexString(Sdl.version()));
		System.out.println(Sdl.init(Sdl.SDL_INIT_VIDEO));
		System.out.println((Sdl.wasInit(Sdl.SDL_INIT_VIDEO) & Sdl.SDL_INIT_VIDEO) != 0);
		System.out.println(Sdl.getError());
		
		int bpp = Sdl.getBitsPerPixel();
		Sdl.glSetAttribute(Sdl.SDL_GL_RED_SIZE, 8);
		Sdl.glSetAttribute(Sdl.SDL_GL_GREEN_SIZE, 8);
		Sdl.glSetAttribute(Sdl.SDL_GL_BLUE_SIZE, 8);
		Sdl.glSetAttribute(Sdl.SDL_GL_DEPTH_SIZE, 16);
		Sdl.glSetAttribute(Sdl.SDL_GL_DOUBLEBUFFER, 1);
		
		int flags = Sdl.SDL_OPENGL;
		try {
			Sdl.setVideoMode(640, 480, bpp, flags);
		} catch(GdxRuntimeException e) {
			e.printStackTrace();
			System.out.println(Sdl.getError());
		}
		Sdl.glSwapBuffers();
		Thread.sleep(2000);
		Sdl.quit();
	}
}

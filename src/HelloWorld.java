import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.backend.sdl.Sdl;
import com.badlogic.gdx.backend.sdl.SdlApplication;
import com.badlogic.gdx.backend.sdl.SdlApplicationConfiguration;
import com.badlogic.gdx.utils.SharedLibraryLoader;


public class HelloWorld extends ApplicationAdapter {
	public static void main(String[] args) throws InterruptedException {
		new SharedLibraryLoader("libs/gdx-backend-sdl-natives.jar").load("gdx-backend-sdl");
		System.out.println(Integer.toHexString(Sdl.version()));
		SdlApplicationConfiguration config = new SdlApplicationConfiguration();
		new SdlApplication(new HelloWorld(), config);
		Thread.sleep(5000);
	}

	@Override
	public void create() {
		System.out.println("created");
	}

	@Override
	public void render() {
		System.out.println("rendered");
	}
}

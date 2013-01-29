package com.badlogic.gdx.backend.sdl;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Clipboard;

public class SdlApplication implements Application {
	private final ApplicationListener listener;
	private final SdlGraphics graphics;
	private final SdlInput input;
	private final SdlAudio audio;
	private final SdlFiles files;
	private final SdlNet net;
	private final SdlApplicationConfiguration config;
	private volatile boolean running = true;
	private final Thread mainLoop;
	
	protected final Array<Runnable> runnables = new Array();
	protected final Array<Runnable> executedRunnables = new Array();
	protected final Array<LifecycleListener> lifecycleListeners = new Array<LifecycleListener>();
	protected int logLevel = LOG_INFO;
	
	public SdlApplication(ApplicationListener listener, SdlApplicationConfiguration config) {
		this.listener = listener;
		this.graphics = new SdlGraphics();
		this.input = new SdlInput();
		this.audio = new SdlAudio();
		this.files = new SdlFiles();
		this.net = new SdlNet();
		this.config = config;
		
		Gdx.app = this;
		Gdx.audio = audio;
		Gdx.files = files;
		Gdx.graphics = graphics;
		Gdx.input = input;
		Gdx.net = net;
		
		System.out.println("starting thread");
		mainLoop = startMainLoop();
	}
	
	private Thread startMainLoop() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("would do something");
			}
		});
		thread.start();
		return thread;
	}

	@Override
	public Graphics getGraphics() {
		return graphics;
	}

	@Override
	public Audio getAudio() {
		return audio;
	}

	@Override
	public Input getInput() {
		return input;
	}

	@Override
	public Files getFiles() {
		return files;
	}

	@Override
	public Net getNet() {
		return net;
	}

	@Override
	public long getJavaHeap () {
		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}

	@Override
	public long getNativeHeap () {
		return getJavaHeap();
	}

	Map<String, Preferences> preferences = new HashMap<String, Preferences>();

	@Override
	public Preferences getPreferences (String name) {
		if (preferences.containsKey(name)) {
			return preferences.get(name);
		} else {
			Preferences prefs = new SdlPreferences(name);
			preferences.put(name, prefs);
			return prefs;
		}
	}

	@Override
	public Clipboard getClipboard () {
		// FIXME
		return new Clipboard() {
			@Override
			public String getContents() {
				return null;
			}

			@Override
			public void setContents(String content) {
			}
		};
	}

	@Override
	public void postRunnable (Runnable runnable) {
		synchronized (runnables) {
			runnables.add(runnable);
			Gdx.graphics.requestRendering();
		}
	}

	@Override
	public void debug (String tag, String message) {
		if (logLevel >= LOG_DEBUG) {
			System.out.println(tag + ": " + message);
		}
	}

	@Override
	public void debug (String tag, String message, Throwable exception) {
		if (logLevel >= LOG_DEBUG) {
			System.out.println(tag + ": " + message);
			exception.printStackTrace(System.out);
		}
	}

	public void log (String tag, String message) {
		if (logLevel >= LOG_INFO) {
			System.out.println(tag + ": " + message);
		}
	}

	@Override
	public void log (String tag, String message, Exception exception) {
		if (logLevel >= LOG_INFO) {
			System.out.println(tag + ": " + message);
			exception.printStackTrace(System.out);
		}
	}

	@Override
	public void error (String tag, String message) {
		if (logLevel >= LOG_ERROR) {
			System.err.println(tag + ": " + message);
		}
	}

	@Override
	public void error (String tag, String message, Throwable exception) {
		if (logLevel >= LOG_ERROR) {
			System.err.println(tag + ": " + message);
			exception.printStackTrace(System.err);
		}
	}

	@Override
	public void setLogLevel (int logLevel) {
		this.logLevel = logLevel;
	}

	@Override
	public void exit () {
		postRunnable(new Runnable() {
			@Override
			public void run () {
				running = false;
			}
		});
	}
	
	@Override
	public void addLifecycleListener (LifecycleListener listener) {
		synchronized(lifecycleListeners) {
			lifecycleListeners.add(listener);
		}
	}

	@Override
	public void removeLifecycleListener (LifecycleListener listener) {
		synchronized(lifecycleListeners) {
			lifecycleListeners.removeValue(listener, true);
		}		
	}

	@Override
	public ApplicationType getType() {
		// TODO Auto-generated method stub
		return ApplicationType.Desktop;
	}

	@Override
	public int getVersion() {
		// TODO Auto-generated method stub
		return 0;
	}
}

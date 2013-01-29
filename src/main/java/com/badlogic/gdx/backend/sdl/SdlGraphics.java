package com.badlogic.gdx.backend.sdl;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GLCommon;
import com.badlogic.gdx.graphics.GLU;

public class SdlGraphics implements Graphics {

	@Override
	public boolean isGL11Available() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGL20Available() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GLCommon getGLCommon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GL10 getGL10() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GL11 getGL11() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GL20 getGL20() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GLU getGLU() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getDeltaTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getRawDeltaTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFramesPerSecond() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GraphicsType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getPpiX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getPpiY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getPpcX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getPpcY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getDensity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean supportsDisplayModeChange() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DisplayMode[] getDisplayModes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DisplayMode getDesktopDisplayMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setDisplayMode(DisplayMode displayMode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setDisplayMode(int width, int height, boolean fullscreen) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVSync(boolean vsync) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BufferFormat getBufferFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supportsExtension(String extension) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setContinuousRendering(boolean isContinuous) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isContinuousRendering() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void requestRendering() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isFullscreen() {
		// TODO Auto-generated method stub
		return false;
	}

}

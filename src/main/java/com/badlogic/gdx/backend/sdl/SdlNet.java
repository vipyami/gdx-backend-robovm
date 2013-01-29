package com.badlogic.gdx.backend.sdl;

import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;

public class SdlNet implements Net {

	@Override
	public void sendHttpRequest(HttpRequest httpRequest,
			HttpResponseListener httpResponseListener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServerSocket newServerSocket(Protocol protocol, int port,
			ServerSocketHints hints) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Socket newClientSocket(Protocol protocol, String host, int port,
			SocketHints hints) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void openURI(String URI) {
		// TODO Auto-generated method stub
		
	}

}

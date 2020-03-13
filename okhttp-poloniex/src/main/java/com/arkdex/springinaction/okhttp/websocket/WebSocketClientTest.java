package com.arkdex.springinaction.okhttp.websocket;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

public class WebSocketClientTest {

	public static void main(String... args) {

		OkHttpClient client = new OkHttpClient();
		
		Request request = new Request.Builder().url("wss://api2.poloniex.com").build();
		PoloniexWebSocketListener listener = new PoloniexWebSocketListener();

		WebSocket ws = client.newWebSocket(request, listener);

		// Trigger shutdown of the dispatcher's executor so this process can
		// exit cleanly.
		client.dispatcher().executorService().shutdown();
	}
}

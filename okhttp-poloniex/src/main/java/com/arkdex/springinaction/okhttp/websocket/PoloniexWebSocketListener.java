package com.arkdex.springinaction.okhttp.websocket;

import com.google.gson.Gson;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

import java.math.BigDecimal;
import java.util.List;

public final class PoloniexWebSocketListener extends WebSocketListener {
    private static final int NORMAL_CLOSURE_STATUS = 1000;
    private final static Gson GSON = new Gson();

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        webSocket.send("{ \"command\": \"subscribe\", \"channel\": \"1002\" }");
        //webSocket.send("Hello!");
        //webSocket.send(ByteString.decodeHex("deadbeef"));
        //webSocket.close(NORMAL_CLOSURE_STATUS, "Goodbye!");
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        System.out.println("Receiving: " + text);
        PoloniexWSSTicker ticker = this.mapMessageToPoloniexTicker(text);
        // LOG.debug(ticker);

    }

    protected PoloniexWSSTicker mapMessageToPoloniexTicker(String message) {
        List results = GSON.fromJson(message, List.class);
        if (results.size() < 3) {
            return null;
        }

		List olhc = (List) results.get(2);
		return new PoloniexWSSTicker.PoloniexWSSTickerBuilder()
				.setCurrencyPair((Double) olhc.get(0))
				.setLastPrice(new BigDecimal((String) olhc.get(1)))
				.setLowestAsk(new BigDecimal((String) olhc.get(2)))
				.setHighestBid(new BigDecimal((String) olhc.get(3)))
				.setPercentChange(new BigDecimal((String) olhc.get(4)))
				.setBaseVolume(new BigDecimal((String) olhc.get(5)))
				.setQuoteVolume(new BigDecimal((String) olhc.get(6)))
				.setIsFrozen(olhc.get(7).toString().equalsIgnoreCase("1"))
				.setTwentyFourHourHigh(new BigDecimal((String) olhc.get(8)))
				.setTwentyFourHourLow(new BigDecimal((String) olhc.get(9)))
				.buildPoloniexTicker();

    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        System.out.println("Receiving: " + bytes.hex());
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.close(NORMAL_CLOSURE_STATUS, null);
        System.out.println("Closing: " + code + " " + reason);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        t.printStackTrace();
    }

}
package com.github.sanhak.nitrogenertor.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RequestUtils {

	public static boolean isAvailable(String giftCode) {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url("https://discord.com/api/v10/entitlements/gift-codes/" + giftCode)
				.build();
		try {
			Response response = client.newCall(request).execute();
			int statusCode = response.code();
			if (statusCode == 200) {
				response.close();
				return true;
			} else {
				response.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

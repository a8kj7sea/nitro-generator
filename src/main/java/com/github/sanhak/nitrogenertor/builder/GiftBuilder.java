package com.github.sanhak.nitrogenertor.builder;

import java.util.Random;

public class GiftBuilder {

	private int size;

	public GiftBuilder(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public String build() {
		String id = "";
		char[] letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		for (int x = 0; x < size; x++) {
			id += letters[new Random().nextInt(letters.length)];
		}
		return id;
	}
}

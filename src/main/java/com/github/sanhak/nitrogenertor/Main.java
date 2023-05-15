package com.github.sanhak.nitrogenertor;

import com.github.sanhak.nitrogenertor.builder.GiftBuilder;
import com.github.sanhak.nitrogenertor.file.DataFile;
import com.github.sanhak.nitrogenertor.utils.RequestUtils;

public class Main {

	private static DataFile dataFile;

	public static void main(String[] args) {
		dataFile = new DataFile(System.getProperty("user.dir"), "working-gifts.txt");

		int success = 0;
		int failed = 0;

		if (args[0].equalsIgnoreCase("google")) {
			for (int x = Integer.MIN_VALUE; x < Integer.MAX_VALUE; x++) {
				String giftCode = new GiftBuilder(16).build();
				if (RequestUtils.isAvailable(giftCode)) {
					dataFile.write(giftCode);
					System.out.println(giftCode + " Success [" + ++success + "]");
				} else {
					System.out.println(giftCode + " Failed [" + ++failed + "]");

				}
			}
		} else {
			try {
				int gifts = Integer.parseInt(args[0]);
				if (gifts <= 0) {
					System.out.println("Please enter number higher than 0 or negative numbers");
					System.exit(0);
				} else {
					for (int x = 0; x < gifts; x++) {
						String giftCode = new GiftBuilder(16).build();
						if (RequestUtils.isAvailable(giftCode)) {
							dataFile.write(giftCode);
							System.out.println(giftCode + " Success [" + ++success + "]");
						} else {
							System.out.println(giftCode + " Failed [" + ++failed + "]");

						}
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("Please type number !");
				System.exit(0);
			}
		}

	}

}

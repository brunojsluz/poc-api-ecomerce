package br.com.api.utils;

import java.math.BigDecimal;
import java.util.Random;

public class TestUtils {
	
	public static Long getRandomLong() {
		return Long.valueOf(new Random().nextInt(999999999) + 1);
	}
	
	public static Integer getRandomInteger() {
		return Long.valueOf(new Random().nextInt(999999999) + 1).intValue();
	}
	
	public static BigDecimal getRandomBigDecimal() {
		return new BigDecimal(new Random().nextInt(999999999) + 1);
	}
	
	public static String getRandomString() {
		return getRandomString(10);
	}
	
	public static String getRandomString(int length) {
		final Random random = new Random();
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			switch (random.nextInt(3)) {
				case 0:
					// 48 = 0, 57 = 9
					sb.append(new Character((char) (48 + random.nextInt((57 + 1 - 48)))));
					break;
				case 1:
					// 97 = a, 122 = z
					sb.append(new Character((char) (97 + random.nextInt((122 + 1 - 97)))));
					break;
				case 2:
					// 65 = A, 90 = Z
					sb.append(new Character((char) (65 + random.nextInt((90 + 1 - 65)))));
					break;
				default:
					break;
			}
		}
		return sb.toString();
	}

}

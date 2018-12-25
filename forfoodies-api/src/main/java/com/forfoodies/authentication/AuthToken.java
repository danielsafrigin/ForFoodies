package com.forfoodies.authentication;

public class AuthToken {

	private static final int length = 24;
	private static final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String generateToken() {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(characters.charAt((int) (Math.random() * 62)));
		}
		return sb.toString();
	}

}

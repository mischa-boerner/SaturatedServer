package com.mischaboerner.saturatedserver.account.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordService {
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public String hashPassword(String rawPassword) {
		return passwordEncoder.encode(rawPassword);
	}

	public boolean checkPassword(String rawPassword, String hashedPassword) {
		return passwordEncoder.matches(rawPassword, hashedPassword);
	}
}

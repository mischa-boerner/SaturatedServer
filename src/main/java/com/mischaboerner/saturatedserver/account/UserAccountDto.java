package com.mischaboerner.saturatedserver.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserAccountDto {
	@NotNull(message = "Email can't be null")
	@NotEmpty(message = "Email can't be empty")
	@Email(message = "Email is not valid.")
	private String email;

	@NotNull(message = "Password can't be null")
	@NotEmpty(message = "Password can't be empty")
	private String hashedPassword;

	public UserAccountDto() {
	}

	public UserAccountDto(final String email, final String hashedPassword) {
		this.email = email;
		this.hashedPassword = hashedPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(final String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
}

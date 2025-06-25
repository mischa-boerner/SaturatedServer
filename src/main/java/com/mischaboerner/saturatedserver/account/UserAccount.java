package com.mischaboerner.saturatedserver.account;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserAccount {
	@Id
	@GeneratedValue
	private Long id;

	private String email;

	private String hashedPassword;

	public UserAccount() {
	}

	public UserAccount(final Long id, final String email, final String hashedPassword) {
		this.id = id;
		this.email = email;
		this.hashedPassword = hashedPassword;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
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

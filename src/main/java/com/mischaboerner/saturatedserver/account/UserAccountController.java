package com.mischaboerner.saturatedserver.account;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mischaboerner.saturatedserver.account.password.PasswordService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserAccountController {
	private final UserAccountRepository repository;
	private final UserAccountMapper mapper;

	public UserAccountController(final UserAccountRepository repository, final UserAccountMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@PostMapping
	public UserAccountDto create(@Valid @RequestBody UserAccountDto dto) {
		PasswordService passwordService = new PasswordService();
		dto.setHashedPassword(passwordService.hashPassword(dto.getHashedPassword()));
		UserAccount saved = repository.save(mapper.toEntity(dto));
		return mapper.toDto(saved);
	}

	@GetMapping
	public List<UserAccountDto> getAll() {
		return mapper.toDtoList(repository.findAll());
	}
}

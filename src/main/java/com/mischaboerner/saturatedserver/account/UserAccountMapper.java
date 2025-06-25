package com.mischaboerner.saturatedserver.account;

import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {
	UserAccountDto toDto(UserAccount userAccount);

	UserAccount toEntity(UserAccountDto userAccountDto);

	List<UserAccountDto> toDtoList(List<UserAccount> userAccounts);

	List<UserAccount> toEntityList(List<UserAccountDto> userAccountDtos);
}

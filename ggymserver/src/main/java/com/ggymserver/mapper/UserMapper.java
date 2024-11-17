package com.ggymserver.mapper;

import com.ggymserver.annotations.EncodedMapping;
import com.ggymserver.dto.request.RegisterUserDTO;
import com.ggymserver.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {PasswordEncoderMapper.class})
public interface UserMapper {

    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    User toEntity (RegisterUserDTO registerUserDTO);
}

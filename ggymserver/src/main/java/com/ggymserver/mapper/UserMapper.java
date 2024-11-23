package com.ggymserver.mapper;

import com.ggymserver.annotations.EncodedMapping;
import com.ggymserver.dto.RegisterUserDTO;
import com.ggymserver.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {PasswordEncoderMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    User toEntity (RegisterUserDTO registerUserDTO);
}

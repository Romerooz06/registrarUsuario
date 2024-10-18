package com.example.ejercicio.service.dto.mapper;


import com.example.ejercicio.model.User;
import com.example.ejercicio.service.dto.ResponseDTO;
import com.example.ejercicio.service.dto.UserDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface UserMapper {

    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "name", source = "name")
    UserDTO toDtoFromModel(User user);

    @Mapping(target = "name", source = "name")
    User toModelFromDto( UserDTO userDTO );

    @Mapping(target = "id", source = "uuid")
    @Mapping(target = "created", source = "createdAt")
    @Mapping(target = "modified", source = "lastModifiedAt")
    @Mapping(target = "last_login", source = "createdAt")
    ResponseDTO toResponseDTOFromModel(User user);
}

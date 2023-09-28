package com.hotelpremier.Hotel.Premier.persistence.mapper;

import com.hotelpremier.Hotel.Premier.domain.UserType;
import com.hotelpremier.Hotel.Premier.persistence.entity.TipoUsuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserTypeMapper {

    @Mapping(source = "idTipouser", target = "userTypeId")
    @Mapping(source = "nombreTipouser", target = "name")
    @Mapping(source = "activoTipouser", target = "active")
    UserType toUserType(TipoUsuario tipoUsuario);
    List<UserType> toUserTypes(List<TipoUsuario> tipoUsuarios);

    @InheritInverseConfiguration
    TipoUsuario toTipoUsuario(UserType userType);
}

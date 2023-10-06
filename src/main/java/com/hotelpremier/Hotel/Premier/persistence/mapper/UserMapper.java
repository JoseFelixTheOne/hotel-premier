package com.hotelpremier.Hotel.Premier.persistence.mapper;

import com.hotelpremier.Hotel.Premier.domain.User;
import com.hotelpremier.Hotel.Premier.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserTypeMapper.class, PassengerMapper.class})
public interface UserMapper {
    @Mapping(source = "idusuario", target = "iduser")
    @Mapping(source = "idpasajero", target = "idpassenger")
    @Mapping(source = "usuarioacceso", target = "user")
    @Mapping(source = "clave", target = "password")
    @Mapping(source = "tipousuario", target = "usertpe")
    @Mapping(source = "activo", target = "active")
    @Mapping(source = "objTpoUsuario", target = "objuserType")
    @Mapping(source = "objPasajero", target = "objPassenger")
    User toUser(Usuario usuario);

    List<User> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration
    Usuario toUsuario(User user);
}

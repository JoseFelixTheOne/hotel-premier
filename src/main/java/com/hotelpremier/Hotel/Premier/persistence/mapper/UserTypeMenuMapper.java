package com.hotelpremier.Hotel.Premier.persistence.mapper;

import com.hotelpremier.Hotel.Premier.domain.UserTypeMenu;
import com.hotelpremier.Hotel.Premier.persistence.entity.TipoUsuarioMenu;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;
import java.util.Map;

@Mapper(componentModel =  "spring")
public interface UserTypeMenuMapper {

    @Mapping(source = "idMenuTipoUsuario", target = "idUserTypeMenu")
    @Mapping(source = "idTipoUsuario", target = "idUserType")
    @Mapping(source = "idMenu", target = "idMenu")
    UserTypeMenu userTypeMenu(TipoUsuarioMenu tipoUsuarioMenu);

    List<UserTypeMenu> userTypeMenus(List<TipoUsuarioMenu> tipoUsuarioMenus);

    @InheritInverseConfiguration
    TipoUsuarioMenu tipoUsuarioMenu(UserTypeMenu userTypeMenu);
}

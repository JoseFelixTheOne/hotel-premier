package com.hotelpremier.Hotel.Premier.persistence.mapper;

import com.hotelpremier.Hotel.Premier.domain.MenuD;
import com.hotelpremier.Hotel.Premier.persistence.entity.Menu;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuMapper {

    @Mapping(source = "idMenu", target = "menuId")
    @Mapping(source = "nombreMenu", target = "menuName")
    @Mapping(source = "urlMenu", target = "menuUrl")
    @Mapping(source = "iconoMenu", target = "menuIcon")
    @Mapping(source = "activoMenu", target = "menuActive")
    MenuD toMenuD(Menu menu);

    List<MenuD> toMenus(List<Menu> menuList);

    @InheritInverseConfiguration
    Menu toMenu(MenuD menuD);
}

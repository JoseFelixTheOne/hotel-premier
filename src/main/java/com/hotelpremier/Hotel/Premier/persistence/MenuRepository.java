package com.hotelpremier.Hotel.Premier.persistence;

import com.hotelpremier.Hotel.Premier.domain.MenuD;
import com.hotelpremier.Hotel.Premier.domain.repository.MenuDRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.MenuCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.Menu;
import com.hotelpremier.Hotel.Premier.persistence.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MenuRepository implements MenuDRepository {
    @Autowired
    private MenuCrudRepository menuCrudRepository;
    @Autowired
    private MenuMapper mapper;

    @Override
    public List<MenuD> getAll() {
        List<Menu> menus = menuCrudRepository.findAll();
        return mapper.toMenus(menus);
    }

    @Override
    public List<MenuD> getAllActive() {
        List<Menu> menus = menuCrudRepository.findAllActive().get();
        return mapper.toMenus(menus);
    }

    @Override
    public List<MenuD> getAllInactive() {
        List<Menu> menus = menuCrudRepository.findAllInactive().get();
        return mapper.toMenus(menus);
    }

    @Override
    public Optional<MenuD> getMenuD(int idMenu) {
        return menuCrudRepository.findById(idMenu).map(m -> mapper.toMenuD(m));
    }
    @Override
    public MenuD save(MenuD menuD) {
        Menu menu = mapper.toMenu(menuD);
        return mapper.toMenuD(menuCrudRepository.save(menu));
    }
    @Override
    public void delete(int menuId) {
        System.out.println("SE ELIMINÓ CORRECTAMENTE EL USUARIO: " + menuId);

    }
}

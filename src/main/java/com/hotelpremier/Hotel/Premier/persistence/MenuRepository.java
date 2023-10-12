package com.hotelpremier.Hotel.Premier.persistence;

import com.hotelpremier.Hotel.Premier.domain.MenuD;
import com.hotelpremier.Hotel.Premier.domain.repository.MenuDRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.MenuCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.Menu;
import com.hotelpremier.Hotel.Premier.persistence.mapper.MenuMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MenuRepository implements MenuDRepository {

    private MenuCrudRepository menuCrudRepository;

    private MenuMapper mapper;

    @Override
    public List<MenuD> getAll() {
        List<Menu> menuList = menuCrudRepository.findAll();
        return mapper.toMenus(menuList);
    }

    @Override
    public Optional<MenuD> getMenu(int idMenu) {
        return menuCrudRepository.findById(idMenu).map(m -> mapper.toMenuD(m));
    }
    @Override
    public MenuD save(MenuD menuD) {
        return null;
    }
    @Override
    public void delete(int idMenu) {

    }
}

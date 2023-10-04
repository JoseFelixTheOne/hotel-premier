package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.MenuD;
import com.hotelpremier.Hotel.Premier.domain.repository.MenuDRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MenuDService {
    @Autowired
    private MenuDRepository menuDRepository;

    public List<MenuD> getAll() {
        return menuDRepository.getAll();
    }
    public Optional<MenuD> getMenuD(int idMenu){
        return menuDRepository.getMenu(idMenu);
    }
    public MenuD save(MenuD menuD){
        return menuDRepository.save(menuD);
    }
    public MenuD update(MenuD menuD){
        int idMenu = menuD.getMenuId();
        MenuD menu1 = getMenuD(idMenu).map(m ->{
            BeanUtils.copyProperties(menuD, m);
            return m;
        }).orElseThrow(() -> new EntityNotFoundException("Menu not found using ID: " + idMenu));
        return menuDRepository.save(menuD);
    }
    public boolean delete(int idMenu) {
        if (getMenuD(idMenu).isPresent()) {
            menuDRepository.delete(idMenu);
            return true;
        } else {
            return false;
        }
    }
}

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
    public List<MenuD> getAllActive() {
        return menuDRepository.getAllActive();
    }
    public List<MenuD> getAllInactive() {
        return menuDRepository.getAllInactive();
    }
    public Optional<MenuD> getMenuD(int menuId){
        return menuDRepository.getMenu(menuId);
    }
    public MenuD save(MenuD menuD){
        return menuDRepository.save(menuD);
    }
    public MenuD update(MenuD menuD){
        int menuId = menuD.getMenuId();
        MenuD menu = getMenuD(menuId).map(m ->{
            BeanUtils.copyProperties(menuD, m);
            return m;
        }).orElseThrow(() -> new EntityNotFoundException("Menu not found using ID: " + menuId));
        return menuDRepository.save(menuD);
    }
    public void delete(int menuId) {
        if (getMenuD(menuId).isPresent()) {
            MenuD menuD = menuDRepository.getMenu(menuId).get();
            menuD.setMenuActive("I");
            menuDRepository.save(menuD);
        }
        else {
            System.out.println("ERROR 404 : MENU NOT FOUND");
        }
    }
}

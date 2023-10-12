package com.hotelpremier.Hotel.Premier.persistence;

import com.hotelpremier.Hotel.Premier.domain.UserTypeMenu;
import com.hotelpremier.Hotel.Premier.domain.repository.UserTypeMenuRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.TipoUsuarioMenuCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.TipoUsuarioMenu;
import com.hotelpremier.Hotel.Premier.persistence.mapper.UserTypeMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class TipoUsuarioMenuRepository implements UserTypeMenuRepository {
    @Autowired
    private TipoUsuarioMenuCrudRepository tipoUsuarioMenuCrudRepository;
    @Autowired
    private UserTypeMenuMapper mapper;
    @Override
    public List<UserTypeMenu> getAll() {
        List<TipoUsuarioMenu> menus = tipoUsuarioMenuCrudRepository.findAll();
        return mapper.userTypeMenus(menus);
    }
    @Override
    public Optional<UserTypeMenu> getUserTypeMenu(int idUserTypeMenu) {
        return tipoUsuarioMenuCrudRepository.findById(idUserTypeMenu).map(menus -> mapper.userTypeMenu(menus));
    }

    @Override
    public Optional<List<UserTypeMenu>> getRolesByUserType(int idUserType) {
        return tipoUsuarioMenuCrudRepository.findByIdTipoUsuario(idUserType)
                .map(menus -> mapper.userTypeMenus(menus));
    }

    @Override
    public Optional<List<UserTypeMenu>> getRolesByMenu(int idMenu){
        return tipoUsuarioMenuCrudRepository.findByIdMenu(idMenu)
                .map(m -> mapper.userTypeMenus(m));
    }

    @Override
    public Optional<List<UserTypeMenu>> getRolesByUserTypeAndMenu(int idUserType, int idMenu) {
        return tipoUsuarioMenuCrudRepository.findByIdTipoUsuarioAndIdMenu(idUserType,idMenu)
                .map(m -> mapper.userTypeMenus(m));
    }

    @Override
    public UserTypeMenu save(UserTypeMenu userTypeMenu) {
        TipoUsuarioMenu menus = mapper.tipoUsuarioMenu(userTypeMenu);
        return mapper.userTypeMenu(tipoUsuarioMenuCrudRepository.save(menus));
    }
    @Override
    public void delete(int idUserTypeMenu) {
        tipoUsuarioMenuCrudRepository.deleteById(idUserTypeMenu);
    }
}

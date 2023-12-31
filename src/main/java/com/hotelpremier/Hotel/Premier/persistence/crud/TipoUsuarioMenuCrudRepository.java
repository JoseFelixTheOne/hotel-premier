package com.hotelpremier.Hotel.Premier.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.TipoUsuarioMenu;
import java.util.List;
import java.util.Optional;

public interface TipoUsuarioMenuCrudRepository extends JpaRepository<TipoUsuarioMenu, Integer> {
    Optional<List<TipoUsuarioMenu>> findByIdTipoUsuario(int idTipoUsuario);
    Optional<List<TipoUsuarioMenu>> findByIdMenu(int idMenu);
    Optional<List<TipoUsuarioMenu>> findByIdTipoUsuarioAndIdMenu(int idUserType, int idMenu);
}

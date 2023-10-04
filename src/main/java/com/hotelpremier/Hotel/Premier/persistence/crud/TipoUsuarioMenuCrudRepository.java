package com.hotelpremier.Hotel.Premier.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.TipoUsuarioMenu;

public interface TipoUsuarioMenuCrudRepository extends JpaRepository<TipoUsuarioMenu, Integer> {
}

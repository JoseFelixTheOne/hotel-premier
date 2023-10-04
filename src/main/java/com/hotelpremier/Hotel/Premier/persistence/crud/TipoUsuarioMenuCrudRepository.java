package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.persistence.entity.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.TipoUsuarioMenu;

import java.util.Optional;

public interface TipoUsuarioMenuCrudRepository extends JpaRepository<TipoUsuarioMenu, Integer> {
}

package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.persistence.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuCrudRepository  extends JpaRepository<Menu, Integer> {
}

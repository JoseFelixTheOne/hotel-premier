package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.persistence.entity.Piso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PisoCrudRepository extends JpaRepository<Piso, Integer> {

}

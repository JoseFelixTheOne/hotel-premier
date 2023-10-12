package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.persistence.entity.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasajeroCrudRepository extends JpaRepository<Pasajero, Integer> {
}

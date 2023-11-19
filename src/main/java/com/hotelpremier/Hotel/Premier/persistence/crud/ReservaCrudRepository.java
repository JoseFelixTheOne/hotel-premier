package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.persistence.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaCrudRepository extends JpaRepository<Reserva, Integer> {
}

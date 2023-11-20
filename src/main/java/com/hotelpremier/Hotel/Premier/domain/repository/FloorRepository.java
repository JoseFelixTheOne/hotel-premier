package com.hotelpremier.Hotel.Premier.domain.repository;

import com.hotelpremier.Hotel.Premier.domain.Floor;
import java.util.List;
import java.util.Optional;

public interface FloorRepository {
    List<Floor> getAll();
    List<Floor> getAllActive();
    List<Floor> getAllInactive();
    Optional<Floor> getFloor(int idfloor);
    Floor save(Floor floor);
    void delete(int idfloor);
}

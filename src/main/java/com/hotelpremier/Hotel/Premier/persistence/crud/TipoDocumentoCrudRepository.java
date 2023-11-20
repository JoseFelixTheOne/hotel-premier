package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.persistence.entity.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TipoDocumentoCrudRepository extends JpaRepository<TipoDocumento, Integer> {
    Optional<List<TipoDocumento>> findByActivo(String active);
    Optional<TipoDocumento> findByIdTipoDocAndActivo(Integer idTipoDoc,String active);
}

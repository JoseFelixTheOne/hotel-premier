package com.hotelpremier.Hotel.Premier.domain.repository;

import com.hotelpremier.Hotel.Premier.domain.DocType;

import java.util.List;
import java.util.Optional;

public interface DocTypeRepository {
    List<DocType> getAll();
    Optional<DocType> getDocType(int idTypeDoc);
    DocType save(DocType docType);
    void delete(int idTypeDoc);
}

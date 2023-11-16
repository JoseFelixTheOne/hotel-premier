package com.hotelpremier.Hotel.Premier.persistence;

import com.hotelpremier.Hotel.Premier.domain.DocType;
import com.hotelpremier.Hotel.Premier.domain.repository.DocTypeRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.TipoDocumentoCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.TipoDocumento;
import com.hotelpremier.Hotel.Premier.persistence.mapper.DocTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class TipoDocumentoRepository implements DocTypeRepository {
    @Autowired
    private TipoDocumentoCrudRepository tipoDocumentoCrudRepository;
    @Autowired
    private DocTypeMapper mapper;
    @Override
    public Optional<List<DocType>> getAll() {
        return tipoDocumentoCrudRepository.findByActivo("a").map(docs -> mapper.toDocTypes(docs));
    }
    @Override
    public Optional<DocType> getDocType(int idTypeDoc) {
        return tipoDocumentoCrudRepository.findByIdTipoDocAndActivo(idTypeDoc, "a").map(tipoDocumento -> mapper.toDocType(tipoDocumento));
    }
    @Override
    public DocType save(DocType docType) {
        TipoDocumento tipoDocumento = mapper.toTipoDocumento(docType);
        return mapper.toDocType(tipoDocumentoCrudRepository.save(tipoDocumento));
    }
    @Override
    public void delete(int idTypeDoc) {
        if( getDocType(idTypeDoc).isPresent()){
            TipoDocumento tipoDocumento = mapper.toTipoDocumento(getDocType(idTypeDoc).get());
            tipoDocumento.setActivo("I");
            save(mapper.toDocType(tipoDocumento));
        }
    }
}

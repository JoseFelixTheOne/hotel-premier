package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.DocType;
import com.hotelpremier.Hotel.Premier.domain.repository.DocTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DocTypeService {
    @Autowired
    private DocTypeRepository docTypeRepository;
    public Optional<List<DocType>> getAll() {
        return docTypeRepository.getAll();
    }
    public Optional<DocType> getDocType(int idTypeDoc) {
        return docTypeRepository.getDocType(idTypeDoc);
    }
    public DocType save(DocType docType) {
        docType.setActive("A");
        return docTypeRepository.save(docType);
    }
    public DocType update(DocType docType) {
        int idTypeDoc = docType.getIdTypeDoc();
        DocType tipodoc = getDocType(idTypeDoc).map(t ->{
            BeanUtils.copyProperties(docType, t);
            return t;
        }).orElseThrow(() -> new EntityNotFoundException("TypeDoc not found with ID: " + idTypeDoc));
        return docTypeRepository.save(tipodoc);
    }
    public void delete(int idTypeDoc) {
        if (getDocType(idTypeDoc).isPresent()) {
            DocType docType = getDocType(idTypeDoc).get();
            docType.setActive("I");
            docTypeRepository.save(docType);
        }else {
            System.out.println("DocType not found : " + idTypeDoc);
        }
    }
}

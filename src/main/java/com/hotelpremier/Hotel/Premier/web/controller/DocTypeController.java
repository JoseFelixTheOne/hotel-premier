package com.hotelpremier.Hotel.Premier.web.controller;

import com.hotelpremier.Hotel.Premier.domain.DocType;
import com.hotelpremier.Hotel.Premier.domain.service.DocTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/doctypes")
public class DocTypeController {
    @Autowired
    private DocTypeService docTypeService;
    @GetMapping("")
    public ResponseEntity<List<DocType>> getAll() {
        return docTypeService.getAll()
                .map(docs -> new ResponseEntity<>(docs, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DocType> getDocType(@PathVariable("id") int idTypeDoc){
        return docTypeService.getDocType(idTypeDoc)
                .map(docType -> new ResponseEntity<>(docType, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/")
    public ResponseEntity<DocType> save(@RequestBody DocType docType) {
        return new ResponseEntity<>(docTypeService.save(docType), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<DocType> update(@RequestBody DocType docType) {
        return new ResponseEntity<>(docTypeService.update(docType), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int idTypeDoc){
        return new ResponseEntity(docTypeService.delete(idTypeDoc) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}

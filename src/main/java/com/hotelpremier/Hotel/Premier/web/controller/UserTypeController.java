package com.hotelpremier.Hotel.Premier.web.controller;

import com.hotelpremier.Hotel.Premier.domain.UserType;
import com.hotelpremier.Hotel.Premier.domain.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usertypes")
public class UserTypeController {
    @Autowired
    private UserTypeService userTypeService;

    @GetMapping("")
    public ResponseEntity<List<UserType>> getAll(){
        return new ResponseEntity<>(userTypeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserType> getUserType(@PathVariable("id") int userTypeId) {
        return userTypeService.getUserType(userTypeId)
                .map(type -> new ResponseEntity<>(type, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<UserType> save(@RequestBody UserType userType) {
        return new ResponseEntity<>(userTypeService.save(userType), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<UserType> update(@RequestBody UserType userType) {
        return new ResponseEntity<>(userTypeService.update(userType), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int userTypeId){
        return new ResponseEntity(userTypeService.delete(userTypeId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}

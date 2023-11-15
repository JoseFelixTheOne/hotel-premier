package com.hotelpremier.Hotel.Premier.web.controller;

import com.hotelpremier.Hotel.Premier.domain.MenuD;
import com.hotelpremier.Hotel.Premier.domain.service.MenuDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/menus")
public class MenuDController {
    @Autowired
    private MenuDService menuDService;
    @GetMapping({"", "/"})
    public ResponseEntity<List<MenuD>> getAll(){
        return new ResponseEntity<>(menuDService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MenuD> getMenuD(@PathVariable("id") int idMenuD){
        return menuDService.getMenuD(idMenuD)
                .map(menuD -> new ResponseEntity<>(menuD, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/")
    public ResponseEntity<MenuD> save(@RequestBody MenuD menuD){
        return new ResponseEntity<>(menuDService.save(menuD), HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<MenuD> update(@RequestBody MenuD menuD){
        return new ResponseEntity<>(menuDService.update(menuD), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity delete(@PathVariable("id") int menuId){
        return new ResponseEntity(menuDService.delete(menuId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}

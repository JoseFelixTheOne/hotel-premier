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
@RequestMapping("/menu")
public class MenuDController {
    @Autowired
    private MenuDService menuDService;

    @GetMapping({"", "/"})
    public ResponseEntity<List<MenuD>> getAllActive() {
        return new ResponseEntity<>(menuDService.getAllActive(), HttpStatus.OK);
    }
    //Listado de inactivos
    @GetMapping({"/inactive"})
    public ResponseEntity<List<MenuD>> getAllInactive() {
        return new ResponseEntity<>(menuDService.getAllInactive(), HttpStatus.OK);
    }
    //Listado total de los menús
    @GetMapping({"/listAll"})
    public ResponseEntity<List<MenuD>> getAll(){
        return new ResponseEntity<>(menuDService.getAll(), HttpStatus.OK);
    }

    //Menú filtrado por ID
    @GetMapping("/{id}")
    public ResponseEntity<MenuD> getMenuD(@PathVariable("id") int menuId){
        return menuDService.getMenuD(menuId)
                .map(menuD -> new ResponseEntity<>(menuD, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.OK));
    }
    //Registro de Menú
    @PostMapping("/")
    public ResponseEntity<MenuD> save(@RequestBody MenuD menuD){
        return new ResponseEntity<>(menuDService.save(menuD), HttpStatus.CREATED);
    }
    //Actulización de Menú
    @PutMapping("/")
    public ResponseEntity<MenuD> update(@RequestBody MenuD menuD){
        return new ResponseEntity<>(menuDService.update(menuD), HttpStatus.OK);
    }
    // Eliminación de Menú
    // -> Pasa a Inactivo
    // -> Vuelve a listar los Menús activos
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<MenuD>> delete(@PathVariable("id") int menuId){
        menuDService.delete(menuId);
        return new ResponseEntity<>(menuDService.getAllActive(), HttpStatus.OK);
    }
}

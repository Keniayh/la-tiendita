package com.store.app_demo.infrastructure.controller;

import org.springframework.web.bind.annotation.RestController;

import com.store.app_demo.domain.entity.Store;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/api/demo")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class StoreRestController {
    private List<Store> lstStore = new ArrayList<>();
    @GetMapping("/list-store")
    public List<Store> liststore() {
        // Store store = new Store("C45T","Naruto", 20000, 20);
        // List<Store> lstStore = Arrays.asList(store);
        return lstStore;
    }
    @PostMapping("/createstore")
    public Store createproduct(@RequestBody Store store) {
        store.setNombre(store.getNombre().toUpperCase());
        lstStore.add(store);
        return store;
    }
    @DeleteMapping("deletestore/{codigo}")
    public String deleteProduct(@PathVariable String codigo) {
        Optional<Store> storeToRemove = lstStore.stream()
                .filter(store -> store.getCodigo().equals(codigo))
                .findFirst();
        if (storeToRemove.isPresent()) {
            lstStore.remove(storeToRemove.get());
            return "Producto eliminando con écito";
        } else {
            return "Producto no encontrado";
        }
    }
}

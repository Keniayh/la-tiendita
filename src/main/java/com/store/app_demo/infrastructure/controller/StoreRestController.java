package com.store.app_demo.infrastructure.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.app_demo.domain.entity.Store;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StoreRestController {
    @PostMapping("/createproduct")
    public Store createproduct(@RequestBody Store store) {
        store.setCodigo(store.getCodigo().toUpperCase());
        return store;
    }
    
}

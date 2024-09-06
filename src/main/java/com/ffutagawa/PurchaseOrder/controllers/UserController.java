package com.ffutagawa.PurchaseOrder.controllers;

import com.ffutagawa.PurchaseOrder.entities.User;
import com.ffutagawa.PurchaseOrder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.finAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
       User user = userService.findById(id);
       return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert (@RequestBody User user){
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update (@PathVariable Long id, @RequestBody User obj){
        obj = userService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}










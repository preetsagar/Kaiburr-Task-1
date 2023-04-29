package com.preet.task1.controller;

import com.preet.task1.model.serverModel;
import com.preet.task1.serverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class controller {

    @Autowired
    serverRepository repository;

    @GetMapping("/servers")
    public List<serverModel> getAllServer(){
        return repository.findAll();
    }

    @GetMapping("/servers/{id}")
    public List<serverModel> getServerByID(@PathVariable String id){
        System.out.print(id);
        Optional<serverModel> server = repository.findById(id);
        if (server.isPresent()) {
            return List.of(server.get());
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Server not found");
        }
    }

    @PutMapping("/servers")
    public serverModel addServer(@RequestBody serverModel server){
        return repository.save(server);
    }

    @DeleteMapping("servers/{id}")
    public void deleteServer(@PathVariable String id) {
        repository.deleteById(id);
    }

    @GetMapping("servers/name/{name}")
    public List<serverModel> getServersByName(@PathVariable String name) {
        List<serverModel> servers = repository.findByName(name);
        if (servers.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No servers found with name: " + name);
        } else {
            return servers;
        }
    }

}

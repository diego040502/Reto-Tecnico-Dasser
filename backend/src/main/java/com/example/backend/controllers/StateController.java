package com.example.backend.controllers;

import com.example.backend.models.StateModel;
import com.example.backend.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/state")
public class StateController {
    @Autowired
    private StateService service;

    @GetMapping("/states")
    public List<StateModel> listStates(){
        return  service.listStates();
    }

    @GetMapping("/users/{id}")
    public Optional<StateModel> getStateById(@PathVariable Integer id){
        return service.getStateById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<StateModel> saveState(@RequestBody StateModel model){
        service.saveState(model);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StateModel> updateState(@PathVariable Integer id, @RequestBody StateModel model){
        StateModel s = service.updateState(id, model);
        if(s != null){
            return  new ResponseEntity<>(s, HttpStatus.OK);
        } else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StateModel> deleteState(@PathVariable Integer id){
        service.deleteState(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

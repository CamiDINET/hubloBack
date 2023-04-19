package com.projet3.hublo.controller;

import com.projet3.hublo.entity.Category;
import com.projet3.hublo.entity.Command;
import com.projet3.hublo.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommandController {
    @Autowired
    private CommandRepository commandRepository;

    @GetMapping("/commands")
    public List<Command> getAll(){
        return commandRepository.findAll();
    }

    @GetMapping("/commands/{id}")
    public Command getCommand(@PathVariable Long id){
        return commandRepository.findById(id).get();
    }

    @PostMapping("/commands")
    public Command createCommand(@RequestBody Command command){
        return commandRepository.save(command);
    }
    @PutMapping("/commands/{id}")
    public Command updateCommand(@PathVariable Long id, @RequestBody Command command){
        Command commandToUpdate = commandRepository.findById(id).get();
        commandToUpdate.setComment(command.getComment());
        commandToUpdate.setDeliveryStation(command.getDeliveryStation());
        return commandRepository.save(commandToUpdate);
    }
    @DeleteMapping("commands/{id}")
    public boolean deleteCommandById(@PathVariable Long id){
        commandRepository.deleteById(id);
        return true;
    }
}

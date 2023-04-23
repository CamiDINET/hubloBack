package com.projet3.hublo.controller;


import com.projet3.hublo.entity.ProductCommand;
import com.projet3.hublo.repository.ProductCommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProductCommandController {
    @Autowired
    private ProductCommandRepository productCommandRepository;
    @GetMapping("/productCommands")
    public List<ProductCommand> getAll(){ return productCommandRepository.findAll(); }

    @GetMapping("/productCommands/{id}")
    public ProductCommand getProductCommand(@PathVariable Long id){ return productCommandRepository.findById(id).get(); }

    @PostMapping("/productCommands")
    public ProductCommand createProductCommand(@RequestBody ProductCommand productCommand){
        return productCommandRepository.save(productCommand);
    }
    @PutMapping("/productCommands/{id}")
    public ProductCommand updateProductCommand(@PathVariable Long id, @RequestBody ProductCommand productCommand){
        ProductCommand productCommandToUpdate = productCommandRepository.findById(id).get();
        productCommandToUpdate.setCommand(productCommand.getCommand());
        productCommandToUpdate.setProduct(productCommand.getProduct());
        productCommandToUpdate.setQuantity(productCommand.getQuantity());
        return productCommandRepository.save(productCommandToUpdate);
    }
    @DeleteMapping("productCommands/{id}")
    public boolean deleteProductCommandById(@PathVariable Long id){
        productCommandRepository.deleteById(id);
        return true;
    }
}

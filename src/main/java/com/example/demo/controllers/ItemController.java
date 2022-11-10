package com.example.demo.controllers;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.models.Item;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

@CrossOrigin(origins = "http://localhost:3000/") 
@RestController
public class ItemController {
    private final ItemRepository itemRepository;
    public ItemController(final ItemRepository itemRepository) {
this.itemRepository=itemRepository;
    }
@GetMapping("/items")
public Iterable<Item> getAllItems() {
    return this.itemRepository.findAll();
}

@GetMapping("/items/{id}")
public Optional<Item> 
getItemById(@PathVariable("id") Integer id) {
    return this.itemRepository.findById(id);
}

@PostMapping("/items") 
public Item createNewItem(@RequestBody Item item) {
    Item newItem = this.itemRepository.save(item);
    return newItem; 

}
@PutMapping("/items/{id}")
  public Item updateItem(@PathVariable("id") Integer id, @RequestBody Item i) {
    Optional<Item> itemToUpdateOptional = this.itemRepository.findById(id);
 if (!itemToUpdateOptional.isPresent()) {
    return null;
 }
  Item itemToUpdate = itemToUpdateOptional.get();
 
  if (i.getName() != null) {
    itemToUpdate.setName(i.getName());
  }
  if (i.getDescription() != null) {
    itemToUpdate.setDescription(i.getDescription());
  }
  if (i.getType() != null) {
    itemToUpdate.setType(i.getType());
  }
  
 
 
  Item updatedItem = this.itemRepository.save(itemToUpdate);
  return updatedItem;
  }

  @DeleteMapping("/items/{id}")
public Item deleteItem(@PathVariable("id") Integer id) {
  Optional<Item> itemToDeleteOptional = this.itemRepository.findById(id);
  if (!itemToDeleteOptional.isPresent()) {
    return null;
  }
  Item itemToDelete = itemToDeleteOptional.get();
  this.itemRepository.delete(itemToDelete);
  return itemToDelete;
}


}

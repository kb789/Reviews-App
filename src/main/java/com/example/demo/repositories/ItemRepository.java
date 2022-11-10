package com.example.demo.repositories;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.models.Item;


public interface ItemRepository extends CrudRepository<Item, Integer> {


}


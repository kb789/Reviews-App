package com.example.demo.repositories;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.models.Review;


public interface ReviewRepository extends CrudRepository<Review, Integer> {


}


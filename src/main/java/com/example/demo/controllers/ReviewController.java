package com.example.demo.controllers;
import com.example.demo.repositories.ReviewRepository;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.models.Item;
import com.example.demo.models.Review;

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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "https://reviews-lime-two.vercel.app/") 
@RestController
public class ReviewController {
    private final ReviewRepository reviewRepository;
    private ItemRepository itemRepository;
    public ReviewController(final ReviewRepository reviewRepository, final ItemRepository itemRepository) {
        this.reviewRepository=reviewRepository;
        this.itemRepository=itemRepository;

    }

    @GetMapping("/reviews")
public Iterable<Review> getAllReviews() {
    return this.reviewRepository.findAll();
}



@PostMapping("/items/{id}/reviews") 
public Review createNewReview(@PathVariable("id") Integer id, @RequestBody Review r) {
   
    Review newReview = this.reviewRepository.save(r);
    Optional<Item> i=this.itemRepository.findById(id);
    Item itemToUpdate = i.get();
    List<Review> itemReviews = itemToUpdate.getReviews();
    itemReviews.add(r);
    itemToUpdate.setReviews(itemReviews);
    this.itemRepository.save(itemToUpdate);
    return newReview;

}
   
}
package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "reviews")

public class Review {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(name="TEXT")
private String text;

@Column(name="RATING")
private Integer rating;


public String getText() {
    return this.text;
  }
  
  public void setText(String text) {
    this.text = text;
  }

  public Integer getRating() {
    return this.rating;
  }
  
  public void setRating(Integer rating) {
    this.rating = rating;
  }

  
    
}

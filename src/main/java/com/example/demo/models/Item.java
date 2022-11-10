package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Table;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name = "items")
public class Item {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(name="NAME")
private String name;

@Column(name="DESCRIPTION")
private String description;

@Column(name="TYPE")
private String type;

@OneToMany(
  cascade = CascadeType.ALL,
  orphanRemoval = true
)
@JoinColumn(name = "item_id")
private List<Review> reviews = new ArrayList<>();


public Integer getId() {
  return this.id;
}

public void setId(Integer id) {
  this.id = id;
}

public String getName() {
  return this.name;
}

public void setName(String name) {
  this.name = name;
}


public String getDescription() {
  return this.description;
}

public void setDescription(String description) {
  this.description = description;
}

public String getType() {
  return this.type;
}

public void setType(String type) {
  this.type = type;
}

public List<Review> getReviews()  
{
  return this.reviews;
}
public void setReviews(List<Review> reviews) {
  this.reviews = reviews;
}

}
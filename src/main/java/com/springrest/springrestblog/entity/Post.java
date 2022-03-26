package com.springrest.springrestblog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Post {
   @Id
   @GeneratedValue(
     strategy = GenerationType.IDENTITY
   )
   private long id;
   
   @Column(nullable=false)
   private String title;
   @Column(nullable=false)
   private String description;
   @Column(nullable=false)
   private String content;
   
}

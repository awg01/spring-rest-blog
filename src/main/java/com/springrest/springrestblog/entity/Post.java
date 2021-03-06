package com.springrest.springrestblog.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


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
   
   @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
   private Set<Comment> comments = new HashSet<>();
}

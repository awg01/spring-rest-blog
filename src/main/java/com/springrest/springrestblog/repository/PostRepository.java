package com.springrest.springrestblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrestblog.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}

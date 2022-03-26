package com.springrest.springrestblog.service;

import java.util.List;

import org.hibernate.event.spi.PostDeleteEvent;

import com.springrest.springrestblog.payload.PostDto;

public interface PostService {
  PostDto createPost(PostDto postDto);
  List<PostDto> getAllPosts();
}

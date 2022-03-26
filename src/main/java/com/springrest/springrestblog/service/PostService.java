package com.springrest.springrestblog.service;

import org.hibernate.event.spi.PostDeleteEvent;

import com.springrest.springrestblog.payload.PostDto;

public interface PostService {
  PostDto createPost(PostDto postDto);
}

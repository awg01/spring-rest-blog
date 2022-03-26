package com.springrest.springrestblog.service;

import java.util.List;

import org.hibernate.event.spi.PostDeleteEvent;

import com.springrest.springrestblog.entity.Post;
import com.springrest.springrestblog.payload.PostDto;

public interface PostService {
  PostDto createPost(PostDto postDto);
//  List<PostDto> getAllPosts();
  List<Post> getAllPosts();
  PostDto getPostById(long id);
  PostDto updatePostById(PostDto postDto, long id);
}

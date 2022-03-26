package com.springrest.springrestblog.service.impl;

import org.springframework.stereotype.Service;

import com.springrest.springrestblog.entity.Post;
import com.springrest.springrestblog.payload.PostDto;
import com.springrest.springrestblog.repository.PostRepository;
import com.springrest.springrestblog.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	private PostRepository postRepository;
	
	
	public PostServiceImpl(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}


	@Override
	public PostDto createPost(PostDto postDto) {
		//convert dto to entity
		Post post = new Post();
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		
		Post newPost = postRepository.save(post);
		
		//convert entity to dto
		PostDto postResponse = new PostDto();
		postResponse.setId(newPost.getId());
		postResponse.setTitle(newPost.getTitle());
		postResponse.setDescription(newPost.getDescription());
		postResponse.setContent(newPost.getContent());
		
		return postResponse;
	}
}

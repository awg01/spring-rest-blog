package com.springrest.springrestblog.service.impl;

import java.util.ArrayList;
import java.util.List;

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
		// convert dto to entity
		Post post = mapToEntity(postDto);
		
		Post newPost = postRepository.save(post);

		// convert entity to dto
		PostDto postResponse = mapToDto(newPost);

		return postResponse;
	}

	@Override
	public List<PostDto> getAllPosts() {
		List<Post> postList = postRepository.findAll();
		List<PostDto> posts = new ArrayList<>();
		
		for(Post e:postList) {
			posts.add(e);
		}
		
		return posts;
	}

	// convert entity to dto
	private PostDto mapToDto(Post post) {
		PostDto postDto = new PostDto();
		postDto.setId(post.getId());
		postDto.setTitle(post.getTitle());
		postDto.setDescription(post.getDescription());
		postDto.setContent(post.getContent());

		return postDto;
	}

	// convert dto to entity
	private Post mapToEntity(PostDto postDto) {
		Post post = new Post();
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());

		return post;
	}
}

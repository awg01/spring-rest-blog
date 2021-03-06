package com.springrest.springrestblog.service.impl;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springrest.springrestblog.entity.Post;
import com.springrest.springrestblog.exception.ResourceNotFoundException;
import com.springrest.springrestblog.payload.PostDto;
import com.springrest.springrestblog.payload.PostResponse;
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
	public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() 
				: Sort.by(sortBy).descending();
		
		//pagination
		PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);
		
//		List<Post> postList = postRepository.findAll();
		Page<Post> postList = postRepository.findAll(pageable);
		
		List<Post> content = postList.getContent();
		
		for(Post e:postList) {
//			posts.add(e);
		}
		
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(content);
		postResponse.setPageNo(postList.getNumber());
		postResponse.setPageSize(postList.getSize());
		postResponse.setTotalElements(postList.getTotalElements());
		postResponse.setTotalPages(postList.getTotalPages());
		postResponse.setLast(postList.isLast());
		postResponse.setFirst(postList.isFirst());
		
		return postResponse;
	}

	@Override
	public PostDto getPostById(long id) {
		//https://szymonkrajewski.pl/the-practical-difference-between-findby-and-getby-in-repositories/
//		Post post = postRepository.getById(id); 
		Post post = postRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("post", "id", id+"") );
		PostDto postDto = mapToDto(post);
		return postDto;
	}
	
	@Override
	public PostDto updatePostById(PostDto postDto, long id) {
		Post post = postRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("post", "id", id+"") );
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		Post updatedPost = postRepository.save(post);
		
		
		return mapToDto(updatedPost);
	}
	
	@Override
	public void deletePostById(long id) {
		Post post = postRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("post", "id", id+"") );
		postRepository.delete(post);
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

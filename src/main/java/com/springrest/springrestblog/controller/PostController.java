package com.springrest.springrestblog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrestblog.entity.Post;
import com.springrest.springrestblog.payload.PostDto;
import com.springrest.springrestblog.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	private PostService postService;

	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
	
	//create blog post
	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
		return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
	}
	
	//get all posts
//	@GetMapping
//	public List<Post> getAllPosts() {
//		return postService.getAllPosts();
//	}
	
	//get all posts pagination
	@GetMapping
	public List<Post> getAllPosts(
			@PathVariable(value="pageNo", required=false) int  pageNo, 
			@PathVariable(value="pageSize", required=false) int pageSize
	){
		return postService.getAllPosts(pageNo, pageSize);
	}
	
	
	//get a single post by id
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable long id) {
		return ResponseEntity.ok(postService.getPostById(id));
	}
	
	//update a post
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto,  @PathVariable long id){
		return ResponseEntity.ok(postService.updatePostById(postDto, id));
	}
	
	//delete post
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePostById(@PathVariable long id){
		postService.deletePostById(id);
		return ResponseEntity.ok("Deleted post successfully");
	}

}

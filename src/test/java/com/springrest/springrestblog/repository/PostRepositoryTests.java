package com.springrest.springrestblog.repository;

import javax.persistence.Column;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.springrest.springrestblog.entity.Post;

@DataJpaTest //loads repository layer components - auto adds in memory db
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //Annotation that can be applied to a test class to configure a test database to use instead of the application-defined or auto-configured DataSource
public class PostRepositoryTests {
   @Autowired
   private PostRepository postRepository;
   
   //junit test for createPost method
   @DisplayName("Junit test for create post method")
   @Test
   public void givenPostObject_whenCreate_thenReturnCreatedPost() {
	   //given - precondition
	   Post post = Post.builder().title("first post").content("contents").description("test post create method").build();
			   
	   //when - action to test
	   Post createdPost = postRepository.save(post);
	   
	   //then - verify the output
	   assertThat(createdPost).isNotNull();
	   assertThat(createdPost.getId()).isGreaterThan(0);
	   
   }
}

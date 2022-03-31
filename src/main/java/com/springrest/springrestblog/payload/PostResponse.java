package com.springrest.springrestblog.payload;

import java.util.List;

import com.springrest.springrestblog.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
   private List<Post> content;
   private int pageNo;
   private int pageSize;
   private long totalElements;
   private int totalPages;
   private boolean isLast;
   private boolean isFirst;
}

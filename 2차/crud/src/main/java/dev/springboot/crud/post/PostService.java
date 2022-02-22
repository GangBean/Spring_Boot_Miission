package dev.springboot.crud.post;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface PostService {
    void createPost(PostDto dto);
    HashMap<Integer, PostDto> readAllPost();
    PostDto readPost(int id);
    void updatePost(int id, PostDto dto);
    void deletePost(int id);
}

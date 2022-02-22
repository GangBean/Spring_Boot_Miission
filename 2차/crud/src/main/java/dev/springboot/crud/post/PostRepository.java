package dev.springboot.crud.post;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface PostRepository {
    HashMap<Integer, PostDto> findAll();
    PostDto findById(int id);
    boolean save(PostDto dto);
    boolean delete(int id);
    boolean update(int id, PostDto dto);
}

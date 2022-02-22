package dev.springboot.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PostInMemoryRepository implements PostRepository {
    private static final Logger logger = LoggerFactory.getLogger(PostRepository.class);
    private final HashMap<Integer,PostDto> postMap;
    private int idx;

    public PostInMemoryRepository() {
        this.postMap = new HashMap<>();
        idx = 0;
    }

    @Override
    public HashMap<Integer, PostDto> findAll() {
        return this.postMap;
    }

    @Override
    public PostDto findById(int id) {
        return this.postMap.get(id);
    }

    @Override
    public boolean save(PostDto dto) {
        this.postMap.put(idx++,dto);
        return true;
    }

    @Override
    public boolean delete(int id) {
        this.postMap.remove(id);
        return true;
    }

    @Override
    public boolean update(int id, PostDto dto) {
        PostDto targetPost = this.postMap.get(id);

        if( dto.getTitle() != null ){
            targetPost.setTitle(dto.getTitle());
        }

        if( dto.getContent() != null ){
            targetPost.setContent(dto.getContent());
        }
        this.postMap.put(id, targetPost);
        return false;
    }
}

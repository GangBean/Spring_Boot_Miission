package dev.springboot.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class PostServiceImpl implements PostService{
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostRepository postRepository;

    public PostServiceImpl(
            @Autowired PostRepository postRepository) {

        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostDto dto) {
        postRepository.save(dto);
    }

    @Override
    public HashMap<Integer, PostDto> readAllPost() {
        return postRepository.findAll();
    }

    @Override
    public PostDto readPost(int id) {
        return postRepository.findById(id);
    }

    @Override
    public void updatePost(int id, PostDto dto) {
        postRepository.update(id, dto);
    }

    @Override
    public void deletePost(int id) {
        postRepository.delete(id);
    }
}

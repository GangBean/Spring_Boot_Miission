package dev.springboot.crud.board;

import dev.springboot.crud.post.PostDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface BoardRepository {
    HashMap<Integer, BoardDto> findAll();
    BoardDto findById(int id);
    boolean save(BoardDto dto);
    boolean delete(int id);
    boolean update(int id, BoardDto dto);
}

package dev.springboot.crud.board;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface BoardService {
    boolean createBoard(BoardDto dto);
    HashMap<Integer,BoardDto> readAllBoard();
    BoardDto findById(int id);
    boolean updateBoard(int id, BoardDto dto);
    boolean deleteBoard(int id);
}

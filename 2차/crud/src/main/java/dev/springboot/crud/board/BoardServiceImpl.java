package dev.springboot.crud.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class BoardServiceImpl implements BoardService{
    private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
    private final BoardRepository boardRepository;

    public BoardServiceImpl(
            @Autowired BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public boolean createBoard(BoardDto dto) {
        return boardRepository.save(dto);
    }

    @Override
    public HashMap<Integer,BoardDto> readAllBoard() {
        return boardRepository.findAll();
    }

    @Override
    public BoardDto findById(int id) {
        return boardRepository.findById(id);
    }

    @Override
    public boolean updateBoard(int id, BoardDto dto) {
        return boardRepository.update(id, dto);
    }

    @Override
    public boolean deleteBoard(int id) {
        return boardRepository.delete(id);
    }
}

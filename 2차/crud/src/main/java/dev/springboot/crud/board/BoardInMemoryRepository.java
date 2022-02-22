package dev.springboot.crud.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BoardInMemoryRepository implements BoardRepository{
    private final static Logger logger = LoggerFactory.getLogger(BoardRepository.class);
    private final HashMap<Integer, BoardDto> boardMap;
    private int idx;

    public BoardInMemoryRepository() {
        this.boardMap = new HashMap<>();
    }

    @Override
    public HashMap<Integer, BoardDto> findAll() {
        return this.boardMap;
    }

    @Override
    public BoardDto findById(int id) {
        return this.boardMap.get(id);
    }

    @Override
    public boolean save(BoardDto dto) {
        this.boardMap.put(idx++, dto);
        return true;
    }

    @Override
    public boolean delete(int id) {
        this.boardMap.remove(id);
        return true;
    }

    @Override
    public boolean update(int id, BoardDto dto) {
        BoardDto targetDto = new BoardDto();
        if( dto.getName() != null ){
            targetDto.setName(dto.getName());
        }

        if(dto.getPostList() != null){
            targetDto.setPostList(dto.getPostList());
        }
        this.boardMap.put(id, targetDto);
        return true;
    }
}

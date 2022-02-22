package dev.springboot.crud.board;

import dev.springboot.crud.post.PostRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("board")
public class BoardRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final BoardRepository boardRepository;

    public BoardRestController(
            @Autowired BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @PostMapping()
    public void createBoard(
            @RequestBody BoardDto boardDto){
        BoardDto targetDto = new BoardDto();

        if(boardDto.getName() != null){
            targetDto.setName( boardDto.getName());
        } else {
            logger.info("Please enter name");
            throw new RuntimeException();
        }

        if(boardDto.getPostList() != null){
            targetDto.setPostList(boardDto.getPostList());
        }

        this.boardRepository.save(targetDto);
    }

    @GetMapping()
    public HashMap<Integer,BoardDto> readBoardAll(){
        return this.boardRepository.findAll();
    }

    @GetMapping("{id}")
    public BoardDto readBoard(@PathVariable("id") int id){
        if( this.boardRepository.findAll().size() == 0
                || this.boardRepository.findAll().size() <= id ){
            logger.info("존재하지 않는 게시판입니다.");
            throw new RuntimeException();
        }
        return this.boardRepository.findById(id);
    }

    @PutMapping("{id}")
    public void updateBoard(
            @PathVariable("id") int id,
            @RequestBody BoardDto boardDto){

        this.boardRepository.update(id, boardDto);
    }

    @DeleteMapping("{id}")
    public void deleteBoard(@PathVariable("id") int id){
        this.boardRepository.delete(id);
    }

}

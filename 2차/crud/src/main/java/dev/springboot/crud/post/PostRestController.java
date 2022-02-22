package dev.springboot.crud.post;

import dev.springboot.crud.board.BoardRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.RuntimeErrorException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("board/{name}/post")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final BoardRestController boardRestController;
    private int idx;

    public PostRestController(
            @Autowired BoardRestController boardRestController
    ) {
        this.boardRestController = boardRestController;
    }

    @PostMapping()
    public void createPost(
            @PathVariable("name") int name,
            @RequestBody PostDto postDto
    ){
        logger.info(postDto.toString());
        while(this.boardRestController.readBoard(name).getPostList().get(idx) != null){
            idx++;
        }
        this.boardRestController.readBoard(name).getPostList().put(idx++, postDto);
    }

    @GetMapping()
    public HashMap<Integer,PostDto> readPostAll(
            @PathVariable("name") int name
    ){
        logger.info("Read all Posts!");
        return this.boardRestController.readBoard(name).getPostList();
    }

    @GetMapping("{id}")
    public PostDto readPost(
            @PathVariable("name") int name,
            @PathVariable("id") int id
    ){
        logger.info("Read post.");
        return this.boardRestController.readBoard(name).getPostList().get(id);
    }

    @PutMapping("{id}")
    public Boolean updatePost(
            @PathVariable("name") int name,
            @PathVariable("id") int id,
            @RequestBody PostDto postDto
    ){
      PostDto targetPost = this.boardRestController.readBoard(name).getPostList().get(id);
      if( postDto.getTitle() != null ){
          targetPost.setTitle(postDto.getTitle());
      }

      if( postDto.getContent() != null ){
          targetPost.setContent(postDto.getContent());
      }
      this.boardRestController.readBoard(name).getPostList().put(id, targetPost);
      return true;
    }

    @DeleteMapping("{id}")
    public void deletePost(
            @PathVariable("name") int name,
            @PathVariable("id") int id,
            @RequestParam("password") String password
    ){
        if( password.equals(
                this.boardRestController.readBoard(name).getPostList().get(id).getPassword())){
            this.boardRestController.readBoard(name).getPostList().remove(id);
        } else {
            logger.info("패스워드가 일치하지 않습니다.");
            throw new RuntimeException("패스워드 불일치");
        }
    }
}

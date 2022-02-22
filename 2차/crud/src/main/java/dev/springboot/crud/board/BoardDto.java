package dev.springboot.crud.board;

import dev.springboot.crud.post.PostDto;

import java.util.HashMap;
import java.util.List;

public class BoardDto {
    private HashMap<Integer,PostDto> postList;
    private String name;

    public BoardDto(){
    }

    public BoardDto(HashMap<Integer,PostDto> postList, String name) {
        this.postList = postList;
        this.name = name;
    }

    public HashMap<Integer,PostDto> getPostList() {
        return postList;
    }

    public String getName() {
        return name;
    }

    public void setPostList(HashMap<Integer,PostDto> postList) {
        this.postList = postList;
    }

    public void setName(String name) {
        this.name = name;
    }
}

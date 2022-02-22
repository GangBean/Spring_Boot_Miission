package dev.springboot.crud.post;

public class PostDto {
    private String title;
    private String content;
    private String writer;
    private String password;

    public PostDto(String title, String content, String writer, String password) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public String getPassword() {
        return password;
    }
}

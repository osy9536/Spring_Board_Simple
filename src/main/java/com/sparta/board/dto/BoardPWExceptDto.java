package com.sparta.board.dto;

import com.sparta.board.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardPWExceptDto {
    public LocalDateTime createdAt;
    public LocalDateTime modifiedAt;
    public Long id;
    public String title;
    public String userName;
    public String comment;

    public BoardPWExceptDto(Board board) {
        createdAt = board.getCreatedAt();
        modifiedAt = board.getModifiedAt();
        id = board.getId();
        title = board.getTitle();
        userName = board.getUserName();
        comment = board.getComment();
    }
}

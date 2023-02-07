package com.sparta.board.dto;

import com.sparta.board.entity.Board;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class BoardGetDto {
    private String title;
    private String userName;
    private String comment;
    private LocalDateTime createdAt;

    public BoardGetDto(Board board) {
        title = board.getTitle();
        userName = board.getUserName();
        comment = board.getComment();
        createdAt = board.getCreatedAt();
    }
}

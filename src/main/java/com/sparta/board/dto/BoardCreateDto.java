package com.sparta.board.dto;

import lombok.Getter;

@Getter
public class BoardCreateDto {
    private String title;
    private String userName;
    private String password;
    private String comment;
}

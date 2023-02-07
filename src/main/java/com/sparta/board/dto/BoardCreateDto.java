package com.sparta.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCreateDto {
    private String title;
    private String userName;
    private String password;
    private String comment;
}

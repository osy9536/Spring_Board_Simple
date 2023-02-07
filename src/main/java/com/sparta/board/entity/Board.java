package com.sparta.board.entity;

import com.sparta.board.dto.BoardCreateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Board extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable = false)
    public String title;

    @Column(nullable = false)
    public String userName;

    @Column(nullable = false)
    public String comment;

    @Column(nullable = false)
    public String password;

    public Board(BoardCreateDto boardCreateDto) {
        this.title=boardCreateDto.getTitle();
        this.userName = boardCreateDto.getUserName();
        this.comment = boardCreateDto.getPassword();
        this.password = boardCreateDto.getPassword();
    }

    public void update(BoardCreateDto boardCreateDto) {
        this.title=boardCreateDto.getTitle();
        this.userName = boardCreateDto.getUserName();
        this.comment = boardCreateDto.getComment();
        this.password = boardCreateDto.getPassword();
    }
}

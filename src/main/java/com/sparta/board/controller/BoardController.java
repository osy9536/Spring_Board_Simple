package com.sparta.board.controller;

import com.sparta.board.dto.BoardCreateDto;
import com.sparta.board.dto.BoardGetDto;
import com.sparta.board.entity.Board;
import com.sparta.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/api/board")
    public Board createBoard(@RequestBody BoardCreateDto boardCreateDto) {
        return boardService.createBoard(boardCreateDto);
    }

    @GetMapping("/api/board")
    public List<BoardGetDto> getBoard() {
        return boardService.getBoard();
    }

    @GetMapping("/api/board/{id}")
    public BoardGetDto getIdBoard(@PathVariable Long id) {
        return boardService.getIdBoard(id);
    }

    @PutMapping("/api/board/{id}")
    public Board updateBoard(@PathVariable Long id, @RequestBody BoardCreateDto boardCreateDto) {
        return boardService.update(id, boardCreateDto);
    }

    @DeleteMapping("/api/board/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        return boardService.deleteBoard(id);
    }
}

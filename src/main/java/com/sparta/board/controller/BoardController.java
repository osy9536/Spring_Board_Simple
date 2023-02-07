package com.sparta.board.controller;

import com.sparta.board.dto.BoardCreateDto;
import com.sparta.board.dto.BoardPWExceptDto;
import com.sparta.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/api/board")
    public BoardPWExceptDto createBoard(@RequestBody BoardCreateDto boardCreateDto) {
        return boardService.createBoard(boardCreateDto);
    }

    @GetMapping("/api/board")
    public List<BoardPWExceptDto> getBoard() {
        return boardService.getBoard();
    }

    @GetMapping("/api/board/{id}")
    public BoardPWExceptDto getIdBoard(@PathVariable Long id) {
        return boardService.getIdBoard(id);
    }

    @PutMapping("/api/board/{id}")
    public BoardPWExceptDto updateBoard(@PathVariable Long id, @RequestBody BoardCreateDto boardCreateDto) {
        return boardService.update(id, boardCreateDto);
    }

    @DeleteMapping("/api/board/{id}/{password}")
    public Map<String, Boolean> deleteBoard(@PathVariable Long id, @PathVariable String password) {
        return boardService.deleteBoard(id,password);
    }
}

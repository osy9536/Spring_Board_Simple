package com.sparta.board.service;

import com.sparta.board.dto.BoardCreateDto;
import com.sparta.board.dto.BoardPWExceptDto;
import com.sparta.board.entity.Board;
import com.sparta.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardPWExceptDto createBoard(BoardCreateDto boardCreateDto) {
        Board board = new Board(boardCreateDto);
        boardRepository.save(board);
        return new BoardPWExceptDto(board);
    }

    public List<BoardPWExceptDto> getBoard() {
        List<Board> board = boardRepository.findAllByOrderByModifiedAtDesc();
        List<BoardPWExceptDto> boardPWExceptDtos = new ArrayList<>();
        for (Board b : board) {
            boardPWExceptDtos.add(new BoardPWExceptDto(b));
        }
        return boardPWExceptDtos;
    }


    public BoardPWExceptDto getIdBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return new BoardPWExceptDto(board);
    }

    public BoardPWExceptDto update(Long id, BoardCreateDto boardCreateDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (board.getPassword().equals(boardCreateDto.getPassword())) {
            board.update(boardCreateDto);
            boardRepository.save(board);
        } else throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");

        return new BoardPWExceptDto(board);
    }

    public Map<String ,Boolean> deleteBoard(Long id, String pw) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        Map<String, Boolean> map = new HashMap<>();
        if (board.getPassword().equals(pw)) {
            boardRepository.deleteById(id);
            map.put("success", true);
        } else throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        return map;
    }
}

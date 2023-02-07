package com.sparta.board.service;

import com.sparta.board.dto.BoardCreateDto;
import com.sparta.board.dto.BoardGetDto;
import com.sparta.board.entity.Board;
import com.sparta.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board createBoard(BoardCreateDto boardCreateDto) {
        return boardRepository.save(new Board(boardCreateDto));
    }

    public List<BoardGetDto> getBoard() {
        List<Board> board = boardRepository.findAllByOrderByModifiedAtDesc();
        List<BoardGetDto> boardGetDto = new ArrayList<>();
        for (Board b : board) {
            boardGetDto.add(new BoardGetDto(b));
        }
        return boardGetDto;
    }


    public BoardGetDto getIdBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return new BoardGetDto(board);
    }

    public Board update(Long id,BoardCreateDto boardCreateDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (board.getPassword().equals(boardCreateDto.getPassword())) {
            board.update(boardCreateDto);
            boardRepository.save(board);
        } else throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");

        return board;
    }

    public Long deleteBoard(Long id) {
        boardRepository.deleteById(id);
        return id;
    }
}

package com.korit.servlet_study.service;

import com.korit.servlet_study.dao.BoardDao;
import com.korit.servlet_study.dto.InsertBoardDto;
import com.korit.servlet_study.entity.Board;

public class BoardService {
//    private BoardDao boardDao;
//    private static BoardService boardService;
//
//    private BoardService() {boardDao = boardDao.getInstance();}
//
//    public static BoardService getInstance() {
//        if (boardService == null) {
//            boardService = new BoardService();
//        }
//        return boardService;
//    }
//
//    public Board addBoard(Board board) {
//        boardDao.save(board);
//
//        return boardDao.save(board).get();
//    }
    private BoardDao boardDao;

    private static BoardService instance;

    private BoardService() {
        boardDao = BoardDao.getInstance();
    }

    public static BoardService getInstance() {
        if (instance == null) {
            instance = new BoardService();
        }
        return instance;
    }


    public void insertBoard(InsertBoardDto dto) {
        Board board = dto.toBoard();
        boardDao.save(board);
    }
}

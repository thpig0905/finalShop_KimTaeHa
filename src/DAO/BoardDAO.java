package DAO;

import DTO.Board;
import Util.Util;

import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    public List<Board> boardList;
    private BoardDAO() {}
    private static BoardDAO instance = new BoardDAO();
    public static BoardDAO getInstance() { return instance; }

    public void printBoardList(){
        System.out.println("=====[ 게시판 목록 ]=====");
        int totalPage = boardList.size() % 5 == 0 ? boardList.size() / 5 : boardList.size() / 5 + 1;
        int nowPage = 1;
        while (true) {
            System.out.printf("총 게시글 : %d\n", boardList.size());
            System.out.printf("현재 페이지 : %d / %d\n", nowPage, totalPage);
            for (int i = nowPage - 1; i < nowPage * 5; i++) {
                Board board = boardList.get(i);
                System.out.println(board);
            }
            System.out.println("[1] 이전 페이지\n[2] 다음 페이지\n[3] 게시글 보기\n[0] 뒤로가기");
            int sel = Util.getInt("메뉴", 0, 3);
            if (sel == 0){
                break;
            } else if (sel == 1){
                if (nowPage == 1) {
                    System.out.println("첫 페이지 입니다.");
                } else {
                    nowPage--;
                }
            } else if (sel == 2){
                if (nowPage == totalPage) {
                    System.out.println("마지막 페이지 입니다.");
                } else {
                    nowPage++;
                }
            } else if (sel == 3){
                Board board = getBoard(Util.getInt("게시글 번호", 1, boardList.size()));
                if (board == null) {
                    System.out.println("없는 게시글 입니다.");
                } else {
                    System.out.printf("제목 : %s\t", board.getTitle());
                    System.out.printf("작성자 : %s\n", board.getId());
                    System.out.printf("작성일 : %s\t", board.getDate());
                    System.out.printf("조회수 : %d\n", board.getHits());
                    System.out.printf("내용 : %s\n", board.getContents());
                }
            }
        }
    }

    public void printBoardList(String id){
        System.out.println("=====[ 게시판 목록 ]=====");
        List<Board> temp = new ArrayList<>();
        for (Board board : boardList){
            if (board.getId().equals(id)){
                temp.add(board);
            }
        }
        int totalPage = temp.size() % 5 == 0 ? temp.size() / 5 : temp.size() / 5 + 1;
        int nowPage = 1;
        while (true) {
            System.out.printf("총 게시글 : %d\n", boardList.size());
            System.out.printf("현재 페이지 : %d / %d\n", nowPage, totalPage);
            for (int i = nowPage - 1; i < nowPage * 5; i++) {
                Board board = boardList.get(i);
                System.out.println(board);
            }
            System.out.println("[1] 이전 페이지\n[2] 다음 페이지\n[3] 게시글 보기\n[4]게시글 삭제\n[0] 뒤로가기");
            int sel = Util.getInt("메뉴", 0, 4);

            if (sel == 0){
                break;
            } else if (sel == 1){
                if (nowPage == 1) {
                    System.out.println("첫 페이지 입니다.");
                } else {
                    nowPage--;
                }
            } else if (sel == 2){
                if (nowPage == totalPage) {
                    System.out.println("마지막 페이지 입니다.");
                } else {
                    nowPage++;
                }
            } else if (sel == 3){
                Board board = getBoard(Util.getInt("게시글 번호", 1, boardList.size()));
                if (board == null) {
                    System.out.println("없는 게시글 입니다.");
                } else {
                    System.out.printf("제목 : %s\t", board.getTitle());
                    System.out.printf("작성자 : %s\n", board.getId());
                    System.out.printf("작성일 : %s\t", board.getDate());
                    System.out.printf("조회수 : %d\n", board.getHits());
                    System.out.printf("내용 : %s\n", board.getContents());
                    board.setHits(board.getHits() + 1);
                }
            } else if (sel == 4){
                Board board = getBoard(Util.getInt("게시글 번호", 1, boardList.size()));
                if (board == null) {
                    System.out.println("없는 게시글 입니다.");
                } else {
                    boardList.remove(board);
                }
            }
        }
    }
    public void writeBoard(String id) {
        System.out.println("=====[ 게시글 작성 ]=====");
        String title = Util.getValue("제목");
        String contents = Util.getValue("내용");
        Board board = new Board(id, title, contents);
        boardList.add(board);
        System.out.println("[ 게시글 작성 완료 ]");
    }
    public void removeBoard() {
        printBoardList();
        System.out.println("=====[ 게시글 삭제 ]=====");
        Board board = getBoard(Util.getInt("삭제할 게시글 번호", 1, boardList.size()));
        if (board == null) {
            System.out.println("없는 게시글 입니다.");
            return;
        } else {
            boardList.remove(board);
        }
        System.out.println("게시글이 삭제되었습니다.");
    }
    private Board getBoard(int boardNum) {
        for (Board board : boardList) {
            if (board.getBoardNum() == boardNum) {
                return board;
            }
        }
        return null;
    }
}

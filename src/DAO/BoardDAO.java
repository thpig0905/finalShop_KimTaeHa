package DAO;

import DTO.Board;
import java.util.List;
import Util.Util;

public class BoardDAO {
    List<Board> boards;

    // BoardDAO 생성자
    private BoardDAO() {}
    private static BoardDAO instance = new BoardDAO();
    public static BoardDAO getInstance() { return instance; }

    public void printBoardList() {
        System.out.println("=====[ 게시판 목록 ]=====");
        int totalPage = boards.size() % 5 == 0 ? boards.size() / 5 : boards.size() / 5 + 1;
        int nowPage = 1;

        while (true) {
            System.out.printf("총 게시글 : %d\n", boards.size());
            System.out.printf("현재 페이지 : %d / %d\n", nowPage, totalPage);
            for (int i = (nowPage - 1) * 5; i < nowPage * 5; i++) {
                Board board = boards.get(i);
                System.out.printf("(%d) [ 제목 : %s ] [ 작성자 : %s ] [ 작성일 : %S ] [ 조회수 : %d ]\n",
                        board.getBoradNum(), board.getTitle(), board.getId(), board.getDate(), board.getHits());
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
                Board board = getBoard(Util.getInt("게시글 번호", 1, boards.size()));
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

    public void removeBoard() {
        printBoardList();
        System.out.println("=====[ 게시글 삭제 ]=====");
        Board board = getBoard(Util.getInt("삭제할 게시글 번호", 1, boards.size()));
        if (board == null) {
            System.out.println("없는 게시글 입니다.");
            return;
        } else {
            boards.remove(board);
        }
        System.out.println("게시글이 삭제되었습니다.");
    }

    public void writeBoard(String id) {
        System.out.println("=====[ 게시글 작성 ]=====");
        String title = Util.getValue("제목");
        Board board = getBoard(title);
        if (board != null) {
            System.out.println("이미 있는 제목 입니다.");
            return;
        }
        String contents = Util.getValue("내용");
        board = new Board(title, id, Util.getDate(), contents);
        boards.add(board);
        System.out.println("게시글이 작성되었습니다.");
    }

    private Board getBoard(String title){
        for (Board board : boards) {
            if (board.getTitle().equals(title)) {
                return board;
            }
        }
        return null;
    }

    public void printMyBoard(String id){
        for (Board board : boards) {
            if (board.getId().equals(id)) {
                System.out.printf("제목 : %s\t", board.getTitle());
                System.out.printf("작성자 : %s\n", board.getId());
                System.out.printf("작성일 : %s\t", board.getDate());
                System.out.printf("조회수 : %d\n", board.getHits());
                System.out.printf("내용 : %s\n", board.getContents());
            }
        }
    }

    public void printBoardList(String id) {
        System.out.println("=====[ 게시판 목록 ]=====");
        int totalPage = 0;
        for (Board board : boards) {
            if (board.getId().equals(id)) {
                totalPage++;
            }
        }
        int nowPage = 1;

        while (true) {
            System.out.printf("총 게시글 : %d\n", boards.size());
            System.out.printf("현재 페이지 : %d / %d\n", nowPage, totalPage);
            for (int i = (nowPage - 1) * 5; i < nowPage * 5; i++) {
                if (!boards.get(i).getId().equals(id)) {
                    continue;
                }
                Board board = boards.get(i);
                System.out.printf("(%d) [ 제목 : %s ] [ 작성자 : %s ] [ 작성일 : %S ] [ 조회수 : %d ]\n",
                        board.getBoradNum(), board.getTitle(), board.getId(), board.getDate(), board.getHits());
            }
            System.out.println("[1] 이전 페이지\n[2] 다음 페이지\n[3] 게시글 보기\n[4]게시글 삭제\n[0] 뒤로가기");
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
                Board board = getBoard(Util.getInt("게시글 번호", 1, boards.size()));
                if (board == null) {
                    System.out.println("없는 게시글 입니다.");
                } else {
                    System.out.printf("제목 : %s\t", board.getTitle());
                    System.out.printf("작성자 : %s\n", board.getId());
                    System.out.printf("작성일 : %s\t", board.getDate());
                    System.out.printf("조회수 : %d\n", board.getHits());
                    System.out.printf("내용 : %s\n", board.getContents());
                }
            } else if (sel == 4){
                removeBoard(id);
            }
        }
    }

    private void removeBoard(String id){
        Board board = getBoard(Util.getInt("삭제할 게시글 번호", 1, boards.size()));
        if (board == null) {
            System.out.println("없는 게시글 입니다.");
        } else {
            if (board.getId().equals(id)) {
                boards.remove(board);
                System.out.println("게시글이 삭제되었습니다.");
            } else {
                System.out.println("자신의 게시글만 삭제할 수 있습니다.");
            }
        }
    }

    private Board getBoard(int boardNum) {
        for (Board board : boards) {
            if (board.getBoradNum() == boardNum) {
                return board;
            }
        }
        return null;
    }
}

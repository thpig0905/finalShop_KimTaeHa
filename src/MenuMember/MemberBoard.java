package MenuMember;

import DAO.BoardDAO;
import Mall.MenuCommand;
import Util.Util;
import Controller.MallController;

public class MemberBoard implements MenuCommand {
    private MallController mallController = MallController.getInstance();
    @Override
    public void init() {
        System.out.println("=====[ 게시판 ]=====");
        System.out.println("[1] 게시글 보기");
        System.out.println("[2] 게시글 작성");
        System.out.println("[3] 내 게시글");
        System.out.println("[4] 뒤로가기");
        System.out.println("[0] 종료");
    }

    @Override
    public boolean update() {
        BoardDAO boardDAO = BoardDAO.getInstance();
        int sel = Util.getInt("번호를 입력하세요 : ", 0, 4);

        if (sel == 0) {
            System.out.println("[ 프로그램 종료 ]");
            mallController.setNext(null);
        } else if (sel == 1) {
            boardDAO.printBoardList();
        } else if (sel == 2) {
            boardDAO.writeBoard(mallController.getLoginId());
        } else if (sel == 3) {
            boardDAO.printBoardList(mallController.getLoginId());
        } else if (sel == 4) {
            mallController.setNext("MemberMain");
        }
        return false;
    }
}

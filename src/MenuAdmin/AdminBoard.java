package MenuAdmin;

import DAO.BoardDAO;
import Mall.MenuCommand;
import Controller.MallController;

public class AdminBoard implements MenuCommand {
    MallController mallController = MallController.getInstance();
    @Override
    public void init() {
        System.out.println("=====[ 게시판 관리 ]=====");
        System.out.println("[1] 게시글 목록");
        System.out.println("[2] 게시글 삭제");
        System.out.println("[3] 뒤로가기");
        System.out.println("[0] 종료");
    }

    @Override
    public boolean update() {
        BoardDAO boardDAO = BoardDAO.getInstance();
        int sel = Util.Util.getInt("메뉴", 0, 3);

        if (sel == 0) {
            mallController.setNext(null);
        } else if (sel == 1) {
            boardDAO.printBoardList();
        } else if (sel == 2) {
            boardDAO.removeBoard();
        } else if (sel == 3) {
            mallController.setNext("AdminMain");
        }
        return false;
    }
}

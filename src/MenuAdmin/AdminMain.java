package MenuAdmin;

import Mall.MenuCommand;
import Util.Util;
import Controller.MallController;
import DAO.FileDAO;

public class AdminMain implements MenuCommand {
    private MallController mallController = MallController.getInstance();
    private FileDAO fileDAO = FileDAO.getInstance();
    @Override
    public void init() {
        System.out.println("=====[ 관리자 ]=====");
        System.out.println("[1] 회원관리");
        System.out.println("[2] 상품관리");
        System.out.println("[3] 게시판관리");
        System.out.println("[4] 로그아웃");
        System.out.println("[5] 파일저장");
        System.out.println("[0] 종료");
    }

    @Override
    public boolean update() {
        int sel = Util.getInt("메뉴", 0, 5);

        if (sel == 0){
            mallController.setNext(null);
        } else if (sel == 1) {
            mallController.setNext("AdminMember");
        } else if (sel == 2) {
            mallController.setNext("AdminItem");
        } else if (sel == 3) {
            mallController.setNext("AdminBoard");
        } else if (sel == 4) {
            mallController.setLoginId(null);
            mallController.setNext("MallMain");
        } else if (sel == 5) {
            fileDAO.saveAllFile();
        }

        return false;
    }
}

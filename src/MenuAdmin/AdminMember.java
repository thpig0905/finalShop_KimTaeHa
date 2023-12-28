package MenuAdmin;

import DAO.MemberDAO;
import Mall.MenuCommand;
import Util.Util;
import Controller.MallController;

public class AdminMember implements MenuCommand {
    private MallController mallController = MallController.getInstance();
    @Override
    public void init() {
        System.out.println("=====[ 회원관리 ]=====");
        System.out.println("[1] 회원목록");
        System.out.println("[2] 회원삭제");
        System.out.println("[3] 뒤로가기");
        System.out.println("[0] 종료");
    }

    @Override
    public boolean update() {
        MemberDAO memberDAO = MemberDAO.getInstance();

        int sel = Util.getInt("메뉴", 0, 3);

        if (sel == 0) {
            mallController.setNext(null);
        } else if (sel == 1) {
            memberDAO.printMembers();
        } else if (sel == 2) {
            memberDAO.printMembers();
            memberDAO.deleteMember(Util.getValue("삭제할 회원 아이디"));
        } else if (sel == 3) {
            mallController.setNext("AdminMain");
        }
        return false;
    }
}

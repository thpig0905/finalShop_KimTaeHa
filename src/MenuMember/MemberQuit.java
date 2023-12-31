package MenuMember;

import Controller.MallController;
import DAO.MemberDAO;
import Mall.MenuCommand;
import Util.Util;

public class MemberQuit implements MenuCommand {
    private MallController mallController = MallController.getInstance();
    @Override
    public void init() {
        System.out.println("=====[ 회원탈퇴 ]=====");
        System.out.println("[1] 회원탈퇴");
        System.out.println("[2] 뒤로가기");
    }

    @Override
    public boolean update() {
        MemberDAO memberDAO = MemberDAO.getInstance();
        int sel = Util.getInt("번호를 입력하세요 : ", 1, 2);
        if (sel == 1) {
            memberDAO.deleteMember(mallController.getLoginId());
        } else if (sel == 2) {
            mallController.setNext("MemberMain");
        }
        return false;
    }
}

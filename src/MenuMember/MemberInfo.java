package MenuMember;

import Controller.MallController;
import DAO.MemberDAO;
import Mall.MenuCommand;
import Util.Util;

public class MemberInfo implements MenuCommand {
    private MallController mallController = MallController.getInstance();
    @Override
    public void init() {
        System.out.println("=====[ 나의정보 ]=====");
        System.out.println("[1] 비밀번호 변경");
        System.out.println("[2] 뒤로가기");
        System.out.println("[0] 종료");
    }

    @Override
    public boolean update() {
        MemberDAO memberDAO = MemberDAO.getInstance();
        int sel = Util.getInt("번호를 입력하세요 : ", 0, 2);
        if (sel == 0) {
            System.out.println("[ 프로그램 종료 ]");
            mallController.setNext(null);
        } else if (sel == 1) {
            memberDAO.changePw(mallController.getLoginId());
        } else if (sel == 2) {
            mallController.setNext("MemberMain");
        }
        return false;
    }
}

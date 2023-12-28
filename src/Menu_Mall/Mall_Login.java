package Menu_Mall;

import Cotroller.MallController;
import DAO.MemberDAO;
import Mall.MenuCommand;
import Util.Util;

public class Mall_Login implements MenuCommand {
    private MallController mallController;
    @Override
    public void init() {
        System.out.println("=====[ 로그인 ]=====");
        mallController = MallController.getInstance();
    }

    @Override
    public boolean update() {
        MemberDAO memberDAO = MemberDAO.getInstance();

        String id = Util.getValue("아이디 ");
        String pw = Util.getValue("페스워드 ");

        if (memberDAO.isValidMember(id, pw)!=null) {
            if (id.equals("admin")) {
                mallController.setLoginId("admin");
                mallController.setNext("Admin_Main");
            } else {
                mallController.setLoginId(id);
                mallController.setNext("Member_Main");
            }
            System.out.println("[ 로그인 성공 ]");
        } else {
            System.err.println("아이디 혹은 비밀번호를 확인해주세요");
            mallController.setNext("Mall_Main");
        }
        return false;
    }
}

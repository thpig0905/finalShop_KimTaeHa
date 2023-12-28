package Menu_Mall;

import Cotroller.MallController;
import DAO.MemberDAO;
import Mall.MenuCommand;
import Util.Util;

public class Mall_Join implements MenuCommand {
    private MallController mallController;
    @Override
    public void init() {mallController = MallController.getInstance();}

    @Override
    public boolean update() {
        System.out.println("=====[ 회원가입 ]=====");
        MemberDAO memberDAO = MemberDAO.getInstance();
        String id = Util.getValue("아이디 ");

        if(memberDAO.getMember(id)!= null) {
            System.out.println("이미 사용하는 아이디");
            return false;
        }

        String pw = Util.getValue("비밀번호 ");
        String name = Util.getValue("이름 ");

        memberDAO.insertMember(id , pw , name);

        mallController.setNext("Mall_Main");
        return false;
    }
}

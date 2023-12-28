package MenuMall;

import Controller.MallController;
import DAO.MemberDAO;
import Mall.MenuCommand;
import Util.Util;

public class MallJoin implements MenuCommand {
    private MallController mallController = MallController.getInstance();
    @Override
    public void init() {mallController = MallController.getInstance();}

    @Override
    public boolean update() {
        MemberDAO memberDAO = MemberDAO.getInstance();
        memberDAO.insertMember();
        mallController.setNext("MallMain");
        return false;
    }
}

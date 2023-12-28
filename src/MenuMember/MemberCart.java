package MenuMember;

import Controller.MallController;
import DAO.CartDAO;
import Mall.MenuCommand;
import Util.Util;

public class MemberCart implements MenuCommand {
    private MallController mallController = MallController.getInstance();
    @Override
    public void init() {
        System.out.println("=====[ 장바구니 ]=====");
        System.out.println("[1] 쇼핑하기");
        System.out.println("[2] 뒤로가기");
        System.out.println("[0] 종료");
    }

    @Override
    public boolean update() {
        CartDAO cartDAO = CartDAO.getInstance();
        cartDAO.cartSortByMember(mallController.getLoginId());

        int sel = Util.getInt("번호를 입력하세요 : ", 0, 2);

        if (sel == 0) {
            System.out.println("[ 프로그램 종료 ]");
            mallController.setNext(null);
        } else if (sel == 1) {
            mallController.setNext("MemberShopping");
        } else if (sel == 2) {
            mallController.setNext("MemberMain");
        }
        return false;
    }
}

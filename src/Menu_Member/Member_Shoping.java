package Menu_Member;

import Cotroller.MallController;
import DAO.CartDAO;
import DAO.ItemDAO;
import DTO.Item;
import Mall.MenuCommand;
import Util.Util;

public class Member_Shoping implements MenuCommand {
    MallController mallController = MallController.getInstance();
    int sel;
    @Override
    public void init() {
        System.out.println("=====[ 상품구매 ]=====");
        System.out.println("[1] 쇼핑하기");
        System.out.println("[2] 뒤로가기");
        System.out.println("[0] 종료");
    }

    @Override
    public boolean update() {
        ItemDAO itemDAO = ItemDAO.getInstance();
        String category = itemDAO.printItemCategory();
        if (category == null) {
            System.out.println("[ 상품이 존재하지 않습니다 ]");
            mallController.setNext("Member_Main");
            return false;
        }
        Item item = itemDAO.printItemByCategory(category);
        if (item == null) {
            System.out.println("[ 상품이 존재하지 않습니다 ]");
            mallController.setNext("Member_Main");
            return false;
        }
        CartDAO cartDAO = CartDAO.getInstance();
        cartDAO.addItemToCart(item, mallController.getLoginId());

        int sel = Util.getInt("번호를 입력하세요 : ", 0, 2);

        if (sel == 0) {
            System.out.println("[ 프로그램 종료 ]");
            mallController.setNext(null);
        } else if (sel == 1) {
            mallController.setNext("Member_Shopping");
        } else if (sel == 2) {
            mallController.setNext("Member_Main");
        }
        return false;
    }
}

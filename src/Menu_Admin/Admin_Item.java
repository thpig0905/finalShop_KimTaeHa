package Menu_Admin;

import Cotroller.MallController;
import DAO.ItemDAO;
import Mall.MenuCommand;

public class Admin_Item implements MenuCommand {
    private MallController mallController = MallController.getInstance();
    @Override
    public void init() {
        System.out.println("=====[ 상품관리 ]=====");
        System.out.println("[1] 상품 추가");
        System.out.println("[2] 상품 삭제");
        System.out.println("[3] 총 판매 수량 (내림차순)");
        System.out.println("[4] 뒤로가기");
        System.out.println("[0] 종료");
    }

    @Override
    public boolean update() {
        ItemDAO itemDAO = ItemDAO.getInstance();
        int sel = Util.Util.getInt("메뉴", 0, 4);

        if (sel == 0) {
            mallController.setNext(null);
        } else if (sel == 1) {
            itemDAO.addItem();
        } else if (sel == 2) {
            itemDAO.removeItem();
        } else if (sel == 3) {
            itemDAO.printItems();
        } else if (sel == 4) {
            mallController.setNext("AdminMain");
        }
        return false;
    }
}

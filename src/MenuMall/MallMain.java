package MenuMall;

import Controller.MallController;
import Mall.MenuCommand;

public class MallMain implements MenuCommand {
    private MallController mallController = MallController.getInstance();
    @Override
    public void init() {
        mallController = MallController.getInstance();
        System.out.println("=====[ 쇼핑몰 ]=====");
        System.out.println("[1] 회원가입\n[2] 로그인\n[0] 종료");
        System.out.println("=====================");
    }

    @Override
    public boolean update() {
        int sel = Util.Util.getInt("번호를 입력하세요 : ", 0, 2);

        if (sel == 0) {
            System.out.println("[ 프로그램 종료 ]");
            mallController.setNext(null);
        }
        else if (sel == 1) {
            mallController.setNext("MallJoin");
        } else if (sel == 2) {
            mallController.setNext("MallLogin");
        }

        return false;
    }
}

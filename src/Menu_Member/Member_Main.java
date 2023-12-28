package Menu_Member;

import Cotroller.MallController;
import Mall.MenuCommand;
import Util.Util;

public class Member_Main implements MenuCommand {
    MallController mallController = MallController.getInstance();
    @Override
    public void init() {
        System.out.printf("=====[ 회원 %s님 환영합니다 ]=====", mallController.getLoginId());
        System.out.println("[1] 상품구매");
        System.out.println("[2] 구매목록");
        System.out.println("[3] 게시판");
        System.out.println("[4] 나의정보");
        System.out.println("[5] 회원탈퇴");
        System.out.println("[6] 로그아웃");
        System.out.println("[0] 종료");
    }

    @Override
    public boolean update() {
        int sel = Util.getInt("번호를 입력하세요 : ", 0, 6);
        if (sel == 0) {
            System.out.println("[ 프로그램 종료 ]");
            mallController.setNext(null);
        } else if (sel == 1) {
            mallController.setNext("Member_Shopping");
        } else if (sel == 2) {
            mallController.setNext("Member_Cart");
        } else if (sel == 3) {
            mallController.setNext("Member_Board");
        } else if (sel == 4) {
            mallController.setNext("Member_Info");
        } else if (sel == 5) {
            mallController.setNext("Member_Quit");
        } else if (sel == 6) {
            mallController.setNext("Mall_Login");
        } else if (sel == 7) {
            mallController.setNext("Mall_Main");
        }
        return false;
    }
}

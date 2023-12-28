package Cotroller;

import Mall.MenuCommand;
import Menu_Admin.*;
import Menu_Mall.*;
import Menu_Member.*;
import DAO.*;

import java.util.HashMap;
import java.util.Map;

public class MallController {

    // MallController 생성자
    private MallController() {}
    private static MallController instance = new MallController();
    public static MallController getInstance() { return instance; }

    // 로그인 아이디
    private String loginId;
    // 다음 메뉴
    private String nextMenu;
    // 메뉴 커맨드
    private MenuCommand menuCommand;

    // 메뉴 커맨드 맵
    public Map<String, MenuCommand> mapCont;

    // 다음 정보 반환
    public String getNext() { return nextMenu; }
    public String getLoginId() { return loginId; }

    // 다음 정보 설정
    public void setNext(String next) { this.nextMenu = next; }
    public void setLoginId(String loginId) { this.loginId = loginId; }


    public void init() {
        //FileDAO.getInstance().loadAllFile();
        mapCont = new HashMap<>();
        mapCont.put("Mall_Main", new Mall_Main());
        mapCont.put("Mall_Join", new Mall_Join());
        mapCont.put("Mall_Login", new Mall_Login());
        mapCont.put("Admin_Board", new Admin_Board());
        mapCont.put("Admin_Item", new Admin_Item());
        mapCont.put("Admin_Main", new Admin_Main());
        mapCont.put("Admin_Member", new Admin_Member());
        mapCont.put("Member_Board", new Member_Board());
        mapCont.put("Member_Cart", new Member_Cart());
        mapCont.put("Member_Info", new Member_Info());
        mapCont.put("Member_Main", new Member_Main());
        mapCont.put("Member_Shopping", new Member_Shopping());
        mapCont.put("Member_Quit", new Member_Quit());

        menuCommand = mapCont.get("Mall_Main");
        menuCommand.init();
        update();
    }

    public void update() {
        while (true) {
            if (!menuCommand.update()) {
                if (nextMenu != null) {
                    menuCommand= mapCont.get(nextMenu);
                    menuCommand.init();
                } else {
                    return;
                }
            }
        }
    }
}

package Controller;

import DAO.FileDAO;
import Mall.MenuCommand;

import java.util.HashMap;
import java.util.Map;
import MenuAdmin.*;
import MenuMall.*;
import MenuMember.*;

public class MallController {
    private MallController() {}
    private static MallController instance = new MallController();
    public static MallController getInstance() { return instance; }

    private String loginId;
    private static String nextMenu;
    private MenuCommand menuCommand;
    public Map<String, MenuCommand> mapCont;

    public String getNext() { return nextMenu; }
    public String getLoginId() { return loginId; }

    // 다음 정보 설정
    public void setNext(String next) { this.nextMenu = next; }
    public void setLoginId(String loginId) { this.loginId = loginId; }

    public void init() {
        FileDAO.getInstance().loadAllFile();
        mapCont = new HashMap<>();
        mapCont.put("MallMain", new MallMain());
        mapCont.put("MallJoin", new MallJoin());
        mapCont.put("MallLogin", new MallLogin());
        mapCont.put("AdminBoard", new AdminBoard());
        mapCont.put("AdminItem", new AdminItem());
        mapCont.put("AdminMain", new AdminMain());
        mapCont.put("AdminMember", new AdminMember());
        mapCont.put("MemberBoard", new MemberBoard());
        mapCont.put("MemberCart", new MemberCart());
        mapCont.put("MemberInfo", new MemberInfo());
        mapCont.put("MemberMain", new MemberMain());
        mapCont.put("MemberShopping", new MemberShopping());
        mapCont.put("MemberQuit", new MemberQuit());

        menuCommand = mapCont.get("MallMain");
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

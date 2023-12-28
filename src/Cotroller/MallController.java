package Cotroller;

import Mall.MenuCommand;

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
        mapCont = new HashMap<>();

    }
}

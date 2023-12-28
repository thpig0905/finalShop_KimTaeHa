package DTO;

public class Member {
    // Member 번호
    private static int num = 1000;
    // Member 정보를 저장할 변수
    private int memberNum;
    private String id;
    private String pw;
    private String memberName;
    private Cart cart;

    // Member 정보를 반환하는 메소드
    public int getMemberNum() { return memberNum; }
    public String getId() { return id; }
    public String getPw() { return pw; }
    public String getMemberName() { return memberName; }
    public Cart getCart() { return cart; }

    // Member 정보를 수정하는 매소드
    public void setMemberNum(int memberNum) { this.memberNum = memberNum; }
    public void setId(String id) { this.id = id; }
    public void setPw(String pw) { this.pw = pw; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
    public void setCart(Cart cart) { this.cart = cart; }

    // Member 생성자
    public Member(int num, int memberNum, String id, String pw, String memberName) {
        this.memberNum = memberNum;
        this.id = id;
        this.pw = pw;
        this.memberName = memberName;
        this.num = num++;
    }

    public Member(String id, String pw, String memberName) {
        this.memberNum = ++num;
        this.id = id;
        this.pw = pw;
        this.memberName = memberName;
    }

    // Member 정보를 출력하는 메소드
    public String toString() {
        return String.format("%d,%d,%s,%s,%s"
                , this.num, this.memberNum, this.id, this.pw, this.memberName);
    }
}

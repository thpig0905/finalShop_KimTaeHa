package DTO;

public class Member {
    private static int num = 1000;
    private int memberNum;
    private String id;
    private String pw;
    private String memberName;

    public int getMemberNum() { return memberNum; }
    public void setMemberNum(int memberNum) { this.memberNum = memberNum; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPw() { return pw; }
    public void setPw(String pw) { this.pw = pw; }
    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }

    public Member(int memberNum, String id, String pw, String memberName) {
        this.memberNum = memberNum;
        this.id = id;
        this.pw = pw;
        this.memberName = memberName;
        num = memberNum + 1;
    }
    public String toSaveString(){
        return String.format("%d/%s/%s/%s\n", memberNum, id, pw, memberName);
    }
    public Member(String id, String pw, String memberName) {
        this.memberNum = num;
        this.id = id;
        this.pw = pw;
        this.memberName = memberName;
        num++;
    }

    public String toString(){
        return String.format("[ 회원 번호 : %d ] [ ID : %s ] [PW : %s] [ 이름 : %s ]", memberNum, id, pw, memberName);
    }
}

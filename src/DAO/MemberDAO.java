package DAO;

import java.util.List;
import DTO.Member;
import Util.Util;
public class MemberDAO {
    public List<Member> memberList;
    private MemberDAO() {}
    private static MemberDAO instance = new MemberDAO();
    public static MemberDAO getInstance() { return instance; }

    public void printMembers(){
        System.out.println("=====[ 회원 목록 ]=====");
        for (Member member : memberList) {
            System.out.println(member);
        }
    }
    public void deleteMember(String id){
        System.out.println("=====[ 회원 탈퇴 ]=====");
        Member member = getMember(id);
        if (member == null) {
            System.out.println("없는 회원입니다.");
            return;
        }
        memberList.remove(member);
        System.out.println("회원 탈퇴 완료");
    }
    public void insertMember(){
        System.out.println("=====[ 회원 가입 ]=====");
        String id = Util.getValue("아이디");
        Member member = getMember(id);
        if (member != null) {
            System.out.println("이미 존재하는 아이디입니다.");
            return;
        }
        String pw = Util.getValue("비밀번호");
        String name = Util.getValue("이름");
        member = new Member(id, pw, name);
        memberList.add(member);
        System.out.println("회원 가입 완료");
    }
    public Member isValidMember(String id, String pw){
        for (Member member : memberList) {
            if (member.getId().equals(id) && member.getPw().equals(pw)) {
                return member;
            }
        }
        return null;
    }
    public void changePw(String id){
        String pw = Util.getValue("변경할 비밀번호");
        for (Member member : memberList){
            if (member.getId().equals(id)){
                if (!member.getPw().equals(pw)){
                    System.out.println("비밀번호가 일치하지 않습니다.");
                    return;
                }
                String newPw = Util.getValue("새로운 비밀번호");
                member.setPw(newPw);
                System.out.println("[ 비밀번호 변경 완료 ]");
                return;
            }
        }
    }
    public Member getMember(String id){
        for (Member member : memberList) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }
}

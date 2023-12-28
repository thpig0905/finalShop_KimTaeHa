package DAO;

import DTO.Member;

import java.util.List;
import Util.Util;

public class MemberDAO {
    List<Member> members;

    // MemberDAO 생성자
    private MemberDAO() {}
    private static MemberDAO instance = new MemberDAO();
    public static MemberDAO getInstance() { return instance; }

    public Member getMember(String id) {
        for (Member member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }

    public void insertMember(String id, String pw, String name) {
        Member member = new Member(id, pw, name);
        members.add(member);
        System.out.println("[ 회원 추가 완료 ]");
    }

    public Member isValidMember(String id, String pw) {
        for (Member member : members) {
            if (member.getId().equals(id) && member.getPw().equals(pw)) {
                return member;
            }
        }
        return null;
    }

    public void printMembers() {
        System.out.println("=====[ 회원 목록 ]=====");
        for (Member member : members) {
            System.out.printf("[%d] [ ID : %s ] [PW : %s] [ 이름 : %s ]\n"
                    , member.getMemberNum(), member.getId(), member.getPw(), member.getMemberName());
        }
    }

    public void deleteMember(String id) {
        if (id.equals("admin")) {
            System.out.println("관리자 계정은 삭제할 수 없습니다.");
            return;
        }

        Member member = getMember(id);
        if (member != null) {
            members.remove(member);
            System.out.println("[ 회원 삭제 완료 ]");
            return;
        } else if (member == null) {
            System.out.println("[ 회원 삭제 실패 ]");
            return;
        }
    }

    public void changePw(String id){
        String pw = Util.getValue("변경할 비밀번호");
        for (Member member : members){
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
}

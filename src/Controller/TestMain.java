package Controller;

import DAO.*;
import DTO.Board;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import DAO.FileDAO;
import DTO.Cart;
import DTO.Item;
import DTO.Member;

public class TestMain {
    public static void main(String[] args) {
        FileDAO f = FileDAO.getInstance();
        f.loadAllFile();

        MemberDAO m = MemberDAO.getInstance();
        for (Member member : m.memberList) {
            System.out.println(member);
        }
        System.out.println("========================================");
        Member member = new Member("test", "test", "test");

        m.memberList.add(member);
        for (Member member1 : m.memberList) {
            System.out.println(member1);
        }

        member = new Member("test2", "test2", "test2");
        m.memberList.add(member);
        for (Member member1 : m.memberList) {
            System.out.println(member1);
        }
    }
}

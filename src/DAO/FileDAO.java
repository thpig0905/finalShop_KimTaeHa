package DAO;

import DTO.Board;
import DTO.Cart;
import DTO.Item;
import DTO.Member;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileDAO {

    // 파일명을 enum으로 관리
    enum FileName {
        MEMBER("member.txt"), CART("cart.txt"), ITEM("item.txt"), BOARD("board.txt");

        private String fileName;
        FileName(String fileName) { this.fileName = fileName; }
        public String getFileName() { return fileName; }
    }

    // 파일 클래스 생성자
    private FileDAO() {}
    private static FileDAO instance = new FileDAO();
    public static FileDAO getInstance() { return instance; }

    // 파일 경로
    private String txtPath = "src/Files/";

    // 파일 로드
    public List loadFile(FileName fileName) {
        Path path = Paths.get(txtPath, fileName.getFileName());
        StringBuilder data = new StringBuilder();

        try (FileInputStream fs = new FileInputStream(path.toString());
             InputStreamReader isr = new InputStreamReader(fs, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {

            String line = "";
            while ((line = br.readLine()) != null) {
                data.append(line);
                data.append("\n");
            }
        } catch (Exception e) {
            System.out.println("파일 읽기 실패");
        }

        String str = data.toString() + "\n";
        String[] arr = str.split("\n");

        if (fileName == FileName.BOARD) {
            List<Board> lists = new ArrayList<Board>();
            for (String s : arr) {
                String[] temp = s.split(",");
                Board board = new Board(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]),
                        temp[2], temp[3], temp[4], temp[5], Integer.parseInt(temp[6]));
                lists.add(board);
            }
            return lists;
        } else if (fileName == FileName.CART) {
            List<Cart> lists = new ArrayList<Cart>();
            for (String s : arr) {
                String[] temp = s.split(",");
                Cart cart = new Cart(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]),
                        Integer.parseInt(temp[3]), temp[4], Integer.parseInt(temp[5]), Integer.parseInt(temp[6]));
                lists.add(cart);
            }
            return lists;
        } else if (fileName == FileName.ITEM) {
            List<Item> lists = new ArrayList<Item>();
            for (String s : arr) {
                String[] temp = s.split(",");
                Item item = new Item(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]),
                        temp[2], temp[3], Integer.parseInt(temp[4]), Integer.parseInt(temp[5]));
                lists.add(item);
            }
            return lists;
        } else if (fileName == FileName.MEMBER) {
            List<Member> lists = new ArrayList<Member>();
            for (String s : arr) {
                String[] temp = s.split(",");
                Member member = new Member(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), temp[2], temp[3], temp[4]);
                lists.add(member);
            }
            return lists;
        }

        return null;
    }

    // 파일 저장
    public void saveFile(FileName fileName, List<?> list) {
        Path path = Paths.get(txtPath, fileName.getFileName());
        String data = listToString(list);

        try (FileOutputStream fos = new FileOutputStream(path.toString());
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
             BufferedWriter bw = new BufferedWriter(osw)) {

            bw.write(data);
        } catch (Exception e) {
            System.out.println("파일 쓰기 실패");
        }
    }

    public void loadAllFile(BoardDAO boardDAO, CartDAO cartDAO, ItemDAO itemDAO, MemberDAO memberDAO) {
        boardDAO.boards = loadFile(FileName.BOARD);
        cartDAO.carts = loadFile(FileName.CART);
        itemDAO.items = loadFile(FileName.ITEM);
        memberDAO.members = loadFile(FileName.MEMBER);
    }

    public void saveAllFile() {
        saveFile(FileName.BOARD, BoardDAO.getInstance().boards);
        saveFile(FileName.CART, CartDAO.getInstance().carts);
        saveFile(FileName.ITEM, ItemDAO.getInstance().items);
        saveFile(FileName.MEMBER, MemberDAO.getInstance().members);
    }

    // 리스트 값 String으로 변환
    public String listToString(List<?> list) {
        String data = "";
        for (Object o : list) {
            data += o.toString() + "\n";
        }
        return data;
    }
}

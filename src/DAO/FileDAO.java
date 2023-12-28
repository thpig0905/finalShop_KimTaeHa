package DAO;

import DTO.Board;
import DTO.Cart;
import DTO.Item;
import DTO.Member;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileDAO {
    enum FileName {
        MEMBER("member.txt"), CART("cart.txt"), ITEM("item.txt"), BOARD("board.txt");

        private String fileName;
        FileName(String fileName) { this.fileName = fileName; }
        public String getFileName() { return fileName; }
    }
    private FileDAO() {}
    private static FileDAO instance = new FileDAO();
    public static FileDAO getInstance() { return instance; }

    String txtPath = "src/Files";

    public ArrayList<?> loadFile(FileName fileName){
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
            return null;
        }
        String str[] = data.toString().split("\n");
        String temp[][] = new String[str.length][];
        for (int i = 0; i < str.length; i++) {
            temp[i] = str[i].split("/");
        }
        if (fileName.equals(FileName.BOARD)) {
            ArrayList<Board> lists = new ArrayList<Board>();
            for (int i = 0; i < temp.length; i++) {
                Board board = new Board(Integer.parseInt(temp[i][0]),
                        temp[i][1], temp[i][2], temp[i][3], temp[i][4],
                        Integer.parseInt(temp[i][5]));
                lists.add(board);
            }
            return lists;
        } else if (fileName.equals(FileName.CART)) {
            ArrayList<Cart> lists = new ArrayList<Cart>();
            for (int i = 0; i < temp.length; i++) {
                Cart cart = new Cart(Integer.parseInt(temp[i][0]), temp[i][1],
                        Integer.parseInt(temp[i][2]), Integer.parseInt(temp[i][3]));
                lists.add(cart);
            }
            return lists;
        } else if (fileName.equals(FileName.ITEM)) {
            ArrayList<Item> lists = new ArrayList<Item>();
            for (int i = 0; i < temp.length; i++) {
                Item item = new Item(Integer.parseInt(temp[i][0]), temp[i][1], temp[i][2], Integer.parseInt(temp[i][3]));
                lists.add(item);
            }
            return lists;
        } else if (fileName.equals(FileName.MEMBER)) {
            ArrayList<Member> lists = new ArrayList<Member>();
            for (int i = 0; i < temp.length; i++) {
                Member member = new Member(Integer.parseInt(temp[i][0]), temp[i][1], temp[i][2], temp[i][3]);
                lists.add(member);
            }
            return lists;
        }
        return null;
    }

    public void loadAllFile() {
        MemberDAO.getInstance().memberList = (ArrayList<Member>) loadFile(FileName.MEMBER);
        BoardDAO.getInstance().boardList = (ArrayList<Board>) loadFile(FileName.BOARD);
        CartDAO.getInstance().cartList = (ArrayList<Cart>) loadFile(FileName.CART);
        ItemDAO.getInstance().itemList = (ArrayList<Item>) loadFile(FileName.ITEM);
    }
    private void saveFile(FileName fileName){
        Path path = Paths.get(txtPath, fileName.getFileName());
        StringBuilder data = new StringBuilder();

        if (fileName.equals(FileName.BOARD)){
            BoardDAO boardDAO = BoardDAO.getInstance();
            for (Board board : boardDAO.boardList) {
                data.append(board.toSaveString());
            }
            try (FileOutputStream fos = new FileOutputStream(path.toString());
                 OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                 BufferedWriter bw = new BufferedWriter(osw)) {
                bw.write(data.toString());
            } catch (Exception e) {
                System.out.println("파일 쓰기 실패");
            }
        } else if (fileName.equals(FileName.CART)) {
            CartDAO cartDAO = CartDAO.getInstance();
            for (Cart cart : cartDAO.cartList) {
                data.append(cart.toSaveString());
            }
            try (FileOutputStream fos = new FileOutputStream(path.toString());
                 OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                 BufferedWriter bw = new BufferedWriter(osw)) {
                bw.write(data.toString());
            } catch (Exception e) {
                System.out.println("파일 쓰기 실패");
            }

        } else if (fileName.equals(FileName.ITEM)) {
            ItemDAO itemDAO = ItemDAO.getInstance();
            for (Item item : itemDAO.itemList) {
                data.append(item.toSaveString());
            }
            try (FileOutputStream fos = new FileOutputStream(path.toString());
                 OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                 BufferedWriter bw = new BufferedWriter(osw)) {
                bw.write(data.toString());
            } catch (Exception e) {
                System.out.println("파일 쓰기 실패");
            }
        } else if (fileName.equals(FileName.MEMBER)) {
            MemberDAO memberDAO = MemberDAO.getInstance();
            for (Member member : memberDAO.memberList) {
                data.append(member.toSaveString());
            }
            try (FileOutputStream fos = new FileOutputStream(path.toString());
                 OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                 BufferedWriter bw = new BufferedWriter(osw)) {
                bw.write(data.toString());
            } catch (Exception e) {
                System.out.println("파일 쓰기 실패");
            }
        }
    }
    public void saveAllFile() {
        saveFile(FileName.MEMBER);
        saveFile(FileName.BOARD);
        saveFile(FileName.CART);
        saveFile(FileName.ITEM);
    }
}

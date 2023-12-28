package DAO;

import DTO.Item;
import Util.Util;

import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    List<Item> items;

    // ItemDAO 생성자
    private ItemDAO() {}
    private static ItemDAO instance = new ItemDAO();
    public static ItemDAO getInstance() { return instance; }

    public void addItem() {
        System.out.println("=====[ 상품 추가 ]=====");
        String name = Util.getValue("상품명");
        Item item = getItem(name);
        if (item != null) {
            System.out.println("이미 존재하는 상품입니다.");
            return;
        }
        item = new Item(Util.getValue("카테고리"), name, Util.getInt("가격", 0, Integer.MAX_VALUE));
        items.add(item);
    }

    public void removeItem() {
        System.out.println("=====[ 상품 삭제 ]=====");
        String name = Util.getValue("상품명");
        Item item = getItem(name);
        if (item == null) {
            System.out.println("존재하지 않는 상품입니다.");
            return;
        }
        items.remove(item);
    }
    public void printItems() {
        List<Item> temp = new ArrayList<>(items);

        // temp 의 count 를 기준으로 내림차순 정렬
        temp.sort((o1, o2) -> o2.getCount() - o1.getCount());
        System.out.println("=====[ 상품 목록 ]=====");
        for (Item item : temp) {
            System.out.println(item);
        }
    }

    public String printItemCategory() {
        System.out.println("=====[ 카테고리 목록 ]=====");
        for (Item item : items) {
            System.out.println(item.getCategory());
        }
        String category = Util.getValue("카테고리");
        for (Item item : items) {
            if (item.getCategory().equals(category)) {
                return category;
            }
        }
        return null;
    }

    public Item printItemByCategory(String category) {
        System.out.printf("=====[ %s 상품 목록 ]=====", category);
        for (Item item : items) {
            if (item.getCategory().equals(category)) {
                System.out.printf("[ %s ] \t %s \t ( %d원 ) \t %d개\n"
                        , item.getName(), item.getCategory(), item.getPrice(), item.getCount());
            }
        }
        String name = Util.getValue("상품명");
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    private Item getItem(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
}

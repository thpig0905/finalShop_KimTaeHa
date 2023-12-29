package DAO;

import java.util.ArrayList;
import java.util.List;

import DTO.Cart;
import DTO.Item;
import Util.Util;

public class ItemDAO {
    public List<Item> itemList;

    private ItemDAO() {}
    private static ItemDAO instance = new ItemDAO();
    public static ItemDAO getInstance() { return instance; }

    public String printItemCategory() {
        System.out.println("=====[ 카테고리 목록 ]=====");
        for (Item item : itemList) {
            System.out.println(item.getCategoryName());
        }
        String category = Util.getValue("카테고리");
        for (Item item : itemList) {
            if (item.getCategoryName().equals(category)) {
                return category;
            }
        }
        return null;
    }

    public Item printItemByCategory(String category) {
        System.out.println("=====[ 상품 목록 ]=====");
        for (Item item : itemList) {
            if (item.getCategoryName().equals(category)) {
                System.out.println(item);
            }
        }
        int itemNum = Util.getInt("상품 번호", 1, itemList.size());
        for (Item item : itemList) {
            if (item.getItemNum() == itemNum) {
                return item;
            }
        }
        return null;
    }
    public void addItem(){
        System.out.println("=====[ 상품 추가 ]=====");
        String name = Util.getValue("상품명");
        Item item = getItem(name);
        if (item != null) {
            System.out.println("이미 존재하는 상품입니다.");
            return;
        }
        item = new Item(name, Util.getInt("가격", 0, Integer.MAX_VALUE), Util.getValue("카테고리"));
        itemList.add(item);
    }
    public void removeItem(){
        System.out.println("=====[ 상품 삭제 ]=====");
        String name = Util.getValue("상품명");
        Item item = getItem(name);
        if (item == null) {
            System.out.println("존재하지 않는 상품입니다.");
            return;
        }
        itemList.remove(item);
        CartDAO cartDAO = CartDAO.getInstance();
        for (Cart cart : cartDAO.cartList) {
            if (cart.getItemNum() == item.getItemNum()) {
                cartDAO.cartList.remove(cart);
            }
        }
    }
    public void printItems() {
        List<Item> temp = new ArrayList<>(itemList);
        temp.sort((o1, o2) -> o2.getCount() - o1.getCount());
        System.out.println("=====[ 상품 목록 ]=====");
        for (Item item : temp) {
            System.out.println(item);
        }
    }
    private Item getItem(String name) {
        for (Item item : itemList) {
            if (item.getItemName().equals(name)) {
                return item;
            }
        }
        return null;
    }
}

package DAO;

import java.util.ArrayList;
import java.util.List;
import DTO.Cart;
import DTO.Item;

public class CartDAO {
    public List<Cart> cartList;
    private CartDAO() {}
    private static CartDAO instance = new CartDAO();
    public static CartDAO getInstance() { return instance; }

    public void addItemToCart(String id, Item item) {
        int cnt = 0;
        for (Cart cart : cartList) {
            if (cart.getId().equals(id) && cart.getItemNum() == item.getItemNum()){
                cnt = cart.getItemCnt();
            }
        }
        Cart cart = new Cart(id, item.getItemNum(), cnt);
        cartList.add(cart);
    }

    public void cartSortByMember(String id) {
        List<Cart> temp = new ArrayList<>();
        for (Cart cart : cartList) {
            if (cart.getId().equals(id)) {
                temp.add(cart);
            }
        }
        System.out.println("=====[ 장바구니 목록 ]=====");
        for (Cart cart : temp) {
            System.out.println(cart);
        }
    }
}

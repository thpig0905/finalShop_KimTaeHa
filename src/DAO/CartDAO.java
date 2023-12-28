package DAO;

import DTO.Cart;
import DTO.Item;
import DTO.Member;

import java.util.List;

public class CartDAO {
    List<Cart> carts;

    // CartDAO 생성자
    private CartDAO() {}
    private static CartDAO instance = new CartDAO();
    public static CartDAO getInstance() { return instance; }

    public void cartSortByMember(String id) {
        int counter = 0;
        int totalPrice = 0;
        for (Cart cart : carts) {
            if (cart.getId().equals(id)) {
                System.out.printf("[ %s ] \t %s \t ( %d원) \t %d개\n"
                        , cart.getCartNum(), cart.getItemName(), cart.getItemPrice(), cart.getItemCnt());
                counter++;
                totalPrice += cart.getItemPrice() * cart.getItemCnt();
            }
        }
        System.out.printf("총 %d 개 ( 총 %d 원 )", counter, totalPrice);
    }

    public void addItemToCart(Item item, String id){
        Cart cart = new Cart(id, item.getItemName(), item.getPrice(), Integer.parseInt(item.getItemNum()));
        carts.add(cart);
    }
}

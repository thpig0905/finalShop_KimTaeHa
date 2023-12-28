package DTO;

public class Cart {
    private static int num;
    private int cartNum;
    private String id;
    private int itemNum;
    private int itemCnt;
    private int totalPrice;

    public int getCartNum() { return cartNum; }
    public String getId() { return id; }
    public int getItemNum() { return itemNum; }
    public int getItemCnt() { return itemCnt; }
    public int getTotalPrice() { return totalPrice; }

    public Cart(int cartNum, String id, int itemNum, int itemCnt) {
        this.cartNum = cartNum;
        this.id = id;
        this.itemNum = itemNum;
        this.itemCnt = itemCnt;
        this.totalPrice = itemCnt * itemNum;
        num++;
    }

    public Cart(String id, int itemNum, int itemCnt) {
        this.id = id;
        this.itemNum = itemNum;
        this.itemCnt = itemCnt;
        this.totalPrice = itemCnt * itemNum;
        num++;
    }

    public String toSaveString(){
        return String.format("%d/%s/%d/%d\n", cartNum, id, itemNum, itemCnt);
    }

    public String toString(){
        return String.format("[ 장바구니 번호 : %d ] [ 회원 ID : %s ] [ 상품 번호 : %d ] [ 상품 개수 : %d ]", cartNum, id, itemNum, itemCnt);
    }
}

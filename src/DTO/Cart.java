package DTO;

public class Cart {
    // Cart 객체의 고유번호를 저장할 static 변수
    private static int num = 0;

    // Cart 객체의 정보를 저장할 변수
    private String itemName;
    private int cartNum;
    private String id;
    private int itemNum;
    private int itemCnt;
    private int itemPrice;

    // Cart 객체의 정보를 반환하는 매소드
    public String getItemName() { return itemName; }
    public int getCartNum() { return cartNum; }
    public String getId() { return id; }
    public int getItemNum() { return itemNum; }
    public int getItemCnt() { return itemCnt; }
    public int getItemPrice() { return itemPrice; }

    // Cart 객체의 정보를 수정하는 매소드
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setCartNum(int cartNum) { this.cartNum = cartNum; }
    public void setId(String id) { this.id = id; }
    public void setItemNum(int itemNum) { this.itemNum = itemNum; }
    public void setItemCnt(int itemCnt) { this.itemCnt = itemCnt; }
    public void setItemPrice(int itemPrice) { this.itemPrice = itemPrice; }

    // Cart 객체를 생성할 때 필요한 정보를 매개변수로 받는 생성자
    public Cart(int num, String id, int itemNum, int itemCnt,
                String itemName, int itemPrice, int cartNum) {
        this.num = num;
        this.id = id;
        this.itemNum = itemNum;
        this.itemCnt = itemCnt;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.cartNum = cartNum;
    }

    public Cart(String id, String itemName, int itemPrice, int itemNum){
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCnt = this.itemCnt + 1;
        this.cartNum = this.cartNum + 1;
        this.num = this.num + 1;
        this.itemNum = itemNum;
    }

    // Cart 객체의 정보를 출력하기 위한 toString() 메소드
    public String toString() {
        return String.format("%d,%s,%d,%s,%d,%d,%d,%d"
                , this.num, this.id, this.itemNum, this.itemName, this.itemCnt, this.itemPrice, this.cartNum, this.itemPrice * this.itemCnt);
    }
}

package DTO;

public class Item {
    private static int num;
    private int itemNum;
    private String categoryName;
    private String itemName;
    private int price;
    private int count;

    public int getItemNum() { return itemNum; }
    public String getCategoryName() { return categoryName; }
    public String getItemName() { return itemName; }
    public int getPrice() { return price; }
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }


    public Item(int itemNum, String categoryName, String itemName, int price) {
        this.itemNum = itemNum;
        this.categoryName = categoryName;
        this.itemName = itemName;
        this.price = price;
        this.count = 0;
        num++;
    }

    public Item(String itemName, int price, String categoryName) {
        this.itemName = itemName;
        this.price = price;
        this.categoryName = categoryName;
        this.itemNum = ++num;
        this.count = 0;
        num++;
    }
    public String toSaveString(){
        return String.format("%d/%s/%s/%d/%d\n", itemNum, categoryName, itemName, price, count);
    }
    public String toString(){
        return String.format("[ 상품 번호 : %d ] [ 카테고리 : %s ] [ 상품 이름 : %s ] [ 상품 가격 : %d ] [ 판매 수량 : %d ]", itemNum, categoryName, itemName, price, count);
    }
}

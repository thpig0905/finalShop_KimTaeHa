package DTO;

public class Item {
    // Item 번호
    private static int num;

    // Item 정보를 저장할 변수
    private int itemNum;
    private String categoryName;
    private String itemName;
    private int price;
    private int count;

    // Item 정보를 반환하는 매소드
    public int getNum(){ return num; }
    public String getItemNum() { return itemName; }
    public String getCategory() { return categoryName; }
    public String getItemName() { return itemName; }
    public int getPrice() { return price; }
    public String getName() { return itemName; }
    public int getCount() { return count; }

    // Item 정보를 수정하는 매소드
    public void setNum(int num){ this.itemNum = num; }
    public void setItemNum(String itemNum) { this.itemName = itemNum; }
    public void setCategory(String category) { this.categoryName = category; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setPrice(int price) { this.price = price; }

    // Item 생성자
    public Item (int num, int itemNum, String category, String itemName, int price, int count){
        this.num = num;
        this.itemNum = itemNum;
        this.categoryName = category;
        this.itemName = itemName;
        this.price = price;
        this.count = count;
    }

    public Item (String category, String itemName, int price){
        this.itemNum = num++;
        this.categoryName = category;
        this.itemName = itemName;
        this.price = price;
    }

    // Item 정보를 출력하는 매소드
    public String toString() {
        return String.format("%d,%d,%s,%s,%d,%d"
                , this.num, this.itemNum, this.categoryName, this.itemName, this.price, this.count);
    }

}

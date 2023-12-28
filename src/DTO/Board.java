package DTO;

public class Board {
    // 게시글 번호
    private static int num;

    // 게시글 정보를 저장할 변수
    private int boradNum;
    private String title;
    private String id;
    private String date;
    private String contents;
    private int hits;

    // 게시글 정보를 반환하는 매소드
    public int getBoradNum() { return boradNum; }
    public String getTitle() { return title; }
    public String getId() { return id; }
    public String getDate() { return date; }
    public String getContents() { return contents; }
    public int getHits() { return hits; }

    // 게시글 정보를 수정하는 매소드
    public void setBoradNum(int boradNum) { this.boradNum = boradNum; }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setContents(String contents) {
        this.contents = contents;
    }
    public void setHits(int hits) {
        this.hits = hits;
    }

    // 게시글 생성
    public Board(int num, int boradNum, String title, String id, String date, String contents, int hits) {
        this.boradNum = ++num;
        this.title = title;
        this.id = id;
        this.date = date;
        this.contents = contents;
        this.hits = 0;
    }

    public Board(String title, String id, String data, String contents) {
        this.title = title;
        this.id = id;
        this.date = data;
        this.contents = contents;
        this.hits = 0;
        this.boradNum = ++num;
        this.num = ++num;
    }

    public String toString() {
        return String.format("%d,%d,%s,%s,%s,%s,%d"
                , this.num, this.boradNum, this.title, this.id, this.date, this.contents, this.hits);
    }
}

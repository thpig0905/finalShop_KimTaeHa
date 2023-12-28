package DTO;
import Util.Util;
public class Board {
    private static int num;

    // 게시글 정보를 저장할 변수
    private int boradNum;
    private String title;
    private String id;
    private String date;
    private String contents;
    private int hits;

    public int getBoardNum() { return boradNum; }
    public String getTitle() { return title; }
    public String getId() { return id; }
    public String getDate() { return date; }
    public String getContents() { return contents; }
    public int getHits() { return hits; }

    public void setHits(int hits) { this.hits = hits; }

    public Board(int boradNum, String title, String contents, String id, String date, int hits) {
        this.boradNum = boradNum;
        this.title = title;
        this.id = id;
        this.date = date;
        this.contents = contents;
        this.hits = hits;
        num++;
    }

    public Board(String id, String title, String contents) {
        this.boradNum = num;
        this.title = title;
        this.id = id;
        this.date = Util.getDate();
        this.contents = contents;
        this.hits = 0;
        num++;
    }
    public String toSaveString() {
        return String.format("%d/%s/%s/%s/%s/%d\n",
                boradNum, title, id, date, contents, hits);
    }
    public String toString() {
        return String.format("(%d) [ 제목 : %s ] [ 작성자 : %s ] [ 작성일 : %s ] [ 조회수 : %d ]\n",
                boradNum, title, id, date, hits);
    }
}

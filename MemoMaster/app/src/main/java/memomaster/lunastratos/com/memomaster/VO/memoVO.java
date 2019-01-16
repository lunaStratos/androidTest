package memomaster.lunastratos.com.memomaster.VO;

public class memoVO {

    private String title;
    private String date;
    private int number;

    public memoVO(String title, String date, int number) {
        this.title = title;
        this.date = date;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

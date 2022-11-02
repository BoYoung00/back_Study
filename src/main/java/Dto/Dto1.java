package Dto;

import java.util.Date;

public class Dto1 {
    private int id;
    private String text;
    private String main;

    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Dto1{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", main='" + main + '\'' +
                ", date=" + date +
                '}';
    }
}

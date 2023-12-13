package ddwucom.mobile.finalreport;

import java.io.Serializable;

public class MyData implements Serializable {
    private long _id;
    private String date;
    private String weather;
    private String title;
    private String content;
    private String place;
    private int img;

    public MyData(String date, String weather, String title, String content, String place, int img) {
        this.date = date;
        this.weather = weather;
        this.title = title;
        this.content = content;
        this.place = place;
        this.img = img;
    }

    public MyData(long _id, String date, String weather, String title, String content, String place, int img) {
        this._id = _id;
        this.date = date;
        this.weather = weather;
        this.title = title;
        this.content = content;
        this.place = place;
        this.img = img;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getImg() { return img; }

    public void setImg(int img) { this.img = img; }
}

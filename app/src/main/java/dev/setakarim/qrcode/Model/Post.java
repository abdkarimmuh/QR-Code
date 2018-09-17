package dev.setakarim.qrcode.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("result")
    @Expose
    private String result;

    public Post(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "result:" + getResult() +
                '}';
    }
}

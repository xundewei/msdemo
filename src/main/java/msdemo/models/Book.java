package msdemo.models;

import java.io.Serializable;

/**
 * @Author: TODY
 * @Version: V1.00
 * @Create Date: 2017年4月13日18:01:17
 * @Description:书的持久化类
 */

public class Book implements Serializable{
   
    private String bookID;
   
    private String bookName;
   
    private String author;
   
    private String coverUrl;
   
    private String iSBN;
   
    private String publisher;



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getiSBN() {
        return iSBN;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

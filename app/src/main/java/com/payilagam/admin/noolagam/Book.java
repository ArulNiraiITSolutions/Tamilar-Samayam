package com.payilagam.admin.noolagam;

/**
 * Created by Admin on 12/30/2017.
 */
public class Book {
    private String bookId;
    private String bookName;
    private String bookAuthor;
    private String noOfPage;
    private String bookPrice;
    private String publication;
    private String bookImage;
    private String bookFile;

    public String getBookFile() {
        return bookFile;
    }

    public void setBookFile(String bookFile) {
        this.bookFile = bookFile;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getNoOfPage() {
        return noOfPage;
    }

    public void setNoOfPage(String noOfPage) {
        this.noOfPage = noOfPage;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }
}

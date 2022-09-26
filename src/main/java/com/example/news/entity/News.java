package com.example.news.entity;

public class News {
    private int newsId;
    private String newTitle;
    private String newsContent;
    private String newsDate;
    private String author;
//    储存新闻ID
    public int getNewsId() {
        return newsId;
    }
    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }
//    储存新闻列表
    public String getNewTitle(){
        return newTitle;
    }
    public void setNewTitle(String newTitle){
        this.newTitle=newTitle ;
    }
//    储存新闻内容
    public  String getNewsContent(){
        return newsContent;
    }
    public void setNewsContent(String newsContent){
        this.newsContent = newsContent;
    }
//    储存次新闻发布时间
    public String getNewsDate(){
        return  newsDate;
    }
    public  void setNewsDate(String newsDate){
        this.newsDate = newsDate;
    }
//    储存新闻发布者ID
    public String getAuthor(){
        return  author;
    }
    public void setAuthor(String author){
        this.author=author;
    }

    @Override
    public String toString() {
        return "News [newsId=" + newsId + ", newTitle=" + newTitle + ", newsContent=" + newsContent + ", newsDate=" + newsDate + ",Author="+author+ "]";
    }

    public News(int newsId, String newTitle, String newsContent,String newsDate,String author) {
        super();
        this.newsId = newsId;
        this.newTitle = newTitle;
        this.newsContent = newsContent;
        this.newsDate = newsDate;
        this.author = author;
    }

    public News() {
        super();
    }

}

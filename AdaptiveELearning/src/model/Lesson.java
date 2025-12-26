package model;

public class Lesson {
    private String lessonId;
    private String title;
    private String contentPath;

    public Lesson(String lessonId, String title, String contentPath) {
        this.lessonId = lessonId;
        this.title = title;
        this.contentPath = contentPath;
    }

    public String getTitle() { return title; }
    public String getContentPath() { return contentPath; }
}

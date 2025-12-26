package model;

public class Question {
    private String topic;
    private String question;
    private String[] options;
    private int correctOption;

    public Question(String topic, String question, String[] options, int correctOption) {
        this.topic = topic;
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getTopic() { return topic; }
    public String getQuestion() { return question; }
    public String[] getOptions() { return options; }
    public int getCorrectOption() { return correctOption; }
}

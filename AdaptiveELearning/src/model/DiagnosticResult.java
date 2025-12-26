package model;

public class DiagnosticResult {
    private String topic;
    private int score;

    public DiagnosticResult(String topic, int score) {
        this.topic = topic;
        this.score = score;
    }

    public String getTopic() {
        return topic;
    }

    public int getScore() {
        return score;
    }
}

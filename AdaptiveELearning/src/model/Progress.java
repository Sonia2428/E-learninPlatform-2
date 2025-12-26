package model;

public class Progress {
    private String userId;
    private String topic;
    private int score;

    public Progress(String userId, String topic, int score) {
        this.userId = userId;
        this.topic = topic;
        this.score = score;
    }

    public String getUserId() {
        return userId;
    }

    public String getTopic() {
        return topic;
    }

    public int getScore() {
        return score;
    }

    public int getPercentage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPercentage'");
    }
}


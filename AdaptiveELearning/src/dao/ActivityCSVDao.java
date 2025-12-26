package dao;

import java.io.*;

public class ActivityCSVDao {

    private static final String FILE = "data/activity_log.csv";

    public void log(String userId, String activity) {
        try (FileWriter fw = new FileWriter(FILE, true)) {
            fw.write(userId + "," + activity + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

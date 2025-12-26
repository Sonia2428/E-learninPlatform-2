package dao;

import model.Lesson;
import java.io.*;
import java.util.*;

public class LessonCSVDao {

    private static final String FILE = "data/lessons.csv";

    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                lessons.add(new Lesson(d[0], d[1], d[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lessons;
    }
}

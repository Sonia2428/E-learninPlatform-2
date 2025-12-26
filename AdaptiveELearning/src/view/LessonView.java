package view;

import javax.swing.*;
import java.io.*;

public class LessonView extends JFrame {

    public LessonView(String topic) {
        setTitle("Lesson: " + topic);
        setSize(500,400);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("content/" + topic.toLowerCase() + ".txt"));
            String line;
            while ((line = br.readLine()) != null) {
                area.append(line + "\n");
            }
            br.close();
        } catch (Exception e) {
            area.setText("Lesson content not found.");
        }

        add(new JScrollPane(area));
    }
}

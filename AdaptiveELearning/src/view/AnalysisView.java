package view;

import dao.ProgressCSVDao;
import model.Progress;

import javax.swing.*;
import java.util.List;

public class AnalysisView extends JFrame {

    public AnalysisView(String userId) {
        setTitle("Analysis & Suggestions");
        setSize(500,350);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        List<Progress> list = new ProgressCSVDao().getProgress(userId);

        for (Progress p : list) {
            if (p.getScore() < 40) {
                area.append(p.getTopic() + ": Revise basics and practice more.\n");
            } else if (p.getScore() < 70) {
                area.append(p.getTopic() + ": Improve problem-solving skills.\n");
            } else {
                area.append(p.getTopic() + ": You are doing great! Try projects.\n");
            }
        }

        add(new JScrollPane(area));
    }
}

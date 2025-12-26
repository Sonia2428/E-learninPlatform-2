package view;

import javax.swing.*;

public class ActionSelectionView extends JFrame {

    public ActionSelectionView(String userId) {
        setTitle("Choose Action");
        setSize(400,300);
        setLayout(null);

        JButton testBtn = new JButton("Take Test");
        JButton progressBtn = new JButton("View Progress");
        JButton analysisBtn = new JButton("Analyze & Improve");

        testBtn.setBounds(100,50,200,30);
        progressBtn.setBounds(100,100,200,30);
        analysisBtn.setBounds(100,150,200,30);

        add(testBtn);
        add(progressBtn);
        add(analysisBtn);

        testBtn.addActionListener(e -> {
            new TestSelectionView(userId).setVisible(true);
            dispose();
        });

        progressBtn.addActionListener(e -> {
            new ProgressChartView(userId).setVisible(true);
        });

        analysisBtn.addActionListener(e -> {
            new AnalysisView(userId).setVisible(true);
        });
    }
}

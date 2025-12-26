package view;

import dao.ProgressCSVDao;
import model.Progress;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DashboardView extends JFrame {

    public DashboardView(String userId) {

        setTitle("User Dashboard");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ---------- TABLE ----------
        String[] columns = {
                "Topic",
                "Score (%)",
                "Recommendation",
                "Suggested Action"
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // ---------- DATA ----------
        ProgressCSVDao pdao = new ProgressCSVDao();
        List<Progress> plist = pdao.getProgress(userId);

        for (Progress p : plist) {

            String recommendation;
            String action;

            int percentage = p.getPercentage(); // derived from score

            if (percentage >= 75) {
                recommendation = "Ready for Advanced Level";
                action = "Take Advanced Test";
            } else if (percentage >= 50) {
                recommendation = "Needs Practice";
                action = "Improve Skills";
            } else {
                recommendation = "Learn Basics First";
                action = "Study Fundamentals";
            }

            model.addRow(new Object[]{
                    p.getTopic(),
                    percentage,
                    recommendation,
                    action
            });
        }

        // ---------- BUTTON PANEL ----------
        JButton takeTestBtn = new JButton("Take Test");
        JButton viewProgressBtn = new JButton("View Progress Chart");
        JButton analyzeBtn = new JButton("Analyze & Improve");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(takeTestBtn);
        buttonPanel.add(viewProgressBtn);
        buttonPanel.add(analyzeBtn);

        // ---------- BUTTON ACTIONS ----------
        takeTestBtn.addActionListener(e ->
                new TestSelectionView(userId).setVisible(true)
        );

        viewProgressBtn.addActionListener(e ->
                new ProgressChartView(userId).setVisible(true)
        );

        analyzeBtn.addActionListener(e ->
                new AnalysisView(userId).setVisible(true)
        );

        // ---------- LAYOUT ----------
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}

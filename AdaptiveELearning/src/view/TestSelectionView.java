package view;

import javax.swing.*;

public class TestSelectionView extends JFrame {

    public TestSelectionView(String userId) {
        setTitle("Select Subject");
        setSize(300,250);
        setLayout(null);

        String[] topics = {"Basics", "Loops", "OOP"};
        JComboBox<String> combo = new JComboBox<>(topics);
        JButton startBtn = new JButton("Start Test");

        combo.setBounds(70,50,150,25);
        startBtn.setBounds(80,100,130,30);

        add(combo);
        add(startBtn);

        startBtn.addActionListener(e -> {
            new MCQTestView(userId, combo.getSelectedItem().toString()).setVisible(true);
            dispose();
        });
    }
}

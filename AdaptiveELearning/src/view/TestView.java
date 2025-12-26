package view;

import dao.ProgressCSVDao;

import javax.swing.*;

public class TestView extends JFrame {

    public TestView(String userId, String topic) {
        setTitle("Test: " + topic);
        setSize(400,300);
        setLayout(null);

        JLabel q = new JLabel("Is " + topic + " important?");
        JRadioButton a1 = new JRadioButton("Yes");
        JRadioButton a2 = new JRadioButton("No");
        JButton submit = new JButton("Submit");

        ButtonGroup bg = new ButtonGroup();
        bg.add(a1);
        bg.add(a2);

        q.setBounds(50,30,300,25);
        a1.setBounds(50,70,100,25);
        a2.setBounds(50,100,100,25);
        submit.setBounds(120,160,120,30);

        add(q); add(a1); add(a2); add(submit);

        submit.addActionListener(e -> {
            int score = a1.isSelected() ? 80 : 30;
            new ProgressCSVDao().updateProgress(userId, topic, score);
            JOptionPane.showMessageDialog(this,
                    "Test completed. Score: " + score);
            dispose();
        });
    }
}

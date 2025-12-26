package view;

import dao.ProgressCSVDao;
import dao.QuestionCSVDao;
import model.Question;

import javax.swing.*;
import java.util.List;

public class MCQTestView extends JFrame {

    private int index = 0;
    private int score = 0;
    private List<Question> questions;
    private JRadioButton[] options = new JRadioButton[4];
    private ButtonGroup group = new ButtonGroup();
    private JLabel questionLabel = new JLabel();

    public MCQTestView(String userId, String topic) {
        questions = new QuestionCSVDao().getQuestionsByTopic(topic);

        setTitle(topic + " Test");
        setSize(500,350);
        setLayout(null);

        questionLabel.setBounds(30,20,420,30);
        add(questionLabel);

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setBounds(40,60 + i * 30,400,25);
            group.add(options[i]);
            add(options[i]);
        }

        JButton next = new JButton("Next");
        next.setBounds(180,200,120,30);
        add(next);

        loadQuestion();

        next.addActionListener(e -> {
            if (group.getSelection() == null) return;

            int selected = getSelectedOption();
            if (selected == questions.get(index).getCorrectOption())
                score += 10;

            index++;

            if (index < questions.size()) {
                group.clearSelection();
                loadQuestion();
            } else {
                new ProgressCSVDao().updateProgress(userId, topic, score);
                JOptionPane.showMessageDialog(this, "Score: " + score);
                dispose();
            }
        });
    }

    private void loadQuestion() {
        Question q = questions.get(index);
        questionLabel.setText(q.getQuestion());
        for (int i = 0; i < 4; i++) {
            options[i].setText(q.getOptions()[i]);
        }
    }

    private int getSelectedOption() {
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) return i + 1;
        }
        return -1;
    }
}


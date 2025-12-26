package dao;

import model.Question;
import util.CSVUtil;

import java.util.ArrayList;
import java.util.List;

public class QuestionCSVDao {

    public List<Question> getQuestionsByTopic(String topic) {
        List<Question> list = new ArrayList<>();

        List<String[]> rows = CSVUtil.read("data/questions.csv");

        for (String[] r : rows) {
            if (r[0].equalsIgnoreCase(topic)) {
                String[] options = { r[3], r[4], r[5], r[6] };
                list.add(new Question(
                        r[0],
                        r[2],
                        options,
                        Integer.parseInt(r[7])
                ));
            }
        }
        return list;
    }
}

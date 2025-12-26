package dao;

import model.Progress;
import util.CSVUtil;

import java.util.ArrayList;
import java.util.List;

public class ProgressCSVDao {

    private static final String FILE = "data/progress.csv";

    public void updateProgress(String userId, String topic, int score) {
        CSVUtil.append(FILE, new String[]{userId, topic, String.valueOf(score)});
    }

    public List<Progress> getProgress(String userId) {
        List<Progress> list = new ArrayList<>();

        List<String[]> rows = CSVUtil.read(FILE);
        for (String[] r : rows) {
            if (r[0].equals(userId)) {
                list.add(new Progress(
                        r[0],
                        r[1],
                        Integer.parseInt(r[2])
                ));
            }
        }
        return list;
    }
}

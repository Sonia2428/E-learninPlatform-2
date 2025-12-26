package util;

import java.io.*;
import java.util.List;

import org.jfree.data.category.DefaultCategoryDataset;

public class CSVUtil {

    private static final String PROGRESS_FILE = "data/progress.csv";
    private static final String SKILL_FILE = "data/diagnostic_results.csv";

    public static int countStatus(String userId, String status) {
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(PROGRESS_FILE))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(userId) && data[2].equals(status)) {
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static DefaultCategoryDataset getSkillDataset(String userId) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try (BufferedReader br = new BufferedReader(new FileReader(SKILL_FILE))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(userId)) {
                    String topic = data[1];
                    int score = Integer.parseInt(data[2]);
                    dataset.addValue(score, "Score", topic);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }

    public static void append(String file, String[] strings) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'append'");
    }

    public static List<String[]> read(String file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }
}

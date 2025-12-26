package view;

import dao.ProgressCSVDao;
import model.Progress;
import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.List;

public class ProgressChartView extends JFrame {

    public ProgressChartView(String userId) {
        setTitle("Progress Chart");
        setSize(600,400);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<Progress> list = new ProgressCSVDao().getProgress(userId);

        for (Progress p : list) {
            dataset.addValue(p.getScore(), "Score", p.getTopic());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Progress", "Topic", "Score", dataset);

        add(new ChartPanel(chart));
    }
}


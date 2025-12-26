package dao;

import model.DiagnosticResult;
import java.io.*;
import java.util.*;

public class DiagnosticCSVDao {

    public List<DiagnosticResult> getResults(String userId) {
        List<DiagnosticResult> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data/diagnostic_results.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d[0].equals(userId)) {
                    list.add(new DiagnosticResult(d[1], Integer.parseInt(d[2])));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

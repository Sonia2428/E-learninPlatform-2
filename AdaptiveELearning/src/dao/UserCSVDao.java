package dao;

import model.User;
import java.io.*;

public class UserCSVDao {

    private static final String FILE = "data/users.csv";

    public User login(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d[1].equals(username) && d[2].equals(password)) {
                    return new User(d[0], d[1], d[2]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean userExists(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d[1].equals(username)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void registerUser(String username, String password) {
        String userId = "U" + System.currentTimeMillis();

        try (FileWriter fw = new FileWriter(FILE, true)) {
            fw.write(userId + "," + username + "," + password + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


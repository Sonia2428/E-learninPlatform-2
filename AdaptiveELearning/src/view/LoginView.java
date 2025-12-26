package view;

import dao.UserCSVDao;
import model.User;

import javax.swing.*;

public class LoginView extends JFrame {

    public LoginView() {
        setTitle("Login");
        setSize(320,230);
        setLayout(null);

        JLabel l1 = new JLabel("Username");
        JLabel l2 = new JLabel("Password");
        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();
        JButton loginBtn = new JButton("Login");
        JButton signUpBtn = new JButton("Sign Up");

        l1.setBounds(30,30,80,25);
        user.setBounds(120,30,150,25);
        l2.setBounds(30,70,80,25);
        pass.setBounds(120,70,150,25);
        loginBtn.setBounds(50,120,90,30);
        signUpBtn.setBounds(160,120,90,30);

        add(l1); add(user);
        add(l2); add(pass);
        add(loginBtn); add(signUpBtn);

        loginBtn.addActionListener(e -> {
            UserCSVDao dao = new UserCSVDao();
            User u = dao.login(user.getText(), new String(pass.getPassword()));

            if (u != null) {
                new DashboardView(u.getUserId()).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Invalid login.\nIf you are new, please Sign Up.");
            }
        });

        signUpBtn.addActionListener(e -> {
            new RegisterView().setVisible(true);
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

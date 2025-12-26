package view;

import dao.UserCSVDao;

import javax.swing.*;

public class RegisterView extends JFrame {

    public RegisterView() {
        setTitle("Sign Up");
        setSize(300,220);
        setLayout(null);

        JLabel l1 = new JLabel("New Username");
        JLabel l2 = new JLabel("New Password");
        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();
        JButton btn = new JButton("Register");

        l1.setBounds(30,30,120,25);
        user.setBounds(150,30,120,25);
        l2.setBounds(30,70,120,25);
        pass.setBounds(150,70,120,25);
        btn.setBounds(90,120,120,30);

        add(l1); add(user);
        add(l2); add(pass);
        add(btn);

        btn.addActionListener(e -> {
            UserCSVDao dao = new UserCSVDao();

            if (dao.userExists(user.getText())) {
                JOptionPane.showMessageDialog(this, "User already exists!");
            } else {
                dao.registerUser(user.getText(), new String(pass.getPassword()));
                JOptionPane.showMessageDialog(this, "Registration successful!");
                dispose();
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}

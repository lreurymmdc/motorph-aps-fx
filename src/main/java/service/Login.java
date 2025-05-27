package service;

import model.Employee;
import repository.FileHandler;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class Login extends JFrame {
    private JPanel loginWindow;
    private JTextField userIDFieldLogin;
    private JLabel userIDLabel;
    private JTextField birthDayFieldLogin;
    private JLabel birthDayLabel;
    private JPanel loginForm;
    private JButton loginBtn;

    public boolean loginStatus = false;
    private FileHandler fileHandler;
    private List<String[]> employeeRecords;
    private int searchKey;
    private Employee user;
    private int loggedUserID;
    private String birthDay;



    public Login() {
        setTitle("MotorPH APS - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setContentPane(loginWindow);

        fileHandler = new FileHandler("HR");
        employeeRecords = fileHandler.getRecords();

        setupListeners();
    }

    private void setupListeners() {
        setupLoginButton();
        setupUserIDField();
        setupBirthDayField();
    }

    private void setupLoginButton() {
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == loginBtn) {
                    try {
                        loggedUserID = Integer.parseInt(userIDFieldLogin.getText());
                        birthDay = birthDayFieldLogin.getText();

                        user = new Employee(loggedUserID, birthDay, false);

                        if (user.getCredentialsValid()) {
                            loginStatus = true;
                        }

                        if (loginStatus) {
                            new Menu(user);
                            dispose();
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "User ID must be a number.");
                    }
                }
            }
        });
    }

    private void setupUserIDField() {
        userIDFieldLogin.addMouseListener(new MouseAdapter() {}); // placeholder
        userIDFieldLogin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || userIDFieldLogin.getText().length() >= 5) {
                    e.consume();
                }
            }
        });
    }

    private void setupBirthDayField() {
        birthDayFieldLogin.addMouseListener(new MouseAdapter() {}); // placeholder
        birthDayFieldLogin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = birthDayFieldLogin.getText();

                if (text.length() >= 10) {
                    e.consume();
                    return;
                }
                if (!Character.isDigit(c) && c != '/') {
                    e.consume();
                    return;
                }
                if (c == '/' && text.chars().filter(ch -> ch == '/').count() >= 2) {
                    e.consume();
                }
            }
        });
    }
}
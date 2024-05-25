package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Controller.UserController;

public class LoginPage extends JFrame implements ActionListener {
    JLabel tulisan = new JLabel("Selamat Datang!");
    JLabel tulisan2 = new JLabel("Silahkan Masuk untuk melanjutkan.");
    JLabel username = new JLabel("Username");
    JTextField inputNama = new JTextField();
    JLabel password = new JLabel("Password");
    JPasswordField inputpassword = new JPasswordField();
    JButton tombolLogin = new JButton("Login");
    UserController userController;

    public LoginPage() {
        userController = new UserController();

        setVisible(true);
        setSize(480, 520);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        add(tulisan);
        tulisan.setBounds(20, 20, 150, 30);
        tulisan.setFont(new Font("Serif", Font.BOLD, 20));

        add(tulisan2);
        tulisan2.setBounds(20, 40, 300, 30);

        add(username);
        username.setBounds(20, 70, 150, 30);

        add(inputNama);
        inputNama.setBounds(20, 100, 410, 30);

        add(password);
        password.setBounds(20, 140, 150, 30);

        add(inputpassword);
        inputpassword.setBounds(20, 170, 410, 30);

        add(tombolLogin);
        tombolLogin.setBounds(20, 280, 410, 35);
        tombolLogin.setBackground(Color.white);
        tombolLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String Username = inputNama.getText();
            String Password = new String(inputpassword.getPassword());

            if (Username.isEmpty()) {
                throw new Exception("Username jangan kosong, Gus");
            } else if (Password.isEmpty()) {
                throw new Exception("Password jangan kosong ya!");
            }

            if (userController.validateUser(Username, Password)) {
                new MenuPage(Username);
                this.dispose();
            } else {
                throw new Exception("Username atau Password salah!");
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
}

package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuPage extends JFrame implements ActionListener {
    JLabel salam = new JLabel();
    JLabel tulisan = new JLabel("Silahkan pilih untuk melanjutkan");
    JButton mahasiswa = new JButton("Mahasiswa");
    JButton dosen = new JButton("Dosen");
    JButton logout = new JButton("Logout");

    public MenuPage(String Username) {
        setVisible(true);
        setSize(480, 400);
        setTitle("Halaman Utama");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        add(salam);
        salam.setText("Welcome, " + Username);
        salam.setBounds(20, 20, 370, 40);
        salam.setFont(new Font("Serif", Font.BOLD, 20));

        add(tulisan);
        tulisan.setBounds(20, 60, 370, 40);

        add(mahasiswa);
        mahasiswa.setBounds(20, 120, 410, 40);
        mahasiswa.addActionListener(this);

        add(dosen);
        dosen.setBounds(20, 180, 410, 40);
        dosen.addActionListener(this);

        add(logout);
        logout.setBounds(20, 240, 410, 40);
        logout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mahasiswa) {
            new View.Mahasiswa.ViewData();
            this.dispose();
        } else if (e.getSource() == dosen) {
            new View.Dosen.ViewData();
            this.dispose();
        } else if (e.getSource() == logout) {
            this.dispose();
            new LoginPage();
        }
    }
}

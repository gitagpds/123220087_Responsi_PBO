package View.Dosen;

import Controller.ControllerDosen;
import java.awt.event.*;
import javax.swing.*;

public class InputData extends JFrame {

    // Membuat sebuah instance bernama controller dari class "ControllerDosen".
    ControllerDosen controller;

    JLabel header = new JLabel("Input Dosen");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputNoHP = new JLabel("No HP");
    JLabel labelInputEmail = new JLabel("Email");
    JTextField inputNama = new JTextField();
    JTextField inputNoHP = new JTextField();
    JTextField inputEmail = new JTextField();
    JButton tombolTambah = new JButton("Tambah Dosen");
    JButton tombolKembali = new JButton("Kembali");

    public InputData() {
        setTitle("Input Dosen");
        setVisible(true);
        setSize(600, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(header);
        add(labelInputNama);
        add(labelInputNoHP);
        add(labelInputEmail);
        add(inputNama);
        add(inputNoHP);
        add(inputEmail);
        add(tombolTambah);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputNoHP.setBounds(20, 96, 440, 24);
        inputNoHP.setBounds(18, 120, 440, 36);
        labelInputEmail.setBounds(20, 150, 440, 24);
        inputEmail.setBounds(18, 180, 440, 36);
        tombolKembali.setBounds(20, 260, 215, 40);
        tombolTambah.setBounds(240, 300, 215, 40);

        controller = new ControllerDosen(this);

        /* 
          Memberikan event handling untuk tombol kembali,
          Ketika tombol kembali diklik, maka akan kembali ke halaman ViewData().
         */
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewData();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.insertDosen();
            }
        });
    }

    /*
      Membuat sebuah getter untuk mengambil nilai dari form "inputNama".
      Kenapa perlu getter? karena nama yang diinput user akan digunakan di controller.
      Kita tidak bisa langsung mengambil isi dari input nama karena variabel "inputNama"
      memiliki modifier "default", yang artinya variabel tersebut tidak dapat diakses
      di package yang berbeda. Sebagaimana sturktur folder kita, 
      file ControllerDosen.java dan file InputData.java 
      berada pada package yang berbeda.
     */
    public String getInputNama() {
        return inputNama.getText();
    }

    /*
      Membuat sebuah getter untuk mengambil nilai dari form "inputNIDN".
      Kenapa perlu getter? karena NIDN yang diinput user akan digunakan di controller.
      Kita tidak bisa langsung mengambil isi dari input NIDN karena variabel "inputNIDN"
      memiliki modifier "default", yang artinya variabel tersebut tidak dapat diakses
      di package yang berbeda. Sebagaimana sturktur folder kita, 
      file ControllerDosen.java dan file InputData.java 
      berada pada package yang berbeda.
     */
    public String getInputNo_hp() {
        return inputNoHP.getText();
    }
    
    public String getInputEmail() {
        return inputEmail.getText();
    }
}

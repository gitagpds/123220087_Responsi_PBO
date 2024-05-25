package View.Dosen;

import Controller.ControllerDosen;
import Model.Dosen.ModelDosen;
import View.MenuPage;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewData extends JFrame {
    Integer baris;
    ControllerDosen controller;

    JLabel header = new JLabel("Data Dosen");
    JTextField searchField = new JTextField();
    JButton searchButton = new JButton("Search");
    JButton tombolTambah = new JButton("Tambah Dosen");
    JButton tombolEdit = new JButton("Edit Dosen");
    JButton tombolHapus = new JButton("Hapus Dosen");
    JButton tombolKembali = new JButton("Kembali ke menu utama");

    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    String namaKolom[] = {"ID", "Nama", "No HP", "Email"};

    public ViewData() {
        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setTitle("Daftar Dosen");
        setVisible(true);
        setSize(552, 620);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(header);
        add(searchField);
        add(searchButton);
        add(scrollPane);
        add(tombolTambah);
        add(tombolEdit);
        add(tombolHapus);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        searchField.setBounds(20, 36, 410, 30);
        searchButton.setBounds(440, 36, 90, 30);
        scrollPane.setBounds(20, 70, 512, 320);
        tombolTambah.setBounds(20, 400, 512, 40);
        tombolEdit.setBounds(20, 444, 512, 40);
        tombolHapus.setBounds(20, 488, 512, 40);
        tombolKembali.setBounds(20, 532, 512, 40);

        controller = new ControllerDosen(this);
        controller.showAllDosen();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                baris = table.getSelectedRow();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InputData();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    ModelDosen dosenTerpilih = new ModelDosen();
                    Integer id = (int) table.getValueAt(baris, 0);
                    String nama = table.getValueAt(baris, 1).toString();
                    String no_hp = table.getValueAt(baris, 2).toString();
                    String email = table.getValueAt(baris, 3).toString();
                    
                    dosenTerpilih.setId(id);
                    dosenTerpilih.setNama(nama);
                    dosenTerpilih.setNo_hp(no_hp);
                    dosenTerpilih.setEmail(email);

                    dispose();
                    new EditData(dosenTerpilih);
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });

        tombolHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    controller.deleteDosen(baris);
                    baris = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });

        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuPage();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = searchField.getText();
                controller.searchDosen(query);
            }
        });
    }

    public JTable getTableDosen() {
        return table;
    }
}

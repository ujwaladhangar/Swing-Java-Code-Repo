package com.infogalaxy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FrameDemo3 {
    JFrame frame = new JFrame("Frame Demo2");
    JPanel panel = new JPanel();
    JLabel lblGender = new JLabel("Select Gender : ");
    ButtonGroup btnGroup = new ButtonGroup();
    JRadioButton rbMale = new JRadioButton("Male");
    JRadioButton rbFemale = new JRadioButton("Female");
    JLabel lblGenderMessage = new JLabel("Gender Message");
    JLabel lblDoc = new JLabel("Select the Documents:");
    JCheckBox chkAdhar = new JCheckBox("Aadhar Card");
    JCheckBox chkPan = new JCheckBox("Pan Card");
    JCheckBox chkLC = new JCheckBox("L.C.");
    JCheckBox chkTC = new JCheckBox("T.C.");
    JLabel lblSelDoc = new JLabel("Selected :");
    JLabel lblItems = new JLabel("Select Item:");
    String[] items = {"Select", "Pen", "Pencil", "Book"};
    JComboBox cmbItem = new JComboBox(items);
    JTextField txtNewItem = new JTextField();
    JButton btnNewItem = new JButton("ADD");
    JButton btnDeleteItem = new JButton("DELETE");

    FrameDemo3() {
        genderView();
        docView();
        itemView();
        panel.setLayout(null);
        frame.add(panel);

        frame.setSize(400, 400);
        frame.setLocation(200, 100);
        frame.setVisible(true);
    }

    public void genderView() {
        btnGroup.add(rbMale);
        btnGroup.add(rbFemale);

        lblGender.setBounds(20, 20, 100, 30);
        panel.add(lblGender);

        rbMale.setBounds(130, 20, 80, 30);
        panel.add(rbMale);

        rbMale.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lblGenderMessage.setText("Your Gender is Male");
            }
        });

        rbFemale.setBounds(220, 20, 80, 30);
        panel.add(rbFemale);

        rbFemale.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lblGenderMessage.setText("Your Gender is Female");
            }
        });

        lblGenderMessage.setBounds(20, 60, 200, 30);
        panel.add(lblGenderMessage);
    }

    public void docView() {
        lblDoc.setBounds(20, 100, 150, 30);
        panel.add(lblDoc);
        lblSelDoc.setBounds(170, 100, 100, 30);
        panel.add(lblSelDoc);
        chkAdhar.setBounds(20, 140, 100, 30);
        panel.add(chkAdhar);
        chkAdhar.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (chkAdhar.isSelected()) {
                    lblSelDoc.setText("Aadhar Card");
                } else {
                    lblSelDoc.setText("Selected :");
                }
            }
        });
        chkPan.setBounds(130, 140, 100, 30);
        panel.add(chkPan);
        chkLC.setBounds(20, 190, 100, 30);
        panel.add(chkLC);
        chkTC.setBounds(130, 190, 100, 30);
        panel.add(chkTC);
    }

    public void itemView() {
        lblItems.setBounds(20, 220, 100, 30);
        panel.add(lblItems);
        cmbItem.setBounds(20, 260, 100, 30);
//        cmbItem.addItem("Pen");
//        cmbItem.addItem("Pencil");
//        cmbItem.addItem("Book");
        panel.add(cmbItem);
        cmbItem.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(cmbItem.getSelectedItem().toString());
                System.out.println(cmbItem.getSelectedIndex());
            }
        });

        txtNewItem.setBounds(130, 260, 100, 30);
        panel.add(txtNewItem);
        btnNewItem.setBounds(130, 300, 100, 30);
        panel.add(btnNewItem);
        btnNewItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtNewItem.getText().isEmpty()) {
                    //System.out.println("Please Enter the Item First");
                    JOptionPane.showMessageDialog(frame, "Please Enter the Item Name");
                } else {
                    cmbItem.addItem(txtNewItem.getText());
                    txtNewItem.setText("");
                    txtNewItem.requestFocus();
                }
            }
        });
        btnDeleteItem.setBounds(240, 300, 80, 30);
        panel.add(btnDeleteItem);
        btnDeleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbItem.getSelectedItem().toString().equals("Select")) {
                    JOptionPane.showMessageDialog(frame, "Please Select the Valid Item");
                } else {
                    cmbItem.removeItem(cmbItem.getSelectedItem());
                }
            }
        });
    }
}

class Main3 {
    public static void main(String[] args) {
        FrameDemo3 frameDemo2 = new FrameDemo3();
    }
}


package sim.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComboBoxSelectedItem extends JFrame {
    public ComboBoxSelectedItem() {
        initialize();
    }

    private void initialize() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create a combo box with four items and set it to editable so that user can
        // enter their own value.
        final JComboBox<String> comboBox = new JComboBox<>(new String[] {"One", "Two", "Three", "Four"});
        comboBox.setEditable(true);
        getContentPane().add(comboBox);

        // Create two button that will set the selected item of the combo box. The
        // first button select "Two" and and second button select "Four".
        JButton button1 = new JButton("Set Two");
        getContentPane().add(button1);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBox.setSelectedItem("Two");
            }
        });

        JButton button2 = new JButton("Set Four");
        getContentPane().add(button2);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBox.setSelectedItem("Four");
            }
        });

        // Create a text field for displaying the selected item when we press the
        // Get Value button. When user enter their own value the selected item
        // returned is the string that entered by user.
        final JTextField textField = new JTextField("");
        textField.setPreferredSize(new Dimension(150, 20));

        JButton button3 = new JButton("Get Value");
        getContentPane().add(button3);
        getContentPane().add(textField);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText((String) comboBox.getSelectedItem());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComboBoxSelectedItem().setVisible(true);
            }
        });
    }
}
package lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestRunner {

    public static void main(String[] ags) {


        JFrame f = new JFrame("ComboBox Example");
        final JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(400, 100);
        JButton b = new JButton("Show");
        b.setBounds(200, 100, 75, 20);
        String languages[] = {"C", "C++", "C#", "Java", "PHP"};

        final JComboBox cb = new JComboBox(languages);
        cb.setBounds(50, 100, 150, 20);

        JButton eb = new JButton("X");
        final String erase = "X";
        cb.getEditor().getEditorComponent().createImage(10, 10);
        f.add(cb);
        f.add(label);
        f.add(b);


//        cb.seted

        f.setLayout(null);
        f.setSize(350, 350);
        f.setVisible(true);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Programming language Selected: "
                        + cb.getItemAt(cb.getSelectedIndex());
                label.setText(data);
            }
        });
    }
}

package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomComboBoxEditor {

    public static void main(String[] args) {
        new CustomComboBoxEditor();
    }

    public CustomComboBoxEditor() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JComboBox cb = new JComboBox();
                cb.addItem("Apple");
                cb.addItem("Banana");
                cb.addItem("Orange");
                cb.setEditable(true);
                cb.setEditor(new MyComboBoxEditor());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                frame.add(cb);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MyComboBoxEditor implements ComboBoxEditor {

        private EditorPane editorPane;

        public MyComboBoxEditor() {
            editorPane = new EditorPane();
        }

        @Override
        public Component getEditorComponent() {
            return editorPane;
        }

        @Override
        public void setItem(Object anObject) {
            editorPane.setText(anObject == null ? null : anObject.toString());
        }

        @Override
        public Object getItem() {
            return editorPane.getText();
        }

        @Override
        public void selectAll() {
            editorPane.selectAll();
        }

        @Override
        public void addActionListener(ActionListener l) {
            editorPane.addActionListener(l);
        }

        @Override
        public void removeActionListener(ActionListener l) {
            editorPane.removeActionListener(l);
        }

    }

    public class EditorPane extends JPanel {

        private JTextField field;
        private JButton button;

        public EditorPane() {
            field = new JTextField(10);
            button = new JButton("X");
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            add(field, gbc);
            gbc.weightx = 0;
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridx++;
            add(button, gbc);

            button.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed (ActionEvent e)
                {

                    field.setText(null);
//                    if (getPattern().length() != 0)
//                    {
//                        JTextField jText = (JTextField) m_comboPattern.getEditor().getEditorComponent();
//                        jText.setText(null);
//                        return;
//                    }
                }
            });

        }

        @Override
        public void addNotify() {
            super.addNotify();
            field.requestFocusInWindow();
        }

        public void selectAll() {
            field.selectAll();
        }

        public void setText(String text) {
            field.setText(text);
        }

        public String getText() {
            return field.getText();
        }

        public void addActionListener(ActionListener listener) {
            field.addActionListener(listener);
        }

        public void removeActionListener(ActionListener listener) {
            field.removeActionListener(listener);
        }

        public JTextField getTextField() {
            return field;
        }

        public JButton getResetButton() {
            return button;
        }
    }
}

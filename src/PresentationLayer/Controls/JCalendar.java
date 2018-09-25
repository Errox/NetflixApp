package PresentationLayer.Controls;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

public class JCalendar extends JTextField {

    //private JTextField field;
    private String input;
    private int maxLenght;

    public JCalendar(int maxLenght) {
        this.maxLenght = maxLenght;
        this.addKeyListener(new onChange(this));

    }

    public Date getValue() {
        String input = this.getText();
        Date d = new Date();


        //d.setMonth();
        //d.setYear();
        return d;
        //return date;
    }


    public class onChange implements KeyListener {
        private JTextField textField;

        public onChange(JTextField tf) {
            this.textField = tf;
        }

        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (textField.getText().length() >= maxLenght ||
                    !(Character.isDigit(c) ||
                            (c == KeyEvent.VK_BACK_SPACE) ||
                            (c == KeyEvent.VK_DELETE))) {

                e.consume();
            }
            if (textField.getText().length() == 2 || textField.getText().length() == 5) {
                textField.setText(textField.getText() + "-");
            }


        }

        @Override
        public void keyPressed(KeyEvent e) {


        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}


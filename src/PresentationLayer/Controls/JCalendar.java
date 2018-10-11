package PresentationLayer.Controls;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JCalendar extends JTextField {

    private int maxLength;

    public JCalendar(int maxLength) {
        this.maxLength = maxLength;
        this.addKeyListener(new onChange(this));

    }

    public void setDate(Date s){

        SimpleDateFormat originalFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat iFormatter = new SimpleDateFormat("yyyy-MM-dd");

        String formatted  = null;
        try {
            formatted = originalFormat.format(iFormatter.parse(s.toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        this.setText(formatted);
    }

    public Date getDateValue() {
        String input = this.getText();
        Date date = new Date();

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = df.parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }


    public class onChange implements KeyListener {
        private JTextField textField;

        public onChange(JTextField tf) {
            this.textField = tf;
        }

        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();

            if ((c == KeyEvent.VK_BACK_SPACE)) {
                textField.setText(textField.getText().substring(0, textField.getText().length()));
                return;
            }

            if (textField.getText().length() >= maxLength || !(Character.isDigit(c)
                    || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_DELETE))) {
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


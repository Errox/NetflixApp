package PresentationLayer.Controls;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.util.Date;

public class JCalendar extends JComponent {

    private JTextField field;
    private String input;
    private int maxLenght;

    public JCalendar(int maxLenght){
        this.maxLenght = maxLenght;
        this.field = new JTextField();
        field.addKeyListener(new onChange());

        field.setSize(100, 100);
        input = "";
    }

    public Date getValue(){
       // return Date.parse(field.getText());
        return null;
    }


    public class onChange implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            char c = e.getKeyChar();
            if (field.getText().length() >= maxLenght &&
                    !(Character.isDigit(c) ||
                     (c == KeyEvent.VK_BACK_SPACE) ||
                     (c == KeyEvent.VK_DELETE))) {

                e.consume();
            }



        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}


package PresentationLayer.Controls;

import javax.swing.*;

public class JMaxLengthTextBox extends JTextField {

    public JMaxLengthTextBox(int length) {
        this(null, length);
    }

    public JMaxLengthTextBox(String text, int length) {
        super(new PlainDocumentMaxLength(length), text, length);
    }
}




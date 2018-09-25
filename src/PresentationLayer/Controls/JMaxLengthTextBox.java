package PresentationLayer.Controls;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JMaxLengthTextBox extends JTextField {

    public JMaxLengthTextBox(int length) {
        this(null, length);
    }

    public JMaxLengthTextBox(String text, int length) {
        super(new PlainDocumentMaxLength(length), text, length);
    }
}


class PlainDocumentMaxLength extends PlainDocument {
    private int maxLength;

    public PlainDocumentMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
            if (!(getLength() + str.length() > maxLength)) {
                super.insertString(offset, str, a);
            }
    }
}

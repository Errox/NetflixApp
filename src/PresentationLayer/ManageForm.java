package PresentationLayer;

import javax.swing.*;

public class ManageForm {

    public void ManageAccount(){
        JTextField firstName = new JTextField();
        JTextField lastName = new JTextField();
        JPasswordField password = new JPasswordField();


        final JComponent[] inputs = new JComponent[] {
                new JLabel("First"),
                firstName,
                new JLabel("Last"),
                lastName,
                new JLabel("Password"),
                password
        };

        int result = JOptionPane.showConfirmDialog(null, inputs, "Fill in the fields", JOptionPane.DEFAULT_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            System.out.println("You entered " +
                    firstName.getText() + ", " +
                    lastName.getText() + ", " +
                    password.getPassword());
        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
    }

    public void ManageProfile(){

        JTextField firstName = new JTextField();
        JTextField lastName = new JTextField();
        JPasswordField password = new JPasswordField();


        final JComponent[] inputs = new JComponent[] {
                new JLabel("First"),
                firstName,
                new JLabel("Last"),
                lastName,
                new JLabel("Password"),
                password
        };

        int result = JOptionPane.showConfirmDialog(null, inputs, "Fill in the fields", JOptionPane.DEFAULT_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            System.out.println("You entered " +
                    firstName.getText() + ", " +
                    lastName.getText() + ", " +
                    password.getPassword());
        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
    }

    public void ManageWatched(){

        JTextField firstName = new JTextField();
        JTextField lastName = new JTextField();
        JPasswordField password = new JPasswordField();


        final JComponent[] inputs = new JComponent[] {
                new JLabel("First"),
                firstName,
                new JLabel("Last"),
                lastName,
                new JLabel("Password"),
                password
        };

        int result = JOptionPane.showConfirmDialog(null, inputs, "Fill in the fields", JOptionPane.DEFAULT_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            System.out.println("You entered " +
                    firstName.getText() + ", " +
                    lastName.getText() + ", " +
                    password.getPassword());
        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
    }

}

package PresentationLayer;

import ApplicationLayer.AccountManager;
import ApplicationLayer.ProfileManager;
import ApplicationLayer.WatchedManager;
import DomainModelLayer.Account;
import PresentationLayer.Controls.ManageType;
import PresentationLayer.Controls.ModifyType;

import javax.swing.*;

public class ManageForm {
   private ManageType manageType;
   private ModifyType modifyType;
   private AccountManager accountManager;
   private WatchedManager watchedManager;
   private ProfileManager profileManager;

   public ManageForm(ModifyType modifyType, ManageType type){

       this.manageType = type;
       this.modifyType = modifyType;

       if(manageType == ManageType.ACCOUNT){
            ManageAccount();
       }
       if(manageType == ManageType.PROFILE){
            ManageProfile();
       }
       if(manageType == ManageType.WATCHED){
           ManageWatched();
       }
   }

    public void ManageAccount(){
        this.accountManager = new AccountManager();

        JTextField fullName = new JTextField("", 8);
        JTextField streetName = new JTextField();
        JTextField postalCode = new JTextField();
        JTextField houseNumber = new JTextField();
        JTextField place = new JTextField();

        final JComponent[] inputs = new JComponent[] {
                new JLabel("Full name"),
                fullName,
                new JLabel("Street name"),
                streetName,
                new JLabel("Postal code"),
                postalCode,
                new JLabel("House number"),
                houseNumber,
                new JLabel("Place"),
                place
        };

        int result = JOptionPane.showConfirmDialog(null, inputs, "Fill in the fields", JOptionPane.DEFAULT_OPTION);

        if (result == JOptionPane.OK_OPTION) {

            if(modifyType == ModifyType.UPDATE){
                accountManager.updateAccount(null, null);
            }

            if(modifyType == ModifyType.CREATE){
                accountManager.addAccount(new Account(0, fullName.getText(), streetName.getText(), postalCode.getText(), houseNumber.getText(), place.getText() ));

            }
        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
    }

    public void ManageProfile(){
        this.profileManager = new ProfileManager();

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
        this.watchedManager = new WatchedManager();

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

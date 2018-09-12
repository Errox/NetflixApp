package PresentationLayer;

import javax.swing.*;
import java.awt.*;

public class ManagePanel extends JPanel {

    public enum ManageType {
        ACCOUNT,
        PROFILE,
        EDIT
    }

    private ManageType manageType;

    public ManagePanel(ManageType manageType){
        this.manageType = manageType;

        //JPanel related.
        setLayout(new BorderLayout());


//        updatePanel = createUpdatePanel();
//        add(createButtonPanel(), BorderLayout.SOUTH);
//        add(createContentPanel(), BorderLayout.NORTH);
//        add(updatePanel, BorderLayout.CENTER);
    }


}

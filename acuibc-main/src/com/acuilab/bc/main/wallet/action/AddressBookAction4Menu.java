package com.acuilab.bc.main.wallet.action;

import com.acuilab.bc.main.wallet.AddressBookDialog;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import static javax.swing.Action.NAME;

/**
 *
 * @author admin
 */
public class AddressBookAction4Menu extends AbstractAction {
    
    public AddressBookAction4Menu() {
        putValue(NAME, "通讯录");
        putValue(SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/resource/address16.png")));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        AddressBookDialog dlg = new AddressBookDialog(null);
        dlg.setVisible(true);
    }
}

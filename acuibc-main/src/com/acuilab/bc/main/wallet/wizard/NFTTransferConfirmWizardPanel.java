package com.acuilab.bc.main.wallet.wizard;

import com.acuilab.bc.main.wallet.Wallet;
import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;
import com.acuilab.bc.main.nft.INFT;

public class NFTTransferConfirmWizardPanel implements WizardDescriptor.Panel<WizardDescriptor> {
    
    private final Wallet wallet;
    private final INFT nft;
    
    public NFTTransferConfirmWizardPanel(Wallet wallet, INFT nft) {
        this.wallet = wallet;
        this.nft = nft;
    }

    /**
     * The visual component that displays this panel. If you need to access the
     * component from this class, just use getComponent().
     */
    private NFTTransferConfirmVisualPanel component;

    // Get the visual component for the panel. In this template, the component
    // is kept separate. This can be more efficient: if the wizard is created
    // but never displayed, or not all panels are displayed, it is better to
    // create only those which really need to be visible.
    @Override
    public NFTTransferConfirmVisualPanel getComponent() {
        if (component == null) {
            component = new NFTTransferConfirmVisualPanel(wallet, nft);
        }
        return component;
    }

    @Override
    public HelpCtx getHelp() {
        // Show no Help button for this panel:
        return HelpCtx.DEFAULT_HELP;
        // If you have context help:
        // return new HelpCtx("help.key.here");
    }

    @Override
    public boolean isValid() {
        // If it is always OK to press Next or Finish, then:
        return true;
        // If it depends on some condition (form filled out...) and
        // this condition changes (last form field filled in...) then
        // use ChangeSupport to implement add/removeChangeListener below.
        // WizardDescriptor.ERROR/WARNING/INFORMATION_MESSAGE will also be useful.
    }

    @Override
    public void addChangeListener(ChangeListener l) {
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
    }

    @Override
    public void readSettings(WizardDescriptor wiz) {
        // use wiz.getProperty to retrieve previous panel state
        String recvAddress = (String)wiz.getProperty("recvAddress");
        int value = (int)wiz.getProperty("value");
        int gas = (int)wiz.getProperty("gas");
	getComponent().init(recvAddress, value, wallet.getAddress(), nft.gasDesc(gas));
    }

    @Override
    public void storeSettings(WizardDescriptor wiz) {
        // use wiz.putProperty to remember current panel state
    }

}

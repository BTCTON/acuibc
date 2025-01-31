package com.acuilab.bc.main.action;

import com.acuilab.bc.main.dapp.BrowserInfo;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;
import org.apache.commons.lang3.StringUtils;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.Utilities;

/**
 *
 * @author admin
 */
public class BackBrowserDAppAction extends AbstractAction implements LookupListener {
    
    private final Lookup.Result<BrowserInfo> result;
    private BrowserInfo browserInfo;
    
    public BackBrowserDAppAction() {
        putValue(NAME, "后退");
        putValue(SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/resource/back32.png")));

        result = Utilities.actionsGlobalContext().lookupResult(BrowserInfo.class);
        result.addLookupListener(this);
        
        setEnabled(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        browserInfo.getBrowser().goBack();
    }

    @Override
    public void resultChanged(LookupEvent ev) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 setEnabled(!result.allInstances().isEmpty());
            }
            
        });
       
        if(result.allInstances().isEmpty()) {
            return; 
        }
        
        browserInfo = result.allInstances().iterator().next();
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 setEnabled(browserInfo.getBrowser().canGoBack() && !StringUtils.equals(browserInfo.getBrowser().getURL(), browserInfo.getHomeUrl()));
            }
        });
    }
}
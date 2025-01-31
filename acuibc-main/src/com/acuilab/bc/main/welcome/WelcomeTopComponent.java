package com.acuilab.bc.main.welcome;

import com.acuilab.bc.main.JxBrowserDisposer;
import com.google.common.io.Files;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserContext;
import com.teamdev.jxbrowser.chromium.BrowserContextParams;
import com.teamdev.jxbrowser.chromium.BrowserType;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.BorderLayout;
import java.util.logging.Logger;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.ServiceProvider;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.acuilab.bc.main.welcome//Welcome//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "WelcomeTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "com.acuilab.bc.main.welcome.WelcomeTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_WelcomeAction",
        preferredID = "WelcomeTopComponent"
)
@Messages({
    "CTL_WelcomeAction=欢迎",
    "CTL_WelcomeTopComponent=欢迎",
    "HINT_WelcomeTopComponent=欢迎"
})
@ServiceProvider(service=JxBrowserDisposer.class)
public final class WelcomeTopComponent extends TopComponent implements JxBrowserDisposer {
    private static final Logger LOG = Logger.getLogger(WelcomeTopComponent.class.getName());
    private final Browser browser;
    private final BrowserView view;

    public WelcomeTopComponent() {
        initComponents();
        setName(Bundle.CTL_WelcomeTopComponent());
        setToolTipText(Bundle.HINT_WelcomeTopComponent());
        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_MAXIMIZATION_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);

	// http://acuilab.com:8080/articles/2021/02/09/1612840191556.html
	// 解决JxBrowser中BrowserView控件覆盖其他控件的办法 
	browser = new Browser(BrowserType.LIGHTWEIGHT, new BrowserContext(new BrowserContextParams(Files.createTempDir().getAbsolutePath())));
	view = new BrowserView(browser);
	this.add(view, BorderLayout.CENTER);
	
        browser.loadURL("https://www.tree-graph.org.cn/");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
//
//    private void handleHyperlinkAction(java.awt.event.ActionEvent evt) {
//        if(Desktop.isDesktopSupported()) {
//            try {
//                if(Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
//                    // 打开默认浏览器
//                    JXHyperlink link = (JXHyperlink)evt.getSource();
//                    Desktop.getDesktop().browse(URI.create(link.getText()));
//                }
//            } catch (IOException ex) {
//                Exceptions.printStackTrace(ex);
//            }
//        }
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }
    
    public void disposeBrowser() {
        if(browser != null) {
            browser.dispose();
        }
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//	g.drawImage(ImageUtilities.loadImage("/resource/splash.png", true), 0, 0, this);
//	super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
//    }
}

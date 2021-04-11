package com.acuilab.bc.main.dapp;

import com.acuilab.bc.main.util.AESUtil;
import com.acuilab.bc.main.wallet.Wallet;
import java.awt.Image;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.SwingWorker;
import org.jdesktop.swingx.JXPanel;
import org.netbeans.api.progress.ProgressHandle;
import org.openide.util.Exceptions;

/**
 *
 * @author admin
 */
public class SingleDAppPanel extends JXPanel {
    private final IDApp dapp;

    /**
     * Creates new form SingleDAppPanel
     */
    public SingleDAppPanel(IDApp dapp) {
	initComponents();
	
	this.dapp = dapp;
	nameLbl.setText(dapp.getName());
//	Image image = dapp.getImage();
//	imageView.setImage(image);
//	double scaleX = 178.0d/image.getWidth(null);
//	double scaleY = 178.0d/image.getHeight(null);
//	imageView.setScale(Math.max(scaleX, scaleY));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageView = new org.jdesktop.swingx.JXImageView();
        nameLbl = new org.jdesktop.swingx.JXLabel();
        launchBtn = new org.jdesktop.swingx.JXButton();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();

        setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.activeTitleGradient"));
        setMaximumSize(new java.awt.Dimension(180, 326));
        setMinimumSize(new java.awt.Dimension(180, 326));
        setPreferredSize(new java.awt.Dimension(180, 326));

        imageView.setMaximumSize(new java.awt.Dimension(178, 178));
        imageView.setMinimumSize(new java.awt.Dimension(178, 178));
        imageView.setPreferredSize(new java.awt.Dimension(178, 178));

        javax.swing.GroupLayout imageViewLayout = new javax.swing.GroupLayout(imageView);
        imageView.setLayout(imageViewLayout);
        imageViewLayout.setHorizontalGroup(
            imageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imageViewLayout.setVerticalGroup(
            imageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );

        nameLbl.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.activeTitleGradient"));
        org.openide.awt.Mnemonics.setLocalizedText(nameLbl, org.openide.util.NbBundle.getMessage(SingleDAppPanel.class, "SingleDAppPanel.nameLbl.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(launchBtn, org.openide.util.NbBundle.getMessage(SingleDAppPanel.class, "SingleDAppPanel.launchBtn.text")); // NOI18N
        launchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchBtnActionPerformed(evt);
            }
        });

        jXLabel2.setForeground(java.awt.Color.red);
        jXLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        org.openide.awt.Mnemonics.setLocalizedText(jXLabel2, org.openide.util.NbBundle.getMessage(SingleDAppPanel.class, "SingleDAppPanel.jXLabel2.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jXLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(launchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(imageView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(launchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void launchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchBtnActionPerformed

	// 选择钱包，输入密码，获得私钥
        WalletSelectorDialog dlg = new WalletSelectorDialog(null);
        dlg.setVisible(true);
        if(dlg.getReturnStatus() == WalletSelectorDialog.RET_OK) {
	    Wallet wallet = dlg.getSelectedWallet();
	    String password = dlg.getPassword();
            try {
                String privateKey = AESUtil.decrypt(wallet.getPrivateKeyAES(), password);
		
		launchBtn.setEnabled(false);
		final ProgressHandle ph = ProgressHandle.createHandle("正在启动" + dapp.getName() + "，请稍候");
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
		    @Override
		    protected Void doInBackground() throws Exception {
			ph.start();
			dapp.launch(privateKey);
			return null;
		    }

		    @Override
		    protected void done() {
			ph.finish();
			launchBtn.setEnabled(true);
		    }
		};
		worker.execute();
            } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | NoSuchAlgorithmException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }//GEN-LAST:event_launchBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXImageView imageView;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXButton launchBtn;
    private org.jdesktop.swingx.JXLabel nameLbl;
    // End of variables declaration//GEN-END:variables
}

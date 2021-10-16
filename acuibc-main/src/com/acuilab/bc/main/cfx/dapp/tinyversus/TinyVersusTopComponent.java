package com.acuilab.bc.main.cfx.dapp.tinyversus;

import com.acuilab.bc.main.coin.ICoin;
import com.acuilab.bc.main.manager.CoinManager;
import com.acuilab.bc.main.util.Constants;
import com.acuilab.bc.main.wallet.Wallet;
import com.acuilab.bc.main.wallet.common.SelectWalletDialog;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.examples.complete.Utils;
import net.java.balloontip.utils.TimingUtils;
import org.javatuples.Pair;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.acuilab.bc.main.cfx.dapp.tinyversus//TinyVersus//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "TinyVersusTopComponent",
        iconBase="tinyversus16.png", 
        persistenceType = TopComponent.PERSISTENCE_NEVER
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.acuilab.bc.main.cfx.dapp.tinyversus.TinyVersusTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_TinyVersusAction",
        preferredID = "TinyVersusTopComponent"
)
@Messages({
    "CTL_TinyVersusAction=TinyVersus",
    "CTL_TinyVersusTopComponent=TinyVersus",
    "HINT_TinyVersusTopComponent=This is a TinyVersus window"
})
public final class TinyVersusTopComponent extends TopComponent {
    
    private Wallet wallet;

    public TinyVersusTopComponent() {
        initComponents();
        setName(Bundle.CTL_TinyVersusTopComponent());
        setToolTipText(Bundle.HINT_TinyVersusTopComponent());

    }
    
    private void myInit() {
        if(wallet != null) {
            setBtnEnabled(false);
            final ProgressHandle ph = ProgressHandle.createHandle("正在初始化，请稍候...");
            SwingWorker<Pair<BigInteger, Map>, Void> worker = new SwingWorker<Pair<BigInteger, Map>, Void>() {
                @Override
                protected Pair<BigInteger, Map> doInBackground() throws Exception {
                    ph.start();
                    
                    ICoin lumiCoin = CoinManager.getDefault().getCoin(Constants.CFX_BLOCKCHAIN_SYMBAL, Constants.CFX_LUMI_SYMBOL);
                    
                    return new Pair<>(lumiCoin.balanceOf(wallet.getAddress()), null);
                }

                @Override
                protected void done() {
                    try {
                        Pair<BigInteger, Map> result = get();
                        BigInteger lumiBalance = result.getValue0();
                        ICoin lumiCoin = CoinManager.getDefault().getCoin(Constants.CFX_BLOCKCHAIN_SYMBAL, Constants.CFX_LUMI_SYMBOL);
                        lumiBalFld.setText(lumiCoin.minUnit2MainUint(lumiBalance).setScale(2, RoundingMode.HALF_DOWN).toPlainString());
                    } catch (InterruptedException | ExecutionException ex) {
                        Exceptions.printStackTrace(ex);
                    } finally {
                        ph.finish();
                        setBtnEnabled(true);
                    }
                }
            };
            worker.execute();
        } else {
            // 提示选择钱包
            try {
                JLabel lbl = new JLabel("请选择钱包");
                BalloonTip balloonTip = new BalloonTip(selectWalletBtn, 
                                lbl,
                                Utils.createBalloonTipStyle(),
                                Utils.createBalloonTipPositioner(), 
                                null);
                TimingUtils.showTimedBalloon(balloonTip, 2000);
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }
    
    private void setBtnEnabled(boolean enabled) {
        withdrawBtn.setEnabled(enabled);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        walletFld = new org.jdesktop.swingx.JXTextField();
        selectWalletBtn = new org.jdesktop.swingx.JXButton();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        withdrawBtn = new org.jdesktop.swingx.JXButton();
        lumiBalFld = new org.jdesktop.swingx.JXTextField();

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel1, org.openide.util.NbBundle.getMessage(TinyVersusTopComponent.class, "TinyVersusTopComponent.jXLabel1.text")); // NOI18N

        walletFld.setEditable(false);
        walletFld.setToolTipText(org.openide.util.NbBundle.getMessage(TinyVersusTopComponent.class, "TinyVersusTopComponent.walletFld.toolTipText")); // NOI18N
        walletFld.setPrompt(org.openide.util.NbBundle.getMessage(TinyVersusTopComponent.class, "TinyVersusTopComponent.walletFld.prompt")); // NOI18N
        walletFld.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                walletFldMouseClicked(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(selectWalletBtn, org.openide.util.NbBundle.getMessage(TinyVersusTopComponent.class, "TinyVersusTopComponent.selectWalletBtn.text")); // NOI18N
        selectWalletBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectWalletBtnActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel2, org.openide.util.NbBundle.getMessage(TinyVersusTopComponent.class, "TinyVersusTopComponent.jXLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(withdrawBtn, org.openide.util.NbBundle.getMessage(TinyVersusTopComponent.class, "TinyVersusTopComponent.withdrawBtn.text")); // NOI18N
        withdrawBtn.setEnabled(false);
        withdrawBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawBtnActionPerformed(evt);
            }
        });

        lumiBalFld.setEditable(false);
        lumiBalFld.setText(org.openide.util.NbBundle.getMessage(TinyVersusTopComponent.class, "TinyVersusTopComponent.lumiBalFld.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(walletFld, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectWalletBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lumiBalFld, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(withdrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(walletFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectWalletBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(withdrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lumiBalFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(238, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void walletFldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_walletFldMouseClicked
        selectWalletBtnActionPerformed(null);
    }//GEN-LAST:event_walletFldMouseClicked

    private void selectWalletBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectWalletBtnActionPerformed
        SelectWalletDialog dlg = new SelectWalletDialog(null, Constants.CFX_BLOCKCHAIN_SYMBAL);
        dlg.setVisible(true);
        if(dlg.getReturnStatus() == SelectWalletDialog.RET_OK) {
            wallet = dlg.getSelectedWallet();
            walletFld.setText(wallet.getName() + "(地址：" + wallet.getAddress() + ")");

            myInit();
        }
    }//GEN-LAST:event_selectWalletBtnActionPerformed

    private void withdrawBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawBtnActionPerformed
        PasswordVerifyDialog passwordVerifyDialog = new PasswordVerifyDialog(null, wallet);
        passwordVerifyDialog.setVisible(true);
        if(passwordVerifyDialog.getReturnStatus() == PasswordVerifyDialog.RET_OK) {
            try {
                String privateKey = AESUtil.decrypt(wallet.getPrivateKeyAES(), passwordVerifyDialog.getPassword());

                withdrawBtn.setEnabled(false);
                // 获得余额及质押余额
                final ProgressHandle ph = ProgressHandle.createHandle("正在提取，请稍候");
                SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {
                    @Override
                    protected String doInBackground() throws Exception {
                        ph.start();

                        IStakingXIANGContract contract = Lookup.getDefault().lookup(IStakingXIANGContract.class);
                        return contract.withdrawPoolAll(privateKey);
                    }

                    @Override
                    protected void done() {
                        try {
                            String hash = get();
                            System.out.println("hash==================" + hash);
                        } catch (InterruptedException | ExecutionException ex) {
                            Exceptions.printStackTrace(ex);
                        }

                        ph.finish();
                        withdrawBtn.setEnabled(true);
                    }
                };
                worker.execute();
            } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | NoSuchAlgorithmException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }//GEN-LAST:event_withdrawBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXTextField lumiBalFld;
    private org.jdesktop.swingx.JXButton selectWalletBtn;
    private org.jdesktop.swingx.JXTextField walletFld;
    private org.jdesktop.swingx.JXButton withdrawBtn;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
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
}

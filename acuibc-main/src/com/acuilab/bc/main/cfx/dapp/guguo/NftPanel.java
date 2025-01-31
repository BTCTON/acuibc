package com.acuilab.bc.main.cfx.dapp.guguo;

import com.acuilab.bc.main.wallet.Wallet;
import java.awt.Color;
import java.math.BigInteger;

/**
 *
 * @author admin
 */
public class NftPanel extends javax.swing.JPanel {
    
    private final int pId;
    private Wallet wallet;
    private BigInteger tockenId;

    /**
     * Creates new form KaoZiPanel
     */
    public NftPanel(int pId) {
        initComponents();
        
        this.pId = pId;
    }
    
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
    
    public void setPledged(BigInteger tockenId) {
        this.tockenId = tockenId;
        
        tockenIdLbl.setText(tockenId.toString());
        tockenIdLbl.setEnabled(true);
        depositBtn.setEnabled(false);
        withdrawBtn.setEnabled(true);
        
        this.setBackground(Color.ORANGE);
    }
    
    public void setUnpledged() {
        this.tockenId = null;
        
        tockenIdLbl.setText("无");
        tockenIdLbl.setEnabled(false);
        depositBtn.setEnabled(true);
        withdrawBtn.setEnabled(false);
        
        this.setBackground(new Color(240, 240, 240));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        depositBtn = new org.jdesktop.swingx.JXButton();
        withdrawBtn = new org.jdesktop.swingx.JXButton();
        tockenIdLbl = new org.jdesktop.swingx.JXLabel();

        org.openide.awt.Mnemonics.setLocalizedText(depositBtn, org.openide.util.NbBundle.getMessage(NftPanel.class, "NftPanel.depositBtn.text")); // NOI18N
        depositBtn.setToolTipText(org.openide.util.NbBundle.getMessage(NftPanel.class, "NftPanel.depositBtn.toolTipText")); // NOI18N
        depositBtn.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(withdrawBtn, org.openide.util.NbBundle.getMessage(NftPanel.class, "NftPanel.withdrawBtn.text")); // NOI18N
        withdrawBtn.setToolTipText(org.openide.util.NbBundle.getMessage(NftPanel.class, "NftPanel.withdrawBtn.toolTipText")); // NOI18N
        withdrawBtn.setEnabled(false);

        tockenIdLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(tockenIdLbl, org.openide.util.NbBundle.getMessage(NftPanel.class, "NftPanel.tockenIdLbl.text")); // NOI18N
        tockenIdLbl.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(depositBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(withdrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(tockenIdLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tockenIdLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depositBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(withdrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton depositBtn;
    private org.jdesktop.swingx.JXLabel tockenIdLbl;
    private org.jdesktop.swingx.JXButton withdrawBtn;
    // End of variables declaration//GEN-END:variables
}

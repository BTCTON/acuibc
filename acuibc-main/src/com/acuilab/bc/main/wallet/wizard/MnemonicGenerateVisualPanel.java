package com.acuilab.bc.main.wallet.wizard;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.examples.complete.Utils;
import net.java.balloontip.utils.TimingUtils;
import org.apache.commons.lang3.StringUtils;
import org.openide.util.Exceptions;
import party.loveit.bip44forjava.utils.Bip44Utils;

public final class MnemonicGenerateVisualPanel extends JPanel {
    
    private List<String> mnemonicWords;
    
    /**
     * Creates new form FirstCreateVisualPanel3
     */
    public MnemonicGenerateVisualPanel() {
        initComponents();
        try {
            //get 12 words
            mnemonicWords = Bip44Utils.generateMnemonicWords();
            this.mnemonicLbl1.setText(mnemonicWords.get(0));
            this.mnemonicLbl2.setText(mnemonicWords.get(1));
            this.mnemonicLbl3.setText(mnemonicWords.get(2));
            this.mnemonicLbl4.setText(mnemonicWords.get(3));
            this.mnemonicLbl5.setText(mnemonicWords.get(4));
            this.mnemonicLbl6.setText(mnemonicWords.get(5));
            this.mnemonicLbl7.setText(mnemonicWords.get(6));
            this.mnemonicLbl8.setText(mnemonicWords.get(7));
            this.mnemonicLbl9.setText(mnemonicWords.get(8));
            this.mnemonicLbl10.setText(mnemonicWords.get(9));
            this.mnemonicLbl11.setText(mnemonicWords.get(10));
            this.mnemonicLbl12.setText(mnemonicWords.get(11));
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }
    
    public List<String> getMnemonicWords() {
        return mnemonicWords;
    }

    @Override
    public String getName() {
        return "生成您的助记词";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        mnemonicLbl1 = new org.jdesktop.swingx.JXLabel();
        mnemonicLbl2 = new org.jdesktop.swingx.JXLabel();
        mnemonicLbl3 = new org.jdesktop.swingx.JXLabel();
        mnemonicLbl4 = new org.jdesktop.swingx.JXLabel();
        mnemonicLbl5 = new org.jdesktop.swingx.JXLabel();
        mnemonicLbl6 = new org.jdesktop.swingx.JXLabel();
        mnemonicLbl7 = new org.jdesktop.swingx.JXLabel();
        mnemonicLbl8 = new org.jdesktop.swingx.JXLabel();
        mnemonicLbl9 = new org.jdesktop.swingx.JXLabel();
        mnemonicLbl10 = new org.jdesktop.swingx.JXLabel();
        mnemonicLbl11 = new org.jdesktop.swingx.JXLabel();
        mnemonicLbl12 = new org.jdesktop.swingx.JXLabel();
        copyBtn = new org.jdesktop.swingx.JXButton();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();

        setMinimumSize(new java.awt.Dimension(760, 540));
        setPreferredSize(new java.awt.Dimension(760, 540));

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel1, org.openide.util.NbBundle.getMessage(MnemonicGenerateVisualPanel.class, "MnemonicGenerateVisualPanel.jXLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel2, org.openide.util.NbBundle.getMessage(MnemonicGenerateVisualPanel.class, "MnemonicGenerateVisualPanel.jXLabel2.text")); // NOI18N

        jXPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jXPanel1.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jXPanel1.setLayout(new java.awt.GridLayout(4, 3, 10, 10));

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicLbl1, org.openide.util.NbBundle.getMessage(MnemonicGenerateVisualPanel.class, "MnemonicGenerateVisualPanel.mnemonicLbl1.text")); // NOI18N
        jXPanel1.add(mnemonicLbl1);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicLbl2, org.openide.util.NbBundle.getMessage(MnemonicGenerateVisualPanel.class, "MnemonicGenerateVisualPanel.mnemonicLbl2.text")); // NOI18N
        jXPanel1.add(mnemonicLbl2);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicLbl3, org.openide.util.NbBundle.getMessage(MnemonicGenerateVisualPanel.class, "MnemonicGenerateVisualPanel.mnemonicLbl3.text")); // NOI18N
        jXPanel1.add(mnemonicLbl3);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicLbl4, org.openide.util.NbBundle.getMessage(MnemonicGenerateVisualPanel.class, "MnemonicGenerateVisualPanel.mnemonicLbl4.text")); // NOI18N
        jXPanel1.add(mnemonicLbl4);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicLbl5, org.openide.util.NbBundle.getMessage(MnemonicGenerateVisualPanel.class, "MnemonicGenerateVisualPanel.mnemonicLbl5.text")); // NOI18N
        jXPanel1.add(mnemonicLbl5);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicLbl6, org.openide.util.NbBundle.getMessage(MnemonicGenerateVisualPanel.class, "MnemonicGenerateVisualPanel.mnemonicLbl6.text")); // NOI18N
        jXPanel1.add(mnemonicLbl6);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicLbl7, org.openide.util.NbBundle.getMessage(MnemonicGenerateVisualPanel.class, "MnemonicGenerateVisualPanel.mnemonicLbl7.text")); // NOI18N
        jXPanel1.add(mnemonicLbl7);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicLbl8, org.openide.util.NbBundle.getMessage(MnemonicGenerateVisualPanel.class, "MnemonicGenerateVisualPanel.mnemonicLbl8.text")); // NOI18N
        jXPanel1.add(mnemonicLbl8);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicLbl9, org.openide.util.NbBundle.getMessage(MnemonicGenerateVisualPanel.class, "MnemonicGenerateVisualPanel.mnemonicLbl9.text")); // NOI18N
        jXPanel1.add(mnemonicLbl9);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicLbl10, org.openide.util.NbBundle.getMessage(MnemonicGenerateVisualPanel.class, "MnemonicGenerateVisualPanel.mnemonicLbl10.text")); // NOI18N
        jXPanel1.add(mnemonicLbl10);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicLbl11, org.openide.util.NbBundle.getMessage(MnemonicGenerateVisualPanel.class, "MnemonicGenerateVisualPanel.mnemonicLbl11.text")); // NOI18N
        jXPanel1.add(mnemonicLbl11);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicLbl12, org.openide.util.NbBundle.getMessage(MnemonicGenerateVisualPanel.class, "MnemonicGenerateVisualPanel.mnemonicLbl12.text")); // NOI18N
        jXPanel1.add(mnemonicLbl12);

        org.openide.awt.Mnemonics.setLocalizedText(copyBtn, org.openide.util.NbBundle.getMessage(MnemonicGenerateVisualPanel.class, "MnemonicGenerateVisualPanel.copyBtn.text")); // NOI18N
        copyBtn.setDefaultCapable(false);
        copyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyBtnActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel3, org.openide.util.NbBundle.getMessage(MnemonicGenerateVisualPanel.class, "MnemonicGenerateVisualPanel.jXLabel3.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(copyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void copyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyBtnActionPerformed
        Transferable str = new StringSelection(StringUtils.join(mnemonicWords, " ")); 
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        
        // 气泡提示
        try {
            JLabel lbl = new JLabel("复制成功");
            BalloonTip balloonTip = new BalloonTip(copyBtn, 
                            lbl,
                            Utils.createBalloonTipStyle(),
                            Utils.createBalloonTipPositioner(), 
                            null);
            TimingUtils.showTimedBalloon(balloonTip, 2000);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_copyBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton copyBtn;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXLabel mnemonicLbl1;
    private org.jdesktop.swingx.JXLabel mnemonicLbl10;
    private org.jdesktop.swingx.JXLabel mnemonicLbl11;
    private org.jdesktop.swingx.JXLabel mnemonicLbl12;
    private org.jdesktop.swingx.JXLabel mnemonicLbl2;
    private org.jdesktop.swingx.JXLabel mnemonicLbl3;
    private org.jdesktop.swingx.JXLabel mnemonicLbl4;
    private org.jdesktop.swingx.JXLabel mnemonicLbl5;
    private org.jdesktop.swingx.JXLabel mnemonicLbl6;
    private org.jdesktop.swingx.JXLabel mnemonicLbl7;
    private org.jdesktop.swingx.JXLabel mnemonicLbl8;
    private org.jdesktop.swingx.JXLabel mnemonicLbl9;
    // End of variables declaration//GEN-END:variables
}

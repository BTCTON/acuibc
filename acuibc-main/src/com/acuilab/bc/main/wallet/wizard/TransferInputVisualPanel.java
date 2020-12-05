package com.acuilab.bc.main.wallet.wizard;

import com.acuilab.bc.main.BlockChain;
import static com.acuilab.bc.main.cfx.StakingDialog.AMOUNT_MUST_BE_GRATE_OR_EQUAL_1;
import com.acuilab.bc.main.manager.BlockChainManager;
import com.acuilab.bc.main.wallet.Address;
import com.acuilab.bc.main.wallet.AddressSelectDialog;
import com.acuilab.bc.main.wallet.Wallet;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.concurrent.ExecutionException;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingWorker;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.openide.util.Exceptions;
import com.acuilab.bc.main.coin.ICoin;
import javax.swing.JLabel;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.examples.complete.Utils;
import net.java.balloontip.utils.TimingUtils;

public final class TransferInputVisualPanel extends JPanel {
    
    private final Wallet wallet;
    private final ICoin coin;
    private BigInteger balance;
    
    /**
     * Creates new form TransferVisualPanel1
     */
    public TransferInputVisualPanel(Wallet wallet, ICoin coin) {
        initComponents();
        
        this.wallet = wallet;
        this.coin = coin;

        BlockChain bc = BlockChainManager.getDefault().getBlockChain(coin.getBlockChainSymbol());
        int min = coin.gasMin(wallet.getAddress());
        int max = coin.gasMax(wallet.getAddress());
        int defaultValue = coin.gasDefaultValue(wallet.getAddress());
        gasSlider.setMinimum(min);
        gasSlider.setMaximum(max);
        gasSlider.setValue(defaultValue);
        gasSpinner.setModel(new SpinnerNumberModel(defaultValue, min, max, 1));
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(gasSpinner, "#");
        final JFormattedTextField textField = editor.getTextField();
        final DefaultFormatterFactory factory = (DefaultFormatterFactory)textField.getFormatterFactory();
        final NumberFormatter formatter = (NumberFormatter)factory.getDefaultFormatter();
        formatter.setCommitsOnValidEdit(true);
        gasSpinner.setEditor(editor);
        
        slowLbl.setText("慢(" + min + ")");
        gasLbl.setText(coin.gasDesc(coin.gasDefaultValue(wallet.getAddress())));
        fastLbl.setText("(" + max + ")快");

        // 求余额
        valueFld.setPrompt("正在请求余额，请稍候...");
        SwingWorker<BigInteger, Void> worker = new SwingWorker<BigInteger, Void>() {
            @Override
            protected BigInteger doInBackground() throws Exception {
                return coin.balanceOf(wallet.getAddress());
            }

            @Override
            protected void done() {
                try {
                    balance = get();
                    valueFld.setPrompt("可用：" + coin.minUnit2MainUint(balance).setScale(coin.getMainUnitScale(), RoundingMode.FLOOR).toPlainString() + " " + coin.getMainUnit());
                } catch (InterruptedException | ExecutionException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        };
        worker.execute();
        
        sendAddressFld.setText(wallet.getAddress());
    }

    @Override
    public String getName() {
        return "输入转账信息";
    }
    
    public JTextField getRecvAddressFld() {
        return recvAddressFld;
    }
    
    public JTextField getValueFld() {
        return valueFld;
    }
    
    public JSlider getGasSlider() {
        return gasSlider;
    }
    
    public BigInteger getBalance() {
        return balance;
    }
    
    public boolean balanceAvailable() {
        return balance != null;
    }
    
    public boolean isGasDefault() {
        return gasDefaultCheckBox.isSelected();
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
        recvAddressFld = new org.jdesktop.swingx.JXTextField();
        valueFld = new org.jdesktop.swingx.JXTextField();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        sendAddressFld = new org.jdesktop.swingx.JXTextField();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        gasSlider = new javax.swing.JSlider();
        slowLbl = new org.jdesktop.swingx.JXLabel();
        fastLbl = new org.jdesktop.swingx.JXLabel();
        gasLbl = new org.jdesktop.swingx.JXLabel();
        gasDefaultCheckBox = new javax.swing.JCheckBox();
        gasSpinner = new javax.swing.JSpinner();
        pasteBtn = new org.jdesktop.swingx.JXButton();
        selectBtn = new org.jdesktop.swingx.JXButton();
        maxBtn = new org.jdesktop.swingx.JXButton();
        resetBtn = new org.jdesktop.swingx.JXButton();

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel1, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.jXLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel2, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.jXLabel2.text")); // NOI18N

        recvAddressFld.setText(org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.recvAddressFld.text")); // NOI18N

        valueFld.setText(org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.valueFld.text")); // NOI18N
        valueFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueFldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel3, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.jXLabel3.text")); // NOI18N

        sendAddressFld.setEditable(false);
        sendAddressFld.setText(org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.sendAddressFld.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel4, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.jXLabel4.text")); // NOI18N

        gasSlider.setPaintTicks(true);
        gasSlider.setSnapToTicks(true);
        gasSlider.setEnabled(false);
        gasSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                gasSliderStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(slowLbl, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.slowLbl.text")); // NOI18N

        fastLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(fastLbl, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.fastLbl.text")); // NOI18N

        gasLbl.setForeground(new java.awt.Color(0, 0, 255));
        gasLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(gasLbl, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.gasLbl.text")); // NOI18N

        gasDefaultCheckBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(gasDefaultCheckBox, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.gasDefaultCheckBox.text")); // NOI18N
        gasDefaultCheckBox.setToolTipText(org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.gasDefaultCheckBox.toolTipText")); // NOI18N
        gasDefaultCheckBox.setEnabled(false);
        gasDefaultCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gasDefaultCheckBoxActionPerformed(evt);
            }
        });

        gasSpinner.setEnabled(false);
        gasSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                gasSpinnerStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(pasteBtn, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.pasteBtn.text")); // NOI18N
        pasteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteBtnActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(selectBtn, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.selectBtn.text")); // NOI18N
        selectBtn.setToolTipText(org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.selectBtn.toolTipText")); // NOI18N
        selectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectBtnActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(maxBtn, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.maxBtn.text")); // NOI18N
        maxBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxBtnActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(resetBtn, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.resetBtn.text")); // NOI18N
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendAddressFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(slowLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gasLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
                            .addComponent(gasSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(gasSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(fastLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gasDefaultCheckBox)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recvAddressFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valueFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pasteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(maxBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recvAddressFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pasteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendAddressFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gasDefaultCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gasSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gasSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slowLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fastLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gasLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(234, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void gasSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gasSliderStateChanged
        int value = ((JSlider) evt.getSource()).getValue();
        gasLbl.setText(coin.gasDesc(value));
        gasSpinner.setValue(value);
    }//GEN-LAST:event_gasSliderStateChanged

    private void gasDefaultCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gasDefaultCheckBoxActionPerformed
        gasSlider.setEnabled(!gasDefaultCheckBox.isSelected());
        gasSpinner.setEnabled(!gasDefaultCheckBox.isSelected());
    }//GEN-LAST:event_gasDefaultCheckBoxActionPerformed

    private void gasSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gasSpinnerStateChanged
        int value = (Integer)((JSpinner) evt.getSource()).getValue();
        gasLbl.setText(coin.gasDesc(value));
        gasSlider.setValue(value);
    }//GEN-LAST:event_gasSpinnerStateChanged

    private void pasteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteBtnActionPerformed
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        // 获取剪贴板中的内容
        Transferable trans = clipboard.getContents(null);

        if (trans != null) {
            // 判断剪贴板中的内容是否支持文本
            if (trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                // 获取剪贴板中的文本内容
                try {
                    String text = (String) trans.getTransferData(DataFlavor.stringFlavor);
                    recvAddressFld.setText(text);
                } catch (UnsupportedFlavorException | IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }
    }//GEN-LAST:event_pasteBtnActionPerformed

    private void selectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBtnActionPerformed

        AddressSelectDialog dlg = new AddressSelectDialog(null, wallet.getBlockChainSymbol());
        dlg.setVisible(true);
        if(dlg.getReturnStatus() == AddressSelectDialog.RET_OK) {
            Address address = dlg.getSelectedAddress();
            recvAddressFld.setText(address.getAddress());
            recvAddressFld.setToolTipText(address.getAddress() + "(" + address.getRemark() + ")");
        }
    }//GEN-LAST:event_selectBtnActionPerformed

    private void maxBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxBtnActionPerformed
        // TODO add your handling code here:
        // 设置为最大数
        // 求余额
        valueFld.setPrompt("正在请求余额，请稍候...");
        SwingWorker<BigInteger, Void> worker = new SwingWorker<BigInteger, Void>() {
            @Override
            protected BigInteger doInBackground() throws Exception {
                return coin.balanceOf(wallet.getAddress());
            }

            @Override
            protected void done() {
                try {
                    balance = get();
                    BigInteger defaultGas = coin.getDefaultGas();
                    if(balance.compareTo(defaultGas)<=0){
                        try {
                            JLabel lbl = new JLabel("账户余额不足。");
                            BalloonTip balloonTip = new BalloonTip(valueFld, 
                                            lbl,
                                            Utils.createBalloonTipStyle(),
                                            Utils.createBalloonTipPositioner(), 
                                            null);
                            TimingUtils.showTimedBalloon(balloonTip, 3000);
                        } catch (Exception ex) {
                            Exceptions.printStackTrace(ex);
                        }
                    }
                    else{
                        //valueFld.setPrompt(coin.minUnit2MainUint(balance.subtract(defaultGas)).setScale(coin.getMainUnitScale(), RoundingMode.FLOOR).toPlainString() + " " + coin.getMainUnit());
                        valueFld.setText(coin.minUnit2MainUint(balance.subtract(defaultGas)).setScale(coin.getMainUnitScale(), RoundingMode.FLOOR).toPlainString());
                    }
              
                } catch (InterruptedException | ExecutionException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        };
        worker.execute();
        
        //sendAddressFld.setText(wallet.getAddress());
        
        
    }//GEN-LAST:event_maxBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        // TODO add your handling code here:
        // 重置余额
        valueFld.setText("");
        valueFld.setPrompt("可用：" + coin.minUnit2MainUint(balance).setScale(coin.getMainUnitScale(), RoundingMode.HALF_DOWN).toPlainString() + " " + coin.getMainUnit());
               
       

    }//GEN-LAST:event_resetBtnActionPerformed

    private void valueFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valueFldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXLabel fastLbl;
    private javax.swing.JCheckBox gasDefaultCheckBox;
    private org.jdesktop.swingx.JXLabel gasLbl;
    private javax.swing.JSlider gasSlider;
    private javax.swing.JSpinner gasSpinner;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXButton maxBtn;
    private org.jdesktop.swingx.JXButton pasteBtn;
    private org.jdesktop.swingx.JXTextField recvAddressFld;
    private org.jdesktop.swingx.JXButton resetBtn;
    private org.jdesktop.swingx.JXButton selectBtn;
    private org.jdesktop.swingx.JXTextField sendAddressFld;
    private org.jdesktop.swingx.JXLabel slowLbl;
    private org.jdesktop.swingx.JXTextField valueFld;
    // End of variables declaration//GEN-END:variables
}

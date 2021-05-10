package com.acuilab.bc.main.cfx.dapp.browser;

import com.acuilab.bc.main.coin.ICoin;
import com.acuilab.bc.main.manager.CoinManager;
import com.acuilab.bc.main.util.Constants;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.KeyStroke;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.openide.util.ImageUtilities;

/**
 *
 * @author chia1
 */
public class SignTransactionDialog extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;
    
    private ICoin cfxCoin = CoinManager.getDefault().getBaseCoin(Constants.CFX_BLOCKCHAIN_SYMBAL);

    /**
     * Creates new form SignTransactionDialog
     */
    public SignTransactionDialog(String from, String to, BigInteger gas, BigInteger storageLimit, BigInteger value, String data) {
        super((java.awt.Frame)null, true);
        initComponents();
        
        sendFld.setText(from);
        recvFld.setText(to);
        
        if(value != null) {
            valueFld.setText(cfxCoin.minUnit2MainUint(value).toString() + cfxCoin.getMainUnit());
        }
        
        // 矿工费初始化
        int defaultValue = gas != null ? gas.intValue() : cfxCoin.gasDefault();
        int gasMin = gas != null ? defaultValue*8/10 : cfxCoin.gasMin();
        int gasMax = gas != null ? defaultValue*15/10 : cfxCoin.gasMax();
        
        gasSlider.setMinimum(gasMin);
        gasSlider.setMaximum(gasMax);
        gasSlider.setValue(defaultValue);
        System.out.println("min=" + gasMin + ", max=" + gasMax + ", defaultValue=" + defaultValue);
        gasSpinner.setModel(new SpinnerNumberModel(defaultValue, gasMin, gasMax, 1));
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(gasSpinner, "#");
        final JFormattedTextField textField = editor.getTextField();
        final DefaultFormatterFactory factory = (DefaultFormatterFactory)textField.getFormatterFactory();
        final NumberFormatter formatter = (NumberFormatter)factory.getDefaultFormatter();
        formatter.setCommitsOnValidEdit(true);
        gasSpinner.setEditor(editor);
        gasLbl.setText(cfxCoin.gasDesc(defaultValue));

        gasSlider.setEnabled(true);
        gasSpinner.setEnabled(true);
        gasLbl.setEnabled(true);
        
        dataArea.setText(data);

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        gasSlider = new javax.swing.JSlider();
        gasSpinner = new javax.swing.JSpinner();
        slowLbl = new org.jdesktop.swingx.JXLabel();
        fastLbl = new org.jdesktop.swingx.JXLabel();
        gasLbl = new org.jdesktop.swingx.JXLabel();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataArea = new org.jdesktop.swingx.JXTextArea();
        sendFld = new org.jdesktop.swingx.JXTextField();
        recvFld = new org.jdesktop.swingx.JXTextField();
        valueFld = new org.jdesktop.swingx.JXTextField();

        setIconImage(ImageUtilities.loadImage("/resource/gourd32.png"));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(okButton, org.openide.util.NbBundle.getMessage(SignTransactionDialog.class, "SignTransactionDialog.okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, org.openide.util.NbBundle.getMessage(SignTransactionDialog.class, "SignTransactionDialog.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel1, org.openide.util.NbBundle.getMessage(SignTransactionDialog.class, "SignTransactionDialog.jXLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel2, org.openide.util.NbBundle.getMessage(SignTransactionDialog.class, "SignTransactionDialog.jXLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel3, org.openide.util.NbBundle.getMessage(SignTransactionDialog.class, "SignTransactionDialog.jXLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel5, org.openide.util.NbBundle.getMessage(SignTransactionDialog.class, "SignTransactionDialog.jXLabel5.text")); // NOI18N

        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SignTransactionDialog.class, "SignTransactionDialog.jXPanel2.border.title"))); // NOI18N

        gasSlider.setPaintTicks(true);
        gasSlider.setSnapToTicks(true);
        gasSlider.setEnabled(false);
        gasSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                gasSliderStateChanged(evt);
            }
        });

        gasSpinner.setEnabled(false);
        gasSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                gasSpinnerStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(slowLbl, org.openide.util.NbBundle.getMessage(SignTransactionDialog.class, "SignTransactionDialog.slowLbl.text")); // NOI18N

        fastLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(fastLbl, org.openide.util.NbBundle.getMessage(SignTransactionDialog.class, "SignTransactionDialog.fastLbl.text")); // NOI18N

        gasLbl.setForeground(new java.awt.Color(0, 0, 255));
        gasLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(gasLbl, org.openide.util.NbBundle.getMessage(SignTransactionDialog.class, "SignTransactionDialog.gasLbl.text")); // NOI18N
        gasLbl.setEnabled(false);

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(slowLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gasLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fastLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gasSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gasSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gasSpinner)
                    .addComponent(gasSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(slowLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gasLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fastLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel6, org.openide.util.NbBundle.getMessage(SignTransactionDialog.class, "SignTransactionDialog.jXLabel6.text")); // NOI18N

        dataArea.setEditable(false);
        dataArea.setBackground(new java.awt.Color(240, 240, 240));
        dataArea.setColumns(20);
        dataArea.setRows(5);
        jScrollPane1.setViewportView(dataArea);

        sendFld.setEditable(false);
        sendFld.setText(org.openide.util.NbBundle.getMessage(SignTransactionDialog.class, "SignTransactionDialog.sendFld.text")); // NOI18N

        recvFld.setEditable(false);
        recvFld.setText(org.openide.util.NbBundle.getMessage(SignTransactionDialog.class, "SignTransactionDialog.recvFld.text")); // NOI18N

        valueFld.setEditable(false);
        valueFld.setText(org.openide.util.NbBundle.getMessage(SignTransactionDialog.class, "SignTransactionDialog.valueFld.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(sendFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(recvFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valueFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(325, Short.MAX_VALUE)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addGap(10, 10, 10))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recvFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void gasSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gasSliderStateChanged
        int value = ((JSlider) evt.getSource()).getValue();
        gasLbl.setText(cfxCoin.gasDesc(value));
        gasSpinner.setValue(value);
    }//GEN-LAST:event_gasSliderStateChanged

    private void gasSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gasSpinnerStateChanged
        int value = (Integer)((JSpinner) evt.getSource()).getValue();
        gasLbl.setText(cfxCoin.gasDesc(value));
        gasSlider.setValue(value);
    }//GEN-LAST:event_gasSpinnerStateChanged
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private org.jdesktop.swingx.JXTextArea dataArea;
    private org.jdesktop.swingx.JXLabel fastLbl;
    private org.jdesktop.swingx.JXLabel gasLbl;
    private javax.swing.JSlider gasSlider;
    private javax.swing.JSpinner gasSpinner;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private javax.swing.JButton okButton;
    private org.jdesktop.swingx.JXTextField recvFld;
    private org.jdesktop.swingx.JXTextField sendFld;
    private org.jdesktop.swingx.JXLabel slowLbl;
    private org.jdesktop.swingx.JXTextField valueFld;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}

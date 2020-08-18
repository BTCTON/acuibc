package com.acuilab.bc.main.wallet.wizard;

import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdesktop.swingx.prompt.PromptSupport;

public final class PasswordVisualPanel extends JPanel {

    /**
     * Creates new form FirstCreateVisualPanel2
     */
    public PasswordVisualPanel() {
        initComponents();
    }

    @Override
    public String getName() {
        return "设置钱包密码";
    }
    
    public JTextField getPwdField() {
        return pwdFld;
    }
    
    public JTextField getPwdConfirmFeild() {
        return pwdConfirmFld;
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
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        pwdFld = new javax.swing.JPasswordField();
        pwdConfirmFld = new javax.swing.JPasswordField();

        setMinimumSize(new java.awt.Dimension(760, 540));
        setPreferredSize(new java.awt.Dimension(760, 540));

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel1, org.openide.util.NbBundle.getMessage(PasswordVisualPanel.class, "PasswordVisualPanel.jXLabel1.text")); // NOI18N
        jXLabel1.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        jXLabel2.setBackground(new java.awt.Color(255, 0, 0));
        org.openide.awt.Mnemonics.setLocalizedText(jXLabel2, org.openide.util.NbBundle.getMessage(PasswordVisualPanel.class, "PasswordVisualPanel.jXLabel2.text")); // NOI18N
        jXLabel2.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        jXLabel3.setBackground(new java.awt.Color(255, 0, 0));
        org.openide.awt.Mnemonics.setLocalizedText(jXLabel3, org.openide.util.NbBundle.getMessage(PasswordVisualPanel.class, "PasswordVisualPanel.jXLabel3.text")); // NOI18N
        jXLabel3.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        jXLabel4.setBackground(new java.awt.Color(255, 0, 0));
        org.openide.awt.Mnemonics.setLocalizedText(jXLabel4, org.openide.util.NbBundle.getMessage(PasswordVisualPanel.class, "PasswordVisualPanel.jXLabel4.text")); // NOI18N
        jXLabel4.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        jXLabel5.setBackground(new java.awt.Color(255, 0, 0));
        org.openide.awt.Mnemonics.setLocalizedText(jXLabel5, org.openide.util.NbBundle.getMessage(PasswordVisualPanel.class, "PasswordVisualPanel.jXLabel5.text")); // NOI18N
        jXLabel5.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel6, org.openide.util.NbBundle.getMessage(PasswordVisualPanel.class, "PasswordVisualPanel.jXLabel6.text")); // NOI18N
        jXLabel6.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        PromptSupport.init("8-16位字符(包含大小写字符与数字)", null, null, pwdFld);
        pwdFld.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        pwdFld.setText(org.openide.util.NbBundle.getMessage(PasswordVisualPanel.class, "PasswordVisualPanel.pwdFld.text")); // NOI18N

        PromptSupport.init("请再次输入钱包密码", null, null, pwdConfirmFld);
        pwdConfirmFld.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        pwdConfirmFld.setText(org.openide.util.NbBundle.getMessage(PasswordVisualPanel.class, "PasswordVisualPanel.pwdConfirmFld.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pwdFld, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pwdConfirmFld, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwdFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwdConfirmFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private javax.swing.JPasswordField pwdConfirmFld;
    private javax.swing.JPasswordField pwdFld;
    // End of variables declaration//GEN-END:variables
}

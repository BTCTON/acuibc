package com.acuilab.bc.main.wallet.wizard;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.apache.commons.lang3.StringUtils;
import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXLabel;

public final class MnemonicConfirmVisualPanel extends JPanel {
    
    private String mnemonicWordsJoined;
    private final Map<String, JXButton> mnemonicButtons = Maps.newHashMap();
    
    /**
     * Creates new form FirstCreateVisualPanel4
     */
    public MnemonicConfirmVisualPanel() {
        initComponents();
    }

    @Override
    public String getName() {
        return "确认您的助记词";
    }
    
    public JPanel getJXPanel1() {
        return jXPanel1;
    }
    
    public void initMnemonicWords(List<String> mnemonicWords) {
        reset();
        
        this.mnemonicWordsJoined = StringUtils.join(mnemonicWords, " ");;
        
        // 先保存，再打乱顺序
        List<String> mnemonicWordsShuffled = Lists.newArrayListWithCapacity(mnemonicWords.size());
        Collections.addAll(mnemonicWordsShuffled,new String[mnemonicWords.size()]);
        Collections.copy(mnemonicWordsShuffled, mnemonicWords);
        
        // 打乱顺序
        Collections.shuffle(mnemonicWordsShuffled);
        mnemonicBtn1.setText(mnemonicWordsShuffled.get(0));
        mnemonicBtn2.setText(mnemonicWordsShuffled.get(1));
        mnemonicBtn3.setText(mnemonicWordsShuffled.get(2));
        mnemonicBtn4.setText(mnemonicWordsShuffled.get(3));
        mnemonicBtn5.setText(mnemonicWordsShuffled.get(4));
        mnemonicBtn6.setText(mnemonicWordsShuffled.get(5));
        mnemonicBtn7.setText(mnemonicWordsShuffled.get(6));
        mnemonicBtn8.setText(mnemonicWordsShuffled.get(7));
        mnemonicBtn9.setText(mnemonicWordsShuffled.get(8));
        mnemonicBtn10.setText(mnemonicWordsShuffled.get(9));
        mnemonicBtn11.setText(mnemonicWordsShuffled.get(10));
        mnemonicBtn12.setText(mnemonicWordsShuffled.get(11));
        
        mnemonicButtons.put(mnemonicWordsShuffled.get(0), mnemonicBtn1);
        mnemonicButtons.put(mnemonicWordsShuffled.get(1), mnemonicBtn2);
        mnemonicButtons.put(mnemonicWordsShuffled.get(2), mnemonicBtn3);
        mnemonicButtons.put(mnemonicWordsShuffled.get(3), mnemonicBtn4);
        mnemonicButtons.put(mnemonicWordsShuffled.get(4), mnemonicBtn5);
        mnemonicButtons.put(mnemonicWordsShuffled.get(5), mnemonicBtn6);
        mnemonicButtons.put(mnemonicWordsShuffled.get(6), mnemonicBtn7);
        mnemonicButtons.put(mnemonicWordsShuffled.get(7), mnemonicBtn8);
        mnemonicButtons.put(mnemonicWordsShuffled.get(8), mnemonicBtn9);
        mnemonicButtons.put(mnemonicWordsShuffled.get(9), mnemonicBtn10);
        mnemonicButtons.put(mnemonicWordsShuffled.get(10), mnemonicBtn11);
        mnemonicButtons.put(mnemonicWordsShuffled.get(11), mnemonicBtn12);
    }
    
    private void reset() {
        jXPanel1.removeAll();
        msgLbl.setText("");
        mnemonicBtn1.setEnabled(true);
        mnemonicBtn2.setEnabled(true);
        mnemonicBtn3.setEnabled(true);
        mnemonicBtn4.setEnabled(true);
        mnemonicBtn5.setEnabled(true);
        mnemonicBtn6.setEnabled(true);
        mnemonicBtn7.setEnabled(true);
        mnemonicBtn8.setEnabled(true);
        mnemonicBtn9.setEnabled(true);
        mnemonicBtn10.setEnabled(true);
        mnemonicBtn11.setEnabled(true);
        mnemonicBtn12.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        mnemonicBtn1 = new org.jdesktop.swingx.JXButton();
        mnemonicBtn2 = new org.jdesktop.swingx.JXButton();
        mnemonicBtn3 = new org.jdesktop.swingx.JXButton();
        mnemonicBtn4 = new org.jdesktop.swingx.JXButton();
        mnemonicBtn5 = new org.jdesktop.swingx.JXButton();
        mnemonicBtn6 = new org.jdesktop.swingx.JXButton();
        mnemonicBtn7 = new org.jdesktop.swingx.JXButton();
        mnemonicBtn8 = new org.jdesktop.swingx.JXButton();
        mnemonicBtn9 = new org.jdesktop.swingx.JXButton();
        mnemonicBtn10 = new org.jdesktop.swingx.JXButton();
        mnemonicBtn11 = new org.jdesktop.swingx.JXButton();
        mnemonicBtn12 = new org.jdesktop.swingx.JXButton();
        msgLbl = new org.jdesktop.swingx.JXLabel();
        resetBtn = new org.jdesktop.swingx.JXButton();

        setMinimumSize(new java.awt.Dimension(760, 540));
        setPreferredSize(new java.awt.Dimension(760, 540));

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel1, org.openide.util.NbBundle.getMessage(MnemonicConfirmVisualPanel.class, "MnemonicConfirmVisualPanel.jXLabel1.text")); // NOI18N

        jXPanel1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        jXPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jXPanel1.setLayout(new java.awt.GridLayout(0, 3, 10, 10));

        jXPanel2.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jXPanel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jXPanel2.setPreferredSize(new java.awt.Dimension(300, 146));
        jXPanel2.setLayout(new java.awt.GridLayout(4, 3, 10, 10));

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicBtn1, org.openide.util.NbBundle.getMessage(MnemonicConfirmVisualPanel.class, "MnemonicConfirmVisualPanel.mnemonicBtn1.text")); // NOI18N
        mnemonicBtn1.setFocusable(false);
        mnemonicBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnemonicBtn1ActionPerformed(evt);
            }
        });
        jXPanel2.add(mnemonicBtn1);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicBtn2, org.openide.util.NbBundle.getMessage(MnemonicConfirmVisualPanel.class, "MnemonicConfirmVisualPanel.mnemonicBtn2.text")); // NOI18N
        mnemonicBtn2.setFocusable(false);
        mnemonicBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnemonicBtn2ActionPerformed(evt);
            }
        });
        jXPanel2.add(mnemonicBtn2);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicBtn3, org.openide.util.NbBundle.getMessage(MnemonicConfirmVisualPanel.class, "MnemonicConfirmVisualPanel.mnemonicBtn3.text")); // NOI18N
        mnemonicBtn3.setFocusable(false);
        mnemonicBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnemonicBtn3ActionPerformed(evt);
            }
        });
        jXPanel2.add(mnemonicBtn3);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicBtn4, org.openide.util.NbBundle.getMessage(MnemonicConfirmVisualPanel.class, "MnemonicConfirmVisualPanel.mnemonicBtn4.text")); // NOI18N
        mnemonicBtn4.setFocusable(false);
        mnemonicBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnemonicBtn4ActionPerformed(evt);
            }
        });
        jXPanel2.add(mnemonicBtn4);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicBtn5, org.openide.util.NbBundle.getMessage(MnemonicConfirmVisualPanel.class, "MnemonicConfirmVisualPanel.mnemonicBtn5.text")); // NOI18N
        mnemonicBtn5.setFocusable(false);
        mnemonicBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnemonicBtn5ActionPerformed(evt);
            }
        });
        jXPanel2.add(mnemonicBtn5);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicBtn6, org.openide.util.NbBundle.getMessage(MnemonicConfirmVisualPanel.class, "MnemonicConfirmVisualPanel.mnemonicBtn6.text")); // NOI18N
        mnemonicBtn6.setFocusable(false);
        mnemonicBtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnemonicBtn6ActionPerformed(evt);
            }
        });
        jXPanel2.add(mnemonicBtn6);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicBtn7, org.openide.util.NbBundle.getMessage(MnemonicConfirmVisualPanel.class, "MnemonicConfirmVisualPanel.mnemonicBtn7.text")); // NOI18N
        mnemonicBtn7.setFocusable(false);
        mnemonicBtn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnemonicBtn7ActionPerformed(evt);
            }
        });
        jXPanel2.add(mnemonicBtn7);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicBtn8, org.openide.util.NbBundle.getMessage(MnemonicConfirmVisualPanel.class, "MnemonicConfirmVisualPanel.mnemonicBtn8.text")); // NOI18N
        mnemonicBtn8.setFocusable(false);
        mnemonicBtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnemonicBtn8ActionPerformed(evt);
            }
        });
        jXPanel2.add(mnemonicBtn8);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicBtn9, org.openide.util.NbBundle.getMessage(MnemonicConfirmVisualPanel.class, "MnemonicConfirmVisualPanel.mnemonicBtn9.text")); // NOI18N
        mnemonicBtn9.setFocusable(false);
        mnemonicBtn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnemonicBtn9ActionPerformed(evt);
            }
        });
        jXPanel2.add(mnemonicBtn9);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicBtn10, org.openide.util.NbBundle.getMessage(MnemonicConfirmVisualPanel.class, "MnemonicConfirmVisualPanel.mnemonicBtn10.text")); // NOI18N
        mnemonicBtn10.setFocusable(false);
        mnemonicBtn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnemonicBtn10ActionPerformed(evt);
            }
        });
        jXPanel2.add(mnemonicBtn10);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicBtn11, org.openide.util.NbBundle.getMessage(MnemonicConfirmVisualPanel.class, "MnemonicConfirmVisualPanel.mnemonicBtn11.text")); // NOI18N
        mnemonicBtn11.setFocusable(false);
        mnemonicBtn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnemonicBtn11ActionPerformed(evt);
            }
        });
        jXPanel2.add(mnemonicBtn11);

        org.openide.awt.Mnemonics.setLocalizedText(mnemonicBtn12, org.openide.util.NbBundle.getMessage(MnemonicConfirmVisualPanel.class, "MnemonicConfirmVisualPanel.mnemonicBtn12.text")); // NOI18N
        mnemonicBtn12.setFocusable(false);
        mnemonicBtn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnemonicBtn12ActionPerformed(evt);
            }
        });
        jXPanel2.add(mnemonicBtn12);

        msgLbl.setForeground(new java.awt.Color(255, 0, 0));
        msgLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(msgLbl, org.openide.util.NbBundle.getMessage(MnemonicConfirmVisualPanel.class, "MnemonicConfirmVisualPanel.msgLbl.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(resetBtn, org.openide.util.NbBundle.getMessage(MnemonicConfirmVisualPanel.class, "MnemonicConfirmVisualPanel.resetBtn.text")); // NOI18N
        resetBtn.setDefaultCapable(false);
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
                    .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 348, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(msgLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msgLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mnemonicBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnemonicBtn1ActionPerformed
        mnemonicBtnClicked((JButton)evt.getSource());
    }//GEN-LAST:event_mnemonicBtn1ActionPerformed

    private void mnemonicBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnemonicBtn2ActionPerformed
        mnemonicBtnClicked((JButton)evt.getSource());
    }//GEN-LAST:event_mnemonicBtn2ActionPerformed

    private void mnemonicBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnemonicBtn3ActionPerformed
        mnemonicBtnClicked((JButton)evt.getSource());
    }//GEN-LAST:event_mnemonicBtn3ActionPerformed

    private void mnemonicBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnemonicBtn4ActionPerformed
        mnemonicBtnClicked((JButton)evt.getSource());
    }//GEN-LAST:event_mnemonicBtn4ActionPerformed

    private void mnemonicBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnemonicBtn5ActionPerformed
        mnemonicBtnClicked((JButton)evt.getSource());
    }//GEN-LAST:event_mnemonicBtn5ActionPerformed

    private void mnemonicBtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnemonicBtn6ActionPerformed
        mnemonicBtnClicked((JButton)evt.getSource());
    }//GEN-LAST:event_mnemonicBtn6ActionPerformed

    private void mnemonicBtn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnemonicBtn7ActionPerformed
        mnemonicBtnClicked((JButton)evt.getSource());
    }//GEN-LAST:event_mnemonicBtn7ActionPerformed

    private void mnemonicBtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnemonicBtn8ActionPerformed
        mnemonicBtnClicked((JButton)evt.getSource());
    }//GEN-LAST:event_mnemonicBtn8ActionPerformed

    private void mnemonicBtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnemonicBtn9ActionPerformed
        mnemonicBtnClicked((JButton)evt.getSource());
    }//GEN-LAST:event_mnemonicBtn9ActionPerformed

    private void mnemonicBtn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnemonicBtn10ActionPerformed
        mnemonicBtnClicked((JButton)evt.getSource());
    }//GEN-LAST:event_mnemonicBtn10ActionPerformed

    private void mnemonicBtn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnemonicBtn11ActionPerformed
        mnemonicBtnClicked((JButton)evt.getSource());
    }//GEN-LAST:event_mnemonicBtn11ActionPerformed

    private void mnemonicBtn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnemonicBtn12ActionPerformed
        mnemonicBtnClicked((JButton)evt.getSource());
    }//GEN-LAST:event_mnemonicBtn12ActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        Component[] components = jXPanel1.getComponents();
        if(components.length > 0) {
            jXPanel1.remove(components.length - 1);
            // 启用对应的按钮
            JXLabel lbl = (JXLabel)components[components.length -1];
            JXButton btn = mnemonicButtons.get(lbl.getText());
            btn.setEnabled(true);
            
            if(!isOrderOK()) {
                msgLbl.setText("顺序不正确，请重试！");
            } else {
                msgLbl.setText(" ");
            }
        }
        this.jXPanel1.repaint();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void mnemonicBtnClicked(final JButton source) {
        final JXLabel lbl = new JXLabel(source.getText());
//        lbl.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        lbl.setFocusable(false);
        lbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                jXPanel1.remove(lbl);
                jXPanel1.revalidate();
                jXPanel1.repaint();
                source.setEnabled(true);
            }
        });
        jXPanel1.add(lbl);
        jXPanel1.revalidate();
        jXPanel1.repaint();
        source.setEnabled(false);
        
        if(!isOrderOK()) {
            msgLbl.setText("顺序不正确，请重试！");
        } else {
            msgLbl.setText(" ");
        }
    }
    
    // 判断顺序是否正确
    private boolean isOrderOK() {
        List<String> mnemonicWordsInput = Lists.newArrayListWithCapacity(jXPanel1.getComponentCount());
        for(Component comp : jXPanel1.getComponents()) {
            JLabel lbl = (JLabel)comp;
            mnemonicWordsInput.add(lbl.getText());
        }

        return StringUtils.startsWith(mnemonicWordsJoined, StringUtils.join(mnemonicWordsInput, " "));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXButton mnemonicBtn1;
    private org.jdesktop.swingx.JXButton mnemonicBtn10;
    private org.jdesktop.swingx.JXButton mnemonicBtn11;
    private org.jdesktop.swingx.JXButton mnemonicBtn12;
    private org.jdesktop.swingx.JXButton mnemonicBtn2;
    private org.jdesktop.swingx.JXButton mnemonicBtn3;
    private org.jdesktop.swingx.JXButton mnemonicBtn4;
    private org.jdesktop.swingx.JXButton mnemonicBtn5;
    private org.jdesktop.swingx.JXButton mnemonicBtn6;
    private org.jdesktop.swingx.JXButton mnemonicBtn7;
    private org.jdesktop.swingx.JXButton mnemonicBtn8;
    private org.jdesktop.swingx.JXButton mnemonicBtn9;
    private org.jdesktop.swingx.JXLabel msgLbl;
    private org.jdesktop.swingx.JXButton resetBtn;
    // End of variables declaration//GEN-END:variables
}

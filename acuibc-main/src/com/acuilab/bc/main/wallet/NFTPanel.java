package com.acuilab.bc.main.wallet;

import com.acuilab.bc.main.BlockChain;
import com.acuilab.bc.main.manager.BlockChainManager;
import com.acuilab.bc.main.nft.INFT;
import com.acuilab.bc.main.nft.MetaData;
import com.acuilab.bc.main.ui.WrapLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.util.List;
import javax.swing.SwingWorker;
import org.javatuples.Pair;
import org.jdesktop.swingx.JXPanel;
import org.netbeans.api.progress.ProgressHandle;
import org.apache.commons.lang3.StringUtils;
import org.openide.util.Exceptions;

/**
 *
 * @author admin
 */
public class NFTPanel extends JXPanel {
    private final WalletTopComponent parent;
    private final Wallet wallet;
    private final INFT nft;
    private boolean firstOpen;
    
    /**
     * Creates new form NFTPanel
     */
    public NFTPanel(WalletTopComponent parent, Wallet wallet, INFT nft) {
	initComponents();
        this.parent = parent;
	this.nftDisplayPanel.setLayout(new WrapLayout(FlowLayout.LEFT, 10, 10));
	this.wallet = wallet;
	this.nft = nft;
        
        firstOpen = true;
        websiteLink.setText(nft.getWebsite());
        contractAddressFld.setText(nft.getContractAddress());
    }
    
    public WalletTopComponent getWalletTopComponent() {
	return parent;
    }

    public boolean isFirstOpen() {
        return firstOpen;
    }
    
    // 重新加载nft列表(后台线程执行)
    public void reload() {
        nftDisplayPanel.removeAll(); 
        final ProgressHandle ph = ProgressHandle.createHandle("正在NFT列表，请稍候");
        SwingWorker<Void, Pair<Integer, MetaData>> worker = new SwingWorker<Void, Pair<Integer, MetaData>>() {
            @Override
            protected Void doInBackground() throws Exception {
                BigInteger[] tockens = nft.tokensOf(wallet.getAddress());
                balanceFld.setText(tockens.length+"个");
                
                ph.start(tockens.length);
                for(int i=0; i<tockens.length; i++) {
                    MetaData metaData = nft.getMetaData(tockens[i]);
                    
                    publish(Pair.with(i, metaData));
                }

                return null;
            }

            @Override
            protected void process(List<Pair<Integer, MetaData>> chunks) {
                for(Pair<Integer, MetaData> chunk : chunks) {
		    try {
			NFTPanel.this.nftDisplayPanel.add(new SingleNFTPanel(NFTPanel.this, wallet, nft, chunk.getValue1()));
		    } catch (Exception ex) {
		    }
                    ph.progress(chunk.getValue0()+1);
                }
            }

            @Override
            protected void done() {
                ph.finish();
		firstOpen=false;
                NFTPanel.this.repaint();
            }
        };
        worker.execute();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refreshBtn = new org.jdesktop.swingx.JXButton();
        nftDisplayPanel = new org.jdesktop.swingx.JXPanel();
        balanceLbl = new org.jdesktop.swingx.JXLabel();
        balanceFld = new org.jdesktop.swingx.JXTextField();
        contractAddressLbl = new org.jdesktop.swingx.JXLabel();
        contractAddressFld = new org.jdesktop.swingx.JXTextField();
        websiteLbl = new org.jdesktop.swingx.JXLabel();
        websiteLink = new org.jdesktop.swingx.JXHyperlink();

        setScrollableHeightHint(org.jdesktop.swingx.ScrollableSizeHint.PREFERRED_STRETCH);
        setScrollableWidthHint(org.jdesktop.swingx.ScrollableSizeHint.PREFERRED_STRETCH);

        org.openide.awt.Mnemonics.setLocalizedText(refreshBtn, org.openide.util.NbBundle.getMessage(NFTPanel.class, "NFTPanel.refreshBtn.text")); // NOI18N
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        nftDisplayPanel.setLayout(new WrapLayout(FlowLayout.CENTER, 10, 10));

        org.openide.awt.Mnemonics.setLocalizedText(balanceLbl, org.openide.util.NbBundle.getMessage(NFTPanel.class, "NFTPanel.balanceLbl.text")); // NOI18N

        balanceFld.setEditable(false);
        balanceFld.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        balanceFld.setText(org.openide.util.NbBundle.getMessage(NFTPanel.class, "NFTPanel.balanceFld.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(contractAddressLbl, org.openide.util.NbBundle.getMessage(NFTPanel.class, "NFTPanel.contractAddressLbl.text")); // NOI18N

        contractAddressFld.setEditable(false);
        contractAddressFld.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        contractAddressFld.setText(org.openide.util.NbBundle.getMessage(NFTPanel.class, "NFTPanel.contractAddressFld.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(websiteLbl, org.openide.util.NbBundle.getMessage(NFTPanel.class, "NFTPanel.websiteLbl.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(websiteLink, org.openide.util.NbBundle.getMessage(NFTPanel.class, "NFTPanel.websiteLink.text")); // NOI18N
        websiteLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                websiteLinkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nftDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(balanceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(balanceFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(contractAddressLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contractAddressFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(websiteLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(websiteLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(balanceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(balanceFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(contractAddressLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(contractAddressFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(websiteLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(websiteLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nftDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void refreshBtnActionPerformed() {
	refreshBtnActionPerformed(null);
    }    
    
    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        reload();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void websiteLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_websiteLinkActionPerformed
                                                
        if(StringUtils.isBlank(websiteLink.getText())) {
            return;
        }
        
        if(Desktop.isDesktopSupported()) {
            try {
                if(Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    if(websiteLink.getText() != null) {
                        // 打开默认浏览器
                       Desktop.getDesktop().browse(URI.create(websiteLink.getText()));
                    }
                }
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
       
        }// TODO add your handling code here:
    }//GEN-LAST:event_websiteLinkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTextField balanceFld;
    private org.jdesktop.swingx.JXLabel balanceLbl;
    private org.jdesktop.swingx.JXTextField contractAddressFld;
    private org.jdesktop.swingx.JXLabel contractAddressLbl;
    private org.jdesktop.swingx.JXPanel nftDisplayPanel;
    private org.jdesktop.swingx.JXButton refreshBtn;
    private org.jdesktop.swingx.JXLabel websiteLbl;
    private org.jdesktop.swingx.JXHyperlink websiteLink;
    // End of variables declaration//GEN-END:variables
}

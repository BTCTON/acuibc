package com.acuilab.bc.cfxespace;

import java.util.logging.Logger;
import com.acuilab.bc.main.BlockChain;
import com.acuilab.bc.main.util.Constants;
import java.awt.Image;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import javax.swing.Icon;
import org.apache.commons.lang3.StringUtils;
import org.javatuples.Pair;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.ServiceProvider;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;
import party.loveit.bip44forjava.utils.Bip44Utils;

/**
 *
 * @author admin
 */
@ServiceProvider(service=BlockChain.class)
public class ESpaceBlockChain implements BlockChain {
    
    private static final Logger LOG = Logger.getLogger(ESpaceBlockChain.class.getName());
    
    public static final String DEFAULT_NODE = "https://evm.confluxrpc.com"; // 默认结点地址
    public static final String BIP44PATH = "m/44'/60'/0'/0/0";  // 通用的以太坊基于bip44协议的助记词路径
    
    public static final String TRANSACTIONS_DETAIL_URL = "https://evm.confluxscan.io/tx/";

    public static final String TRANSACTION_DETAIL_JSON_URL = "https://evm.confluxscan.io/v1/transaction/";
    public static final int REFRESH_DELAY_MILLISECONDS = 2000;  // 延时毫秒数，以便服务器准备交易记录和余额
    public static final int GET_TRANSACTION_STATUS_INTERVAL_MILLISECONDS = 2000;  // 获得交易状态的时间间隔
    
    //private Cfx cfx;
    private BigInteger chainId;
    private BigInteger gasPrice;
    
    
    private Admin admin;    // Admin连接
    
    public Admin getAdmin() {
        return admin;
    }
    
    @Override
    public void setDefaultNode() {
	setNode(DEFAULT_NODE);
    }

    @Override
    public void setNode(String node) {
        if(admin != null) {
            admin.shutdown();
        }
        admin = Admin.build(new HttpService(node));
    }

    @Override
    public String getDefaultNode() {
        return DEFAULT_NODE;
    }

    @Override
    public String getBIP44Path() {
        return BIP44PATH;
    }

    @Override
    public void close() {
	if(admin != null) {
	    admin.shutdown();
	}
    }

    @Override
    public String getName() {
        return "CFX ESpace";
    }

    @Override
    public String getSymbol() {
        return Constants.ESPACE_BLOCKCHAIN_SYMBAL;
    }

    @Override
    public Icon getIcon(int size) {
        return ImageUtilities.loadImageIcon("/resource/cfx" + size + ".png", true);
    }
    

    @Override
    public Image getIconImage(int size) {
        return ImageUtilities.loadImage("/resource/cfx" + size + ".png", true);
    }

    @Override
    public boolean isValidAddress(String address) {
        return WalletUtils.isValidAddress(address);
    }

    @Override
    public String getTransactionDetailUrl(String hash) {
        return TRANSACTIONS_DETAIL_URL + hash;
    }

    /**
     * 通过助记词创建钱包
     * @param mnemonicWords
     * @return 返回地址和私钥对
     */
    @Override
    public Pair<String, String> createWalletByMnemonic(List<String> mnemonicWords) {
        // 1 根据助记词生成私钥
        BigInteger pathPrivateKey = Bip44Utils.getPathPrivateKey(mnemonicWords, BIP44PATH);
        
        ECKeyPair ecKeyPair = ECKeyPair.create(pathPrivateKey);
//        String publicKey = Numeric.toHexStringWithPrefix(ecKeyPair.getPublicKey());
        String privateKey = Numeric.toHexStringWithPrefix(ecKeyPair.getPrivateKey());
	String address = "0x" + Keys.getAddress(ecKeyPair);
        return new Pair<>(address, privateKey);
    }

    /**
     * 通过私钥导入钱包
     * @param privateKey
     * @return 返回钱包地址
     */
    @Override
    public String importWalletByPrivateKey(String privateKey) {
	Credentials credentials = Credentials.create(privateKey);
	return credentials.getAddress();
    }

    /**
     * 通过助记词导入钱包
     * @param mnemonic
     * @return 
     */
    @Override
    public Pair<String, String> importWalletByMnemonic(String mnemonic) {
	return createWalletByMnemonic(Arrays.asList(StringUtils.split(mnemonic, " ")));
    }

    @Override
    public TransactionStatus getTransactionStatusByHash(String hash) throws Exception {
	// TODO:
        return TransactionStatus.SUCCESS;
    }
    
    @Override
    public String getAddressFromDomain(String ens) {
        return ens;
    }
}

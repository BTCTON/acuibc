package com.acuilab.bc.main.wallet;

import java.util.Date;
import java.util.Objects;
import java.util.Observable;
import org.apache.commons.lang3.StringUtils;

/**
 * 钱包
 * 
 *
 * @author admin
 */
public class Wallet extends Observable {
    
    private String name;          // 钱包名称(主键)
    private String pwdMD5;        // 钱包密码
    private final String blockChainSymbol;        // 区块链简称(其实叫钱包类型更合适一些)
    private final String address;       // 钱包地址
    private String privateKeyAES;    // 私钥
    private String mnemonicAES;      // 助记词
    private final Date created;             // 创建日期
    
    public Wallet(String name, String pwdMD5, String blockChainSymbol, String address, String privateKeyAES, Date created) {
        this(name, pwdMD5, blockChainSymbol, address, privateKeyAES, "", created);
    }
    
    public Wallet(String name, String pwdMD5, String blockChainSymbol, String address, String privateKeyAES, String mnemonicAES, Date created) {
        this.name = name;
        this.pwdMD5 = pwdMD5;
        
        this.blockChainSymbol = blockChainSymbol;
        this.address = address;
        this.privateKeyAES = privateKeyAES;
        this.mnemonicAES = mnemonicAES;
        this.created = created;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if(!StringUtils.equals(this.name, name)) {
            this.name = name;
            setChanged();
        }
        
        notifyObservers();
    }

    public String getPwdMD5() {
        return pwdMD5;
    }

    public void setPwdMD5(String pwdMD5) {
        this.pwdMD5 = pwdMD5;
    }
    
    public String getBlockChainSymbol() {
        return blockChainSymbol;
    }

    public String getAddress() {
        return address;
    }
    
    public String getPrivateKeyAES() {
        return privateKeyAES;
    }
    
    public String getMnemonicAES() {
        return mnemonicAES;
    }
    
    public Date getCreated() {
        return created;
    }

    public void setPrivateKeyAES(String privateKeyAES) {
        this.privateKeyAES = privateKeyAES;
    }

    public void setMnemonicAES(String mnemonicAES) {
        this.mnemonicAES = mnemonicAES;
    }

    // *** equals() & hash() ***
    // 名称相同的钱包认为是同一个钱包
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Wallet other = (Wallet) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
}

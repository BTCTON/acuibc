package com.acuilab.bc.cfx;

import com.acuilab.bc.cfx.util.StructuredDataEncoder;
import com.acuilab.bc.main.cfx.CFXExtend;
import conflux.web3j.Account;
import conflux.web3j.Cfx;
import conflux.web3j.types.Address;
import conflux.web3j.types.RawTransaction;
import conflux.web3j.types.SendTransactionResult;
import conflux.web3j.types.TransactionBuilder;
import java.math.BigInteger;
import org.openide.util.Lookup;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Sign;
import org.web3j.utils.Numeric;

/**
 *
 * @author acuilab.com
 */
public class CFXExtendImpl implements CFXExtend {

    @Override
    public String send(String privateKey, String from, BigInteger gas, String to, BigInteger value, BigInteger storageLimit, String data) throws Exception {
        CFXBlockChain bc = Lookup.getDefault().lookup(CFXBlockChain.class);
        Cfx cfx = bc.getCfx();
        
        Account account = Account.create(cfx, privateKey);
	
	TransactionBuilder txBuilder = new TransactionBuilder(new Address(from));
	txBuilder.withTo(new Address(to));
	if(gas != null) {
	    txBuilder.withGasPrice(gas);
	}
	if(value != null) {
	    txBuilder.withValue(value);
	}

	if(storageLimit != null) {
	    txBuilder.withStorageLimit(storageLimit);
	}
	txBuilder.withData(data);
	RawTransaction rawTx = txBuilder.build(cfx);
	SendTransactionResult result = account.send(rawTx);
	return result.getTxHash();
    }

    @Override
    public String sign(String privateKey, String data) throws Exception {
	System.out.println("data===" + data);
//	Credentials credentials = Credentials.create(privateKey);
//	
//	RlpType rlpType = RlpString.create(Numeric.hexStringToByteArray(data));
//	
//	byte[] encoded = RlpEncoder.encode(rlpType);
//	Sign.SignatureData signature = Sign.signMessage(encoded, credentials.getEcKeyPair());
//	
//	int v = signature.getV()[0] - 27;
//	byte[] r = Bytes.trimLeadingZeroes(signature.getR());
//	byte[] s = Bytes.trimLeadingZeroes(signature.getS());
//
//	byte[] signedData = RlpEncoder.encode(new RlpList(
//			rlpType,
//			RlpString.create(v),
//			RlpString.create(r),
//			RlpString.create(s)));
//	
//	return Numeric.toHexString(signedData);

//        StructuredDataEncoder dataEncoder = new StructuredDataEncoder(data);
        
//        byte[] encodedData =
//                        dataEncoder.encodeData(
//                                dataEncoder.jsonMessageObject.getPrimaryType(),
//                                (HashMap<String, Object>) dataEncoder.jsonMessageObject.getMessage());
//        
//        
//        dataEncoder.hashStructuredData();


//            dataEncoder.getStructuredData();

        StructuredDataEncoder sde = new StructuredDataEncoder(data);
        byte[] hash = sde.hashStructuredData();
        
        Credentials credentials = Credentials.create(privateKey);
        Sign.SignatureData sigData = Sign.signMessage(hash, credentials.getEcKeyPair(), false);
        
        byte[] rsv = new byte[sigData.getR().length + sigData.getS().length + sigData.getV().length];
        System.arraycopy(sigData.getR(), 0, rsv, 0, sigData.getR().length);
        System.arraycopy(sigData.getS(), 0, rsv, sigData.getR().length, sigData.getS().length);
        System.arraycopy(sigData.getV(), 0, rsv, sigData.getR().length + sigData.getS().length, sigData.getV().length);
        
        return Numeric.toHexString(rsv);
    }

}

package com.acuilab.bc.cfx.guguo;

import com.acuilab.bc.cfx.*;
import com.acuilab.bc.main.nft.MetaData;
import com.acuilab.bc.main.util.Constants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import conflux.web3j.Cfx;
import conflux.web3j.contract.ContractCall;
import conflux.web3j.contract.abi.DecodeUtil;
import conflux.web3j.types.Address;
import java.awt.Image;
import java.math.BigInteger;
import java.net.URL;
import java.util.Map;
import javax.swing.Icon;
import org.apache.commons.lang3.StringUtils;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;

/**
 *
 * @author admin
 */
public class GuGuoGenesisNFT extends AbstractNFT {
    
    public static final String CONTRACT_ADDRESS = "cfx:acfpey6redpxtprhktcb78yvfg69ru69hefu7jze7r";
    public static final String WEBSITE = "https://guguo.io/";

    @Override
    public void init() {
    }

    @Override
    public String getName() {
	return "古国创世";
    }

    @Override
    public String getSymbol() {
	return "GuGuoGenesis";
    }

    @Override
    public String getBlockChainSymbol() {
        return Constants.CFX_BLOCKCHAIN_SYMBAL;
    }
    
    @Override
    public String getContractAddress() {
	return CONTRACT_ADDRESS;
    } 
    
    @Override
    public String getWebsite() {
        return WEBSITE;
    }

    @Override
    public Icon getIcon(int size) {
        return ImageUtilities.loadImageIcon("/resource/guguo" + size + ".png", true);
    }

    @Override
    public Image getIconImage(int size) {
        return ImageUtilities.loadImage("/resource/guguo" + size + ".png", true);
    }
    
    @Override
    public MetaData getMetaData(BigInteger tokenId) throws Exception {
        CFXBlockChain bc = Lookup.getDefault().lookup(CFXBlockChain.class);
        Cfx cfx = bc.getCfx();
	ContractCall contract = new ContractCall(cfx, new Address(CONTRACT_ADDRESS));
        // passing method name and parameter to `contract.call`
        // note: parameters should use web3j.abi.datatypes type
        String value = contract.call("uri", new org.web3j.abi.datatypes.Uint(tokenId)).sendAndGet();
        String json = DecodeUtil.decode(value, org.web3j.abi.datatypes.Utf8String.class);
	System.out.println("json======================================" + json);
        /*
        {
                "image": "https://nft-guguo.oss-cn-hongkong.aliyuncs.com/image/85d9f1639485.png",
                "localization": {
                        "uri": "https://guguo.io:8133/api/ferc1155/i18n/6/{locale}.json",
                        "default": "en-us",
                        "locales": ["en-us", "zh-cn"]
                },
                "properties": null,
                "name": "Yellow Emperor",
                "description": "The Yellow Emperor is one of the legendary Chinese sovereigns and culture heroes included among the mytho-historical Three Sovereigns and Five Emperors.",
                "artist": null,
                "artistIntroduction": null,
                "concept": null
        }
        */
        String id16 = tokenId.toString(16);
        
	ObjectMapper mapper = new ObjectMapper();
        
        JsonNode rootNode = mapper.readTree(new URL(StringUtils.replace(json, "{id}", id16)));
        JsonNode imageNode = rootNode.get("image");
        JsonNode localizationNode = rootNode.get("localization");
        /*
        {
                "name": "黄帝",
                "description": "古华夏部落联盟首领、中国远古时代华夏民族的共主、五帝之首，与炎帝共同尊奉为中华民族人文初祖。",
                "artist": "以兮",
                "artistIntroduction": "本科是美术系版画专业，毕业后从事美术教育工作6年，热爱绘画，现在是自由插画师，古风，二次元等多种绘画风格。",
                "concept": "古华夏部落联盟首领、中国远古时代华夏民族的共主、五帝之首，被尊为中华“人文初祖”。本作品创作从其主要成就中作《黄帝内经》为切入点进行绘制，此著作对后世影响深远。人物服饰，头冠，主要以龙作为主要元素凸显人物的身份地位。背景以深色渲染气氛，给人以庄严肃穆的感受。"
        }
        */
        JsonNode uriNode = localizationNode.get("uri");
        ObjectMapper mapper2 = new ObjectMapper();
	Map<String, String> map = mapper2.readValue(new URL(StringUtils.replace(uriNode.asText(), "{locale}", "zh-cn")), Map.class);
	MetaData md = new MetaData();
	md.setName(map.get("name"));
	md.setPlatform("古国序列");
        md.setDesc(map.get("concept"));
	
        String id = tokenId.toString();
	md.setId(id);
        md.setNumber(id);
	md.setImageUrl(imageNode.asText());
	
	return md;
    }
}

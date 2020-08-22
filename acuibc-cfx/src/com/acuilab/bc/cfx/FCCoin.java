package com.acuilab.bc.cfx;

import conflux.web3j.CfxUnit;
import conflux.web3j.contract.ContractCall;
import conflux.web3j.response.UsedGasAndCollateral;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.logging.Logger;
import org.openide.util.Lookup;
import org.web3j.abi.datatypes.Address;

/**
 *
 * @author admin
 */
public class FCCoin extends ERC20Coin {
    
    private static final Logger LOG = Logger.getLogger(FCCoin.class.getName());

    public static final String CONTRACT_ADDRESS = "0x87010faf5964d67ed070bc4b8dcafa1e1adc0997";

    public static final String NAME = "Fans Coin";
    public static final String SYMBOL = "FC";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }

    @Override
    public String getBlockChainSymbol() {
        return CFXBlockChain.SYMBOL;
    }

    @Override
    public String getMainUnit() {
        return "FC";
    }

    @Override
    public String getMinUnit() {
        return "";  // 没有最小单位
    }

    @Override
    public BigDecimal minUnit2MainUint(BigInteger minUnitValue) {
        return CfxUnit.drip2Cfx(minUnitValue);
    }

    @Override
    public BigInteger mainUint2MinUint(double mainUnitValue) {
        return CfxUnit.cfx2Drip(mainUnitValue);
    }

    @Override
    public BigInteger mainUint2MinUint(long mainUnitValue) {
        return CfxUnit.cfx2Drip(mainUnitValue);
    }

    @Override
    public int getMainUnitScale() {
        return 6;
    }

    @Override
    public int getScale() {
        return 18;
    }

    @Override
    public String getContractAddress() {
        return CONTRACT_ADDRESS;
    }
}

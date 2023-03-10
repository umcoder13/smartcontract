package com.test.smart_contract_test;

import com.TestContract;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.FastRawTransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.tx.response.PollingTransactionReceiptProcessor;

import java.math.BigInteger;

@Slf4j
@SpringBootTest
class SmartContractTestApplicationTests {

    private final String CONTRACT_ADDRESS = "";
    private final String USER_ADDRESS = "";
    private final String USER_PRIVATE_KEY= "";
    private final long TX_END_CHECK_DURATION = 3000;
    private final int TX_END_CHECK_RETRY = 3;
    private final long CHAIN_ID = 1337;
    @Test
    void contextLoads() throws Exception {
        Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:7545"));
        Credentials credentials = Credentials.create(USER_PRIVATE_KEY);
        DefaultGasProvider gasProvider = new DefaultGasProvider();
        log.info("gas limit is {}", gasProvider.getGasLimit());
        log.info("gas price is {}", gasProvider.getGasPrice());
        FastRawTransactionManager manager = new FastRawTransactionManager(
                web3,
                credentials,
                new PollingTransactionReceiptProcessor(web3, TX_END_CHECK_DURATION, TX_END_CHECK_RETRY)
        );

        TestContract contract = TestContract.load(CONTRACT_ADDRESS, web3, manager, gasProvider);
        BigInteger send = contract.getBalance().send();

        log.info("balance is {}", send);
    }

    @Test
    @DisplayName("자산송금")
    public void sendTransfer() throws Exception {
        //given
        String amount = "100";
        String sendAddress = "";

        Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:7545"));
        Credentials credentials = Credentials.create(USER_PRIVATE_KEY);
        BigInteger gasPrice = new BigInteger("4500000000");
        // BigInteger gasGwei = Convert.toWei(String.valueOf(gasPrice), Convert.Unit.GWEI).toBigInteger();

        StaticGasProvider gasProvider = new StaticGasProvider(gasPrice, BigInteger.valueOf(90000));
        log.info("gas limit is {}", gasProvider.getGasLimit());
        log.info("gas price is {}", gasProvider.getGasPrice());
        DefaultGasProvider gasProvider1 = new DefaultGasProvider();

        FastRawTransactionManager manager = new FastRawTransactionManager(
                web3,
                credentials,
                new PollingTransactionReceiptProcessor(web3, TX_END_CHECK_DURATION, TX_END_CHECK_RETRY)
        );

        TestContract contract = TestContract.load(CONTRACT_ADDRESS, web3, manager, gasProvider);
        TransactionReceipt send = contract.sendEther(sendAddress, new BigInteger(amount)).send();
        String blockHash = send.getBlockHash();

        log.info("receipt is {}", send);

        //when

        //then

    }

    @Test
    @DisplayName("가스 측정 api")
    public void findGasPrice() throws Exception {
        //given
        Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:7545"));

        EthGasPrice gasPrice = web3.ethGasPrice().send();

        //when

        //then
        log.info("gas price is {}", gasPrice.getGasPrice());
    }

}

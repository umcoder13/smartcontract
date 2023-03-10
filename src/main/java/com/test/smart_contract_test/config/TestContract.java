package com;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.2.
 */
@SuppressWarnings("rawtypes")
public class TestContract extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506104bd806100606000396000f3fe6080604052600436106100345760003560e01c806312065fe01461003957806348c981e214610064578063c605f76c14610080575b600080fd5b34801561004557600080fd5b5061004e6100ab565b60405161005b9190610252565b60405180910390f35b61007e600480360381019061007991906102d0565b6100ca565b005b34801561008c57600080fd5b506100956101fc565b6040516100a2919061038d565b60405180910390f35b60003373ffffffffffffffffffffffffffffffffffffffff1631905090565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610158576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161014f906103fb565b60405180910390fd5b343373ffffffffffffffffffffffffffffffffffffffff163110156101b2576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016101a990610467565b60405180910390fd5b8073ffffffffffffffffffffffffffffffffffffffff166108fc349081150290604051600060405180830381858888f193505050501580156101f8573d6000803e3d6000fd5b5050565b60606040518060400160405280600d81526020017f48656c6c6f2c20576f726c642100000000000000000000000000000000000000815250905090565b6000819050919050565b61024c81610239565b82525050565b60006020820190506102676000830184610243565b92915050565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b600061029d82610272565b9050919050565b6102ad81610292565b81146102b857600080fd5b50565b6000813590506102ca816102a4565b92915050565b6000602082840312156102e6576102e561026d565b5b60006102f4848285016102bb565b91505092915050565b600081519050919050565b600082825260208201905092915050565b60005b8381101561033757808201518184015260208101905061031c565b60008484015250505050565b6000601f19601f8301169050919050565b600061035f826102fd565b6103698185610308565b9350610379818560208601610319565b61038281610343565b840191505092915050565b600060208201905081810360008301526103a78184610354565b905092915050565b7f4f6e6c7920746865206f776e65722063616e2073656e642065746865722e0000600082015250565b60006103e5601e83610308565b91506103f0826103af565b602082019050919050565b60006020820190508181036000830152610414816103d8565b9050919050565b7f496e73756666696369656e742062616c616e63652e0000000000000000000000600082015250565b6000610451601583610308565b915061045c8261041b565b602082019050919050565b6000602082019050818103600083015261048081610444565b905091905056fea26469706673582212202fe3af09687e55bc563ef6701fc973bd5b01897f6c69a05fe42bdc995159313e64736f6c63430008120033";

    public static final String FUNC_SENDETHER = "sendEther";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_HELLOWORLD = "helloWorld";

    @Deprecated
    protected TestContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TestContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TestContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TestContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> sendEther(String recipient, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_SENDETHER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, recipient)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<BigInteger> getBalance() {
        final Function function = new Function(FUNC_GETBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> helloWorld() {
        final Function function = new Function(FUNC_HELLOWORLD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static TestContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TestContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TestContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TestContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TestContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TestContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TestContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TestContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<TestContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TestContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TestContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TestContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TestContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TestContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}

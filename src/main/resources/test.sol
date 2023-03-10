// SPDX-License-Identifier: MIT
pragma solidity ^0.8.2;

contract TestEscrow {
    address payable owner;

    constructor() {
        owner = payable(msg.sender);
    }

    function getBalance() public view returns(uint) {
        return msg.sender.balance;
    }

    function sendEther(address payable recipient) public payable {
        require(msg.sender == owner, "Only the owner can send ether.");
        require(msg.sender.balance >= msg.value, "Insufficient balance.");
        recipient.transfer(msg.value);
    }

    function helloWorld() public pure returns(string memory) {
        return "Hello, World!";
    }
}
package com.capgemini.ocp.demo.dto;

import lombok.Data;

@Data
public class CreateAccountRequest {
	private String accountHolderName;
	private double initialBalance;
}
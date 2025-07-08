package com.capgemini.ocp.basics.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
   private Long accountId;
   private String accountHolderName;
   private double balance;
}
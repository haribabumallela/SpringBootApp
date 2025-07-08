package com.capgemini.ocp.basics.demo.controller;

import com.capgemini.ocp.basics.demo.dto.Account;
import com.capgemini.ocp.basics.demo.dto.CreateAccountRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/api/bank")
public class BankingController {
   private final Map<Long, Account> accounts = new HashMap<>();
   private Long nextId = 3L;
    @PostConstruct
    public void init() {
        Account account1 = new Account(591998L, "Alice", 10000);
        Account account2 = new Account(15122000L, "Bob", 5000);
        accounts.put(account1.getAccountId(), account1);
        accounts.put(account2.getAccountId(), account2);
    }
   @PostMapping("/create")
   @Operation(summary = "Create a new bank account")
   public ResponseEntity<Account> createAccount(@RequestBody CreateAccountRequest request) {
       Account account = new Account(nextId, request.getAccountHolderName(), request.getInitialBalance());
       accounts.put(nextId, account);
       nextId++;
       return ResponseEntity.ok(account);
   }
   @GetMapping("/{accountId}")
   @Operation(summary = "Get account details by account ID")
   public ResponseEntity<Account> getAccount(@PathVariable Long accountId) {
       Account account = accounts.get(accountId);
       if (account == null) {
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(account);
   }
}
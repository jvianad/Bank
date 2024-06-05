package com.prbank.Bank.controllers;
import com.prbank.Bank.entities.Account;
import com.prbank.Bank.entities.dto.DepositRequest;
import com.prbank.Bank.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/accounts")
    @Operation(summary = "Obtener cuentas", description = "Este endpoint devuelve una lista de las cuentas del banco")
    public ResponseEntity<List<Account>> getAccounts(){
        List<Account> allAccounts = accountService.getAllAccounts();
        if (allAccounts.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allAccounts);
    }
    @PostMapping("/user/{idUser}/accounts")
    @Operation(summary = "Crear cuentas", description = "Este endpoint crea las cuentas del banco")
    public ResponseEntity<Account> createAccount(@PathVariable Long idUser, @RequestBody Account account){
        Account createdAccount = accountService.createAccount(idUser, account);
        if (createdAccount != null){
            return ResponseEntity.ok(createdAccount);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/accounts/{idAccount}")
    @Operation(summary = "Eliminar cuentas por ID", description = "Este endpoint elimina las cuentas del banco por su ID")
    public ResponseEntity<String> deleteAccountById(@PathVariable Long idAccount){
        try{
            accountService.deleteAccount(idAccount);
            return ResponseEntity.ok("Account successfully deleted");
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/accounts/{idAccount}/pockets/{idPocket}")
    @Operation(summary = "Eliminar bolsillos asociados ", description = "Este endpoint elimina bolsillos asociados a las cuentas")
    public ResponseEntity<Void> deleteAccountPocket(@PathVariable Long idAccount, @PathVariable Long idPocket){
        accountService.deleteAccountPocket(idAccount, idPocket);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/accounts/deposit/{accountNumber}")
    @Operation(summary = "Depositar dinero", description = "Este endpoint deposita dinero en una cuenta")
    public ResponseEntity<String> depositMoney(@PathVariable String accountNumber, @RequestBody DepositRequest account){
        accountService.deposit(accountNumber,account.getAmount());
        return ResponseEntity.ok("Deposito realizado");
    }
}

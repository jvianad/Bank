package com.prbank.Bank.controllers;

import com.prbank.Bank.entities.Account;
import com.prbank.Bank.entities.Pocket;
import com.prbank.Bank.services.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PocketController {
    @Autowired
    private PocketService pocketService;
    @GetMapping("/pockets")
    public ResponseEntity<List<Pocket>> getPockets(){
        List<Pocket> allPockets = pocketService.getAllPockets();
        if (allPockets.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allPockets);
    }
    @PostMapping("/account/{idAccount}/pockets")
    public ResponseEntity<Pocket> createPocket(@PathVariable Long idAccount, @RequestBody Pocket pocket){
        Pocket createdPocket = pocketService.createPocket(idAccount, pocket);
        if (createdPocket != null){
            return ResponseEntity.ok(createdPocket);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}

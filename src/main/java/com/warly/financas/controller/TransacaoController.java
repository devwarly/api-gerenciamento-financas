package com.warly.financas.controller;

import com.warly.financas.model.Transaction;
import com.warly.financas.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    private final TransactionService service;

    public TransacaoController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Transaction> criar(@RequestBody Transaction transaction) {
        Transaction salva = service.salvarTransacao(transaction);
        return new ResponseEntity<>(salva, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }
}
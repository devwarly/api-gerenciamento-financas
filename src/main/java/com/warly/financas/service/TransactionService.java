package com.warly.financas.service;

import com.warly.financas.client.Client;
import com.warly.financas.dto.BuscarCotacaoDTO;
import com.warly.financas.model.Transaction;
import com.warly.financas.repository.TransacaoRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    private final Client client;
    private final TransacaoRepository repository;

    public TransactionService(Client client, TransacaoRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    public Transaction salvarTransacao(Transaction transacao) {
        // 1. Criar par (Ex: USD-BRL)
        String par = transacao.getCurrency() + "-BRL";
        String chaveMap = transacao.getCurrency() + "BRL";

        // 2. Buscar cotação
        Map<String, BuscarCotacaoDTO> resposta = client.buscarCotacao(par);
        BuscarCotacaoDTO dados = resposta.get(chaveMap);

        // 3. Converter valores (Usando BigDecimal para precisão financeira)
        BigDecimal cotacao = new BigDecimal(dados.getBid());
        BigDecimal valorConvertido = transacao.getOriginalValue().multiply(cotacao);

        // 4. Setar dados finais
        transacao.setConversionRate(cotacao);
        transacao.setConvertedValue(valorConvertido);

        return repository.save(transacao);
    }

    public List<Transaction> listarTodas() {
        return repository.findAll();
    }
}
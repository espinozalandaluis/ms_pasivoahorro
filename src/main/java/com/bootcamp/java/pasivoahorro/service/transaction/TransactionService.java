package com.bootcamp.java.pasivoahorro.service.transaction;

import com.bootcamp.java.pasivoahorro.dto.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

    //public Mono<TransactionDTO> registerTrx(TransactionDTO transactionDTO);

    public Mono<TransactionDTO> register(TransactionRequestDTO transactionRequestDTO);

    public Mono<TransactionDTO> registerTrxEntradaExterna(TransactionDTO transactionDTO,
                                                   String IdProductClient);

    public Flux<ProductClientTransactionDTO2> findByDocumentNumber(String documentNumber);

    public Flux<TransactionDTO> findAll();

}

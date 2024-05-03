package Cashapp.com.CashApp.service;

import Cashapp.com.CashApp.DTO.DetalhesGastosDTO;
import Cashapp.com.CashApp.repository.ControleGastosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;


@Service
public class ControleGastosService {

    @Autowired
    ControleGastosRepository repository;

    public Page<DetalhesGastosDTO> listarTodosGastos(Pageable paginacao) {
        return repository.findAll(paginacao).map(DetalhesGastosDTO::new);
    }
}

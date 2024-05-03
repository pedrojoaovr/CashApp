package Cashapp.com.CashApp.controller;

import Cashapp.com.CashApp.DTO.DetalhesGastosDTO;
import Cashapp.com.CashApp.service.ControleGastosService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/gastos")
public class ControleGastosController {

    @Autowired
    ControleGastosService controleGastosService;

    @GetMapping
    public ResponseEntity<Page<DetalhesGastosDTO>> listarTodosGastos(@PageableDefault(size = 10) Pageable paginacao) {
        Page<DetalhesGastosDTO> gastos = controleGastosService.listarTodosGastos(paginacao);
        return ResponseEntity.ok(gastos);
    }
}

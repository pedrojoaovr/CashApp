package Cashapp.com.CashApp.DTO;

import Cashapp.com.CashApp.entity.ControleGastosEntity;
import Cashapp.com.CashApp.entity.UsuariosEntity;

import java.math.BigDecimal;
import java.util.Date;

public record DetalhesGastosDTO(Long id, BigDecimal valor, String descricao, Date data) {
    public DetalhesGastosDTO(ControleGastosEntity gastos) {
        this(gastos.getId(),gastos.getValor(), gastos.getDescricao(), gastos.getData());
    }
}

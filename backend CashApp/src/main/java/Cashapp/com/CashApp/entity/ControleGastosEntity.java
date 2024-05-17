package Cashapp.com.CashApp.entity;

import Cashapp.com.CashApp.DTO.CadastroGastosDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Table(name = "controle_gastos")
@Entity(name = "ControleGastosEntity")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class ControleGastosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuariosEntity usuario;


    private BigDecimal valor;
    private String descricao;
    private Date data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuariosEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosEntity usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ControleGastosEntity(CadastroGastosDTO gastos) {
        this.valor = gastos.valor();
        this.descricao = gastos.descricao();
        this.data = gastos.data();
    }
}



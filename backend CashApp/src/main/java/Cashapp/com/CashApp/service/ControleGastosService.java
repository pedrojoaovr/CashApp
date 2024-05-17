package Cashapp.com.CashApp.service;

import Cashapp.com.CashApp.DTO.CadastroGastosDTO;
import Cashapp.com.CashApp.DTO.DetalhesGastosDTO;
import Cashapp.com.CashApp.entity.ControleGastosEntity;
import Cashapp.com.CashApp.entity.UsuariosEntity;
import Cashapp.com.CashApp.repository.ControleGastosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.transaction.Transactional;


import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class ControleGastosService {

    @Autowired
    ControleGastosRepository repository;

    public Page<DetalhesGastosDTO> listarTodosGastos(Pageable paginacao) {
        return repository.findAll(paginacao).map(DetalhesGastosDTO::new);
    }

    public Page<DetalhesGastosDTO> listarGastosPorUsuario(Long usuarioId, Pageable paginacao) {
        Page<ControleGastosEntity> gastos = repository.findByUsuarioId(usuarioId, paginacao);
        return gastos.map(DetalhesGastosDTO::new);
    }

    public DetalhesGastosDTO atualizarGasto(Long id, CadastroGastosDTO cadastroGastosDTO, Long userId) {
        ControleGastosEntity gasto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gasto não encontrado"));
        if (!gasto.getUsuario().getId().equals(userId)) {
            throw new RuntimeException("Usuário não autorizado a editar este gasto");
        }
        gasto.setValor(cadastroGastosDTO.valor());
        gasto.setDescricao(cadastroGastosDTO.descricao());
        gasto.setData(cadastroGastosDTO.data());
        repository.save(gasto);
        return new DetalhesGastosDTO(gasto);
    }

    @Transactional
    public void excluirGasto(Long id, Long userId) {
        ControleGastosEntity gasto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gasto não encontrado"));
        if (!gasto.getUsuario().getId().equals(userId)) {
            throw new RuntimeException("Usuário não autorizado a excluir este gasto");
        }
        repository.deleteById(id);
    }

    @Transactional
    public DetalhesGastosDTO cadastrarGasto(CadastroGastosDTO cadastroGastosDTO, UsuariosEntity usuario) {
        ControleGastosEntity novoGasto = new ControleGastosEntity(cadastroGastosDTO);
        novoGasto.setValor(cadastroGastosDTO.valor());
        novoGasto.setDescricao(cadastroGastosDTO.descricao());
        novoGasto.setData(cadastroGastosDTO.data());
        novoGasto.setUsuario(usuario);

        repository.save(novoGasto);

        return new DetalhesGastosDTO(novoGasto);
    }

}

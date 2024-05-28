package Cashapp.com.CashApp.controller;

import Cashapp.com.CashApp.DTO.CadastroGastosDTO;
import Cashapp.com.CashApp.DTO.DetalhesGastosDTO;
import Cashapp.com.CashApp.entity.UsuariosEntity;
import Cashapp.com.CashApp.service.ControleGastosService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/gastos")
public class ControleGastosController {

    @Autowired
    ControleGastosService controleGastosService;

    @GetMapping("/meus-gastos")
    public ResponseEntity<Page<DetalhesGastosDTO>> listarMeusGastos(@AuthenticationPrincipal UserDetails userDetails, @PageableDefault(size = 10) Pageable paginacao) {
        Long userId = ((UsuariosEntity) userDetails).getId();
        Page<DetalhesGastosDTO> gastos = controleGastosService.listarGastosPorUsuario(userId, paginacao);
        return ResponseEntity.ok(gastos);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<DetalhesGastosDTO> cadastrarGasto(@RequestBody @Valid CadastroGastosDTO cadastroGastosDTO, @AuthenticationPrincipal UsuariosEntity usuario) {
        DetalhesGastosDTO novoGasto = controleGastosService.cadastrarGasto(cadastroGastosDTO, usuario);
        return ResponseEntity.ok(novoGasto);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<DetalhesGastosDTO> editarGasto(@PathVariable Long id, @RequestBody @Valid CadastroGastosDTO cadastroGastosDTO, @AuthenticationPrincipal UserDetails userDetails) {
        Long userId = ((UsuariosEntity) userDetails).getId();
        DetalhesGastosDTO atualizado = controleGastosService.atualizarGasto(id, cadastroGastosDTO, userId);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirGasto(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails){
        Long userId = ((UsuariosEntity) userDetails).getId();
        controleGastosService.excluirGasto(id, userId);
        return ResponseEntity.noContent().build();
    }
}

package Cashapp.com.CashApp.controller;

import Cashapp.com.CashApp.autenticacao.DadosAutenticacao;
import Cashapp.com.CashApp.autenticacao.DadosTokenJWT;
import Cashapp.com.CashApp.autenticacao.TokenService;
import Cashapp.com.CashApp.entity.UsuariosEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService service;

    @PostMapping
    public ResponseEntity efetuarLoogin(@RequestBody @Valid DadosAutenticacao dados){
        var authenticationTokentoken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authenticationToken = manager.authenticate(authenticationTokentoken);
        var tokenJWT = service.gerarToken((UsuariosEntity) authenticationToken.getPrincipal());
            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}

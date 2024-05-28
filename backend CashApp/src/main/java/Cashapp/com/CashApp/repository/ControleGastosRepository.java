package Cashapp.com.CashApp.repository;

import Cashapp.com.CashApp.entity.ControleGastosEntity;
import Cashapp.com.CashApp.entity.UsuariosEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ControleGastosRepository extends JpaRepository<ControleGastosEntity, Long>, JpaSpecificationExecutor<ControleGastosEntity> {

    ControleGastosEntity findByUsuario(UsuariosEntity usuario);

    Page<ControleGastosEntity> findByUsuarioId(Long usuarioId, Pageable paginacao);

}

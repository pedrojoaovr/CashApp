package Cashapp.com.CashApp.repository;

import Cashapp.com.CashApp.entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuariosEntity, Long> {
    UserDetails findByEmail(String email);
}

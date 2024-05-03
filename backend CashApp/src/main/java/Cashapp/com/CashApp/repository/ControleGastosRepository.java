package Cashapp.com.CashApp.repository;

import Cashapp.com.CashApp.entity.ControleGastosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ControleGastosRepository extends JpaRepository<ControleGastosEntity, Long>, JpaSpecificationExecutor<ControleGastosEntity> {

}

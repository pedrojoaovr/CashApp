package Cashapp.com.CashApp.DTO;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.Date;

public record CadastroGastosDTO(

    @NotBlank
    BigDecimal valor,

    @NotBlank
    String descricao,

    @NotBlank
    Date data
)
{
}

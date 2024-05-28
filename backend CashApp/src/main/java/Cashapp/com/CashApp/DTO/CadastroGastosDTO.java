package Cashapp.com.CashApp.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record CadastroGastosDTO(

    @NotNull
    BigDecimal valor,

    @NotNull
    String descricao,

    @NotNull
    Date data
)
{
}

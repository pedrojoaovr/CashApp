package Cashapp.com.CashApp.entity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuarios")
@Entity(name = "UsuariosEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class UsuariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String senha;
    private String email;

}

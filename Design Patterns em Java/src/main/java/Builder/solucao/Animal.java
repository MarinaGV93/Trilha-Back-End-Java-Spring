package Builder.solucao;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Animal {

    private String nome;
    private String dono;
    private String raca;
}

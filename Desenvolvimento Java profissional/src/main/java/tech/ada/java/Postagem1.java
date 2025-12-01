package tech.ada.java;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

//@Getter
//@Setter
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Postagem1 {
    private UUID uuid;
    private String titulo;
    private String corpo;
    private LocalDateTime dataCriacao;
    private Usuario1 autor;

 /*
     // Construtor vazio

    public Postagem() {
    }

    //Construtor

    public Postagem(UUID uuid, String titulo, String corpo, LocalDateTime dataCriacao, Usuario autor) {
        this.uuid = uuid;
        this.titulo = titulo;
        this.corpo = corpo;
        this.dataCriacao = dataCriacao;
        this.autor = autor;
    }

    //Getter e Setter

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    //toString

    @Override
    public String toString() {
        return "Postagem{" +
                "uuid=" + uuid +
                ", titulo='" + titulo + '\'' +
                ", corpo='" + corpo + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", autor=" + autor +
                '}';
    }
*/
}

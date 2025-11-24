import java.time.LocalDate;

public class Tarefa {
    private String titulo;
    private String descricao;
    private LocalDate dataEntrega;
    private boolean concluida;

    //Met odo construtor
    public Tarefa(String titulo, String descricao, LocalDate dataEntrega) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
    }

    //Met odos para acessar os atributos (getters) e passar um valor (setters)


    //Pegar o título
    public String getTitulo() {
        return titulo;
    }

    //Definir o título
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    //Met odo que retorna o objeto
    @Override
    public String toString() {
        return "Tarefa: " +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataEntrega=" + dataEntrega +
                ", concluida=" + concluida;
    }
}

package roi;//enum

public enum Prioridade {
    ALTA(3), MEDIA(2), BAIXA(1);

    final int peso;
    Prioridade(int peso) {this.peso = peso;}
}

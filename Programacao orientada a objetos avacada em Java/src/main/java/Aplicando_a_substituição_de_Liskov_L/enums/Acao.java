package Aplicando_a_substituição_de_Liskov_L.enums;

public enum Acao {
    ACT("Aceitar"),
    RCR("Recusar");

    private final String valor;

    Acao(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}

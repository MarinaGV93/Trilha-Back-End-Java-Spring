package Evitando_duplicação_de_código.enums;

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

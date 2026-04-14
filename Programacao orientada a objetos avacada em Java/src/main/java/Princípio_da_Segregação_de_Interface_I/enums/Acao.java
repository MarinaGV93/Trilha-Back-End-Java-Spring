package Princípio_da_Segregação_de_Interface_I.enums;

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

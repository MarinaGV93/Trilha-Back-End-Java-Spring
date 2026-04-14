package Como_evitar_o_uso_excessivo_de_condicionais.enums;

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

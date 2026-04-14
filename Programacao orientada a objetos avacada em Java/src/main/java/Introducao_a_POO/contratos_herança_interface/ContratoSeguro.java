package Introducao_a_POO.contratos_herança_interface;

import java.util.List;

// public class ContratoSeguro implements IContrato{
public class ContratoSeguro extends Contrato{
    private Double valorSeguro;
    private Integer riscoSeguro;

    public ContratoSeguro() {
        super();
    }

    public ContratoSeguro(double v, List<String> pessoas) {
    }

    @Override
    public void assinar() {
        System.out.println("Contrato seguro assinado!");
    }

    @Override
    public void cancelar() {
        System.out.println("Contrato seguro cancelado!");
    }
}

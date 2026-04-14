package Introducao_a_POO.contratos_herança_interface;

// public class ContratoAluguel implements IContrato{
public class ContratoAluguel extends Contrato{
    private String endereco;
    private String tipoMoradia;

    public ContratoAluguel() {
        super();
    }

    @Override
    public void assinar() {
        System.out.println("Contrato aluguel assinado!");
    }

    @Override
    public void cancelar() {
        System.out.println("Contrato aluguel cancelado!");
    }
}

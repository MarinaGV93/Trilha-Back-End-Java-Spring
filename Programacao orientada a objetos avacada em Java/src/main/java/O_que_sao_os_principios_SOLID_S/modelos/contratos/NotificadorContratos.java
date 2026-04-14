package O_que_sao_os_principios_SOLID_S.modelos.contratos;


public class NotificadorContratos {

    public void envioEmailConfirmacao(Contrato contrato){
        System.out.println("Enviando email de confirmação do contrato: " + contrato.numeroContrato);
    }

    public void envioEmailCancelamento(Contrato contrato){
        System.out.println("Enviando email de cancelamento do contrato: " + contrato.numeroContrato);
    }
}

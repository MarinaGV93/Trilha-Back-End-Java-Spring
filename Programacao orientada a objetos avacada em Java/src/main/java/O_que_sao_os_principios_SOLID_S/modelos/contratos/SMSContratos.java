package O_que_sao_os_principios_SOLID_S.modelos.contratos;

public class SMSContratos {
    public void enviarSMSConfirmacao(Contrato contrato){
        System.out.println("Enviando SMS de confirmação do contrato: " + contrato.numeroContrato);
    }

    public void enviarSMSCancelamento(Contrato contrato){
        System.out.println("Enviando SMS de cancelamento do contrato: " + contrato.numeroContrato);
    }
}

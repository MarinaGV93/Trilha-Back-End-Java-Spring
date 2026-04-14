package O_que_sao_os_principios_SOLID_S;

import O_que_sao_os_principios_SOLID_S.modelos.contratos.ContratoAluguel;
import O_que_sao_os_principios_SOLID_S.modelos.contratos.ContratoSeguro;
import O_que_sao_os_principios_SOLID_S.modelos.contratos.NotificadorContratos;
import O_que_sao_os_principios_SOLID_S.modelos.contratos.SMSContratos;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ola!");

        //Criação de contratos de aluguel
        ContratoAluguel contratoAluguel = new ContratoAluguel("Rua das peras, 123", "Casa");

        //Adicionar pessoas ao contrato
        ContratoSeguro contratoSeguro = new ContratoSeguro(1500.00, List.of("Gabriel", "Daniel"));

        System.out.println("----------------------------------------");

        System.out.println("Contrato de aluguel: " + contratoAluguel.toString());
        contratoAluguel.adicionarPessoas("Rafael");
        System.out.println("Contrato de aluguel atualizado: " + contratoAluguel.toString());

        System.out.println("----------------------------------------");

        //Contrato de seguro
        ContratoSeguro outroContratoSeguro = new ContratoSeguro(1500.00, List.of("Gabriel", "Daniel"));
        System.out.println("Contrato de seguro: " +  outroContratoSeguro.toString());

        System.out.println("----------------------------------------");

        //Notificador de contratos
        NotificadorContratos notificador = new NotificadorContratos();

        //Notificar contrato de aluguel
        notificador.envioEmailConfirmacao(contratoAluguel);

        //Notificar contrato de seguro
        notificador.envioEmailCancelamento(contratoSeguro);

        System.out.println("----------------------------------------");

        SMSContratos sms = new SMSContratos();
        sms.enviarSMSConfirmacao(contratoAluguel);
        sms.enviarSMSCancelamento(contratoSeguro);
    }
}

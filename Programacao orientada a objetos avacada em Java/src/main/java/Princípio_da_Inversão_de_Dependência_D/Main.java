package Princípio_da_Inversão_de_Dependência_D;


import Princípio_da_Inversão_de_Dependência_D.enums.Acao;
import Princípio_da_Inversão_de_Dependência_D.modelos.contratos.Contrato;
import Princípio_da_Inversão_de_Dependência_D.modelos.contratos.ContratoAluguel;
import Princípio_da_Inversão_de_Dependência_D.modelos.contratos.ContratoSeguro;
import Princípio_da_Inversão_de_Dependência_D.modelos.contratos.ContratoTrabalho;
import Princípio_da_Inversão_de_Dependência_D.modelos.pagamentos.PagamentoBoleto;
import Princípio_da_Inversão_de_Dependência_D.modelos.pagamentos.PagamentoCartao;
import Princípio_da_Inversão_de_Dependência_D.modelos.pagamentos.PagamentoPix;
import Princípio_da_Inversão_de_Dependência_D.repository.ContratoRepositoryArquivo;
import Princípio_da_Inversão_de_Dependência_D.repository.ContratoRepositoryBD;
import Princípio_da_Inversão_de_Dependência_D.repository.interfaces.ContratoRepository;
import Princípio_da_Inversão_de_Dependência_D.services.ContratoService;
import Princípio_da_Inversão_de_Dependência_D.services.PagamentoService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        gerenciaContratos();
        System.out.println("----------------------------------------");
        gerenciaPessoas();
        System.out.println("----------------------------------------");
        gerenciaPagamentos();
        System.out.println("----------------------------------------");
        gerenciaAcaoContratos();
        System.out.println("----------------------------------------");
        gerenciaRescisaoDeContratos();
        System.out.println("----------------------------------------");
        gerenciaSalvaContratos();
    }

    private static void gerenciaSalvaContratos() {
        System.out.println("Serviço de salvamento de contratos!");

        ContratoRepository contratoRepository = new ContratoRepositoryArquivo();
        ContratoRepositoryBD contratoRepositoryBD = new ContratoRepositoryBD();

        // ContratoRepositoryBD contratoRepositoryBD = new ContratoRepositoryBD();

        ContratoService contratoService = new ContratoService(contratoRepository);
        ContratoService contratoServiceBD = new ContratoService(contratoRepositoryBD);

        ContratoAluguel contratoAluguel = new ContratoAluguel("Rua das peras, 123", "Casa");

        contratoService.salvarContrato(contratoAluguel);
        // contratoService.salvarContratoBD(contratoAluguel.toString());
        contratoServiceBD.salvarContrato(contratoAluguel);
    }

    private static void gerenciaRescisaoDeContratos() {
        System.out.println("Serviço de rescisão de contratos!");

        ContratoTrabalho contratoTrabalho = new ContratoTrabalho(List.of("Gabriel", "Daniel"));
        contratoTrabalho.rescindirPorJustaCausa();
    }

    private static void gerenciaAcaoContratos() {
        System.out.println("Serviço de ação de contratos!");

        ContratoSeguro contratoSeguro = new ContratoSeguro(1500.0, List.of("Gabriel"));
        // System.out.println(contratoSeguro.toString());

        executarAcaoContrato(contratoSeguro, Acao.ACT);
    }

    private static void executarAcaoContrato(Contrato contrato, Acao acaoContrato) {
        // System.out.println("Executando ação de contrato: " + contrato.numeroContrato + " - " + acaoContrato);

        // if (contrato instanceof ContratoSeguro){
        //     if (acaoContrato.equals("Aceitar")){
        //         System.out.println("Contrato de Seguro aceito");
        //     } else if (acaoContrato.equals("Recusar")) {
        //         System.out.println("Contrato de Seguro recusado");
        //     } else {
        //         System.out.println("Ação de contrato inválida");
        //     }
        // } else if (contrato instanceof ContratoAluguel) {
        //     if (acaoContrato.equals("Aceitar")){
        //         System.out.println("Contrato de Seguro aceito");
        //     } else if (acaoContrato.equals("Recusar")) {
        //         System.out.println("Contrato de Seguro recusado");
        //     } else {
        //         System.out.println("Ação de contrato inválida");
        //     }
        // } else {
        //     System.out.println("Tipo de contrato inválido");
        // }

        contrato.executarAcao(acaoContrato);
    }

    private static void gerenciaPagamentos() {
        System.out.println("Serviço de pagamento!");

        PagamentoBoleto pagamentoBoleto = new PagamentoBoleto();
        PagamentoCartao pagamentoCartao = new PagamentoCartao(6);
        PagamentoPix pagamentoPix = new PagamentoPix();

        PagamentoService pagamentoServiceBoleto = new PagamentoService(pagamentoBoleto);
        PagamentoService pagamentoServiceCartao = new PagamentoService(pagamentoCartao);
        PagamentoService pagamentoServicePix = new PagamentoService(pagamentoPix);

        pagamentoServiceBoleto.processarPagamento();
        pagamentoServiceCartao.processarPagamento();
        pagamentoServicePix.processarPagamento();
    }

    private static void gerenciaPessoas() {
        System.out.println("Serviço de pessoas");

    }

    private static void gerenciaContratos() {
        System.out.println("Serviço de contratos");
    }

}

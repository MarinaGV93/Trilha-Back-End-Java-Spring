package Evitando_duplicação_de_código;


import Evitando_duplicação_de_código.enums.Acao;
import Evitando_duplicação_de_código.modelos.contratos.Contrato;
import Evitando_duplicação_de_código.modelos.contratos.ContratoAluguel;
import Evitando_duplicação_de_código.modelos.contratos.ContratoSeguro;
import Evitando_duplicação_de_código.modelos.contratos.ContratoTrabalho;
import Evitando_duplicação_de_código.modelos.pagamentos.PagamentoBoleto;
import Evitando_duplicação_de_código.modelos.pagamentos.PagamentoCartao;
import Evitando_duplicação_de_código.modelos.pagamentos.PagamentoPix;
import Evitando_duplicação_de_código.repository.ContratoRepositoryArquivo;
import Evitando_duplicação_de_código.repository.ContratoRepositoryBD;
import Evitando_duplicação_de_código.repository.interfaces.ContratoRepository;
import Evitando_duplicação_de_código.repository.interfaces.ContratoValidator;
import Evitando_duplicação_de_código.services.ContratoService;
import Evitando_duplicação_de_código.services.PagamentoService;

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

        ContratoValidator contratoValidatorBanco = new ContratoRepositoryBD();
        ContratoValidator contratoValidatorArquivo = new ContratoRepositoryArquivo();
        ContratoRepositoryArquivo contratoRepositoryArquivo = new ContratoRepositoryArquivo();
        ContratoRepositoryBD contratoRepositoryBanco = new ContratoRepositoryBD();
        ContratoService contratoServiceArquivo = new ContratoService(contratoRepositoryArquivo, contratoValidatorArquivo);
        ContratoService contratoServiceBanco = new ContratoService(contratoRepositoryBanco, contratoValidatorBanco);

        ContratoAluguel contratoAluguel = new ContratoAluguel("Rua das peras, 123", "Casa", List.of("Gabriel", "Daniel", "Rafael"));
        ContratoSeguro contratoSeguro = null;
        ContratoTrabalho contratoTrabalho = new ContratoTrabalho(List.of("Gabriel", "Daniel"));

        System.out.println(contratoAluguel);

        contratoServiceArquivo.salvarContrato(contratoAluguel);
        contratoServiceArquivo.salvarContrato(contratoSeguro);
        contratoServiceArquivo.salvarContrato(contratoTrabalho);

        contratoServiceBanco.salvarContrato(contratoAluguel);
        contratoServiceBanco.salvarContrato(contratoSeguro);
        contratoServiceBanco.salvarContrato(contratoTrabalho);
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

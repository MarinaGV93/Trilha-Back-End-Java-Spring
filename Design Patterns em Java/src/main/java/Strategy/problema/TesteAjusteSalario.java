package Strategy.problema;

import Strategy.Funcionario;
import Strategy.TipoContratacaoEnum;

import java.math.BigDecimal;

public class TesteAjusteSalario {
    public static void main(String[] args) {
        ReajusteAnualSalarioComStrategy reajusteAnualSalario = new ReajusteAnualSalarioComStrategy();

        Funcionario funcionarioCLT = new Funcionario();
        funcionarioCLT.setNome("Marcelo");
        funcionarioCLT.setTipoContratacao(TipoContratacaoEnum.CLT);
        funcionarioCLT.setSalario(new BigDecimal(5000));

        Funcionario funcionarioPJ = new Funcionario();
        funcionarioPJ.setNome("Maria");
        funcionarioPJ.setTipoContratacao(TipoContratacaoEnum.PJ);
        funcionarioPJ.setSalario(new BigDecimal(10000));

        Funcionario funcionarioEstagio = new Funcionario();
        funcionarioEstagio.setNome("Pedro");
        funcionarioEstagio.setTipoContratacao(TipoContratacaoEnum.ESTAGIO);
        funcionarioEstagio.setSalario(new BigDecimal(15000));

        //Calcular os reajustes
        reajusteAnualSalario.calculaReajusteAnual(funcionarioCLT);
        reajusteAnualSalario.calculaReajusteAnual(funcionarioPJ);
        reajusteAnualSalario.calculaReajusteAnual(funcionarioEstagio);

        //Imprimir os reajustes
        System.out.println(funcionarioCLT);
        System.out.println(funcionarioPJ);
        System.out.println(funcionarioEstagio);
    }
}

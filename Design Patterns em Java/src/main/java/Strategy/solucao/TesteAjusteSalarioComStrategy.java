/*
Vantagens:
    Quando cria a interface, ganha polimorfismo, passando ele como parametro.
    Sera executado qualquer calculador que implementar a interface.
    Só criar um novo calculador e implementar a interface.
    Separar estrategias e classes, que implementam interfaces. Depois cria um met odo que recebe essa interface e passar tudo que implementa essa interface atraves do polimorfismo.

    Usado quando se sabe qual estrategia passar.
 */

package Strategy.solucao;

import Strategy.Funcionario;
import Strategy.TipoContratacaoEnum;
import Strategy.solucao.ReajusteAnualSalarioComStrategy;

import java.math.BigDecimal;

public class TesteAjusteSalarioComStrategy {
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

        //Adicionar outro funcionario
        Funcionario funcionarioCooperativa = new Funcionario();
        funcionarioCooperativa.setNome("Pedro");
        funcionarioCooperativa.setTipoContratacao(TipoContratacaoEnum.COOPERATIVA);
        funcionarioCooperativa.setSalario(new BigDecimal(8000));

        //Calcular os reajustes
        reajusteAnualSalario.calculaReajusteAnual(funcionarioCLT, new CalculadorReajusteAnualSalarioCLT());
        reajusteAnualSalario.calculaReajusteAnual(funcionarioPJ, new CalculadorReajusteAnualSalarioPJ()
        );
        reajusteAnualSalario.calculaReajusteAnual(funcionarioEstagio, new CalculadorReajusteAnualSalarioEstagio());
        reajusteAnualSalario.calculaReajusteAnual(funcionarioCooperativa, new CalculadorReajusteAnualSalarioCooperativa());

        //Imprimir os reajustes
        System.out.println(funcionarioCLT);
        System.out.println(funcionarioPJ);
        System.out.println(funcionarioEstagio);
        System.out.println(funcionarioCooperativa);
    }
}

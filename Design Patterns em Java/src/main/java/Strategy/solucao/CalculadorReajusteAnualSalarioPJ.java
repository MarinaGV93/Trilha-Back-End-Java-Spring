package Strategy.solucao;

import Strategy.Funcionario;

import java.math.BigDecimal;

public class CalculadorReajusteAnualSalarioPJ implements CalculadorReajusteAnualSalario{
    @Override
    public void calcularReajusteAnual(Funcionario funcionario) {

        //Colocar a estrategia de reajuste para PJ
        BigDecimal salario = funcionario.getSalario();

        //Pega o salario e multiplica por 5%
        funcionario.setSalario(salario.add(salario.multiply(new BigDecimal("0.05"))));
    }
}

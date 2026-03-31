package Strategy.problema;

import Strategy.Funcionario;
import Strategy.TipoContratacaoEnum;

import java.math.BigDecimal;

public class ReajusteAnualSalarioComStrategy {
    public void calculaReajusteAnual(Funcionario funcionario){

        //Se for CLT
        if (TipoContratacaoEnum.CLT.name().equals(funcionario.getTipoContratacao().name())){
            BigDecimal salario = funcionario.getSalario();

            //Pega o salario e multiplica por 10%
            funcionario.setSalario(salario.add(salario.multiply(new BigDecimal("0.10"))));
        }

        //Se for PJ
        else if (TipoContratacaoEnum.PJ.equals(funcionario.getTipoContratacao())) {
            BigDecimal salario = funcionario.getSalario();

            //Pega o salario e multiplica por 5%
            funcionario.setSalario(salario.add(salario.multiply(new BigDecimal("0.05"))));
        }

        //Se for Estagio
        else if (TipoContratacaoEnum.ESTAGIO.equals(funcionario.getTipoContratacao())) {
            BigDecimal salario = funcionario.getSalario();

            //Pega o salario e multiplica por 2%
            funcionario.setSalario(salario.add(salario.multiply(new BigDecimal("0.02"))));
        }
    }
}

package roi;

import java.util.*;

public class OtimizadorDinamico {
    //Estrutura de Memorization: Chave = "Index:Orcamento", Valor = Máximo Valor Efetivo
    private final Map<String, Integer> cache = new HashMap<>();


    public int calcularMaximo(List<Acao> acoes, int orcamentoRestante, int index){
        //Caso base: orçamento esgotado ou lista de ações finalizada
        if (index < 0 || orcamentoRestante <= 0){
            return 0;
        }

        //Interceptação de subproblemas já resolvidos
        String chaveEstado = index + ":" + orcamentoRestante;
        if (cache.containsKey(chaveEstado)){
            return cache.get(chaveEstado);
        }

        //Pegar um da pilha
        Acao acaoAtual = acoes.get(index);
        int resultado;

        //Se o custo ultrapassa o orçamento,, a única opção é ignorar a ação
        if (acaoAtual.custo() > orcamentoRestante){
            resultado = calcularMaximo(acoes, orcamentoRestante, index - 1);
        } else {
            int roiIncuindo = acaoAtual.getValorEfetivo() + calcularMaximo(acoes, orcamentoRestante - acaoAtual.custo(), index - 1);

            int roiIgnorando = calcularMaximo(acoes, orcamentoRestante, index - 1);

            resultado = Math.max(roiIncuindo,  roiIgnorando);
        }

        //Persistencia do estado ótimo antes do retorno
        cache.put(chaveEstado, resultado);
        return resultado;
    }
}

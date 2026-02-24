package roi;

import java.util.List;

public class OtimizacaoRuim {

    public int calcularMaximo(List<Acao> acoes, int orcamentoRestante, int index){
        //Caso base: orçamento esgotado ou lista de ações finalizada
        if (index < 0  || orcamentoRestante <= 0){
            return 0;
        }

        //Pegar um da pilha
        Acao acaoAtual = acoes.get(index);

        //Se o custo ultrapassa o orçamento,, a única opção é ignorar a ação
        if (acaoAtual.custo() > orcamentoRestante){
            return calcularMaximo(acoes, orcamentoRestante, index - 1);
        }

        //Ramificação: Calcular o impacto de INCLUIR vs IGNORAR a ação atual
        //GARGALO: Recálculo massivo de subproblemas idênticos

        //Aprova a pasta. Vai anotar o ROI dela (tirar o dinheiro da gaveta) e passar para o próximo projeto
        int roiIncluindo = acaoAtual.getValorEfetivo() + calcularMaximo(acoes, orcamentoRestante - acaoAtual.custo(),
                //Acessa o projeto abaixo
                index -1 );

        //Quando tem dinheiro, mas não aprova
        int roiIgnorando = calcularMaximo(acoes, orcamentoRestante, index - 1);

        //Pega o máximo do melhor cenário possível
        return Math.max(roiIncluindo, roiIgnorando);
    }
}

/*
Vantagem:
    Elimina a necessidade de criar varia sub-classes, tendo pequenos protótipos, que vao ser responsaveis por gerenciar/dispor objetos, criados a partir de um prototipo
 */

package Prototype.solucao;

import Prototype.Botao;
import Prototype.TipoBordaEnum;

public class TesteBotaoPrototype {
    public static void main(String[] args) {
        //Fica registrado os protótipos
        // BotaoRegistry registry = BotaoRegistry.getInstance();
        Botao botaoVermelho = BotaoRegistry.getBotao("BOTÃO VERMELHO");
        System.out.println(botaoVermelho);

        Botao botaoAzul = BotaoRegistry.getBotao("BOTÃO AZUL");
        System.out.println(botaoAzul);

        Botao botaoAmarelo = BotaoRegistry.getBotao("BOTÃO AMARELO");
        System.out.println(botaoAmarelo);

        //Pode fazer modificações
        botaoAmarelo.setLargura(200);
        System.out.println("Modificando a largura: " + botaoAmarelo);

        //Gerar um novo botao
        Botao botaoAmarelo2 = BotaoRegistry.getBotao("BOTÃO AMARELO");
        System.out.println("Novo botao: " + botaoAmarelo2);

        //Adicionar um prototipo que nao existe
        String chave = "BOTÃO PRETO";
        Botao botaoPreto = new Botao();
        botaoPreto.setCor("Preto");
        botaoPreto.setLargura(50);
        botaoPreto.setAltura(300);
        botaoPreto.setTipoBorda(TipoBordaEnum.FINA);
        BotaoRegistry.addRegistry(chave, botaoPreto);

        Botao botaoPretoClone = BotaoRegistry.getBotao("BOTÃO PRETO");
        System.out.println("Novo botao: " + botaoPretoClone);
    }
}

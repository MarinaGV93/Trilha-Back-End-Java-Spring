package Prototype.solucao;

import Prototype.Botao;
import Prototype.TipoBordaEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BotaoRegistry {
    private static BotaoRegistry botaoRegistry;

    //Vai registrar os protótipos
    private static Map<String, Botao> REGISTRY = new HashMap<>();

    //Inicializar a classe
    //Vai ser executado assim que a classe for carregada
    static{
        Botao botaoAmarelo = new Botao();
        botaoAmarelo.setCor("Amarelo");
        botaoAmarelo.setLargura(40);
        botaoAmarelo.setAltura(100);
        botaoAmarelo.setTipoBorda(TipoBordaEnum.TRACEJADA);

        Botao botaoVermelho = new Botao();
        botaoVermelho.setCor("Vermelho");
        botaoVermelho.setLargura(30);
        botaoVermelho.setAltura(100);
        botaoVermelho.setTipoBorda(TipoBordaEnum.FINA);

        Botao botaoAzul = new Botao();
        botaoAzul.setCor("Azul");
        botaoAzul.setLargura(35);
        botaoAzul.setAltura(125);
        botaoAzul.setTipoBorda(TipoBordaEnum.TRACEJADA);


        REGISTRY.put("BOTÃO AMARELO", botaoAmarelo);
        REGISTRY.put("BOTÃO VERMELHO", botaoVermelho);
        REGISTRY.put("BOTÃO AZUL", botaoAzul);
    }

    public static BotaoRegistry getInstance(){

        //Se botaoRegistry for null, crie uma nova instancia
        if(Objects.isNull(botaoRegistry)){
            botaoRegistry = new BotaoRegistry();
            return botaoRegistry;
        }
        return botaoRegistry;
    }

    //Pegar um botão
    public static Botao getBotao(String chave){
        return BotaoFactory.getInstance(REGISTRY.get(chave));
    }

    //Adicionar registro
    public static void addRegistry(String chave, Botao botao) {
        REGISTRY.put(chave, botao);
    }
}

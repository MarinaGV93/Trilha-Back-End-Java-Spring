import java.util.ArrayList;
import java.util.List;

public class Instruções {
    //Met odo principal
    public static void main(String[] args) {
        //Imprime "Hello World!" no console
        //System.out.println("Hello World!");

        //tipo nomeVariavel = valor
        int a = 5;
        long b = 99999999999999L;
        float c = 3.14f;

        //Terá uma precisão maior
        double d = 3.14;
        char e = 'A';

        // Uma classe
        String nome = "Marina";
        boolean presenca = true;

        System.out.println(nome);
        System.out.println(presenca);
        System.out.println(a);

    //Condicional
        if (presenca){
            System.out.println("Verdadeiro");
        } else {
            System.out.println("Falso");
        }

        if (nome.isEmpty()){
            System.out.println("Vazia");
        } else if (nome.equals("Marina")) {
            System.out.println(nome);
        } else {
            System.out.println("Falso");
        }

// Vetor / Lista
// O tamanho fica fixo
        int [] numerosLista = {1, 2, 3, 4, 5};
// Colocar um tamanho
        int[] numerosLista2 = new int[5];

        //Lista sem o tamanho
        List<String> nomesAlunas = new ArrayList<>();

        //Adicionar um nome
        nomesAlunas.add("Jéssica");
        nomesAlunas.add("Larissa");

        //Imprimir com laço de repetição
        for (String aluna: nomesAlunas){
            System.out.println(aluna);
        }

        //Condição no começo
        int count = 0;
        System.out.println("While: ");
        while(count <= 5){
            System.out.println(count);
            //Incrementar
            count++; //count = count +  1
        }
    }
}
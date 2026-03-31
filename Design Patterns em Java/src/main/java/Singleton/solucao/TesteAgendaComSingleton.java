/*
Vantagem:
    Garante que tenha uma única instância de um objeto na memória
 */

package Singleton.solucao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.TreeMap;

public class TesteAgendaComSingleton {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        /*
        //EAGER

        //Tem o mesmo endereço de memória
        AgendaSingletonEAGER agenda1 = AgendaSingletonEAGER.getInstance();
        AgendaSingletonEAGER agenda2 = AgendaSingletonEAGER.getInstance();
        System.out.println("Agenda EAGER 1: " + agenda1);
        System.out.println("Agenda EAGER 2: " + agenda2);


        reservaDiasEAGLE("Sexta");
        reservaDiasEAGLE("Sábado");
         */

        /*

        //LAZY

        AgendaSingletonLAZY agenda1 = AgendaSingletonLAZY.getInstance();
        AgendaSingletonLAZY agenda2 = AgendaSingletonLAZY.getInstance();
        System.out.println("Agenda LAZY 1: " + agenda1);
        System.out.println("Agenda LAZY 2: " + agenda2);


        //Faz com que o construtor privado se torne publico.
        //Pode evitar isso usando ENUM

        //Codigo reflection -> que pode trabalhar dinamicamente em tempo de execução, quebrando o princípio de encapsulamento
        Constructor<AgendaSingletonLAZY> construtorTravesso = AgendaSingletonLAZY.class.getDeclaredConstructor();
        //Colocar acessivel
        construtorTravesso.setAccessible(true);
        AgendaSingletonLAZY agendaTravessa = construtorTravesso.newInstance();
        AgendaSingletonLAZY agendaTravessa2 = construtorTravesso.newInstance();

        System.out.println("Agenda Travessa 1: " + agendaTravessa);
        System.out.println("Agenda Travessa 2: " + agendaTravessa2);



        reservaDiasLAZY("Sexta");
        reservaDiasLAZY("Sábado");
         */

        //ENUM

        AgendaSingletonEnum agenda1 = AgendaSingletonEnum.getInstance();
        AgendaSingletonEnum agenda2 = AgendaSingletonEnum.getInstance();
        System.out.println("Agenda ENUM 1: " + agenda1.hashCode());
        System.out.println("Agenda ENUM 2: " + agenda2.hashCode());


        //Faz com que o construtor privado se torne publico.
        //Pode evitar isso usando ENUM

        //Codigo reflection -> que pode trabalhar dinamicamente em tempo de execução, quebrando o princípio de encapsulamento
        Constructor<AgendaSingletonEnum> construtorTravesso = AgendaSingletonEnum.class.getDeclaredConstructor();
        //Colocar acessivel
        construtorTravesso.setAccessible(true);
        AgendaSingletonEnum agendaTravessa = construtorTravesso.newInstance();
        AgendaSingletonEnum agendaTravessa2 = construtorTravesso.newInstance();

        System.out.println("Agenda Travessa 1: " + agendaTravessa.hashCode());
        System.out.println("Agenda Travessa 2: " + agendaTravessa2.hashCode());



        reservaDiasEnum("Sexta");
        reservaDiasEnum("Sábado");
    }

    //Reserva um dia
    public static void reservaDiasEAGLE(String dia){
        AgendaSingletonEAGER agenda = AgendaSingletonEAGER.getInstance();
        agenda.ocupa(dia);

        //Mostra os dias disponíveis
        System.out.println(agenda.getDias());
    }

    //Reserva um dia
    public static void reservaDiasLAZY(String dia){
        AgendaSingletonLAZY agenda = AgendaSingletonLAZY.getInstance();
        agenda.ocupa(dia);

        //Mostra os dias disponíveis
        System.out.println(agenda.getDias());
    }

    //Reserva um dia
    public static void reservaDiasEnum(String dia){
        AgendaSingletonEnum agenda = AgendaSingletonEnum.getInstance();
        agenda.ocupa(dia);

        //Mostra os dias disponíveis
        System.out.println(agenda.getDias());
    }
}
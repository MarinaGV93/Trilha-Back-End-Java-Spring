package Singleton.problema;

public class TesteAgenda {
    public static void main(String[] args) {
        reservaDias("Sexta");

        //Sempre que for reservar um dia, ele vai criar um novo objeto Agenda
        reservaDias("Sábado");
    }

    //Reserva um dia
    public static void reservaDias(String dia){
        Agenda agenda = new Agenda();
        agenda.ocupa(dia);

        //Mostra os dias disponíveis
        System.out.println(agenda.getDias());
    }
}
package Builder.solucao;

public class TesteAnimal {
    public static void main(String[] args) {
        Animal animal = Animal.builder()
                .nome("Bolinha")
                .raca("Vira-lata")
                .dono("Marina")
                .build();

        System.out.println(animal);
    }
}

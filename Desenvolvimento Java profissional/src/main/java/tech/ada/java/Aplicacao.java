package tech.ada.java;

public class Aplicacao {
    public static void main(String[] args) {
        Postagem1 postagem = new Postagem1();
        postagem.setTitulo("Teste");
        System.out.println(postagem.getTitulo());
    }
}

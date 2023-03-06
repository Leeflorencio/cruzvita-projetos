package br.com.cruzvita;

public class Jogo {

    public static void main(String[] args) {

        Baralho cartas = new Baralho();

        cartas.imprimeBaralho();
        System.out.println("-----------");

        System.out.println("Apagar baralho: ");
        cartas.apagarBaralho();

        System.out.println("O baralho está vazio?  ");
        cartas.temCarta();

        System.out.println("Embaralhar: ");
        cartas.embaralhar();

        System.out.println("Devolve a carta do topo do baralho: ");
        cartas.darCarta();

        System.out.println("Tamanho do baralho");
        cartas.tamanhoBaralho();
    }
}
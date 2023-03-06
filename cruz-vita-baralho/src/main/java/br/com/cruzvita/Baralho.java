package br.com.cruzvita;

import java.util.ArrayList;
import java.util.Collections;

public class Baralho  {

    private ArrayList<Carta> cartas;
    public Baralho() {
        cartas = new ArrayList<>();

        cartas.add(new Carta("Coringa", "Coringa"));
        cartas.add(new Carta("Coringa", "Coringa"));
        cartas.add(new Carta("Coringa", "Coringa"));
        cartas.add(new Carta("Coringa", "Coringa"));

        String[] naipes = {"Copas", "Espadas", "Ouro", "Paus"};
        String[] nomes = {"Ás", "2", "3", "4", "5", "6", "7", "8", "9", "Valete", "Dama", "Rei"};

        //Percorre e adicione cada nome dentro dos naipes, criando o baralho
        for (String naipe : naipes) {
            for (String nome : nomes) {
                cartas.add(new Carta(naipe, nome));
            }
        }
    }


    public void imprimeBaralho() {
        for (Carta carta : cartas) {
            System.out.println(carta.getNaipe() + " de " + carta.getNome());
        }
    }

    public void apagarBaralho(){
        cartas.clear();
        System.out.println(cartas);
    }

    public void temCarta() {
        System.out.println(cartas.isEmpty());
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
        for (Carta carta : cartas) {
            System.out.println(carta.getNaipe() + " de " + carta.getNome());
        }
    }

    public void darCarta() {
        if(!cartas.isEmpty()){
            System.out.println(cartas.get(0));
        } else{
            System.out.println("O baralho está vázio ");
        }
    }

    public void tamanhoBaralho() {
        System.out.println(cartas.size());
    }
}
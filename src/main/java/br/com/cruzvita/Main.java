package br.com.cruzvita;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            String nome;
            double inicial;
            Scanner entrada = new Scanner(System.in);
            Cliente cliente = new Cliente();
            Scanner conta = new Scanner(System.in);

            System.out.println("Cadastrando novo cliente");
            System.out.println("Informe seu nome: ");
            nome = entrada.nextLine();

            System.out.println("Informe o valor inicial de deposito: ");
            inicial = entrada.nextDouble();

            Banco newConta = new Banco(nome, conta, inicial);
            newConta.iniciar();

    }
}
package br.com.cruzvita;

import java.util.Scanner;

public class Banco {

    public Banco(String nome, Scanner conta, double inicial) {
    }

    public static void main(String[] args) {
    }

    private double saldo;
    Scanner entrada = new Scanner(System.in);

    public void extrato(){
        System.out.println("Extrato:");
        System.out.println("Saldo atual: " + saldo );
    }

    public void sacar(double valor){
        if(saldo >= valor){
            saldo -= valor;
            System.out.println("Saque no valor de: " + valor);
            System.out.println("Saldo atualizado: " + saldo + "\n");
        } else{
            System.out.println("Saldo insuficiente para a transação");
        }
    }
    public void depositar(double valor){
        saldo += valor;
        System.out.println("Valor de deposito: " + valor);
        System.out.println("Saldo atualizado: " + saldo + "\n");
    }

    public void transferir(double valor, Conta contaCliente){

    }

    public void iniciar(){
        int opcao;

        do{
            exibeMenu();
            opcao = entrada.nextInt();
            escolheOpcao(opcao);
        }while(opcao!=5);
    }
    public void exibeMenu(){
        System.out.println("Escolha a opção desejada");
        System.out.println("1 - Consultar extrato");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Transferir");
        System.out.println("5 - Sair\n");
    }

    public void escolheOpcao(int opcao){
        double valor;

        switch(opcao){
            case 1:
                extrato();
                break;
            case 2:
                System.out.println("Digite o valor de saque: ");
                valor = entrada.nextDouble();
                sacar(valor);
                break;
            case 3:
                System.out.println("Digite o valor de deposito: ");
                valor = entrada.nextDouble();
                depositar(valor);
                break;
            case 4:
                System.out.println(" Digite o valor de transferencia: ");
                break;
            case 5:
                System.out.println("Obrigado por utilizar nosso banco :) ");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
}

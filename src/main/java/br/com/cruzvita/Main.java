package br.com.cruzvita;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.nome = "Pedro";
        cliente.cpf = "24343434";
        cliente.endereco = "Avenida Java, 876 - São Miguel";
        cliente.idade = 28;
        cliente.telefone = "22277-8847";

        System.out.println(cliente.nome);
        System.out.println(cliente.cpf);
        System.out.println(cliente.endereco);
        System.out.println(cliente.idade);
        System.out.println(cliente.telefone);

        System.out.println("-------------------");

        Conta conta = new Conta();
        conta.numConta = 1234;
        conta.agencia = 5678;
        conta.tipoDeConta = "Conta Corrente";
        conta.saldo = 560.00D;

        System.out.println(conta);
        System.out.println(conta.numConta);
        System.out.println(conta.agencia);
        System.out.println(conta.tipoDeConta);
        System.out.println(conta.saldo);
    }
}
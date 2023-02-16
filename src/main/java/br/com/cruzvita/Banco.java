package br.com.cruzvita;

public class Banco implements InterfaceBanco {
    public static void main(String[] args) {
    }

    @Override
    public void sacar() {
    }

    @Override
    public double depositar() {
        return 0;
    }

    @Override
    public double transferir() {
        return 0;
    }

    @Override
    public void criarConta() {
        Conta conta1 = new Conta();
        conta1.numConta = 663339;
        conta1.agencia = 8364;
        conta1.tipoDeConta = "Conta Poupança";
        conta1.saldo = 1000.00D;

        System.out.println(conta1);
    }
}

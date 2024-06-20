import java.util.Date;

public class Main{
    public static void main(String[] args) {

        PessoaFisica joao = new PessoaFisica("João", "Av. Antonio Carlos, 6627",
                new Date(), "111.111.111-11", 36, 'm');
        PessoaFisica maria = new PessoaFisica("Maria", "Av. Carlos Luz, 7777",
                new Date(), "222.222.222-22", 16, 'f');
        PessoaJuridica lojinha = new PessoaJuridica("Loja R$1,99", "Av. Afonso Pena, 3000",
                new Date(), "000.00000.0000/0001", 25, "Comércio");


        ContaCorrente conta1 = new ContaCorrente(1111, joao, 2000, 100);
        ContaUniversitaria conta2 = new ContaUniversitaria(222, maria, 50000, 500);
        ContaCorrente conta3 = new ContaCorrente(333, lojinha, 6000, 50);

        System.out.println(conta1.toString());
        System.out.println(conta2.toString());
        System.out.println(conta3.toString());


        conta1.depositar(5000);
        conta2.depositar(2000);
        conta3.depositar(10000);

        conta1.sacar(200);
        conta2.sacar(1500);
        conta3.sacar(1640);



        conta1.imprimirExtrato();
        conta2.imprimirExtrato();
        conta3.imprimirExtrato();

        int media = Operacao.getTotalOperacoes() / Conta.getTotalContas();
        System.out.println("Média de operações por conta aberta: " + media);


        System.out.println("Verificação se existem contas IGUAIS");
        System.out.println("Verificação entre a conta de: " + joao.getNome() + " e da conta de: " + maria.getNome());
        System.out.println(joao.autenticar(maria.getCpf()));
    }
}
public abstract class Conta implements ITaxas{

    protected int numero;

    private Cliente dono;

    protected double saldo;

    protected double limite;

    private Operacao[] operacoes;

    private int proximaOperacao;

    protected static int totalContas = 0;

    public Conta(int numero, Cliente dono, double saldo, double limite) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
        this.limite = limite;

        this.operacoes = new Operacao[1000];
        this.proximaOperacao = 0;

        Conta.totalContas++;
    }


    public boolean sacar(double valor) {
        if (valor >= 0 && valor <= this.limite) {
            this.saldo -= valor;

            this.operacoes[proximaOperacao] = new OperacaoSaque(valor);
            this.proximaOperacao++;
            return true;
        }

        return false;
    }

    public void depositar(double valor) {
        this.saldo += valor;

        this.operacoes[proximaOperacao] = new OperacaoDeposito(valor);
        this.proximaOperacao++;
    }

    public boolean transferir(Conta destino, double valor) {
        boolean valorSacado = this.sacar(valor);
        if (valorSacado) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public String toString(){

        String contaStr = "===== Conta " + this.numero + " =====" + "\n"
                + this.dono.toString() + "\n" +
                "Saldo: " + this.saldo + "\n" +
                "Limite: " + this.limite + "\n" + ("====================");

        return contaStr;
    }

    public boolean equals(Object obj) {
        if(obj instanceof Conta) {
            Conta objConta = (Conta) obj;

            if(this.numero == objConta.numero) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public void imprimirExtrato() {
        System.out.println("======= Extrato Conta " + this.numero + "======");
        for(Operacao atual : this.operacoes) {
            if (atual != null) {
                atual.imprimir();
            }
        }
        System.out.println("====================");
    }
    public void imprimirExtratoTaxas() {
        double total = 0;

        System.out.printf("====== Extrato de Taxas Conta " + this.numero + " ======\n" ,
                "Manutenção da conta: %.2f\n" , calculaTaxas());
        total += calculaTaxas();
        for(int i=0; i<operacoes.length; i++) {
            if (operacoes[i] != null && operacoes[i].getTipo() == 's') {

                    System.out.printf("Saque: %.2f\n", operacoes[i].calculaTaxas());
                    total += operacoes[i].calculaTaxas();
            }
        }
        System.out.printf("\nTotal: %.2f \n==========================================\n", total);
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getDono() {
        return dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public static int getTotalContas() {
        return Conta.totalContas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public abstract boolean setLimite(double limite);

}
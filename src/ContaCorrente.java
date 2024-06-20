public class ContaCorrente extends Conta{
    public ContaCorrente(int numero, Cliente dono, double saldo, double limite) {
        super(numero,dono,saldo,limite);
        setLimite(limite);
    }

    @Override
    public boolean setLimite(double limite) {
        if (limite <= -100) {
            super.limite = -100;
            return false;
        } else {
            super.limite = limite;
            return true;
        }
    }
    public double calculaTaxas() {
        if(getDono() instanceof PessoaFisica){
            return 10;
        }else{
            return 20;
        }
    }
}
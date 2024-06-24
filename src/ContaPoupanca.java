public class ContaPoupanca extends Conta implements ITaxas{

    public ContaPoupanca(int numero, Cliente dono, double saldo, double limite) {
        super(numero,dono,saldo,limite);
        setLimite(limite);
    }

    @Override
    public boolean setLimite(double limite) {
        if (limite <= 1000 && limite >= 100) {
            super.limite = limite;
            return true;
        } else {
            super.limite = 1000;
            return false;
        }
    }
    public double calculaTaxas() {
        return 0;
    }
}
public class ContaUniversitaria extends Conta{
    public ContaUniversitaria(int numero, Cliente dono, double saldo, double limite) {
        super(numero,dono,saldo,limite);
        setLimite(limite);
    }

    @Override
    public boolean setLimite(double limite) {
        if (limite <= 500 && limite >= 0) {
            super.limite = limite;
            return true;
        } else {
            super.limite = 500;
            return false;
        }
    }
    public double calculaTaxas() {
        return 0;
    }
}
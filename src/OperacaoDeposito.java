public class OperacaoDeposito extends Operacao {

    public OperacaoDeposito(double valor) {
        super('d', valor);
    }
    public String toString() {
        String depositoStr = this.getData() + "\t" + this.getTipo() + "\t" + this.getValor();

        return depositoStr;
    }
    public double calculaTaxas() {
        return 0;
    }
}
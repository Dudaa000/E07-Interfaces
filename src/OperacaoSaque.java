public class OperacaoSaque extends Operacao {

    public OperacaoSaque(double valor) {
        super('s', valor);
    }
    public String toString() {
        String saqueStr = this.getData() + "\t" + this.getTipo() + "\t" + this.getValor();

        return saqueStr;
    }
    public double calculaTaxas() {
        return 0.05;
    }
}
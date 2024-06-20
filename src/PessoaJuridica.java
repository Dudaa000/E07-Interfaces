
import java.util.Date;

public class PessoaJuridica extends Cliente {

    private String cnpj;

    private int numFuncionarios;

    private String setor;

    public PessoaJuridica(String nome, String endereco, Date data, String cnpj, int numFuncionarios, String setor) {
        super(nome, endereco, data);
        this.cnpj = cnpj;
        this.numFuncionarios = numFuncionarios;
        this.setor = setor;
    }

    @Override
    public String toString() {
        String PJstr = "--------------- PJ ---------------\n" +
                "Nome: " + this.getNome() + "\n" +
                "Data: " + this.getData() + "\n" +
                "Endereco: " + this.getEndereco() + "\n" +
                "CNPJ: " + cnpj + "\n" +
                "Número de Funcionários: " + numFuncionarios + "\n" +
                "Setor: " + setor + "\n" +
                "----------------------------------";
        return PJstr;
    }



    public boolean equals(Object obj) {
        if(obj instanceof PessoaJuridica) {
            PessoaJuridica objPJ = (PessoaJuridica) obj;

            if(this.cnpj.equals(objPJ.cnpj)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean autenticar(String chave){

        return this.cnpj.equals(chave);

    }


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getNumFuncionarios() {
        return numFuncionarios;
    }

    public void setNumFuncionarios(int numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
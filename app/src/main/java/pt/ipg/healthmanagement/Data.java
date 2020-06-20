package pt.ipg.healthmanagement;

public class Data {
    int id;
    String nome;
    String genero;
    String data_nascimento;
    String contacto_emergencia;
    String morada;
    String numero_cc;
    String data_entrada_servico;
    String sintoma;
    String detalheSintoma;
    String estadoClinico;
    String data_inicio_tratamento;
    String observacoes;
    String regime_alimentar;
    String medicacao;



    public Data() {

    }

    //Create table (query)

    public static final String CREATE_TABLE=
            "CREATE TABLE " + "Pacientes" + "("+
                    "Id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Nome" + " TexT, " +
                    "Genero" + " TexT, " +
                    "Data_nascimento" + " TexT, " +
                    "Contacto_emergencia" + " TexT, " +
                    "Morada" + " TexT, " +
                    "Numero_cc" + " TexT, " +
                    "Data_entrada_servico" + " TexT, " +
                    "Sintoma" + " TexT, " +
                    "Detalhe_sintoma" + " TexT, " +
                    "Estado_clinico" + " TexT, " +
                    "Data_inicio_tratamento" + " TexT, " +
                    "Observacoes" + " TexT, " +
                    "Regime_alimentar" + " TexT, " +
                    "Medicacao" + " TexT "+ ")";



    public Data(int id, String nome, String genero, String data_nascimento, String contacto_emergencia, String morada, String numero_cc, String data_entrada_servico, String sintoma, String detalheSintoma, String estadoClinico, String data_inicio_tratamento, String observacoes, String regime_alimentar, String medicacao) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.data_nascimento = data_nascimento;
        this.contacto_emergencia = contacto_emergencia;
        this.morada = morada;
        this.numero_cc = numero_cc;
        this.data_entrada_servico = data_entrada_servico;
        this.sintoma = sintoma;
        this.detalheSintoma = detalheSintoma;
        this.estadoClinico = estadoClinico;
        this.data_inicio_tratamento = data_inicio_tratamento;
        this.observacoes = observacoes;
        this.regime_alimentar = regime_alimentar;
        this.medicacao = medicacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getContacto_emergencia() {
        return contacto_emergencia;
    }

    public void setContacto_emergencia(String contacto_emergencia) {
        this.contacto_emergencia = contacto_emergencia;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getNumero_cc() {
        return numero_cc;
    }

    public void setNumero_cc(String numero_cc) {
        this.numero_cc = numero_cc;
    }

    public String getData_entrada_servico() {
        return data_entrada_servico;
    }

    public void setData_entrada_servico(String data_entrada_servico) {
        this.data_entrada_servico = data_entrada_servico;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String getDetalheSintoma() {
        return detalheSintoma;
    }

    public void setDetalheSintoma(String detalheSintoma) {
        this.detalheSintoma = detalheSintoma;
    }

    public String getEstadoClinico() {
        return estadoClinico;
    }

    public void setEstadoClinico(String estadoClinico) {
        this.estadoClinico = estadoClinico;
    }

    public String getData_inicio_tratamento() {
        return data_inicio_tratamento;
    }

    public void setData_inicio_tratamento(String data_inicio_tratamento) {
        this.data_inicio_tratamento = data_inicio_tratamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getRegime_alimentar() {
        return regime_alimentar;
    }

    public void setRegime_alimentar(String regime_alimentar) {
        this.regime_alimentar = regime_alimentar;
    }

    public String getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }


}

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
                    "Data_entrada_servico" + " TexT "+ ")";

    public Data(int id, String nome, String genero, String data_nascimento, String contacto_emergencia, String morada, String numero_cc, String data_entrada_servico) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.data_nascimento = data_nascimento;
        this.contacto_emergencia = contacto_emergencia;
        this.morada = morada;
        this.numero_cc = numero_cc;
        this.data_entrada_servico = data_entrada_servico;
    }

    public Data() {

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
}

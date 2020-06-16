package pt.ipg.healthmanagement;

public class DataMedico {
    int id;
    String nome;
    String funcao;
    String contacto;

    public static final String CREATE_TABLE2=
            "CREATE TABLE " + "Medicos" + "("+
                    "Id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Nome" + " TexT, " +
                    "Funcao" + " TexT, " +
                    "Contacto" + " TexT "+ ")";

    public DataMedico() {

    }

    public DataMedico(int id, String nome, String funcao, String contacto) {
        this.id = id;
        this.nome = nome;
        this.funcao = funcao;
        this.contacto = contacto;
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}

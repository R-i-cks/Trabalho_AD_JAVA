package Trabalho_AD_JAVA.Objetos;

import java.io.Serializable;

public class Consulta implements Serializable {
    private String id_consulta;
    private String data;
    private String hora;
    private String upcs;

    private String id_medico;
    private String id_utente;

    public String getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(String id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getUpcs() {
        return upcs;
    }

    public void setUpcs(String upcs) {
        this.upcs = upcs;
    }

    public String getIdMedico(){return id_medico; }

    public void setId_medico(String id_medico){this.id_medico = id_medico;}

    public String getId_utente(){return id_utente;}
    public void setId_utente(String id_utente){this.id_utente = id_utente;}
}




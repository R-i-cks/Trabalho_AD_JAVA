package Trabalho_AD_JAVA.Objetos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Consulta implements Serializable {
    private String id_consulta;
    private String data;
    private String hora;
    private String upcs;

    private String id_medico;
    private String id_utente;

    public Consulta() {}
    public Consulta(String id_consulta, String data, String hora, String upcs, String id_medico, String id_utente) {
        this.id_consulta = id_consulta;
        this.id_medico = id_medico;
        this.id_utente = id_utente;
        this.data = data;
        this.hora = hora;
        this.upcs = upcs;
    }

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

    @Override
    public String toString() {
        return "[Consulta > id: " + getId_consulta() + ", data: " + data + ", utente: " + id_utente + ", medico: " + id_medico + "]";
    }
}




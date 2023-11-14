package Trabalho_AD_JAVA.app;

import Trabalho_AD_JAVA.Objetos.*;
import Trabalho_AD_JAVA.exception.IdAlreadyExists;
import Trabalho_AD_JAVA.exception.ObjectNotFound;

import java.rmi.Remote;
import java.util.List;

public interface GestaoAuxiliarInterface extends Remote {
    public void load();
    public List<Consulta> encontraConsultas_utente(String id) throws ObjectNotFound;
    public List<Prescricao> encontraPrescricoes_utente(String id) throws ObjectNotFound;
    public List<Medicao> encontraMedicoes_utente(String id) throws ObjectNotFound;
    public List<Exame> encontraExames_utente(String id) throws ObjectNotFound;
    public boolean alterarNome_Profissional(String id, String nome) throws ObjectNotFound;
    public boolean alterarNome_utente(String id, String nome) throws ObjectNotFound;
    public boolean alterarGenero_utente(String id, String genero) throws ObjectNotFound;
    public boolean alterarNome_Familiar(String id, String nome) throws ObjectNotFound;
    public boolean alterarContacto_Profissional(String id, String contacto) throws ObjectNotFound;
    public boolean alterarContacto_utente(String id, String nome) throws ObjectNotFound;
    public boolean alterarContacto_Familiar(String id, String contacto) throws ObjectNotFound;
    public void addConsulta(Consulta c) throws ObjectNotFound, IdAlreadyExists;
    public boolean alterarDataConsulta_utente(String idc, String data) throws ObjectNotFound;
    public int consultasNumDadoPeriodo(String inicial, String dfinal);
    public Medico medicoComMaisConsultas();
}

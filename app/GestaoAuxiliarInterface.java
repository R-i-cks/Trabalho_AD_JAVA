package Trabalho_AD_JAVA.app;

import Trabalho_AD_JAVA.Objetos.*;
import Trabalho_AD_JAVA.exception.IdAlreadyExists;
import Trabalho_AD_JAVA.exception.ObjectNotFound;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GestaoAuxiliarInterface extends Remote {
    public void load() throws RemoteException;
    public void addUtente(Utente u) throws RemoteException;
    public List<Consulta> encontraConsultas_utente(String id) throws RemoteException;
    public List<Prescricao> encontraPrescricoes_utente(String id) throws RemoteException;
    public List<Medicao> encontraMedicoes_utente(String id) throws RemoteException;
    public List<Exame> encontraExames_utente(String id) throws RemoteException;
    public boolean alterarNome_Profissional(String id, String nome) throws RemoteException;
    public boolean alterarNome_utente(String id, String nome) throws RemoteException;
    public boolean alterarGenero_utente(String id, String genero) throws RemoteException;
    public boolean alterarNome_Familiar(String id, String nome) throws RemoteException;
    public boolean alterarContacto_Profissional(String id, String contacto) throws RemoteException;
    public boolean alterarContacto_utente(String id, String nome) throws RemoteException;
    public boolean alterarContacto_Familiar(String id, String contacto) throws RemoteException;
    public void addConsulta(Consulta c) throws RemoteException;
    public boolean alterarDataConsulta_utente(String idc, String data) throws RemoteException;
    public int consultasNumDadoPeriodo(String inicial, String dfinal) throws RemoteException;
    public Medico medicoComMaisConsultas() throws RemoteException;
    public Medico medicoComMaisPrescicoes() throws RemoteException;
    public float PercentagemUtentesSemConsultas() throws RemoteException;
    public String medicamentoMaisPrescrito() throws RemoteException;
    public int numeroConsultasPorUtente(String id) throws RemoteException;
}

package Trabalho_AD_JAVA.app;

import Trabalho_AD_JAVA.Objetos.*;
import Trabalho_AD_JAVA.exception.ObjectNotFound;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GestaoUtentesInterface extends Remote {
    public void load() throws RemoteException;
    public List<Consulta> encontraConsultas_utente(String id) throws ObjectNotFound, RemoteException;
    public List<Prescricao> encontraPrescricoes_utente(String id) throws ObjectNotFound, RemoteException;
    public List<Medicao> encontraMedicoes_utente(String id) throws ObjectNotFound, RemoteException;
    public List<Exame> encontraExames_utente(String id) throws ObjectNotFound, RemoteException;
    public boolean alterarNome_utente(String id, String nome) throws ObjectNotFound, RemoteException;
    public boolean alterarGenero_utente(String id, String genero) throws ObjectNotFound, RemoteException;
    public boolean alterarContacto_utente(String id, String genero) throws ObjectNotFound, RemoteException;



}

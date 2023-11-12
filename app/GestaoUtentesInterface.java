package Trabalho_AD_JAVA.app;

import Trabalho_AD_JAVA.Objetos.*;
import Trabalho_AD_JAVA.exception.ObjectNotFound;

import java.rmi.Remote;
import java.util.List;

public interface GestaoUtentesInterface extends Remote {
    public List<Consulta> encontraConsultas_utente(String id) throws ObjectNotFound;
    public List<Prescricao> encontraPrescricoes_utente(String id) throws ObjectNotFound;
    public List<Medicao> encontraMedicoes_utente(String id) throws ObjectNotFound;
    public List<Exame> encontraExames_utente(String id) throws ObjectNotFound;
    public boolean alterarNome_utente(String id, String nome) throws ObjectNotFound;
    public boolean alterarGenero_utente(String id, String genero) throws ObjectNotFound;
    public boolean alterarContacto_utente(String id, String genero) throws ObjectNotFound;

}

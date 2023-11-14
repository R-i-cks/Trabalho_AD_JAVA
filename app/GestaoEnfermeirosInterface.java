package Trabalho_AD_JAVA.app;

import Trabalho_AD_JAVA.Objetos.Consulta;
import Trabalho_AD_JAVA.Objetos.Exame;
import Trabalho_AD_JAVA.Objetos.Medicao;
import Trabalho_AD_JAVA.Objetos.Prescricao;
import Trabalho_AD_JAVA.exception.ObjectNotFound;

import java.rmi.Remote;
import java.util.List;

public interface GestaoEnfermeirosInterface extends Remote {
    public void load();
    public List<Consulta> encontraConsultas_utente(String id) throws ObjectNotFound;
    public List<Prescricao> encontraPrescricoes_utente(String id) throws ObjectNotFound;
    public List<Medicao> encontraMedicoes_utente(String id) throws ObjectNotFound;
    public List<Exame> encontraExames_utente(String id) throws ObjectNotFound;
    public boolean alterarNome_Profissional(String id, String nome) throws ObjectNotFound;
    public boolean alterarContacto_Profissional(String id, String nome) throws ObjectNotFound;
    }

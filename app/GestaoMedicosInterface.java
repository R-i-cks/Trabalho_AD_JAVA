package Trabalho_AD_JAVA.app;

import Trabalho_AD_JAVA.Objetos.Consulta;
import Trabalho_AD_JAVA.Objetos.Exame;
import Trabalho_AD_JAVA.Objetos.Medicao;
import Trabalho_AD_JAVA.Objetos.Prescricao;
import Trabalho_AD_JAVA.exception.IdAlreadyExists;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GestaoMedicosInterface extends Remote{
    public void load() throws RemoteException;
    public List<Consulta> encontraConsultas_medico(String id) throws RemoteException;
    public List<Consulta> encontraConsultas_utente(String id) throws RemoteException;
    public void addConsulta(Consulta c) throws RemoteException, IdAlreadyExists;                      // feito
    public List<Prescricao> encontraPrescricoes_utente(String id) throws RemoteException;
    public List<Prescricao> encontraPrescricao_medico(String id) throws RemoteException;             // feito
    public void addPrescricao(Prescricao pre) throws RemoteException, IdAlreadyExists;
    public List<Medicao> encontraMedicoes_utente(String id) throws RemoteException;
    public void addMedicao(Medicao medicao) throws RemoteException, IdAlreadyExists;                  // feito
    public List<Exame> encontraExames_utente(String id) throws RemoteException;
    public void addExame(Exame e) throws RemoteException, IdAlreadyExists;
    public boolean alterarContacto_Profissional(String id, String contacto) throws RemoteException;
    public boolean alterarNome_Profissional(String id, String nome) throws RemoteException;
}

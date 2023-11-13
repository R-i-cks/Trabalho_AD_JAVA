package Trabalho_AD_JAVA.app;

import Trabalho_AD_JAVA.Objetos.Consulta;
import Trabalho_AD_JAVA.Objetos.Exame;
import Trabalho_AD_JAVA.Objetos.Medicao;
import Trabalho_AD_JAVA.Objetos.Prescricao;
import Trabalho_AD_JAVA.exception.IdAlreadyExists;
import Trabalho_AD_JAVA.exception.ObjectNotFound;

import java.rmi.Remote;
import java.util.List;

public interface GestaoMedicosInterface extends Remote{
    public List<Consulta> encontraConsultas_medico(String id) throws ObjectNotFound;
    public List<Consulta> encontraConsultas_utente(String id) throws ObjectNotFound;
    public void addConsulta(Consulta c) throws ObjectNotFound, IdAlreadyExists;                      // feito
    public List<Prescricao> encontraPrescricoes_utente(String id) throws ObjectNotFound;
    public List<Prescricao> encontraPrescricao_medico(String id) throws ObjectNotFound;             // feito
    public void addPrescricao(Prescricao pre) throws ObjectNotFound, IdAlreadyExists;
    public List<Medicao> encontraMedicoes_utente(String id) throws ObjectNotFound;
    public void addMedicao(Medicao medicao) throws ObjectNotFound, IdAlreadyExists;                  // feito
    public List<Exame> encontraExames_utente(String id) throws ObjectNotFound;
    public void addExame(Exame e) throws ObjectNotFound, IdAlreadyExists;
    public boolean alterarContacto_Profissional(String id, String contacto) throws ObjectNotFound;
    public boolean alterarNome_Profissional(String id, String nome) throws ObjectNotFound;
}

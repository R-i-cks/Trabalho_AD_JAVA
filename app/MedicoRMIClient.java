package Trabalho_AD_JAVA.app;


import Trabalho_AD_JAVA.exception.ObjectNotFound;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MedicoRMIClient {

    public static void main(String[] args) {
        GestaoMedicosInterface gm = null;
        try {
            gm = (GestaoMedicosInterface) Naming.lookup("rmi://localhost:5001/GM");
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(gm.encontraPrescricao_medico("1"));
        } catch (ObjectNotFound e) {
            System.out.println("Nao existe");
        }
    }
}
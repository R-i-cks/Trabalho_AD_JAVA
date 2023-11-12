package Trabalho_AD_JAVA.app;


import Trabalho_AD_JAVA.exception.ObjectNotFound;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AuxiliarRMIClient {

    public static void main(String[] args) {
        GestaoAuxiliarInterface ga = null;
        try {
            ga = (GestaoAuxiliarInterface) Naming.lookup("rmi://localhost:5001/GA");
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(ga.alterarDataConsulta_utente("c3", "10/07/1999"));
        } catch (ObjectNotFound e) {
            System.out.println("Nao existe");
        }

    }
}
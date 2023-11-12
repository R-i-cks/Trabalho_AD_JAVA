package Trabalho_AD_JAVA.app;


import Trabalho_AD_JAVA.exception.ObjectNotFound;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class EnfermeiroRMIClient {

    public static void main(String[] args) {
        GestaoEnfermeirosInterface ge = null;
        try {
            ge = (GestaoEnfermeirosInterface) Naming.lookup("rmi://localhost:5001/GE");
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(ge.encontraExames_utente("u1"));
        } catch (ObjectNotFound e) {
            System.out.println("Nao existe");
        }
    }
}
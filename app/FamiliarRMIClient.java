package Trabalho_AD_JAVA.app;


import Trabalho_AD_JAVA.Objetos.Familiar;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class FamiliarRMIClient {

    public static void main(String[] args) {
        GestaoFamiliarInterface gf = null;
        try {
            gf = (GestaoFamiliarInterface) Naming.lookup("rmi://localhost:5001/GF");
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
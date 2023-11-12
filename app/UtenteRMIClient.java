package Trabalho_AD_JAVA.app;


import Trabalho_AD_JAVA.Objetos.*;
import Trabalho_AD_JAVA.Gestao.GestaoDados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

public class UtenteRMIClient {

    public static void main(String[] args) {

        GestaoUtentesInterface gu = null;
        try {
            gu = (GestaoUtentesInterface) Naming.lookup("rmi://localhost:5001/GU");
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }



    }
}
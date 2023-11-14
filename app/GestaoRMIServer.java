package Trabalho_AD_JAVA.app;

import Trabalho_AD_JAVA.Gestao.GestaoDados;
import java.io.BufferedReader;
import java.rmi.Naming;
//  C:\Users\monic\.jdks\openjdk-21\bin\rmiregistry.exe -J-D"sun.rmi.registry.registryFilter=*" 5001



public class GestaoRMIServer {
    public static void main(String[] args) {
        GestaoDados gd = new GestaoDados();
        try {
            gd.load();

            GestaoUtentesInterface serverU = gd;
            Naming.rebind("rmi://localhost:5001/GA", serverU);

            GestaoAuxiliarInterface serverA = gd;
            Naming.rebind("rmi://localhost:5001/GA", serverA);

            GestaoEnfermeirosInterface serverE = gd;
            Naming.rebind("rmi://localhost:5001/GA", serverE);

            GestaoFamiliarInterface serverF = gd;
            Naming.rebind("rmi://localhost:5001/GA", serverF);

            GestaoMedicosInterface serverM = gd;
            Naming.rebind("rmi://localhost:5001/GA", serverM);

            System.out.println("Running");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
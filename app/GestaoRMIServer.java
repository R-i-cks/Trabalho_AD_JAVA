package Trabalho_AD_JAVA.app;

import Trabalho_AD_JAVA.Gestao.GestaoDados;
import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import static java.lang.System.out;
//  C:\Users\monic\.jdks\openjdk-21\bin\rmiregistry.exe -J-D"sun.rmi.registry.registryFilter=*" 5001



public class GestaoRMIServer {
    public static void main(String[] args) throws RemoteException {

        GestaoDados gd = new GestaoDados();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Codigo a ser executada quando o programa vai abaixo
            gd.saveConsultas();
            gd.saveFamiliar();
            gd.saveMedicoes();
            gd.saveExames();
            gd.saveUtentes();
            gd.saveProfissionais();
            gd.savePrescricoes();

        }));
        try {


                GestaoUtentesInterface serverU = gd;
                Naming.rebind("rmi://localhost:5001/GU", serverU);

                GestaoAuxiliarInterface serverA = gd;
                Naming.rebind("rmi://localhost:5001/GA", serverA);

                GestaoEnfermeirosInterface serverE = gd;
                Naming.rebind("rmi://localhost:5001/GE", serverE);

                GestaoFamiliarInterface serverF = gd;
                Naming.rebind("rmi://localhost:5001/GF", serverF);

                GestaoMedicosInterface serverM = gd;
                Naming.rebind("rmi://localhost:5001/GM", serverM);

                out.println("Running");


        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
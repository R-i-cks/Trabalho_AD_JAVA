package Trabalho_AD_JAVA.app;


import Trabalho_AD_JAVA.Objetos.Consulta;
import Trabalho_AD_JAVA.Objetos.Medicao;
import Trabalho_AD_JAVA.exception.IdAlreadyExists;
import Trabalho_AD_JAVA.exception.ObjectNotFound;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
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


        // MEDICO QUER ENCONTRAR AS PRESCRICOES QUE PASSOU
        try {
            System.out.println(gm.encontraPrescricao_medico("1"));
        } catch (ObjectNotFound e) {
            System.out.println("Nao existe");
        }


        // MEDICO QUER INSERIR CONSULTA
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Insira os dados da seguinte forma: idconsulta, dataconsulta, horaconsulta, upcs, idmedico, idutente");
            String info = scanner.nextLine();
            String[] dados =info.split(", ");
            Consulta c = new Consulta(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5]);
            gm.addConsulta(c);
        } catch (ObjectNotFound e) {
            throw new RuntimeException(e);
        } catch (IdAlreadyExists e) {
            throw new RuntimeException(e);
        }

        // MEDICO QUER INSERIR MEDICAO
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Insira os dados da seguinte forma: idmedicao, tipo, valor, unidades, idutente");
            String info = scanner.nextLine();
            String[] dados =info.split(", ");
            Medicao m = new Medicao(dados[0], dados[1], dados[2], dados[3], dados[4]);
            gm.addMedicao(m);
        } catch (ObjectNotFound e) {
            throw new RuntimeException(e);
        } catch (IdAlreadyExists e) {
            throw new RuntimeException(e);
        }

    }
}
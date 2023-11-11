package app;


import Objetos.Familiar;

public class FamiliarRMIClient {

    public static void main(String[] args) {


        GestaoFamiliarInterface gf = null;
        try {
            gf = (GestaoFamiliarInterface) Naming.lookup("rmi://localhost:8001/GM");
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        /**
         * Leitura do ficheiro csv com os medicamentos, criação dos objectos medicamento e inserção na gestão de medicamentos
         */
        BufferedReader br = null;
        try {
            int cnt = 0;
            /**
             * BufferedReader - stream de leitura de dados (permite ler linha a linha) . É criado a partir de um stream, neste caso um FileReader
             */
            br = new BufferedReader(
                    new FileReader("../Dados/utentes.csv"));
            /**
             * Leitura da 1ª linha que é o cabeçalho do ficheiro e devemos ignorar
             * mostra-se como partir a linha em partes. Neste caso o ";" separa as partes
             */
            String header = br.readLine();
            if (header != null) {
                String[] columns = header.split(";");
                System.out.println(Arrays.toString(columns));
            }
            /**
             * Leitura linha a linha do ficheiro e criação de um objeto por cada linha
             */
            String line = null;
            do {
                line = br.readLine();
                if (line != null) {
                    /**
                     * Separação da linha em partes separadas por ";"
                     */
                    String[] columns = line.split(";");
                    if (columns.length != 0) {
                        //Medicamento M = new Medicamento(columns);
                        /**
                         * Criação do objeto medicamento
                         */
                        Familiar f = new Familiar();
                        /**
                         * Preenchimento dos atributos (variáveis de instância do medicamento)
                         */
                        f.setId(columns[0]);
                        f.setNome(columns[1]);
                        f.setContacto(columns[2]);
                        f.setUtentes(columns[3]);

                        /**
                         * Inserção do medicamento no gestor de medicamentos
                         */
                        gf.addFamiliar(f);
                        cnt++;
                    }
                    System.out.println("OBJECTO: " + cnt);
                    /*
                    Scanner sc = new Scanner(System.in);
                    System.out.println("GET CHAR");
                    String l = sc.nextLine();
*/
                }
            } while (line != null && cnt < 100000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
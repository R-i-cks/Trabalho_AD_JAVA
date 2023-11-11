package app;


import Objetos.Profissional;

public class ProfissionaisRMIClient {

    public static void main(String[] args) {


        GestaoUtentesInterface gu = null;
        try {
            gpro = (GestaoProfissionaisInterface) Naming.lookup("rmi://localhost:8001/GM");
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
                    new FileReader("../Dados/profissionais.csv"));
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
            do{
                line = br.readLine();
                if (line != null) {
                    /**
                     * Separação da linha em partes separadas por ";"
                     */
                    String[] columns = line.split(";");
                    if (columns.length != 0){
                        //Medicamento M = new Medicamento(columns);
                        /**
                         * Criação do objeto medicamento
                         */
                        Profissional pro =  new Profissional();
                        /**
                         * Preenchimento dos atributos (variáveis de instância do medicamento)
                         */
                        pro.setId(columns[0]);
                        pro.setType(columns[1]);
                        pro.setNome(columns[2]);
                        pro.setContacto(columns[3]);
                        pro.setEspecialidade(columns[4]);

                        /**
                         * Inserção do medicamento no gestor de medicamentos
                         */
                        gpro.addProfissional(pro);
                        cnt ++;
                    }
                    System.out.println("OBJECTO: "+ cnt);
                    /*
                    Scanner sc = new Scanner(System.in);
                    System.out.println("GET CHAR");
                    String l = sc.nextLine();
*/
                }
            }while (line != null && cnt <100000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
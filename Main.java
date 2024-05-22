import java.util.Scanner;

public class Main {
    private static final Utilidades utilidades = new Utilidades();
    private static final Scanner scanner = new Scanner(System.in);


    // MENU
    private static void exibirMenu(){
        System.out.println("""
            \n
            |=============== Menu ===============|
            |        Escolha uma opção:          |
            |  1 - Cadastrar um Veículo          |
            |  2 - Listar Veículos               |
            |  3 - Buscar Veículo pela placa     |
            |  4 - Remover Veículo               |
            |  0 - Sair                          |
            |====================================|
            \n""");
    }

    // ADD CARRO
    private static void adicionarVeiculo(){
        System.out.println("\n=== Adicionar Veículo ===");
        System.out.print("Digite o tipo do seu veículo (Carro/Moto...): ");
        String tipo = scanner.nextLine();

        System.out.print("Digite a marca do veículo: ");
        String marca = scanner.nextLine();

        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();

        System.out.print("Digite o ano do veículo: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o número de portas: ");
        int numeroPortas = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        
        // add veiculo
        Carro novCarro = new Carro(tipo, marca, modelo, ano, numeroPortas, placa);
        // Verificação
        try {
            utilidades.adicionarVeiculo(novCarro);
            System.out.println();
            System.out.println("Veículo adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println();
            System.out.println("Erro ao adicionar veículo: " + e.getMessage());
        }
    }


    // DEL VEÍCULO
    private static void removerVeiculo(){
        System.out.println("\n=== Remover Veículo ===");
        System.out.print("Digite a placa do veículo que deseja remover: ");
        String placa = scanner.nextLine();

        // Verificação
        try{
            Carro carroEncontrado = utilidades.buscarCarro(placa);
            if (carroEncontrado != null){
                utilidades.removerVeiculo(carroEncontrado);
                System.out.println("Veículo removido com sucesso!");
            } else {
                System.out.println();
                throw new Exception("Veículo com placa " + placa + " não foi encontrado.");
            }
        } catch (Exception e){
            System.out.println("Erro ao remover veículo: " + e.getMessage());
        }
    }

    // BUSCAR VEÍCULO
    private static void buscarCarro(){
        System.out.println("\n=== Buscar Veículo ===");
        System.out.print("Digite a placa a do veículo a ser buscado: ");
        String placa = scanner.nextLine();
        System.out.println();

        // Verificação
        try{
            Carro carroEncontrado = utilidades.buscarCarro(placa);
            if(carroEncontrado != null){
                System.out.println("Veículo encontrado: \n" + carroEncontrado);
            } else{
                throw new Exception("Veículo com placa " + placa + " não foi encontrado.");
            }
        } catch (Exception e){
            System.out.println("Erro ao buscar veículo: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        while(true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    adicionarVeiculo();
                    break;
                case 2:
                    utilidades.listaVeiculo();
                    break;
                case 3:
                    buscarCarro();
                    break;
                case 4:
                    removerVeiculo();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

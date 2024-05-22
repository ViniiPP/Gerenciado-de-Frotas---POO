import java.util.Scanner;

public class Main {
    private static final Utilidades utilidades = new Utilidades();
    private static final Scanner scanner = new Scanner(System.in);

    private static void exibirMenu() {
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

    private static void adicionarVeiculo() {
        System.out.println("\n=== Adicionar Veículo ===");
        System.out.println("Escolha o tipo de veículo:");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        int tipoVeiculo = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        if (tipoVeiculo != 1 && tipoVeiculo != 2) {
            System.out.println("Erro ao selecionar opção: selecione 1 para Carro ou 2 para Moto.");
            return;
        }

        System.out.print("Digite a marca do veículo: ");
        String marca = scanner.nextLine();

        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();

        System.out.print("Digite o ano do veículo: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();

        Veiculo novoVeiculo = null;
        switch (tipoVeiculo) {
            case 1 -> {
                System.out.print("Digite o número de portas: ");
                int numeroPortas = scanner.nextInt();
                scanner.nextLine();
                novoVeiculo = new Carro(marca, modelo, ano, placa, numeroPortas);
            }
            case 2 -> novoVeiculo = new Moto(marca, modelo, ano, placa);
            default -> {
                System.out.println("Tipo de veículo inválido.");
                return;
            }
        }

        try {
            utilidades.adicionarVeiculo(novoVeiculo);
            System.out.println();
            System.out.println("Veículo adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println();
            System.out.println("Erro ao adicionar veículo: " + e.getMessage());
        }
    }

    private static void removerVeiculo() {
        System.out.println("\n=== Remover Veículo ===");
        System.out.print("Digite a placa do veículo que deseja remover: ");
        String placa = scanner.nextLine();

        try {
            Veiculo veiculoEncontrado = utilidades.buscarCarro(placa);
            if (veiculoEncontrado != null) {
                utilidades.removerVeiculo(veiculoEncontrado);
                System.out.println();
                System.out.println("Veículo removido com sucesso!");
            } else {
                System.out.println();
                throw new Exception("Veículo com placa " + placa + " não foi encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao remover veículo: " + e.getMessage());
        }
    }

    private static void buscarCarro() {
        System.out.println("\n=== Buscar Veículo ===");
        System.out.print("Digite a placa do veículo a ser buscado: ");
        String placa = scanner.nextLine();
        System.out.println();

        try {
            Veiculo veiculoEncontrado = utilidades.buscarCarro(placa);
            if (veiculoEncontrado != null) {
                System.out.println("Veículo encontrado: \n" + veiculoEncontrado);
            } else {
                throw new Exception("Veículo com placa " + placa + " não foi encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar veículo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarVeiculo();
                case 2 -> utilidades.listaVeiculo();
                case 3 -> buscarCarro();
                case 4 -> removerVeiculo();
                case 0 -> {
                    System.out.println("Encerrando o programa.");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}

package Views;

import DataBase.Dados;
import Models.Carro;
import java.util.Scanner;

public class UsuarioMenu {

    public static void exibirMenu(Scanner scanner) {
        while (true) {
            System.out.println("--- Menu Principal ---\n");
            System.out.println("1 - Cadastrar Carro");
            System.out.println("2 - Comprar Carro");
            System.out.println("3 - Listar Carros");
            System.out.println("4 - Logout");
            System.out.print("Sua Escolha: ");

            int decisao = Integer.parseInt(scanner.nextLine());

            switch (decisao) {
                case 1:
                    cadastrarCarro(scanner);
                    break;
                case 2:
                    comprarCarro(scanner);
                    break;
                case 3:
                    listarCarros();
                    break;
                case 4:
                    System.out.println("Fazendo logout...");
                    Dados.setUsuarioLogado(null);
                    LoginView.exibirMenuInicial(scanner);
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void cadastrarCarro(Scanner scanner) {
        System.out.print("ID do carro: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Modelo do carro: ");
        String modelo = scanner.nextLine();
        System.out.print("Preço do carro: ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Quilometragem do carro: ");
        int quilometragem = Integer.parseInt(scanner.nextLine());
        System.out.print("Marca do carro: ");
        String marca = scanner.nextLine();

        Carro carro = new Carro();
        carro.setId(id);
        carro.setModelo(modelo);
        carro.setPreco(preco);
        carro.setQuilometragem(quilometragem);
        carro.setMarca(marca);

        Dados.adicionarCarro(carro);
        System.out.println("Carro cadastrado com sucesso!");
    }

    private static void comprarCarro(Scanner scanner) {
        System.out.print("ID do carro que deseja comprar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Carro carro = encontrarCarroPorId(id);

        if (carro != null) {
            System.out.println("Pedido separado com sucesso! Aguardando pagamento.");
            Dados.getCarros().remove(carro);
        } else {
            System.out.println("Carro não encontrado.");
        }
    }

    private static Carro encontrarCarroPorId(int id) {
        for (Carro carro : Dados.getCarros()) {
            if (carro.getId() == id) {
                return carro;
            }
        }
        return null;
    }

    private static void listarCarros() {
        if (Dados.getCarros().isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
        } else {
            for (Carro carro : Dados.getCarros()) {
                System.out.println(carro.toString());
                System.out.println("-------------------------");
            }
        }
    }
}
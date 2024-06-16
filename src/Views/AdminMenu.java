package Views;

import DataBase.Dados;
import Models.Usuarios;
import java.util.Scanner;

public class AdminMenu {

    public static void exibirMenu(Scanner scanner) {
        while (true) {
            System.out.println("--- Menu Administrador ---\n");
            System.out.println("1 - Listar Usuários");
            System.out.println("2 - Alterar Usuário");
            System.out.println("3 - Excluir Usuário");
            System.out.println("4 - Logout");
            System.out.print("Sua Escolha: ");

            int decisao = Integer.parseInt(scanner.nextLine());

            switch (decisao) {
                case 1:
                    listarUsuarios();
                    break;
                case 2:
                    alterarUsuario(scanner);
                    break;
                case 3:
                    excluirUsuario(scanner);
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

    private static void listarUsuarios() {
        System.out.println("Listagem de usuários:");
        for (Usuarios usuario : Dados.getUsuarios()) {
            System.out.println(usuario.toString());
        }
    }

    private static void alterarUsuario(Scanner scanner) {
        System.out.print("Digite o email do usuário que deseja alterar: ");
        String email = scanner.nextLine();
        Usuarios usuario = Dados.encontrarUsuarioPorEmail(email);

        if (usuario != null) {
            System.out.print("Novo nome: ");
            usuario.setNome(scanner.nextLine());
            System.out.print("Nova senha: ");
            usuario.setSenha(scanner.nextLine());
            System.out.println("Usuário alterado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    private static void excluirUsuario(Scanner scanner) {
        System.out.print("Digite o email do usuário que deseja excluir: ");
        String email = scanner.nextLine();
        Usuarios usuario = Dados.encontrarUsuarioPorEmail(email);

        if (usuario != null) {
            Dados.removerUsuario(usuario);
            System.out.println("Usuário excluído com sucesso!");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}
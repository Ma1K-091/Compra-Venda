package Views;

import DataBase.Dados;
import Models.Usuarios;
import Models.Administrador;
import Models.Comprador;
import Models.Vendedor;

import java.util.Scanner;

public class LoginView {

    public static void exibirMenuInicial(Scanner scanner) {
        while (true) {
            System.out.println("--- Sistema de Compra/Venda de Carros ---\n");
            System.out.println("1 - Fazer Login");
            System.out.println("2 - Cadastrar");
            System.out.print("Sua Escolha: ");

            int escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    realizarLogin(scanner);
                    return;
                case 2:
                    cadastrarUsuario(scanner);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void realizarLogin(Scanner scanner) {
        System.out.println("--- LOGIN USUÁRIO ---\n");
        System.out.print("Login: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuarios usuario = validarLogin(email, senha);

        while (usuario == null) {
            System.out.println("Login ou senha incorreto");
            System.out.print("Login: ");
            email = scanner.nextLine();
            System.out.print("Senha: ");
            senha = scanner.nextLine();
            usuario = validarLogin(email, senha);
        }

        Dados.setUsuarioLogado(usuario);
        System.out.println("Logado com sucesso!");

        if (usuario instanceof Administrador) {
            AdminMenu.exibirMenu(scanner);
        } else {
            UsuarioMenu.exibirMenu(scanner);
        }
    }

    private static Usuarios validarLogin(String email, String senha) {
        for (Usuarios usuario : Dados.getUsuarios()) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    private static void cadastrarUsuario(Scanner scanner) {
        System.out.println("--- CADASTRO DE USUÁRIO ---\n");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.println("Tipo de Usuário: 1 - Comprador, 2 - Vendedor");
        int tipo = Integer.parseInt(scanner.nextLine());

        Usuarios novoUsuario;
        if (tipo == 1) {
            novoUsuario = new Comprador();
        } else {
            novoUsuario = new Vendedor();
        }

        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setSenha(senha);

        Dados.adicionarUsuario(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }
}
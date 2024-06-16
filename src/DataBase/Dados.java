package DataBase;

import Models.*;

import java.util.ArrayList;

public class Dados {
    private static Usuarios usuarioLogado = null;
    private static ArrayList<Usuarios> usuarios = new ArrayList<>();
    private static ArrayList<Carro> carros = new ArrayList<>();

    public static ArrayList<Usuarios> getUsuarios() {
        if (usuarios.isEmpty()) {
            padrao();
        }
        return usuarios;
    }

    public static Usuarios getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuarios usuarioLogado) {
        Dados.usuarioLogado = usuarioLogado;
    }

    public static void adicionarUsuario(Usuarios usuario) {
        usuarios.add(usuario);
    }

    public static Usuarios encontrarUsuarioPorEmail(String email) {
        for (Usuarios usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public static void removerUsuario(Usuarios usuario) {
        usuarios.remove(usuario);
    }

    public static ArrayList<Carro> getCarros() {
        return carros;
    }

    public static void adicionarCarro(Carro carro) {
        carros.add(carro);
    }

    private static void padrao() {
        Administrador adm = new Administrador();
        adm.setNome("Admin");
        adm.setEmail("adm");
        adm.setSenha("adm");
        usuarios.add(adm);

        Comprador com = new Comprador();
        com.setNome("Carlos");
        com.setEmail("c");
        com.setSenha("c");
        usuarios.add(com);

        Vendedor ven = new Vendedor();
        ven.setNome("Ana");
        ven.setEmail("a");
        ven.setSenha("a");
        usuarios.add(ven);
    }
}
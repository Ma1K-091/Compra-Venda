package Services;
import DataBase.Dados;
import Models.Comprador;
import Models.Usuarios;
import Models.Vendedor;

public class UsuarioService {

    public static Usuarios validarLogin(String email, String senha) {
        for (Usuarios usuario : Dados.getUsuarios()) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    public static boolean registrarUsuario(String nome, String email, String senha, String tipoUsuario) {
        Usuarios novoUsuario = null;

        switch (tipoUsuario.toLowerCase()) {
            case "comprador":
                novoUsuario = new Comprador();
                break;
            case "vendedor":
                novoUsuario = new Vendedor();
                break;
            default:
                return false;
        }

        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setSenha(senha);

        Dados.adicionarUsuario(novoUsuario);
        return true;
    }
}
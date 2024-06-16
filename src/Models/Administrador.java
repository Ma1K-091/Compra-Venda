package Models;

public class Administrador extends Usuarios {
    private boolean primeiroLogin = true;

    public boolean isPrimeiroLogin() {
        return primeiroLogin;
    }

    public void setPrimeiroLogin(boolean primeiroLogin) {
        this.primeiroLogin = primeiroLogin;
    }
}
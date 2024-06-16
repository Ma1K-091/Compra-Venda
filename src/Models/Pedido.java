package Models;

public class Pedido {
    private Carro carro;
    private Usuarios comprador;

    public Pedido(Carro carro, Usuarios comprador) {
        this.carro = carro;
        this.comprador = comprador;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Usuarios getComprador() {
        return comprador;
    }

    public void setComprador(Usuarios comprador) {
        this.comprador = comprador;
    }

    @Override
    public String toString() {
        return "Pedido: " +
                "Carro [ID=" + carro.getId() + ", Modelo=" + carro.getModelo() + ", Preço= R$" + carro.getPreco() + "]" +
                ", Comprador=" + comprador.getNome();
    }
}
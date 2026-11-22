abstract class Veiculo {
    protected String modelo;
    protected double velocidadeAtual;

    public Veiculo(String modelo) {
        this.modelo = modelo;
        this.velocidadeAtual = 0;
    }

    public abstract void acelerar();

    public String getModelo() { return modelo; }
    public double getVelocidadeAtual() { return velocidadeAtual; }
}

interface Eletrico {
    void carregarBateria();
}

class Carro extends Veiculo {
    public Carro(String modelo) { super(modelo); }

    @Override
    public void acelerar() { velocidadeAtual += 10; }
}

class CarroEletrico extends Veiculo implements Eletrico {
    public CarroEletrico(String modelo) { super(modelo); }

    @Override
    public void acelerar() { velocidadeAtual += 15; }

    @Override
    public void carregarBateria() {
        System.out.println(modelo + ": bateria sendo carregada...");
    }
}

public class Questao06 {
    public static void main(String[] args) {
        Carro carro = new Carro("Gol");
        CarroEletrico eletrico = new CarroEletrico("Dolphin");

        carro.acelerar();
        carro.acelerar();
        System.out.println(carro.getModelo() + ": " + carro.getVelocidadeAtual() + " km/h");

        eletrico.acelerar();
        eletrico.acelerar();
        eletrico.carregarBateria();
        System.out.println(eletrico.getModelo() + ": " + eletrico.getVelocidadeAtual() + " km/h");
    }
}

interface Ligavel {
    void ligar();
    void desligar();
}

interface Conectavel {
    void conectarInternet();
}

class Televisao implements Ligavel {
    public void ligar() { System.out.println("Televisao ligada."); }
    public void desligar() { System.out.println("Televisao desligada."); }
}

class Roteador implements Ligavel, Conectavel {
    public void ligar() { System.out.println("Roteador ligado."); }
    public void desligar() { System.out.println("Roteador desligado."); }
    public void conectarInternet() { System.out.println("Roteador conectado a internet."); }
}

class Computador implements Ligavel, Conectavel {
    public void ligar() { System.out.println("Computador ligado."); }
    public void desligar() { System.out.println("Computador desligado."); }
    public void conectarInternet() { System.out.println("Computador conectado a internet."); }
}

public class Questao05 {
    /*
     * Por que uma classe pode implementar varias interfaces?
     * Em Java, uma classe so pode herdar de UMA superclasse (heranca simples),
     * o que evita o "problema do diamante" (ambiguidade ao herdar estado e
     * implementacao de varias classes). Interfaces, por outro lado, definem apenas
     * contratos (assinaturas de metodos), sem estado de instancia. Por isso nao ha
     * ambiguidade: a classe simplesmente se compromete a implementar todos os
     * metodos de cada contrato. Isso permite compor capacidades independentes
     * (ex.: Ligavel + Conectavel) e tratar o objeto polimorficamente por qualquer
     * uma das interfaces que ele implementa.
     */
    public static void main(String[] args) {
        Televisao tv = new Televisao();
        Roteador roteador = new Roteador();
        Computador pc = new Computador();

        tv.ligar();
        tv.desligar();

        roteador.ligar();
        roteador.conectarInternet();
        roteador.desligar();

        pc.ligar();
        pc.conectarInternet();
        pc.desligar();
    }
}

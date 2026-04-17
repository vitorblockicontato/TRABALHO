import java.util.ArrayList;

// ---------------------------------------------------------
// Classe abstrata Moeda (classe mãe)
// ---------------------------------------------------------
abstract class Moeda {
    protected double valor;

    public Moeda(double valor) {
        this.valor = valor;
    }

    // Exibe informações da moeda
    public abstract void info();

    // Converte para Real
    public abstract double converter();
}

// ---------------------------------------------------------
// Classe Dólar
// ---------------------------------------------------------
class Dolar extends Moeda {

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Dólar - Valor: " + this.valor);
    }

    @Override
    public double converter() {
        return this.valor * 5.20; // Cotação exemplo
    }
}

// ---------------------------------------------------------
// Classe Euro
// ---------------------------------------------------------
class Euro extends Moeda {

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Euro - Valor: " + this.valor);
    }

    @Override
    public double converter() {
        return this.valor * 5.60; // Cotação exemplo
    }
}

// ---------------------------------------------------------
// Classe Real
// ---------------------------------------------------------
class Real extends Moeda {

    public Real(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Real - Valor: " + this.valor);
    }

    @Override
    public double converter() {
        return this.valor; // Real já está em Real
    }
}

// ---------------------------------------------------------
// Classe Cofrinho
// ---------------------------------------------------------
class Cofrinho {

    private ArrayList<Moeda> listaMoedas = new ArrayList<>();

    // Adiciona moeda ao cofrinho
    public void adicionar(Moeda moeda) {
        listaMoedas.add(moeda);
    }

    // Remove moeda do cofrinho
    public void remover(Moeda moeda) {
        listaMoedas.remove(moeda);
    }

    // Lista todas as moedas
    public void listarMoedas() {
        for (Moeda m : listaMoedas) {
            m.info();
        }
    }

    // Soma tudo convertido para Real
    public double totalConvertido() {
        double soma = 0;
        for (Moeda m : listaMoedas) {
            soma += m.converter();
        }
        return soma;
    }
}

// ---------------------------------------------------------
// Classe Principal (main)
// ---------------------------------------------------------
public class Principal {
    public static void main(String[] args) {

        Cofrinho cofrinho = new Cofrinho();

        // Adiciona algumas moedas de exemplo
        cofrinho.adicionar(new Dolar(10));
        cofrinho.adicionar(new Euro(5));
        cofrinho.adicionar(new Real(20));

        System.out.println("Moedas dentro do cofrinho:");
        cofrinho.listarMoedas();

        System.out.println("\nTotal convertido para Real: R$ " + cofrinho.totalConvertido());
    }
}

package extracaodevariaveis;

/**
 * EXERCÍCIO: Extração de Variáveis
 * 
 * PROBLEMA: A expressão no return é complexa e difícil de entender.
 * 
 * TAREFA: Extraia partes da expressão em variáveis com nomes descritivos.
 * 
 * DICA: Variáveis extraídas tornam o código mais legível e facilitam a depuração.
 */
public class CalculadoraPreco {
    
    public double calcularPrecoFinal(double precoBase, int quantidade, double taxaImposto) {
        return precoBase * quantidade * (1 + taxaImposto) - (precoBase * quantidade * 0.1) + 5.0;
    }
    
    public boolean podeAplicarDesconto(double preco, int quantidade, boolean clienteVIP) {
        return (preco > 100 && quantidade > 5) || (clienteVIP && preco > 50);
    }
}


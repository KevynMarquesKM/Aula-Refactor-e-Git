package substituicaodecondicionalporpolimorfismo;

/**
 * Implementação para Pessoa Física - imposto de 10%
 */
public class PessoaFisica extends Contribuinte {
    
    @Override
    public double calcularImposto(double valor) {
        return valor * 0.10;
    }
}


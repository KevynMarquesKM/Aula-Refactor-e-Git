package substituicaodecondicionalporpolimorfismo;

/**
 * Implementação para Pessoa Jurídica - imposto de 15%
 */
public class PessoaJuridica extends Contribuinte {
    
    @Override
    public double calcularImposto(double valor) {
        return valor * 0.15;
    }
}


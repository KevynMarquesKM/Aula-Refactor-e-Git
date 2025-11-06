package substituicaodecondicionalporpolimorfismo;

/**
 * Implementação para outros tipos - imposto de 20%
 */
public class OutroTipo extends Contribuinte {
    
    @Override
    public double calcularImposto(double valor) {
        return valor * 0.20;
    }
}


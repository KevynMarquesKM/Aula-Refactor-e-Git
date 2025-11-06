package substituicaodecondicionalporpolimorfismo;

/**
 * Implementação para MEI - imposto de 5%
 */
public class MEI extends Contribuinte {
    
    @Override
    public double calcularImposto(double valor) {
        return valor * 0.05;
    }
}


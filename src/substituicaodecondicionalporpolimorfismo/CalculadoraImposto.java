package substituicaodecondicionalporpolimorfismo;

/**
 * EXERCÍCIO: Substituição de Condicional por Polimorfismo
 * 
 * PROBLEMA: O método calcularImposto() usa uma cadeia de if-else baseada no tipo.
 * 
 * TAREFA: Substitua o condicional por polimorfismo criando uma hierarquia de classes.
 * 
 * DICA: Use herança e polimorfismo para eliminar condicionais baseados em tipo.
 */
public class CalculadoraImposto {
    
    public double calcularImposto(String tipo, double valor) {
        if (tipo.equals("PESSOA_FISICA")) {
            return valor * 0.10;
        } else if (tipo.equals("PESSOA_JURIDICA")) {
            return valor * 0.15;
        } else if (tipo.equals("MEI")) {
            return valor * 0.05;
        } else {
            return valor * 0.20;
        }
    }
}


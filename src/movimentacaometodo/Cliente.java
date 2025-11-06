package movimentacaometodo;

/**
 * EXERCÍCIO: Movimentação de Método
 * 
 * PROBLEMA: O método calcularDesconto() está na classe Cliente, mas usa principalmente
 * dados da classe Pedido. Ele deveria estar na classe Pedido.
 * 
 * TAREFA: Mova o método calcularDesconto() da classe Cliente para a classe Pedido.
 * 
 * DICA: Um método deve estar na classe que contém a maioria dos dados que ele usa.
 */
public class Cliente {
    private String nome;
    private Pedido pedido;
    
    public Cliente(String nome, Pedido pedido) {
        this.nome = nome;
        this.pedido = pedido;
    }
    
    public String getNome() {
        return nome;
    }

    // Este método deveria estar na classe Pedido
    public double calcularDesconto() {
        if (pedido.getValorTotal() > 1000) {
            return pedido.getValorTotal() * 0.10;
        } else if (pedido.getValorTotal() > 500) {
            return pedido.getValorTotal() * 0.05;
        }
        return 0;
    }
}


package renomeacao;

/**
 * EXERCÍCIO: Renomeação
 * 
 * PROBLEMA: Os nomes das variáveis e métodos não são claros e não expressam bem sua intenção.
 * 
 * TAREFA: Renomeie as variáveis e métodos para nomes mais descritivos e expressivos.
 * 
 * DICA: Nomes devem revelar a intenção do código. Evite abreviações e nomes genéricos.
 */
public class Processador {
    
    public void proc(String txt, int n) {
        String r = "";
        for (int i = 0; i < n; i++) {
            r = r + txt;
        }
        System.out.println(r);
    }
    
    public int calc(int a, int b) {
        return a * b + a + b;
    }
}


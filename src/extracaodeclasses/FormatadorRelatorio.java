package extracaodeclasses;

/**
 * SOLUÇÃO: Extração de Classes
 * 
 * Classe extraída para encapsular toda a lógica de formatação do relatório.
 */
public class FormatadorRelatorio {
    
    public void formatarTitulo(String titulo) {
        String tituloFormatado = "=== " + titulo.toUpperCase() + " ===";
        System.out.println(tituloFormatado);
    }
    
    public void formatarConteudo(String conteudo) {
        String conteudoFormatado = "  " + conteudo.replace("\n", "\n  ");
        System.out.println(conteudoFormatado);
    }
    
    public void formatarRodape(String rodape) {
        String rodapeFormatado = "--- " + rodape + " ---";
        System.out.println(rodapeFormatado);
    }
}


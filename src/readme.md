### Code Smell

- Condicionais Aninhadas: Um último problema que identifiquei foi o de condicionais aninhadas, que pode ser descrito como o code smell de repetição de código talvez, ou de obssessão por tipos primitivos. Escolhi resolver parte desse problema por não exigir uma refatoração muito "agressiva", pois tentei desde o início não realizar uma fatoração que alterasse completamente a lógica e estrutura do código (como remover as responsabilidade das classe GildedRose para Item por exemplo).
- 
### Solução

- Redução de Condicionais + Inline de Método: A solução utilizada foi a redução de condicionais por variáveis de guarda e, com isso, conseguimos também aplicar inline de método nas funções auxiliares que continham toda sua lógica em apenas 1 linha, a fim de melhorar a legibilidade e entendimento do que está acontecendo no programa. Bastou adicionar algumas variáveis capazes de definir com maior clareza o que o programa realiza de acordo com cada sinal positivo de comparação e, com isso, também conseguimos remover as funções auxiliares que de certa forma poluíam o código. 
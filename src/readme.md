### Code Smell

- Obsessão por Tipos Primitivos: O método updateQuality() possui muitas verificações de tipos primitivos, como nomes, o que dificulta sua legibilidade e compreensão, o que consequentemente gera maior custo de manutenção e evolução de código.

### Solução

- Remoção de Flags: A solução utilizada foi a remoção de flags, a fim de melhorar a legibilidade e entendimento do que está acontecendo no programa. Para isso, criamos algumas funções utilitárias que fazem o mesmo papel das comparações presentes em código.
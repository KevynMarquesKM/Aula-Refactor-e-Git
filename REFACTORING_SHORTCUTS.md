# Guia de Refatoração no IntelliJ IDEA

Lista os atalhos e recursos automatizados do IntelliJ IDEA para realizar cada técnica de refatoração presente nos exercícios.

## 1. Extração de Método

**Atalho:** `Ctrl+Alt+M` (Windows/Linux) ou `Cmd+Alt+M` (macOS)

**Como usar:**
1. Selecione o bloco de código que deseja extrair
2. Pressione `Ctrl+Alt+M` (ou `Cmd+Alt+M` no macOS)
3. Digite o nome do novo método
4. Escolha os parâmetros que serão passados
5. Escolha se o método será `private`, `public`, etc.
6. Pressione `Enter` para confirmar

**Menu:** `Refactor` → `Extract` → `Method...`

**Localização do exercício:** `src/extracaometodo/Calculadora.java`

---

## 2. Inline de Método

**Atalho:** `Ctrl+Alt+N` (Windows/Linux) ou `Cmd+Alt+N` (macOS)

**Como usar:**
1. Posicione o cursor no método que deseja fazer inline
2. Pressione `Ctrl+Alt+N` (ou `Cmd+Alt+N` no macOS)
3. Escolha as opções:
   - Inline todas as ocorrências
   - Inline apenas esta ocorrência
4. Pressione `Enter` para confirmar

**Menu:** `Refactor` → `Inline...`

**Localização do exercício:** `src/inlinedemetodo/ProcessadorTexto.java`

---

## 3. Movimentação de Método

**Atalho:** `F6` (Move)

**Como usar:**
1. Posicione o cursor no método que deseja mover
2. Pressione `F6`
3. Selecione a classe de destino
4. Escolha se deseja mover apenas o método ou também atualizar referências
5. Pressione `Enter` para confirmar

**Menu:** `Refactor` → `Move...`

**Localização do exercício:** `src/movimentacaometodo/Cliente.java`

---

## 4. Extração de Classes

**Atalho:** Não há atalho direto, mas pode usar o assistente de refatoração

**Como usar:**
1. Selecione os campos e métodos que deseja extrair
2. Pressione `Ctrl+Alt+Shift+T` (ou `Ctrl+T` no macOS) para abrir o menu de refatoração
3. Escolha `Extract Class...`
4. Ou vá em `Refactor` → `Extract` → `Class...`
5. Digite o nome da nova classe
6. Escolha quais campos e métodos mover
7. Pressione `Enter` para confirmar

**Menu:** `Refactor` → `Extract` → `Class...`

**Localização do exercício:** `src/extracaodeclasses/Relatorio.java`

---

## 5. Renomeação

**Atalho:** `Shift+F6` (Rename)

**Como usar:**
1. Posicione o cursor no elemento que deseja renomear (variável, método, classe, etc.)
2. Pressione `Shift+F6`
3. Digite o novo nome
4. Escolha o escopo da renomeação:
   - Apenas esta ocorrência
   - Todo o arquivo
   - Todo o projeto
5. Pressione `Enter` para confirmar

**Menu:** `Refactor` → `Rename...`

**Localização do exercício:** `src/renomeacao/Processador.java`

**Dica:** O IntelliJ IDEA renomeia automaticamente todas as referências ao elemento!

---

## 6. Extração de Variáveis

**Atalho:** `Ctrl+Alt+V` (Windows/Linux) ou `Cmd+Alt+V` (macOS)

**Como usar:**
1. Selecione a expressão que deseja extrair em uma variável
2. Pressione `Ctrl+Alt+V` (ou `Cmd+Alt+V` no macOS)
3. Digite o nome da variável
4. Escolha se a variável será `final`
5. Pressione `Enter` para confirmar

**Menu:** `Refactor` → `Extract` → `Variable...`

**Localização do exercício:** `src/extracaodevariaveis/CalculadoraPreco.java`

**Dica:** Funciona também para extrair constantes com `Ctrl+Alt+C` (ou `Cmd+Alt+C` no macOS)

---

## 7. Remoção de Flags

**Atalho:** Não há atalho direto, mas pode usar múltiplas refatorações

**Como usar:**
1. Use **Extração de Método** (`Ctrl+Alt+M`) para cada branch do `if`
2. Ou use **Substituição de Condicional por Polimorfismo** (veja seção 8)
3. Remova o método original com a flag

**Menu:** Combine `Refactor` → `Extract` → `Method...` múltiplas vezes

**Localização do exercício:** `src/remocaodeflags/ProcessadorPedido.java`

**Dica:** O IntelliJ pode sugerir automaticamente a extração de métodos quando detecta padrões.

---

## 8. Substituição de Condicional por Polimorfismo

**Atalho:** `Ctrl+Alt+Shift+T` (Windows/Linux) ou `Ctrl+T` (macOS) - Menu de Refatoração

**Como usar (método manual):**
1. Crie a classe base abstrata ou interface
2. Use **Extração de Método** (`Ctrl+Alt+M`) no método com condicionais
3. Crie as subclasses
4. Use **Mover Método** (`F6`) se necessário
5. Substitua os condicionais por chamadas polimórficas

**Como usar (com Replace Inheritance with Delegation):**
1. Selecione o código condicional
2. Pressione `Ctrl+Alt+Shift+T` (ou `Ctrl+T` no macOS)
3. Escolha a refatoração apropriada
4. Ou use `Refactor` → `Replace Inheritance with Delegation...`

**Menu:** `Refactor` → (várias opções disponíveis)

**Localização do exercício:** `src/substituicaodecondicionalporpolimorfismo/CalculadoraImposto.java`

**Dica:** O IntelliJ pode sugerir criar classes quando detecta padrões de type checking.

---

## 9. Remoção de Código Morto

**Atalho:** Vários atalhos úteis

### Remover código não utilizado:

**Remover import não usado:**
- `Ctrl+Alt+O` (Windows/Linux) ou `Cmd+Alt+O` (macOS) - Otimizar imports

**Remover variável não usada:**
1. Posicione o cursor na variável
2. Pressione `Alt+Enter` para abrir quick fixes
3. Escolha "Remove unused variable"

**Remover método não usado:**
1. Posicione o cursor no método
2. Pressione `Alt+Enter`
3. Escolha "Remove unused method"

**Remover código comentado:**
- Selecione e delete manualmente, ou use `Ctrl+Shift+/` para descomentar primeiro
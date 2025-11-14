### Code Smell

- Métodos Longos: O método updateQuality() é muito longo, o que sugere que ele possa ser quebrado em outros métodos, a fim de delegar responsabilidades e isolar papéis, já que métodos extensos dificultam o entendimento, manutenção e evolução do código.

### Solução

- Extração de Métodos: A solução utilizada foi a extração de métodos, permitindo dividir o método updateQuality() em partes menores, melhorando a legibilidade e facilitando futuras modificações.

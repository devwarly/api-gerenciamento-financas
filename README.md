💰 API de Gerenciamento de Finanças Multimoedas
Uma API REST robusta desenvolvida com Spring Boot para o controle de despesas internacionais. O sistema automatiza a conversão de moedas estrangeiras para Real (BRL) consumindo cotações em tempo real de uma API externa.

🚀 Funcionalidades
Cadastro de Transações: Registra gastos informando apenas a moeda original (USD, EUR, etc.) e o valor.

Conversão Automática: Integração com a AwesomeAPI para obter a taxa de câmbio atualizada no momento da compra.

Cálculo Financeiro: Processamento automático do valor convertido para BRL utilizando BigDecimal para precisão decimal.

Histórico de Gastos: Listagem completa de todas as transações armazenadas com data, taxa de câmbio aplicada e valores.

🛠️ Tecnologias e Ferramentas
Java 17+

Spring Boot 3.4.x

Spring Data JPA: Abstração de persistência e manipulação de banco de dados.

Spring Cloud OpenFeign: Cliente HTTP declarativo para consumo de APIs externas.

H2 Database: Banco de dados em memória para agilidade no desenvolvimento e testes.

Lombok: Otimização de código (Getters, Setters, Construtores).

Jackson: Serialização e desserialização de objetos JSON.

🏗️ Arquitetura e Padrões
O projeto foi desenhado seguindo as melhores práticas de mercado:

Controller Layer: Exposição dos endpoints REST e tratamento de requisições HTTP.

Service Layer: Camada de regras de negócio, onde ocorrem os cálculos de conversão e orquestração.

Client Layer (Feign): Isolamento da comunicação com serviços externos.

DTO Pattern: Uso de Data Transfer Objects para garantir a integridade dos dados e desacoplamento da API externa.

Externalized Configuration: Configurações de ambiente (URLs, logs) centralizadas no application.properties.

📖 Como Executar o Projeto
Clone o repositório:

Bash
git clone https://github.com/seu-usuario/gerenciador-financas.git
Importe no IntelliJ IDEA (ou sua IDE de preferência) como um projeto Maven.

Execute a aplicação através da classe GerenciadorDeFinancasApplication.

🕹️ Testando a API
1. Criar Nova Transação
   Endpoint: POST /api/transacoes

Payload (JSON):

JSON
{
"description": "Hospedagem em Nova York",
"originalValue": 150.00,
"currency": "USD"
}
2. Listar Todas as Transações
   Endpoint: GET /api/transacoes

Resposta: Retorna a lista de transações com o convertedValue e conversionRate preenchidos automaticamente.

🔍 Monitoramento e Logs
A aplicação está configurada para exibir logs detalhados das chamadas externas no console. Isso permite visualizar a requisição enviada para a AwesomeAPI e o JSON de resposta em tempo real, facilitando o debug e auditoria dos dados de câmbio.


---

Desenvolvido por Warly Martins🧑‍💻
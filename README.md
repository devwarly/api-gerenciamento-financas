# 💰 API de Gerenciamento de Finanças Multimoedas

Uma API REST robusta e eficiente desenvolvida com **Spring Boot** para o controle e gestão de despesas internacionais. O sistema automatiza a conversão de moedas estrangeiras (USD, EUR, etc.) para Real (BRL) consumindo cotações em tempo real de uma API externa.

---

## 🚀 Funcionalidades

* **Cadastro de Transações:** Registra gastos informando a descrição, o valor original e a moeda de origem.
* **Conversão Automática:** Integração nativa com a **AwesomeAPI** para obter a taxa de câmbio (`bid`) atualizada no exato momento da operação.
* **Cálculo Financeiro de Precisão:** Processamento automático do valor convertido para BRL utilizando `BigDecimal`, garantindo a integridade dos centavos e evitando erros de arredondamento.
* **Histórico de Gastos:** Listagem completa de todas as transações armazenadas, incluindo data, taxa de câmbio aplicada e valor final convertido.

---

## 🛠️ Tecnologias e Ferramentas

* **Java 17+**
* **Spring Boot 3.4.x**
* **Spring Data JPA:** Abstração de persistência e manipulação simplificada do banco de dados.
* **Spring Cloud OpenFeign:** Cliente HTTP declarativo para consumo simplificado de APIs externas.
* **H2 Database:** Banco de dados em memória para agilidade no ciclo de desenvolvimento e testes.
* **Lombok:** Redução de código boilerplate (Getters, Setters, Construtores).
* **Jackson:** Serialização e desserialização eficiente de objetos JSON.

---

## 🏗️ Arquitetura e Padrões

O projeto foi desenhado seguindo os padrões de mercado e os princípios de uma arquitetura limpa:

* **Controller Layer:** Exposição dos endpoints REST e tratamento das requisições HTTP.
* **Service Layer:** Camada de regras de negócio, onde ocorrem as validações, cálculos de conversão e orquestração do fluxo.
* **Client Layer (Feign):** Isolamento total da comunicação com serviços externos.
* **DTO Pattern:** Uso de *Data Transfer Objects* para garantir o desacoplamento entre a API externa e o modelo interno do sistema.
* **Externalized Configuration:** Configurações de ambiente (URLs, logs, credenciais) centralizadas no `application.properties`.



---

## 📖 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/devwarly/gerenciador-financas.git
    ```
2.  **Importe na sua IDE:** Abra o IntelliJ IDEA (ou Eclipse/VS Code) e importe como um projeto Maven.
3.  **Configuração:** Verifique se o arquivo `src/main/resources/application.properties` contém a URL da API:
    ```properties
    api.cambio.url=[https://economia.awesomeapi.com.br](https://economia.awesomeapi.com.br)
    ```
4.  **Run:** Execute a aplicação através da classe `GerenciadorDeFinancasApplication`.

---

## 🕹️ Testando a API

### 1. Criar Nova Transação
**Endpoint:** `POST /api/transacoes`

**Payload (JSON):**
```json
{
  "description": "Hospedagem em Nova York",
  "originalValue": 150.00,
  "currency": "USD"
}
```

### 2. Listar Todas as Transações
**Endpoint:** `GET /api/transacoes`

**Resposta esperada:** Retorna a lista de transações com o `convertedValue` (Valor em R$) e `conversionRate` (Taxa do dia) preenchidos automaticamente.

---

## 🔍 Monitoramento e Logs

A aplicação está configurada com logs em nível `DEBUG` para as chamadas Feign. No console da aplicação, é possível auditar a requisição exata enviada para a AwesomeAPI e o JSON de resposta em tempo real:



```plaintext
[Client#buscarCotacao] ---> GET [https://economia.awesomeapi.com.br/last/USD-BRL](https://economia.awesomeapi.com.br/last/USD-BRL) HTTP/1.1
[Client#buscarCotacao] <--- HTTP/1.1 200 OK (250ms)
[Client#buscarCotacao] {"USDBRL":{"code":"USD","bid":"5.40", ...}}


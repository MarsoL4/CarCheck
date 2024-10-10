# CarCheck

Este projeto é uma aplicação em Java para gerenciar clientes e veículos, realizando operações CRUD com acesso a um banco de dados.

## Estrutura do Projeto

- **DAO/**: Contém classes responsáveis pelo acesso a dados.
  - `ConexaoBD.java`: Gerencia a conexão com o banco de dados.
  - `ImplementacaoCliente.java`: Implementa as operações de CRUD para a entidade Cliente.
  - `ImplementacaoVeiculo.java`: Implementa as operações de CRUD para a entidade Veículo.
  
- **Model/**: Contém as classes de modelo de dados.
  - `Cliente.java`: Representa a entidade Cliente.
  - `Veiculo.java`: Representa a entidade Veículo.

- **Main.java**: Classe principal para testar as funcionalidades do projeto. Inclui testes de criação de tabelas e inserção de dados.

## Funcionalidades

- Criação de tabelas no banco de dados para clientes e veículos.
- Inserção, atualização, exclusão e consulta de clientes e veículos.
- Implementação de operações utilizando o padrão DAO.

## Pré-requisitos

- JDK 8 ou superior
- Dependências JDBC para conexão com o banco de dados.

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/usuario/CarCheck.git
2. No arquivo ConexaoBD.java, adicione as informações de conexão do seu banco de dados, como URL, usuário e senha.
3. Compile o projeto:
   ```bash
   javac -d bin $(find ./ -name "*.java")
4. Execute a classe principal:
   ```bash
   java -cp bin Main


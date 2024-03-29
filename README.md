# Aplicativo para Gestão em Projetos
## Rodar na Máquina Local com banco dados H2 ou Container Docker

Este aplicativo é desenvolvido para auxiliar na gestão de projetos. Ele utiliza as seguintes tecnologias:

- Banco de Dados: H2 (utilizado para desenvolvimento ) Postgresql(para anbiente de teste)
- Linguagem de Programação: Java 1.8 com Spring Boot
- Framework: JSP (JavaServer Pages)
 ## variaveis de Ambientes:

 - POSTGRES_PASSWORD=password
 - POSTGRES_USER=username
 - POSTGRES_DB=db-desafio
 - DB_SERVER=localhost
 - PROFILE = dev para banco dados H2 ou test para banco dados Postgresql.

## Funcionalidades

O aplicativo possui as seguintes funcionalidades:

- Cadastro de Funcionários
- Cadastro de Membros de Projeto
- Cadastro de Projetos
- Acompanhamento do status dos projetos
- Avaliação do grau de risco dos projetos

## Configuração do Ambiente

Para executar o aplicativo, certifique-se de ter as seguintes ferramentas instaladas:

- Java Development Kit (JDK) 1.8 ou superior
- Maven (para gerenciamento de dependências)
- docker-compose up -d

## Executando o Aplicativo

1. Clone este repositório para o seu ambiente local.
2. Navegue até o diretório raiz do projeto.
3. Execute o seguinte comando para compilar e executar o aplicativo:
4. comando mvn **spring-boot:run**

5. O aplicativo estará disponível em `http://localhost:8080`.

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

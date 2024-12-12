# projeto AgendaRelatorios
Projeto Agenda

# Agenda de Serviços com Validação de CEP e Integração com Aplicação de Relatórios

## Descrição

Este é um projeto de **Agenda de Serviços**, desenvolvido em Java usando o **Spring Boot** e **Thymeleaf** para o front-end, permitindo a conexão com a aplicação de **Relatórios**, criada nos mesmos moldes da principal, além de ter integração ao **ViaCEP** para validação e preenchimento automático de endereços.

O projeto tem como principal objetivo gerenciar o agendamento de serviços entre clientes e funcionários, permitindo o cadastro e gerenciamento de serviços, e futuramente, validação de horários e controle de acesso de usuários.

## Funcionalidades Principais

- **Cadastro e Gerenciamento de Serviços**:
  - Todo serviço é cadastrado com o status padrão "False".
- **Validação de Endereço**:
    - O sistema consome a API dos Correios (ViaCEP) para validar o CEP inserido e preencher automaticamente os campos de endereço.
- **Integração com Aplicação de Relatórios**:
  - A aplicação Agenda após criar o banco de dados abre uma conexão tcp pelo port `8082`, que é utilizada pela aplicação Relatorios para que ambas hajam sob o mesmo banco de dados.

O projeto segue o seguinte diagrama de classes, com entidades como `Agenda`, `Cliente`, `Serviço`, `Funcionário`, `Endereço`.

## Tecnologias Utilizadas

- **Java 17**
- **ViaCEP API** (para a consulta de CEPs)
- **Maven** (gerenciamento de dependências)
- **Spring Boot(com as seguintes dependências)**
    - Spring Data JPA** (para o gerenciamento de repositórios)
    - Thymeleaf** (para o front-end)
    - H2 Database versão 1.4.193** (banco de dados em memória)
    - Versão expecífica

## Requisitos para Execução

- **JDK 17+**
- **Maven** instalado
- **Portes padrões utilizados pela aplicação, livres** `8080`, `8081` & `8082` (Alteráveis)

## Instruções de Execução

1. Após cumprir todos os requisitos de execução, execute a em sua IDE a API `AgendaApplication.java` em **Agenda\src\main\java\com\matera\blog**
2. Acesse uma página da agenda por qualquer um dos Endpoints, port `8080`
3. Se puder ver, alterar ou criar índices, então execute a API de relatórios `RelatorioApplication.java` em **Relatorios\src\main\java\com\matera\blog**
4. Acesse uma página de relatórios por qualquer um dos Endpoints, port `8081`.
5. Se qualquer alteração feita através aplicação de agenda for visível na aplicação de relatórios, ambas as aplicações estão pronta para uso.

## Endpoints Principais em ambas as aplicações

- **http://localhost:8080/agendamentos**: Cadastro e gerenciamento de agendamentos de serviços.
- **http://localhost:8080/clientes**: Cadastro e gerenciamento de clientes.
- **http://localhost:8080/funcionarios**: Cadastro e gerenciamento de funcionários.
- **http://localhost:8080/servicos**: Cadastro e gerenciamento de novos serviços.
- **http://localhost:8081/enderecos**: Listagem de enderecos. (somente disponível na aplicação de relatórios).

## Exemplo de Agendamento

Para agendar um novo serviço:

1. Acesse a página de **agendamentos** via `/agendamentos`, e clique em **Adicionar**.
2. Preencha os dados do serviço, incluindo **cliente**, **funcionário**, **data do agendamento** & o **serviço** que será prestado.
3. Clique em **Salvar**. Você será levado a página principal e lá estará seu novo agendamento.

## Futuras Melhorias

- **Integração com outros serviços de pagamento.**
- **Implementação de autenticação e autorização usando Spring Security.**
- **Possibilidade de exportação dos relatórios em arquivos de t

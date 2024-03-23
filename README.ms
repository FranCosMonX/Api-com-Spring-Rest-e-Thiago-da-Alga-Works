# Projeto de treino com Spring Tools

## Requisitos

- Conhecimento dos verbos HTTP
- Conhecimento dos códigos HTTP: (link para estudar)[https://httpstatus.io/http-status-codes]
- Programação Orientada a Objetos.
- Conhecimento em Java.
- Conhecimentos básicos de Banco de Dados.
- IDE Spring Tools ou outro.

## Ferramentas usadas

- Flyway: cria uma tabela no BD para gerenciar as alterações (arquivo de migrações) que já foram feitas no BD.
Os arquivos de migração nada mais são que as ações que serão feitas no banco de dados. A nomeação do arquivo
tem que respeitar a sintaxe: V<001>__cria-tabela-cliente.sql >> o numero pode conter pontos, tem que haver dois under-lines
e a extensão do arquivo deve ser "sql".

- jakarta: (link)[https://jakarta.ee/learn/docs/jakartaee-tutorial/current/index.html]

- Spring Data JPA: implementação de repositorios (classes) do jakarta;
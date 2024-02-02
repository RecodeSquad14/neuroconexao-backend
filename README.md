
# NeuroConexão-Backend

Este é o repositório do NeuroConexão-Backend, um projeto desenvolvido utilizando Spring Boot 3.2.1 com a IDE IntelliJ, banco de dados MySQL Workbench 8 e integração com o Postman para testes.

## Configuração do Ambiente de Desenvolvimento

1. **Spring Boot 3.2.1 e IntelliJ:**
   - Certifique-se de ter o Spring Boot 3.2.1 e o Java 17 instalados em sua máquina.
   - Abra o projeto usando a IDE IntelliJ.

2. **Banco de Dados MySQL Workbench 8:**
   - Configure as propriedades do banco de dados no arquivo `application.properties`.
   - Certifique-se de ter o MySQL Workbench 8 configurado e acessível.

## Autenticação e Autorização

O projeto utiliza Spring Security em conjunto com JWT (JSON Web Token) para autenticação e autorização. Apenas usuários com a role de administrador (role 0) têm permissão para listar, editar e excluir recursos.

### Registro de Usuários

- Utilize o método `POST` no Postman para registrar um usuário.
- Endpoint: `localhost:8080/register`
- Parâmetros: `login`, `password` e `role` (0 para admin, 1 para user).

### Autenticação e Geração de Token

- Utilize o método `POST` no Postman para autenticar e gerar um token.
- Endpoint: `localhost:8080/authenticate`
- Parâmetros: `login` e `password`.

### Acesso aos Recursos Protegidos

- Após a autenticação, obtenha o token gerado.
- Utilize o método `POST` no Postman para realizar o login.
- No Postman, clique em "Authorization" e marque a opção "Bearer Token", inserindo o token gerado.
- Agora, todos os métodos estarão disponíveis apenas para os usuários autenticados com a role de administrador.

## Licença

Este projeto está licenciado sob a MIT License.

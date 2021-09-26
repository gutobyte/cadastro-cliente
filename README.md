#Backend - Cadastro de Usuários e Serviços

<br/><br/>
**Aplicação:**
<br/><br/>
Simples CRUD que cadastra usuários, clientes e serviços.
Foi utilizado spring security para autenticar a aplicação frontend Angular e usuários logados. Utilizando tokens jwt, bibliotecas validator para validar campos obrigatórios, além possui um validador de CPF.
<br/><br/>

**Configurações:**


Após dar um git-clone no projeto, basta abrir em uma IDE e executar a classe main:
<code>CadastroClienteApplication.</code>

Este projeto é apenas o backend, necessita do frontend (clientes-app) em Angular para rodar:
<br/><br/>
https://github.com/gutobyte/clientes-app

A aplicação está configurada para rodar em um banco de memória H2, caso queira testar em um banco real, basta editar as configurações no: <code>application.properties</code>.

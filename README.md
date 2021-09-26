##Backend - Cadastro de Usuários e Serviços
<p>Aplicação:</p>
Simples CRUD que cadastra usuários, clientes e serviços.
Foi utilizado spring security para autenticar a aplicação frontend Angular e usuários logados. Utilizando tokens jwt, bibliotecas validator para validar campos obrigatórios, além possui um validador de CPF.
<p></p>
<p>Configurações:</p>
Após dar um git-clone no projeto, basta abrir em uma IDE e executar a classe main:
<code>CadastroClienteApplication.</code>

Este projeto é apenas o backend, necessita do frontend (clientes-app) em Angular para rodar:
<p>https://github.com/gutobyte/clientes-app</p>

A aplicação está configurada para rodar em um banco de memória H2, caso queira testar em um banco real, basta editar as configurações no: <code>application.properties</code>.
<span style="color:red">some **This is Red Bold.** text</span>
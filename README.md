# Projetos Acadêmicos desenvolvido para a disciplina de Programação Web

##### Alunos: Diego Muniz e Bruno Silva

# Baixar o projeto

Escolha uma das opções abaixo e dê um `git clone`

```
https://github.com/diegomunizdev/projeto-web.git
```

ou

```
git@github.com:diegomunizdev/projeto-web.git
```

em seguide entre no diretório que você baixou o projeto e abra com o `Eclipse`.

Ainda antes de rodar, crie um schema no `MySQL` com o nome `api_projetos_academicos`.

# Rodar a aplicação

Rode sua aplicação e no primeiro acesso na rota `http://localhost:8080` você receberá um alert para fazer o login e senha, como na imagem abaixo.

![image](https://user-images.githubusercontent.com/26802818/101963734-30af9280-3bee-11eb-8a77-380c48a9cd9f.png)

Você pode logar com o usuário `admin` e senha `admin`  que tem níveis de permissão de administrador e pode logar com `user`
e senha `user` com permissões limitadas, como por exemplo, não poder criar um projeto.

Depois disso acesse a rota `http://localhost:8080/swagger-ui.html` e veja todas as rotas e modelos da aplicação para as requisições.


![image](https://user-images.githubusercontent.com/26802818/101964070-e0850000-3bee-11eb-92e7-317904ac50d5.png)

No Postman configure as autorizações como na imagem abaixo, sem essas informações você não receberá nem poderá enviar dados para o Banco de Dados.

![image](https://user-images.githubusercontent.com/26802818/101964224-6dc85480-3bef-11eb-9451-d338378430ca.png)

Seja feliz com as requisições!

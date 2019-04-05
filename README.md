# Teste Java
## Questão 1

### Serviço exposto: /cep-ws

### Cenários desenvolvidos (Obs:. Cep válido: String com 8 dígitos de 0 a 9):
    - validado a quantidade de dígitos do CEP;
    - validado entrada com caracteres;
    - validado a regra de substituição do digito por zero;
    - validado a mensagem de retorno ("CEP não encontrado!" e "CEP inválido!").

### Arquitetura:
* Foi utilizada uma arquitetura MVC com os pacotes organizados em dois modulos: 
    - **api:** contem a classe que expõe o endpoint de consulta;
    - **core:** contém as classes de regras de negócio, modelo, utilitários e acesso a dados;

### Dados:
* Foi criado um Mock de alguns CEPs com padrão Singleton, de modo a manter uma única instância da lista de CEPs mocados.




## Questão 2

### Serviço exposto: /endereco-api

### Arquitetura:
* Foi utilizada uma arquitetura MVC com os pacotes organizados em três modulos: 
	- **api:** Contem as classes que expõe os endpoints seguindo o modelo RESTfull (GET, PUT, POST, DELETE); Contém uma classe com handlers para capturar exceções de validação de campo obrigatório e comunicação com o serviço cep-ws;
	- **core:** contém as classes de regras de negócio, modelo, utilitários e acesso a dados;
	- **consumer:** contém a classe que se comunica com o servico cep-ws;

### Dados:
* Foi utilizado um banco de dados em memória (h2Database) para persistir os dados de Endereço.




## Questão 3

**client <--> servidor**

>Neste processo o client (browser) está fazendo uma solicitação de recursos ao servidor provedor daquele recurso. 
>Nessa requsição, o client precisa enviar um pacote de informações importantes de modo que o servidor saiba o que está sendo solicitado.
>São passados então, alguns cabeçalhos (headers) e a url do servidor. Os cabeçalhos carregam informações como método da requisição (GET, >POST, PUT, DELETE,...), tipo do conteúdo (ex: application/json), segurança. etc.
>E por fim, o servidor ao receber a requisição, processa de acordo com o que foi solicitado e envia uma resposta ao client.

**Exemplo dos cabeçalhos envolvidos numa requisição ao serviço cep-ws através de um navegador:**

**General:**
```sh
Request Method: GET
Status Code: 200 OK
Referrer Policy: no-referrer-when-downgrade
```

**Response Headers:**
```sh
Access-Control-Allow-Origin: *
cache-control: no-cache
Content-Security-Policy: script-src 'self' blob: filesystem: chrome-extension-resource:; object-src 'self' blob: filesystem:;
Content-Type: application/json
ETag: "Haq6qgH5x8NBJp5p3z7z6f4kjt4="
```

**Resquest Headers:**
```sh
Referer: http://localhost:8081/cep-ws/40026031
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36
```

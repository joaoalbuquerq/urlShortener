# 🚀 urlShortener

urlShortener é um serviço de encurtamento de URLs desenvolvido com Spring Boot e Java 21, utilizando MongoDB para armazenamento. Este projeto permite que os usuários enviem URLs para encurtamento e fornece um endpoint para redirecionar para a URL original utilizando um ID gerado. O MongoDB é executado em um contêiner Docker, e o projeto utiliza uma biblioteca do Apache para criptografia do ID.

## 📋 Funcionalidades

- **Encurtamento de URLs:** Recebe uma URL via requisição POST e retorna uma URL encurtada com uma data de expiração de 2 minutos.
- **Redirecionamento:** Redireciona para a URL original quando um ID válido é passado via endpoint GET.

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot
- MongoDB
- Docker
- Apache Commons Codec (ou outra biblioteca do Apache utilizada para criptografia do ID)

## 📑 Endpoints

### POST /shorten

Recebe uma URL e retorna uma URL encurtada com uma data de expiração de 2 minutos.

**Exemplo de Requisição:**
```json
POST /shorten
Content-Type: application/json

{
    "url": "https://www.exemplo.com"
}
```

**Exemplo de Resposta:**
```json
{
    "shortenedUrl": "http://localhost:8080/{id}"
}
```

### GET /{id}

Redireciona para a URL original correspondente ao ID fornecido.

**Exemplo de Requisição:**
```json
GET /{id}
```

## ⚙️ Configuração

1. Clone o repositório:
```bash
git clone https://github.com/joaoalbuquerq/urlShortener.git
cd urlShortener
```
2. Configure as dependências do Maven:
```bash
git clone https://github.com/joaoalbuquerq/urlShortener.git
cd urlShortener
```
3. Configure e inicie o MongoDB usando Docker:
```bash
docker-compose up -d
```
4. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

## 🤝 Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## 📄 Licença
 
Este projeto está licenciado sob a MIT License.




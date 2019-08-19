# Reddit Hot Threads Scrapper Telegram Bot
## About
Esta é uma implementação do  [Idwall Crawlers code challenge](https://github.com/idwall/desafios/tree/master/crawlers).

## Project Overview

### Contexto

O desafio consiste de implementar um Bot de Telegram que efetuará o "scrap" de subreddits dado um certo commando.

O Bot vai extrair desses subreddits dados das threads que possuam pontuação maior ou igual a valor configurável (padrão 5000 pontos) 

Esta aplicação foi construída usando Spring Boot 2.X devido as funcionalidades fornecidas pelo Spring Framework, algumas das quais por exemplo: 
 * Mecanismo de Injeção de Dependência.
 * Spring 5.0 WebClient: Biblioteca de Http client assíncrona que utiliza o padrão Observable com Reactor.
 * Configuração de properties usando arquivos .yml e .properties "out of the box".
 * Logging com Logback "out of the box"
 
A Integração com o Telegram para comunicação com o Bot foi construída utilizando [Telegram Bots Starter for Spring Boot](https://github.com/rubenlagus/TelegramBots) pela sua facilidade de uso.
    
Outras tecnologias empregadas:
* JSoup 1.12
* JUnit 4
* Mockito
* Maven

### Componentes 

Essa aplicação segue o padrão Model-View-Controller.

Os principais componentes são:
* Controller responsável por receber as mensagens do Bot de telegram e acionar validação do comando e a execução do fluxo de crawling.
* Parser responsável por validar a sintaxe do comando enviado ao bot e extrair o nome dos subreddits.
* O crawler responsável por extrair os dados das threads de interesse dado um texto Html.
* Componente para encapsular as requisições Http para baixar os Htmls das páginas dos subreddits.
* Componente de serviço que aciona de forma paralela as requisições Http e repassar esses dados para o crawler e executar o callback do Bot do telegram para enviar os dados extraídos para o usuário final.



## Build e Execução

* Para efetuar o build basta executar o comando mvn clean install
* Para executar a aplicação é necessário fornecer um arquivo [aplication.properties](/src/main/resources/application.properties) (preferencialmente no mesmo diretório onde esta jar da aplicação) e executar o comando java -jar idwall-crawler-bot-0.0.1-SNAPSHOT.jar
* O arquivo application.properties deve conter obrigatoriamente os paramêtros de credenciais do Bot do Telegram (userName e token)

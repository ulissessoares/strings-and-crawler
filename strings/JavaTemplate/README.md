# String Formatter
## About

Esta é uma implementação do [Idwall String Formatter Code Challenge](https://github.com/idwall/desafios/tree/master/strings)

## Project Overview
### Contexto

O desafio consiste em implementar uma aplicação que dado um texto execute uma rotina que formatará todas linhas desse texto para respeitar um limite de caracteres configurável (Padrão 40 caracteres)

Há também uma opção para que essa rotina também efetue a justificação do texto, ou seja, o aumento do espaçamento entre as palavras para que todas as linhas tenham exatamente o número de caracteres igual ao limite.
 
### Componentes

* Formatador

    Esse componente é responsável por ajustar as linhas do texto de entrada para respeitar o limite máximo de caracteres.
    
    A rotina é efetuada criando-se uma estrutura de pilha com as linhas do texto, sendo a linha do topo da pilha a primeira linha do texto de entrada e a última linha da pilha a última do texto de entrada.
    
    Para cada linha da pilha verifica-se se a linha respeita o limite de caracteres, caso afirmativo a linha é adicionada a um texto de saída. 
    
    Caso contrário, a linha é quebrada para respeitar o limite, sendo que o restante da linha é adicionado (concatenado) à frente da próxima linha da pilha.
    
    Esse processamento é repetido até a pilha estar vazia.
    
    Caso a formatação seja justificada, o justificador será para cada linha antes delas serem adicionadas ao texto de saída.
    
* Justificador

    O justificador tem como responsabilidade aumentar os espaçamentos entre as palavras de uma linha para que ela tenha um determinado tamanho fixo que é o limite de caracteres da formatação.
    
    Aqui cabe estabelecer alguns conceitos:
    * espaço: caracter de espaço ou caracter em branco " "
    * espaçamento: sequência de um ou mais espaços consecutivos entre palavras em um texto.
    
    O algoritmo de justificação tem algumas prerrogativas:
    
    * Caso a linha tenha uma única palavra, essa palavra deve ser centralizada no texto colocando espaçamentos antes e depois dela.
    * Caso a linha tenha n palavras (n > 1), os n - 1 espaçamentos entre as palavras devem ser aumentados de maneira proporcional.
    * O cálculo do aumento mínimo do espaçamento entre as palavras é feito dividindo-se o número de caracteres faltantes na linha pelo número de espaçamentos. Essa é uma divisão inteira e o restante dessa divisão corresponde a uma quantidade de espaçamentos que devem ter um espaço a mais dos que os espaçamentos mínimos calculados.
    Exemplo:
            
            Limite 40 caracteres
            
            | Dado                                  | Valor                                    |
            |_______________________________________|__________________________________________|
            | Frase                                 | "and the earth. Now the earth was"       |
            | Tamanho                               | 32                                       |
            | Faltante pra o limite                 | 8                                        |
            | Número de espaçamentos                | 6                                        |
            | Aumento mínimo de espaçamento         | 8 / 6 = 1 (divisão inteira)              |
            | Restante do calculo do aumento mínimo | 8 % 6 = 2 (restante)                     |
            | Tamanho mínimo de espaçamento         | 2                                        |
            | Tamanho máximo de espaçamento         | 3                                        |
            | Qtd de espaçamentos com tamanho max   | 2                                        |
            | Qtd de espaçamentos com tamamho min   | 4                                        |
            
            Frase Justificada: "and   the  earth.   Now  the  earth  was"
            
    * Se quando calculados os tamanhos dos espaçamentos resultar em 2 tamanhos diferentes 
    (Restante do cálculo do aumento mínimo > 0, como no exemplo acima), o primeiro espaçamento deve ser do tamanho máximo e os seguintes espaçamentos devem ser intercalados até sobrar espaçamentos de um único tamanho.
    Exemplo:
    
            | tamanho min | tamanho max | qtd min | qtd max | espaçamentos ordenados                |
            |_____________|_____________|_________|_________|_______________________________________|
            | 2           | 3           | 4       | 2       | "   ", "  ", "   ", "  ", "  ", "  "  |
            | 1           | 2           | 2       | 4       | "  ", " ", "  ", " ", "  ", "  "      |
    
## Build e Execução  

* Para efetuar o build basta executar o comando mvn clean install
* Executar a classe Main com os parâmetros: texto a ser justificado (Obrigatório), limite (opcional, maior que zero), justificando (opcional).
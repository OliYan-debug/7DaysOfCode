# Top 250 IMDB Movies and Top Marvel Animated Series

> **Retornar o Top 250 filmes do IMDB ou Top Series Animadas da Mavel e Gera um HTML deles**

## Como usar

- Clone o repositório

```bash
git clone https://github.com/OliYan-debug/7DaysOfCode.git
```

- Crie um pacote env dentro do diretório principal

```r
├── src
│   └── main
│       ├── java
│       │   └── imbd
│       │       └── top250
│       │           ├── Api
│       │           │   ├── ApiClient.java
│       │           │   ├── JsonParser.java
│       │           │   └── Keys.java
│       │           ├── env  <=
│       │           │   └──

```

- Dentro do pacote enc crie a Classe `Credentials` e implemente a classe `Keys` do pacote API e Adicione todos os métodos com suas respectivas chaves para cada serviço

- Criando uma lista com todos os tops 250 Filmes do IMDB

```java
String jsonString = new ImdbApiClient(imdbApiKey).getBody();  
List<Movie> movies = new ImdbMovieParser(jsonStringImdb).parse();
```

- Criando uma lista de top series de desenho da marvel ( Limitado a 20 pela API )

```java
String jsonStringMarvel = new MarvelApiClient("series",  
        new Credentials().getPublicMarvelApiKey(),  
        new Credentials().getPrivateMarvelApiKey()  
        ).getBody();  
List<Series> series = new MarvelSeriesParser(jsonStringMarvel).parse();
```

- Criando um Html com a lista de séries (Somente criado para fins de aprendizagem)

```java
PrintWriter printWriter = new PrintWriter("src/main/resources/index.html", StandardCharsets.UTF_8);  
new HtmlGenerator(printWriter).generate(mixedList);  
printWriter.close();
```

### Extra

#### Juntar as Duas Listas em uma

```java
List<? extends Content> mixedList = Stream.of(movies, series)  
        .flatMap(Collection::stream)  
        .collect(Collectors.toList());
```

#### Sortear a lista pelo titulo do conteúdo (0-Z)

```java
Collections.sort(mixedList, Comparator.comparing(Content::title));
```

# Trajetória do projeto

## Day one

- Criar um Request para o IMDB e retornar os tops 250 filmes do momento

## Day Two

- Separar cada item do JSON em um item que retorna 2 propiedades (nome, image)
  - Deixe mais uma propiedade rank para facilitar na separação
  - Adicionei um `movies.json` para fazer a manipulação através dele para não gastar a cota de API

## Day Three

- Padronização do modelo do filme (Concluído desde o dia #2)
- Adicionar os campos `year` e `rating` para cada filme

## Day Four

- Gerar um html com todos os filmes da lista
  - Fazer isso não é uma boa prática mas como o intuito é testar conhecimentos e entender o fluxo que uma API deve seguir

## Day Five

- Refatoração e Encapsulamento do Código

## Day Six

- Deixar o código mais genérico para aceitar outro tipos de requests
- Adicionado integração com a marvel API
- Refatoração e Adição de algumas classes e interfaces para melhor organização

## Day Seven

- Implementar a interface `Comparable` no Movie e Series para permitir que eles sejam sorteados por diferentes critérios
  - Mas o padrão é por título


## Dependências

- OkHttp3
- Jackson (0bject Mapper)
#AVISOS:

Estou estou remodeando esse repositório e criando uma página web ([https://luisaraujo.github.io/Estrutura-de-Dados-em-Java/index.html](https://luisaraujo.github.io/Estrutura-de-Dados-em-Java/index.html)) para introduzir figuras e animações. 

Todos os códigos foram movidos para a pasta Códigos. 

---
### AULAS COMIGO?

Acesso o superprof: [superprof/luisaraujo](https://www.superprof.com.br/aulas-estrutura-dados-java-com-doutorando-computacao-aulas-teorica-praticas-vetor-pilha-fila-lista.html)

### INTERESSE EM CURSO DE ESTRUTURA DE DADOS? 

Deixe a sua opinião e contato:

[Para preencher o formulário leva apenas 1 minutos!](https://forms.gle/LnkVgrXfwmg6Wj9s8)


# Estrutura de Dados em Java


Esse texto tem por objetivo apoiar o processo de ensino-aprendizagem do componente curricular Estrutura de Dados. O texto tem como base os códigos no repositório. Não há restrições para a ordem da leitura, mas - se você for um estudante que ainda não conhece os tópicos apresentados - recomenda-se ler um capítulo por vez e partir para a implementação na seção *overview*. 

**Licença**: O material está disponível sob licença: **Creative Commons BY**

![CC BY](https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/CC-BY_icon.svg/88px-CC-BY_icon.svg.png)
 
**Requisitos**: conhecer o Paradigma Orientado a Objeto (POO) e Linguagem em Java. 

**Obs:** *Esse documento está em construção, deixe-me saber se há algum erro: luisaraujo.ifba@gmail.com*

# Sumário

1. Capítulo 1 - [Estrutura de Dados](https://github.com/LuisAraujo/Disciplina-Estrutura-de-Dados#1---estrutura-de-dados)
1. Capítulo 2 - [Pilha](https://github.com/LuisAraujo/Disciplina-Estrutura-de-Dados#2---pilha)
1. Capítulo 3 - [Fila](https://github.com/LuisAraujo/Disciplina-Estrutura-de-Dados#3---fila)
1. Capítulo 4 - [Lista Simplesmente Encadeada](https://github.com/LuisAraujo/Disciplina-Estrutura-de-Dados#4---listas-simplesmente-encadeada)
1. Capítulo 5 - [Lista Duplamente Encadeada](https://github.com/LuisAraujo/Disciplina-Estrutura-de-Dados#5---lista-duplamente-encadeada)
1. Capítulo 6 - [Lista Circular](https://github.com/LuisAraujo/Disciplina-Estrutura-de-Dados#6---lista-circular)
1. Capítulo 7 - [Árvores](https://github.com/LuisAraujo/Disciplina-Estrutura-de-Dados#7---%C3%A1rvores)


# 1 - Estrutura de Dados

O que é uma estrutura de dados? Como o próprio nome diz, é uma forma de organizar informações. Ou seja, passamos de um patamar que usávamos tipos primitivos como Inteiro, Caractere e outros para tipos mais complexos, como Pilha, Fila, Árvore e outros. Sim, esses tipos complexos utilizam tipos primários, mas estamos interessados agora nesses mais complexos.

Como disciplina Estrutura de Dados, embora usemos os tipos primitivos, tem como objetivo apresentar estruturas já consolidadas da área de computação que buscam resolver diversos problemas recorrentes.  

É importante ressaltar que uma Estrutura de Dados é formada por Dados (organizados segundo alguma lógica) e operações permitidas, vinculadas a essas dados.

Formalizando:

> Estrutura de Dados envolve dados organizados de alguma forma e operações vinculadas aos dados que garantem que os mesmos permaneçam com a mesma organização após inserções e deleções.

Assim, algumas estruturas são utilizadas como forma de facilitar o armazenamento de informações, permitindo a recuperação de modo mais rápido. Logicamente que tudo depende do contexto do problema. Por exemplo, não é recomendável utilizar uma Pilha para um problema que envolve o conceito de Fila, como uma fila de Banco por exemplo.

### 1.1 - Modelagem Computacional

Modelagem Computacional é um área da Computação que visa modelar computacionalmente alguns cenários ou problemas. Basicamente, buscamos transpor elementos do mundo real para o computador e para isso precisamos usar a "abstração". Logicamente que não iremos modelar algo da natureza em sua perfeição, e muitas vezes não precisamos. Assim, muitas vezes, modelamos apenas os elementos essenciais, arte proveniente da abstração: poder de focar em elementos principais, ignorando elementos eventuais ou menos importantes (para um contexto específico).

Desse modo, podemos criar classe - quando falamos em POO - com seus métodos que simulem um determinado elemento a ser modelado. Por exemplo: Carro possui uma marca, placa, modelo, ano de fabricação, motor e pode acelerar, frear, virar à esquerda, entre outros. 

Em Estrutura de Dados, faremos constantemente esse exercício, modelaremos elementos do mundo real, eliminando suas características eventuais, focando apenas nos elementos principais. Isso ocorre com Pilhas, Filas, Árvore entre outras estruturas. 

### 1.2 - Revisão POO com Java

Uma condição essencial para criar estruturas de dados, no modelo que vamos apresentar, é saber os conceitos de POO e Java. Caso esse não seja o seu caso, recomendamos parar a leitura e fazer um curso ou ler materiais específicos sobre POO. 

Então, assumindo que você já conhece POO, vamos relembrar.

**Classe**

Classes são elementos no qual podemos implementar modelos, tal como uma forma de bolo que usaremos para fazer vários bolos: chocolate, cenoura e outros. Não importa os ingredientes utilizados, a forma sempre será a mesma. 

Com classes podemos definir como serão os nossos objetos. Fazendo outra analogia, classes são como gabarito. Através das classes podemos definir os atributos e métodos dos objetos.

Vamos ver um exemplo em Java. A seguir temos uma classe de nome *AlgumaClasse*, com dois atributos: um do tipo inteiro, chamado número, e outro do tipo string, chamado nome:

```java
public class AlgumaClasse{

     int numero;
	 String nome;
}

```

**Objetos**

Objetos são copias das Classes, dizemos ainda que quando instanciamos um objeto, estamos consolidando a classe. Ou seja, estamos de fato utilizando a classe como modelo para criar um objeto. Esse objeto terá os atributos e métodos estipulados na Classe. Mas é importante saber que: *dois objetos da mesma classe podem ter comportamentos diferentes, dado o seu estado* (os valores nos atributos). Como o exemplo do bolo, chocolate e cenoura foram implementados com ingredientes diferentes, mas ainda são bolos. 

Em Java, um objeto é criado da seguintes forma, declara-se um local para armazená-lo (como uma variável) estipulando o seu tipo (AlgumaClasse) e depois o seu nome. Do lado direto da igualdade, temos o operador *new* acompanhado do nome da Classe e de parênteses:

```java
public static void main(){
	AlgumaClasse ac = new AlgumaClasse();
}

```

Como disse antes, elas podem ter valores diferentes (estado). Vejamos:



```java
public static void main(){
	AlgumaClasse ac = new AlgumaClasse();
	ac.numero = 10;
	ac.nome = "AC 1";

	AlgumaClasse ac2 = new AlgumaClasse();
	ac.numero = 20;
	ac.nome = "AC 2";

}

```

Assim, ac e ac2 são objetos diferentes que possuem seus próprios valores. Mas, ainda assim, são objetos de AlgumaClasse.


**Construtor**

Mas o que faz o *new*? Bem, ele 'chama' o construtor da classe para que seja instanciado o objeto (o objeto é colocado dentro da variável *ac*). Esse construtor é um método diferenciado, pois ele não possui retorno. Isso não quer dizer que ele é um *void*, ele literalmente não possui retorno. O Java saberá que ele é um construtor, pois não colocamos o tipo de retorno (*void, Integer, String ...*). Vejamos a diferença entre os métodos *setNumero*, *getNumero* e o Construtor.

```java
public class AlgumaClasse{

    [...] //trecho inibido

	public AlgumaClasse(){
		nome = "";
	}

	public int getNumero(){
		return this.numero;
	}

	public void setNumero(int numero){
		this.numero = numero
	}	

```


**Atributos**

Atributos são variáveis (primitivas ou objetos) que são inerentes ao Objeto instanciado. Ou seja, os atributos são estipulados no modelo (a Classe). No exemplo anterior, já vimos o uso de atributos (*nome e número*). Os valores nos atributos definem o estado do objeto, que podem influenciar as suas ações (os métodos).

**Métodos**

Como vimos, os métodos são as ações dos objetos. O que isso significa? Significa que são eles os responsáveis por executar as operações, como obter um valor ou inserir um valor. Vimos um exemplos do Método (*getNúmeros*). 

Métodos podem retornar um tipo ou não (void). Vejamos dois exemplos:

```java
public class AlgumaClasse{

    [...] //trecho inibido

	public void setNumero(int numero){
		this.numero = numero
	}

	public int getNumero(){
 		return numero;
	}

```

**Herança**

Herança é uma forma de compartilhar atributos e métodos, de modo a eliminar a duplicidade de código. Assim, o processo de Herança consiste em agrupar atributos e métodos gerais em uma classe, que chamamos de Pai e reaproveitá-los nos Filhos.

Em Java, a Herança é implementada com a palavra-chave *extends*. Todos os atributos e métodos públicos (public) e protegidos (protected) serão herdados pelos filhos. Vejamos:

A classe Pai:

```java
public class ClassePai{

    protected int valor1;

	protected void getValor1(){
		return valor1;
	}

```

A classe Filha:

```java
public class ClasseFilha extends ClassePai{

    protected int valor2;

	protected void getValor2(){
		return valor2;
	}

	// usando o método do Pai
	protected void exibeValor(){
		System.out.println(  getValor1()  + "  " +  getValor2());
	}

```

Através da Herança podemos utilizar o Polimofirmos para agregar dados de vários tipos e tratá-los como iguais. Por exemplo: Um lista de Funcionários tem objetos do tipo Operador, Gerente e Supervisor. Poderíamos tratá-los como Funcionários e assim utilizar os métodos e atributos em comum.

### 1.3 - Tipos Abstratos em Java

Já que relembramos os conceitos básicos de POO, buscaremos agora entender como implementar algo que funcione para uma variedade de tipos, eliminando a necessidade de implementar várias estrutura (uma para cada tipo). Afinal nosso objetivo é criar estruturas que possam ser utilizadas em vários contextos.

**Classe Object**

Como já falamos sobre Herança, podemos então definir a Classe Object. Basicamente, todos as Classes em Java são filhas de Object, mesmo sem o uso de *extends*. Ou seja, nativamente, todas as classes são filhas de Object. 

Object é uma super classe, logo podemos tratar todas as classes como Objects. O problema é que precisamos saber os seus tipos, quando formos utilizar os atributos e métodos. Então, nem sempre isso é uma vantagem. 


```java

public class EstruturaQualquer (){

	Object[] vetor;

	public EstruturaQualquer(int tamanho){
		vetor = new Object[tamanho];
	} 
	
	public void getItem(int i, Object valor){
		vetor[i] = valor;
	}
	public Object getItem(int i){
		retunr vetor[i];
	}

}
```
	   
Agora vamos utilizar essa estrutura. Como ela foi implementada com Object, podemos inserir todos tipo de objeto, pois todos são filhos de Object.

```java

	public static void main(Strings[] args){

		EstruturaQualquer est1 = new EstruturaQualquer(10);
		est1.setItem(0, "Teste");
		est1.setItem(1, "Teste 2");

		EstruturaQualquer est2 = new EstruturaQualquer(10);
		est2.setItem(0, new Gerente() );
		est2.setItem(1, new Gerente() );


}
   
```

Mas do que se trata isso? Bem, estamos tentando esboçar uma forma de implementar nossas estrutura apenas uma vez de modo que ela sirva para uma ampla gama de contextos. O uso do Object funciona, criamos apenas uma estrutura e podemos inserir vários tipos, mas isso possui uma dificuldade: precisamos sempre fazer o *cast* para usar métodos específicos.


```java

	public static void main(Strings[] args){

		[...]

		EstruturaQualquer est2 = new EstruturaQualquer(10);
		est2.setItem(0, new Gerente() );
		est2.setItem(1, new Gerente() );

		double sal = est2.getItem(0).getSalario(); //isso possui um erro


}
```

Então vamos lá:


```java
	
		public static void main(Strings[] args){
	
			[...]

			EstruturaQualquer est2 = new EstruturaQualqyer(10);
			est2.setItem(0, new Gerente() );
			est2.setItem(1, new Gerente() );

			Gerente g = (Gerente) est2.getItem(0).getSalario(); //cast
			double sal = g.getSalario();

	
	}
	   
```

Agora que já entendemos a limitação, vamos ao próximo tópico.

**Classes Genéricas**

Classes Genéricas são muito boas para o que estamos querendo fazer. É comum que aqui você fique um pouco confuso, mas tenha uma coisa em mente: queremos criar estruturas que sejam implementadas um única vez e que sirva para String, Inteiro, Classes criadas por nós e outras. 

Basicamente Classes Genéricas postergam a definição do tipo de dados. Assim, ao invés de definirmos na implementação (Classe) o tipo a ser utilizado, vamos definir no instanciamento do objeto. As classes Genérias recebem um termo (T) que será substituída em tempo de execução, pelo tipo passado por parâmetro. Certamente você já utilizou algo similar como ArrayList, mas não sabia o motivo. 


```java

public class EstruturaQualquer<T>(){

	T[] vetor;

	public EstruturaQualquer(int tamanho){
		vetor = (T[]) new Object[tamanho];
	} 
	
	public void getItem(int i, T valor){
		vetor[i] = valor;
	}
	public T getItem(int i){
		retunr vetor[i];
	}

}
```
	   
Pare um pouco, observe esse código e compare com a implementação da subseção anterior sobre Object. O que mudou?


Certamente você percebeu que as referências do Object sumiram (menos a de instanciar o vetor, pois em Java não podemos criar diretamente um vetor genérico: *new T[tamanho]*. 

Ao usar essa estrutura, vamos dizer no instanciamento o tipo que desejamos:


```java

	public static void main(Strings[] args){

		EstruturaQualquer<String> est1 = new EstruturaQualquer<String>(10);
		est1.setItem(0, "Teste");
		est1.setItem(1, "Teste 2");

		EstruturaQualquer<Gerente> est2 = new EstruturaQualquer<Gerente>(10);
		est2.setItem(0, new Gerente() );
		est2.setItem(1, new Gerente() );


}
   
```

Vamos ao exemplo do uso de métodos específicos:

	
```java

	public static void main(Strings[] args){

		[...]

		EstruturaQualquer<Gerente> est2 = new EstruturaQualquer<Gerente>(10);
		est2.setItem(0, new Gerente() );
		est2.setItem(1, new Gerente() );

		double sal = est2.getItem(0).getSalario(); //isso NÃO possui erro


}
  
```

Pronto, chegamos ao nosso objetivo. Por se tratar de um assunto novo e abstrato, é recomendado que você implemente os exemplos com Object e Classes Genéricas para internalizar os conceitos. Vamos utilizar esse tipo de codificação para as estruturas a seguir: Pilha, Fila, Listas e Árvores.


# 2 - Pilha

A primeira estrutura de dados que vamos ver é a Pilha. A pilha é uma estrutura bastante simples que tem a seguinte característica: 

> Um elemento entra sempre pelo topo. Ao remover um elemento, só podemos removê-lo pelo topo. 

Essa característica significa dizer que não podemos remover imediatamente qualquer elementos desejado, é necessário obedecer esta ordem. Pense em uma pilha de pratos de louça que a nossa mãe tanto ama. Já pensou em remover um prato que está no meio da pilha e, por essa decisão, deixar cair os pratos de cima? Não queremos nem imaginar o problemão, em?

Logicamente que o mais pudente é retirar os pratos de cima um a um e colocar em algum outo lugar, até que possamos - com segurança - pegar o prato desejado. Então, vamos criar um algoritmo simples para modelar isso:

- Pega a pilha de pratos
- Remove o prato que está no topo desta pilha
- Coloca o prato do lado

Bem, isso deve se repetir até que cheguemos ao prato desejado, então...

- Pega a pilha de pratos
- Até chegar ao prato desejado
	- Remove o prato que está no topo desta pilha
	- Coloca o prato do lado

Quando chegar ao prato, devemos retirá-lo e usá-lo, além de recolocar os pratos no local (sim, somos organizados)! 

- Pega a pilha de pratos
- Até chegar ao prato desejado
	- Remove o prato que está no topo desta pilha
	- Coloca o prato do lado
- Pega o prato desejado
- Até que a pilha do lado seja esvaziada
	- Remover o prato que está no topo desta segunda pilha
	- Coloca o prato na pilha principal novamente

> Ufa! Não quebramos nenhum prato, pois seguimos o protocolo correto para a remoção segura. 

Basicamente esta é a ideia de pilha, você já deve ter entendido. Podemos então usar uma modelagem para essa situação. Como já conhecemos bem POO e gostamos de criar objetos, vamos pensar que o prato pode ser uma objeto do tipo Prato, ou de modo mais geral, um Item.  Outra coisa que devemos ter em mente é: *"devemos usar um vetor para armazenar muitos elementos, pois uma variável não daria conta!"*.

Então, temos:

- Uma classe Item;
- Um vetor.


Mas uma estrutura de dados não é formada apenas por locais onde podemos armazenar coisas ou objetos soltos no ar. Devemos criar operações que **garantam uma certa organização**, neste caso a organização da pilha: entra no topo, sai do topo. É interessante observar, caso ainda não tenha pensado nisso, que o elemento que entra do último é o primeiro a sair e o primeiro a entrar é o último a sair. Por esse motivo, a pilha é chamada de FILO (*First In, Last Out*).

Então, além dos dados, temos:

- Operação de inserir
- Operação de remover


### 2.1 - Inserindo dados em uma Pilha**

Mas como controlar que vou inserir no topo? Bem isso é simples, vamos pensar que temos um vetor de 10 elementos e no início todos são nulos. 

    [null, null, null, null, null, null, null, null, null, null]

Eu posso inserir na posição 0, ela será nosso topo.

    ["Prato A", null, null, null, null, null, null, null, null, null]

Se desejo inserir novamente, eu coloco todos os elemento para a a próxima posição e insiro na posição 0 novamente.

	["Prato B", "Prato A", null, null, null, null, null, null, null, null]


Você certamente já percebeu que eu precisaria transpor os elementos, posição por posição até disponibilizar um local vazio no início:

	int i = tamanho_pilha-1;
	while( (i > 0) && (pilha[i] = null) && (pilha[i-1] != null) )
		pilha[i] = pilha[i-1];
		i = i-1
 
	pilha[0] = "Prato C";


Nossa!!! Mas isso é muito custoso, não acha? Pense em uma Pilha de  1 milhão de dados. Quando tivermos ao menos 50% da Pilha com dados, teremos 500 mil alocações. No final, teremos 999.999 alocações, apenas para inserir um único elemento. **Nossa!!**.

**Usando um Topo**

Uma solução para esse problema é: criar uma variável que armazenará o valor (índice) do topo e assim, poderemos sempre inserir em uma posição vazia. No primeiro caso que apresentamos, o topo poderia ser -1 (pois a Pilha está vazia). Você deve pensar: "Mas na outra solução, se a inserção for no fundo, teríamos o mesmo resultado!". Não! Ainda seria preciso achar a posição vazia. 
	
	topo = -1
	[null, null, null, null, null, null, null, null, null, null]

Seguiremos:

	//inserindo o Prato A
	topo = 0
	["Prato A", null, null, null, null, null, null, null, null, null]
	//inserindo o Prato B
	topo = 1
	["Prato A", "Prato B", null, null, null, null, null, null, null, null]

Mas como ficaria esse algoritmo?

	topo++;
	pilha[topo] = "Prato C";

Só isso? Sim!!! Além de ter menos linhas, há menos necessidade de acesso aos dados. Agora, quando a pilha estiver com 50% de dados, teremos a mesma quantidade de operação que ele como 100% dos dados. **Que legal!!!**

### 2.2 - Removendo dados na Pilha

Analogicamente, na solução antiga precisaríamos percorrer todo o vetor até encontrar uma posição onde o próximo elemento é nulo, guardar este valor e colocar um valor nulo no local.

	["Prato A", "Prato B", "Prato C", "Prato D", null, null, null, null, null, null]

Vejamos:

- pilha na posição 0 é null?  // Não
- pilha na posição 1 é null?  // Não
- pilha na posição 2 é null?  // Não
- pilha na posição 3 é null?  // Não
- pilha na posição 4 é null?  // Sim
- guarde o valor da posição 3
- coloque null na posição 3
	
	["Prato A", "Prato B", "Prato C", null, null, null, null, null, null, null]

Sim, podemos usar o loop;
- n = 0
- Enquanto pilha na posição (n + 1)for diferente de null
	- n++
- Se n < tamanho da pilha
	- guarde o valor da posição n 
	- coloque null na posição n 


Já percebemos que essa solução não é ideal, por motivos claros e sabemos que o uso de uma variável de controle como o topo é ideal. Mas como ficaria esse código? Vamos ver:

	String item = pilha[topo]
	topo--
	return item

Pois é, só isso!!! Assim como a inserção, a remoção é muito simples. Logicamente que isso deve ser inserido em uma função, mas isso veremos mais a frente. 


**Verificações, porque não?**

>  You have a error of type 'StackOverflow' on line 4 - Pilha.java

Sim, ninguém quer ver um erro similar no seu mega projeto que demorou 10 dias para ser implementado, horas antes de vencer o prazo de envio ao professor da disciplina. Certamente o papo de "O cachorro comeu minha atividade" não vai colar. Então, precisamos fazer verificações no nosso projeto, para eliminar de uma vez por todas esses erros. 

Um pilha pode ser implementada com vetor ou com lista, neste caso estamos aprendendo como implementá-la em vetor e isso trás algumas limitações como por exemplo um tamanho máximo fixo de elementos que ele aceita. Como foi dito na Seção 2, existem dois motivos para verificarmos uma pilha baseada em vetor: *inserir em uma pilha cheia e remover em uma pilha vazia*.

A condição para um pilha está vazia é simples e já vimos aqui, é justamente o estado inicial dela, onde o topo é -1. 

	if(topo == -1)
		pilhavazia = true

Já a condição para ela está cheia ainda não vimos e vou dizer agora: basta que o topo seja igual ao tamanho do vetor - 1. Isso porque inserimos no vetor na posição "topo" e se topo é igual a o tamanho do vetor ou maior, não poderíamos inserir, pois é uma posição inválida.

	topo = 3
	["Prato A", "Prato B", "Prato C", "Prato D"]

Podemo inserir no topo? Vejamos:

- O topo será incrementado, ou seja virará 4
- Inserimos no vetor na posição 4 //Erro 

Isso certamente ocorrerá em erro, pois em um vetor de 4 posições (tamanho igual a 4), temos a primeira posição válida, a posição 0 e a última a 3. Ou seja, achamos um limite que é justamente quando o topo é igual à 3 (tamanho - 1).

	if(topo == tamanho_pilha - 1)
		pilhacheia = treu


**Observações**

Alguns exemplos aqui são didáticos, no sentido de que você entenda o problema. O código a seguir pode apresentar algumas diferenças, mas isso não impacta na solução do problema. Caso ainda ache que um algoritmo pode ser solucionado de apenas uma única forma, espero que reflita sobre isso. Esse é o momento! 


### 2.4 - Overview

Agora você está pronto para consultar o código da Pilha.java que implementamos.

```java
public class PilhaV<T> {

	/**
	* Array da Pilha 
	*/
	private T[] arrayPilha;
	/**
	* Atributo para armazenar o indice do topo da pilha
	*/
	private int topo;
	
	/**
	* Contrutor da Pilha
	* @param max Tamanho da pilha
	*/
	public PilhaV(int max){
		//instanciando um vetor genérico (cria um vetor do tipo Objetc e faz o cast (conversão) para o tipo T
		arrayPilha = (T[]) new Object[max];
		topo = -1;
	}
	
	/**
	* Insere um elemento se a pilha não estiver cheia
	* @param elemento Elemento a ser inserido na pilha
	* @return retora true se a operação foi bem sucedida
	*/
	public boolean inserir(T elemento) {		
		if(!this.estaCheia()) {
		topo++;
		arrayPilha[topo] = elemento;
		return true;
	}
	
	return false;
	}
	
	/**
	* Remove um elemento da pilha, se ela não esiver vazia
	* @return retorna o elemento se a operação foi bem sucedida
	*/
	public T remover() {		
	
	
	if(!this.estaVazia()) {			
		return arrayPilha[topo--];
	}
	
	return null;
	
	}
	
	/**
	* Verifica se a pilha está vazia
	* @return retorna true se a pilha estiver vazia
	*/
	public boolean estaVazia() {		
		return topo == -1;
	}
	
	/**
	* Verifica se a pilha está cheia
	* @return retorna true se a pilha estiver cheia
	*/
	public boolean estaCheia() {		
		return topo == arrayPilha.length-1;
	}
}
```


Link aqui: [PilhaV.java](https://github.com/LuisAraujo/Disciplina-Estrutura-de-Dados/blob/master/Pilha/PilhaV.java)

### 2.5 - Breve nota sobre complexidade de uma Pilha

### 2.6 - Exercício

1. Desenhe um pilha para os seguintes estados, considere além do vetor de 10 posições o topo:
	
	-	Inserir elemento 1
	- 	Inserir elemento 3
	- 	Inserir elemento 4
	- 	Inserir elemento 5
	- 	Remover elemento
	- 	Inserir elemento 6
	- 	Remover elemento
	- 	Remover elemento
	- 	Remover elemento
	- 	Remover elemento
	- 	Inserir elemento 4
1. Modifique a sequencia de comandos acima para que haja um *overflow* de inserção. Ou seja, inserir até que o máximo seja alcançado. 
1. Escreva um código que insira os seguintes elementos na pilha: 1,3,4,5,6 e 10
2. Escreva um código de removar todos os elementos adicionados em uma pilha. O código deve funcionar para qualquer estado da pilha.
2. Escreva um código de insira elementos em uma pilha até que a mesma chegue ao estado de cheia. O código deve funcionar para pilhas de qualquer tamanho.
3. Dada a seguinte inserção em uma pilha:  1,3,4,5,6 e 10, remova os 3 últimos elementos inseridos.
4.  Dada a seguinte inserção em uma pilha:  1,3,4,5,6 e 10, remova o terceiro elemento inserido (4) e recoloque os dois anteriores.
5.  Crie um código que dado um número n qualquer entre 1 e o tamanho da pilha remova todos os elementos até o elemento n (incluindo o n). 
6.  Crie um código que dado um número n qualquer entre 1 e o tamanho da pilha remova o elemento n e recoloque todos os elementos anteriores.  O código deve funcionar para qualquer estado da pilha.
7. [Média] Implemente um algoritmo do jogo torre de hannoi usando três pilhas. No jogo o jogador indicará a pilha de remoção do disco e a pilha de inserção do disco. O jogo deve garantir a regra da torre de hannoi: não é possível inserir um disco maior sobre um disco menor. 
8.  [Média] Implemente um algoritmo que simule um estacionamento. Neste estacionamento entram e saem carros pela mesma extremidade. Para remover um carro x é preciso remover todos os inseridos após ele. Cada manobra deve ser contabiliza e quando um carro sair, deve-se indicar a placa do carro e quantas vezes ele foi manobrado para fora (dando passagem para outro carro).
9.  [Difícil] Implemente um algoritmo que controle duas pilhas conjugadas, aproveitando todo os espaço do vetor e não permitindo que nenhum pilha entre em *overflow*. Assim, é preciso ter quatro métodos: dois de inserção (insereP1 e inserep2) e dois de remoção (removeP1 e removeP2). 


# 3 - Fila

Bem, chegamos a nossa segunda estrutura de dados: a Fila. Quando falamos em fila, já pensamos em filas de banco, atendimento e etc. Você irá se espantar se eu lhe disser que é justamente isso. Lembra que falamos sobre "Modelagem Computacional"? Pois é, aqui vamos modelar uma Fila. Intuitivamente a Fila tem a seguinte característica:

> Um elemento entra sempre no final. Ao remover um elemento só podemos remover o elemento no início.

Isso quer dizer que não podemos remover um elemento se ele não for o elemento que está no início (o próximo a ser atendido). Já pensou se você está em uma Fila, esperando cerca de 30 minutos, é o próximo a ser atendido, e alguém passa na sua frente, sem nenhuma justificativa? É realmente indignante! 

Como fizemos com a Pilha, faremos um algoritmo informal para atender pessoas em Fila. Imagine esse cenário: Uma pessoa D chega ao Banco e verifica que a fila para o atendimento que deseja já possui a pessoa A, B e C.

 
* A pessoa D entra no final da fila
* A pessoa A é atendida!
	* *A pessoa B é a próxima a ser atendida*.
* A pessoa B é atendida!
	* *A pessoa C é a próxima a ser atendida*.
* A pessoa C é atendida!
	* *A pessoa D é a próxima a ser atendida*.
* A pessoa D é atendida!

Bem, há uma repetição aqui, então vamos ajustar usando loop:

* A pessoa D entra no final da fila
* Atá que a pessoa C seja atendida!
	* *Atender Próxima pessoa*
* A pessoa D é atendida!

> Ok, garantimos que a pessoa 'D' será atendida conforme sua posição, assim uma pessoa 'E' não será atendida antes dela.

Assim como fizemos com Pilha, vamos também implementar algo mais formal usando a linguagem de programação Java para isso. Como queremos usar POO, vamos criar algumas classes para serem a "forma" dos nossos objetos. Vamos criar o elemento, um Item que será colocado na Fila e a própria fila, para isto usaremos um simples vetor.

Então:

* Uma classe item (sim, podemos usar a mesma da pilha, copie para o seu novo projeto).
* Um vetor.

Além dos locais de armazenamento, precisamos garanti as operações da Fila. A Fila - diferentemente da Pilha - é uma estrutura onde o último elemento a entrar será também o último a sair, isso quer dizer que o primeiro a entrar será o primeiro a sair, por isso ela é conhecida como FIFO (*First Input First Output*).

Então, além dos dados temos:

* Operação de inserir
* Operação de remover


### 3.1 - Inserindo dados na Fila

Mas como controlar que vou inserir no início? Ok, se você pensou "vou usar o mesmo que fiz na pilha", você está no caminho certo. Vamos pensar que temos um vetor de 10 elementos e no inicio todos são nulos.

	[null, null, null, null, null, null, null, null, null, null]

Eu posso inserir na posição com menor índice que possui o valor null, ela será o nosso final.

	["Pessoa A", null, null, null, null, null, null, null, null, null]

Se desejo inserir novamente, eu coloco na próxima posição com menor índice que esteja vazia (null).

	["Pessoa A", "Pessoa B", null, null, null, null, null, null, null, null]

Você certamente já percebeu que eu precisaria verificar, posição por posição até chegar a uma vazia:

	int pos_vazia = 0;
	while( (i< tamanho_fila) && (fila[i] != null) )
		pos_vazia++;
	
	if(pos_vazia < tamanho_fila)
		fila[i] = "Prato C";

**Nossa!!!** Mas isso é muito custoso! Pense em uma Fila de 1 milhão de lugares. Quando tivermos que inserir o primeiro elemento, faremos 999.999 comparações apenas para inserir um único elemento. 


**Usando o fim** (um primo distante do topo)

Uma solução para esse problema é criar uma variável que armazenará o valor (índice) do fim, assim como o topo. Com isso, poderemos sempre inserir em uma posição vazia. No primeiro caso que apresentamos, o fim inicial poderia ter o valor 0.

	fim = 0
	[null, null, null, null, null, null, null, null, null, null]

Seguiremos:
	
	//Inserir Pessoa A
	fim = 1
	["Pessoa A", null, null, null, null, null, null, null, null, null]
	//Inserir Pessoa B
	fim = 2
	["Pessoa A", "Pessoa B", null, null, null, null, null, null, null, null]

Mas como ficaria esse algoritmo?

	//Inserir Pessoa C
	fila[fim] = "Prato C";
	fim++


Só isso? Sim!!! Como na Pilha, além de ter menos linhas, temos menos acesso aos dados. Agora, quando a Fila estiver com 50% de dados, teremos a mesma quantidade de operações que ela como 100% dos dados. **Que legal!!!**


### 3.2 - Removendo Dados na Fila

Para remover um dado na fila, precisaríamos apenas remover o elemento no início, que naquele caso inicial é o 0. Isso é muito simples, mas há o fator complicador que é a realocação de todos os elementos em suas novas posições.

Vetor inicial:
	
	["Pessoa A", "Pessoa B", "Pessoa C", "Pessoa D", null, null, null, null, null, null]

Removendo o primeiro elemento:

	[null, "Pessoa B", "Pessoa C", "Pessoa D", null, null, null, null, null, null]

Realocando os elementos:

	["Pessoa B", "Pessoa C", "Pessoa D", null, null, null, null, null, null, null]


Um algoritmo informal para a realocação seria:

* Remover a posição 0 do vetor;
* A posição 1 é diferente de null?
	* Mova o elemento 1 para 0
* A posição 2 é é diferente de null?
	* Mova o elemento 2 para 1
* A posição 3 é é diferente de null?
	* Mova o elemento 3 para 2

Usando loops:

* i = 0
* Remover a posição i do vetor;
* Enquanto a posição i + 1 for diferente de null
	* Mova o elemento i + 1 para i


Já percebemos que essa solução não é ideal! Poderíamos então usar outra variável  chamada início pra controlar a remoção:

	String item = fila[inicio]
	inicio++
	return item

**Verificações, porque não?**

>  OMG!!! You have YET a error of type 'StackOverflow' on line 4 - Fila.java

Já falei sobre a estória do "O cachorro comeu minha atividade" não é? Então vamos evitar isso fazendo as verificações necessárias no nosso projeto.

Assim como uma pilha, a fila pode ser implementada com vetor ou com lista, estamos implementando com vetor, neste momento.  Chegará o momento de usarmos lista, mais a frente. Bem, usar vetor torna o processo mais básico e agrega algumas limitações como por exemplo um tamanho máximo fixo de elementos que ele aceita. Assim, existem dois motivos para verificarmos uma fila baseada em vetor: inserir em uma fila cheia e remover em uma fila vazia.

As condições para verificar a fila é um pouco mais complexa, mas nada que não possamos aprender. Bem, uma fila não pode está vazia quando o final é 0, isso porque o final e o início caminham ao longo dela. Então, mesmo o final sendo 0, pode ser que o início seja 10, em uma fila com 15 posições. Logo, temos elementos na posição 10, 11, 12, 13 e 14. *Isso impede o desperdício de locais no vetor*. Mas vamos focar nas condições, por hora aceite que a fila vazia pode ser identificada quando o início for igual ao fim.

	if(inicio == fim)
		filavazia = true 


A condição para ela está cheia é também diferente da Pilha. Uma Fila está cheia quando  a subtração do fim pelo início for igual  à 1 (fim - início == 1) ou (fim = início - 1). Como dito antes, o índice do final e do início caminham ao longo da fila. Logo quando o fim for igual ao tamanho da fila e início for 0, ela também está cheia


	if(fim == tamanho_fila) && (inicio == 0) ) || (fim == inicio-1)
			filacheaia = true 



**Explorando mais sobre o início e o fim**


Como dizia Raul Seixas: "eu sou o início, o fim e o meio". Logicamente que ele não estava falando de uma fila, mas poderia. O fim e o início em uma fila não funcionam como o topo de uma Pilha. O topo em uma pilha varia de -1 até o tamanho da pilha. Na Fila isso não seria muito bom. Vamos pensar em uma fila com capacidade para 8 elementos e inicialmente com 4 elementos:

	    inicio                                      fim 
	      |                                          |
	      v                                          v
		    
	["Pessoa A", Pessoa B", "Pessoa C", "Pessoa D", null, null, null, null]


Ao remover os elementos teríamos:

 			     inicio   fim 
				|       |
				v       v
		    
	[null, null, null, "Pessoa D", null, null, null, null]

Adicionando mais 4 elementos teríamos

			   inicio    					              fim 
			     |                                                         |
			     v                                                         v
		    
	[null, null, null, "Pessoa D", "Pessoa E", "Pessoa F", "Pessoa G", "Pessoa H"]


Ok, até ai nada de novo. Mas o que aconteceria se eu removesse 4 elementos?


				                    inicio    fim 
			                              |        |
				                      v        v
		    
	[null, null, null, null, null, null, null, "Pessoa H"]


Sim, temos 7 posições vazias (*nulls*) e não podemos inserir, pois o fim já chegou ao seu limite. Inserir na posição do fim, nessa situação, nos levaria para um erro por acesso à local não permitido. #stackoverflow 

Por esse motivo que, quando vamos inserir e verificamos que o fim chegou no seu limite, ele é transportado para o índice 0, para que possamos inserir mais elementos: 

	if(fim ==tamanho_fila)
			fim = 0;

O mesmo faremos para o inicio, dada as remoções:

	if(inicio == fila.length)
             		inicio = 0;

Como exercício desenhe uma fila de 10 posições, insira elementos e remova-os. Deixando a fila cheia no primeiro momento e depois vazia. Faça isso ao menos 3 vezes na mesma pilha e verá como essa transição funciona.  

**Observações**

Como na Seção anterior, alguns exemplos aqui são didáticos, no sentido de que você entenda o problema. O código a seguir pode apresentar algumas diferenças, mas isso não impacta na solução do problema. Como já dito anteriormente, não há uma solução fechada para um algoritmo. 

**Overview**

Agora você está pronto para consultar o código da Fila.java que implementamos.
	
```java 
public class FilaV<T>{
	private T[] arrayFila;
	private int inicio;
	private int fim;
	
	public FilaV(int size){
		inicio = fim = 0;
		arrayFila = (T[]) new Object[size];
	}
	
	public boolean estaCheia(){
		return ((fim == arrayFila.length-1) && (inicio == 0) )
				|| (fim == inicio-1);
	}
	
	public boolean estaVazia(){
		return inicio == fim;
	}
	
	public T remover(){
		if(!estaVazia()){

			if(inicio == fila.length)
             			inicio = 0;
	     
			T e = arrayFila[inicio];
			inicio++;
			return e;
		}
		
		return null;
	}
	
	public boolean inserir(T e){
		if(fim == arrayFila.length)
			fim = 0;
		
		if(!estaCheia()){
			arrayFila [fim++] = e;
			System.out.println("inserindo - " + fim);
			return true;
		}
		
		return false;
	}
	
	@Override
    public String toString(){
		
        String s = "[";
        int i = inicio; 
        while(i != fim){
        	System.out.println(s);
            if(i == arrayFila.length)
                i = 0;
            
            if(i == fim-1) 
                s+=arrayFila[i];
            else 
                s+=arrayFila[i] + " , ";
        
            i++;
    		
        }
        
        return s + "]";  
    }
}
```


Link aqui: [FilaV.java](https://github.com/LuisAraujo/Disciplina-Estrutura-de-Dados/blob/master/Fila/FilaV.java)

### 3.3 - Breve nota sobre complexidade de uma Fila

### 3.4 - Exercício

1. Desenhe um fila para os seguintes estados, considere além do vetor de 10 posições o topo:
	
	-	Inserir elemento 1
	- 	Inserir elemento 3
	- 	Inserir elemento 4
	- 	Inserir elemento 5
	- 	Remover elemento
	- 	Inserir elemento 6
	- 	Remover elemento
	- 	Remover elemento
	- 	Remover elemento
	- 	Remover elemento
	- 	Inserir elemento 4
1. Modifique a sequência de comandos acima para que haja um *overflow* de inserção. Ou seja, inserir até que o máximo seja alcançado. 
1. Escreva um código que insira os seguintes elementos na fila: 1,3,4,5,6 e 10
2. Escreva um código de remova todos os elementos adicionados em uma fila. O código deve funcionar para qualquer estado da pilha.
2. Escreva um código de insira elementos em uma fila até que a mesma chegue ao estado de cheia. O código deve funcionar para filas de qualquer tamanho.
3. Dada a seguinte inserção em uma fila:  1,3,4,5,6 e 10, remova os 3 últimos elementos inseridos.
4.  Dada a seguinte inserção em uma fila:  1,3,4,5,6 e 10, remova o terceiro elemento inserido (4) e recoloque os dois anteriores.
5.  Crie um código que dado um número n qualquer entre 1 e o tamanho da fila remova todos os elementos até o elemento n (incluindo o n). 
6.  Crie um código que dado um número n qualquer entre 1 e o tamanho da fila remova o elemento n e recoloque todos os elementos anteriores.  O código deve funcionar para qualquer estado da fila.
7. [Média] Implemente um algoritmo de fila de banco. Você deve considerar duas filas: normal e prioridade. Para cada 2 atendimentos normais é realizado 1 de prioridade. Ao realizar um atendimento é preciso dizer o horário. Quando uma pessoa é atendida deve-se exibir o horário de entrada, o horário de atendimento além dos minutos decorridos entre a entrada e a saída. 
8.  [Média] Implemente um algoritmo que simule um estacionamento. Neste estacionamento entram e saem carros pela mesma extremidade. Para remover um carro x é preciso remover todos os inseridos antes dele. Cada manobra deve ser contabiliza e quando um carro sair, deve-se indicar a placa do carro e quantas vezes ele foi manobrado para fora (dando passagem para outro carro).

# 4 - Listas Simplesmente Encadeada

Parabéns, espero que até aqui vocês tenham compreendido o conceito de Pilha e Fila. Caso contrário eu lhe deixo uma máxima que sempre digo: 

> Não importa o quanto você veja, leia ou ouça, você só aprenderá de fato se tentar. O erro nesta fase é normal, mas você deve lidar com ele, verificá-lo, analisá-lo. Isso só ocorrerá se testar o seu código, só assim chegará ao topo, não só da pilha (rs), mas da montanha. Lugar em que habitam os *programadores(as)-ninjas*! 

Assim, Lista Simplesmente Encadeada é uma estrutura multifacetada, ela possui variações dos métodos de inserção e remoção, diferentemente da Fila e Pilha que só permitiam a entrada e saída de dados de um único local. Existem muitos tipos de Lista, mas agora falaremos apenas da Simplesmente Encadeada. Assim, sempre que mencionarmos o termo Lista, nesta Seção, estamos nos referindo à Lista Simplesmente Encadeada.

A Lista está mais próxima de um Vetor do que das estruturas que fizemos até aqui, por isso mesmo é que ela pode ser utilizada em substituição dos vetores, nas Pilhas e Filas, eliminando os problemas de limitação e de desperdício de espaço de memória. Assim, as Listas alocam memória quando necessário e despejam quando não precisam mais. 


**Saindo de Vetor e indo para lista**

Bem, já que listas podem substituir vetores, podemos então modificar os nossos códigos de Pilha e Fila para utilizarem Listas. Por isso, no início deste material estávamos nos referindo à Pilhas e Filas baseadas em vetores (pois não é o único modo de implementação). Mas antes disso, vamos entender como as Listas funcionam.

### 4.1 - A Lista

**O Nó**

Um nó segundo o [Dicionário Online de Português](https://www.dicio.com.br/no-2/) é: *Enlaçamento de fios, de linhas, de cordas, de cordões, fazendo com que suas extremidades passem uma pela outra, amarrando-as*.

Essa definição não é muito boa para o nosso caso, mas o própio dicionário diz, em outra definição: *Vínculo; ligação estreita entre pessoas por afeição ou parentesco*. Bem, agora sim, isso pode ser útil! 

Nós de uma Lista possuem vínculos, como vizinhos. Pense que uma lista é um conjuntos de Nós ligados por arestas e que essas arestas. Além de serem conectados por duas arestas, os Nós possuem propriedades (valores que podemos alocar neles). Fica claro aqui que o Nó é o elemento principal da nossa lista. 

Os Nós, então, se ligam a outros Nós, através das arestas. No Java arestas são objetos ou referências que aqui chamaremos de próximo, afinal um Nó A está ligado ao próximo Nó, o B. 

Pensando assim, em uma possível classe chamada Nó, teríamos duas propriedades, ou atributos, importantes: **o valor que ele armazena** (que pode ser de qualquer tipo, desde um inteiro até um objeto de uma Classe criada por nós) e a** referência para o próximo nó**. 

Em Linguagem C, essa referência é feita com ponteiros, mas aqui em Java os objetos são como ponteiros, eles apontam para um local na memória no qual aquele valor está armazenado. Experimente criar dois objetos e imprimi-los com *System.out.print*.

Então, se os objetos são ponteiros (ou referências), só precisamos colocá-los neste atributo (próximo) e tudo está conectado. Já que um Nó se liga à outro Nó, só precisamos da referência desse outro Nó. Vamos ver como isso ficaria:

    ```java
    public class No<T> {
    	private T valor;
    	private No proximo;	
    } 
	``` 

Voltaremos para o Nó depois, mas, por hora, assuma que esta é a "cara" dele. Antes disso, que tal criarmos o construtor? Bem, o ideal é passar esse valor por parâmetro e deixar o próximo Nó como nulo, pois ao ser criado o nó ainda não estará na lista, não estará ligado, portanto.  

	```java
    public class No<T> {
    	private T valor;
    	private No proximo;	

		public No(T valor) {
			this.valor = valor;
			proximo = null;
		}
    } 
	``` 

**A lista, uma cadeia de Nós**

Okay, agora temos um nó, se juntarmos os nós, eles formarão uma lista. Por exemplo:


	```java
	No a = new No(4);
	No b = new No(5);
	//esse método coloca o parâmetro b - do tipo Nó - em próximo, do objeto a
	a.setProximo(b);
	``` 
Mas como queremos criar um projeto em POO, o ideal seria ter uma classe que armazenasse os nós e que tivesse os métodos tal como inserir, remover e buscar o Nó, não é? 

Então, vamos pensar: "Se um conjunto de Nó é uma Lista, podemos chamar essa classe, que guardará os Nó, de Lista". Isso é semanticamente bom! Mas o que teria nesta Lista? 

1. - Todos os nós criados? 
1. - Teríamos várias variáveis para os nós? 
1. - Um vetor de nós? 

Opa! Mas tudo isso não iria limitar o número de nós? A resposta é: Sim! 

Vamos lá, se um Nó é ligado sempre ao próximo nó, não há, na lista, um Nó "solto no ar", ou seja, que não esteja ligado a outro nó (com exceção da primeira inserção de um nó em uma lista vazia). 

> Então, isso quer dizer que, se eu tenho a referência do primeiro nó eu posso chegar a todos os nós da lista? Sim, isso mesmo e é justamente por isso que não precisamos de um vetor de nós, precisamos apenas do primeiro. 

Mas por qual motivo não guardo o segundo, terceiro ou o último Nó? Bem, o primeiro é o único nó na lista que tem acesso a todos, pois ele tem como próximo o segundo e assim por diante. O segundo nó não tem acesso ao primeiro, só ao próximo, o terceiro, e assim por diante. O mesmo ocorre para o último, afinal ele nem próximo possui (continua como nulo), senão ele não seria o último.
  	
	```java
	public class Lista<T> {
		private No<T> primeiro;
	}
	```

### 4.2 -Inserindo na Lista

Como já foi dito, uma lista está mais para um vetor do que para uma Pilha ou Fila.  Pense bem: Em um vetor nós podemos inserir na posição 0, na posição lenght-1 ou em qualquer outra posição, certo? A lista tem o mesmo comportamento, nela é possível inserir na posição 0, aqui chamamos isso de inserir no início da lista. Podemos inserir no final (idem à length-1), ou em qualquer outras posição qualquer. Vamos ver essas possibilidades, nesta Seção.

Existem muitos tipos de lista, *e.g.,* simplesmente encadeada, circular, duplamente encadeada entre outras variações. O que temos que ter em mente é: estamos querendo eliminar duas coisas: desperdício de espaço e redimencionamento, problemas do vetor. 

Temos que lembrar também que se uma lista está mais para uma nova forma de armazenar cadeias de elementos, podemos, com ela, criar uma Pilha e uma Fila (como fizemos com o vetor). Sim, basta apenas utilizar os métodos de inserir e remover de modo que as regas sejam respeitada: FIFO e LIFO. 

Inicialmente vamos ver operações de uma lista simples ou simplesmente encadeada. 
 
#### 4.2.1 - Inserindo no início

Inserir no início é simples, basta apenas:

- Cria um novo nó
- Dizer que o seu próximo é o que esta agora como primeiro
- Dizer que ele agora é o novo primeiro

Mas como seria isso? Vejamos em Java:

	´´´java
    public void inserirNoInicio(T  valor) {
    		No<T> novo_no = new No<T>(valor);
			novo_no.proximo = primeiro;
			primeiro = novo_no
	}

	´´´
 
#### 4.2.1 - Inserindo no final

Inserir no final é simples também, basta apenas:

- Cria um novo nó
- Andar até o último nó
- Dizer que o próximo desse último nó é o novo nó

Em Java seria:

	´´´java
    public void inserirNoFinal(T  valor) {
    		No<T> novo_no = new No<T>(valor);
			No auxiliar = primeiro;
			while(auxiliar.proximo != null) {
				auxiliar = auxiliar.proximo;
			}
			auxiliar.proximo = novo_no.proximo
	}



#### 4.2.1 - Inserindo de forma ordenada

Inserir de forma ordenada é a forma mais complexa, mais ainda assim não é nenhum *Dragão Branco de Olhos Azuis*. Temos que verificar alguns pontos:

1. Se vamos inserir no início (caso o meu valor inserido seja menor que o valor do primeiro nó)
2. Se vamos inserir no final (caso o meu valor inserido seja maior que todos os nós na lista)
3. Se vamos inserir no meio (caso o meu valor seja um valor entre dois nós da lista)

- Cria um novo nó
- Andar até encontrar um nó maior que ele
- Dizer que o próximo do nó é este nó de valor maior
- (Atenção) Dizer que o próximo nó do nó anterior a este de valor maior é o novo nó (*Ok, leia novamente para entender!*)

	´´´java
	public void inserirNoMeio(T  valor) {
		No<T> novo_no = new No<T>(valor);
	
		No<T> auxiliar = primeiro;
		 
		while((auxiliar != null) && ( auxiliar.obterValor().compareTo(novo_no.obterValor() )) == -1  )
		{
 
			auxiliar = auxiliar.obterProximo();
		}
	 
		auxiliar.proximo(novo_no);	 
	
	}
	´´´

Mas calma! E se a lista estiver vazia? O while não executará e ocorrerá um erro em "auxiliar.proximo", pois ele é nulo. Vamos Ajustar? Que tal criar uma verificação para isso?

	´´´java
	public void inserirNoMeio(T  valor) {
		No<T> novo_no = new No<T>(valor);
	
		No<T> auxiliar = primeiro;
		 
		
		while((auxiliar != null) && ( auxiliar.obterValor().compareTo(novo_no.obterValor() )) == -1  )
		{
 
			auxiliar = auxiliar.obterProximo();
		}

	 	if(this.primeiro == null) { 
			this.primeiro = novo_no;
		else
			auxiliar.proximo(novo_no);
			
	}
	´´´

Ok, revolvemos isso. Agora pense que o nó a ser inserido é maior que todos os nós, teríamos que inserir no final. Neste caso, ocorreria em erro, pelo mesmo motivo anterior. Então, que tal ter outro auxiliar (auxiliar2), que vem um nó antes do auxiliar? Assim poderíamos dizer que o próximo do auxiliar2 seria o nosso novo nó e isso não traria nenhum erro.

	´´´java
 		public void inserirNoMeio(T  valor) {
		No<T> novo_no = new No<T>(valor);
	
		No<T> auxiliar = primeiro;
		No<T> auxiliar2 = null;
		
		while((auxiliar != null) && ( auxiliar.obterValor().compareTo(novo_no.obterValor() )) == -1  )
		{
 			auxiliar2 = auxiliar;
			auxiliar = auxiliar.proximo();
		}

	 	if(this.primeiro == null) { 
			this.primeiro = novo_no;
		else{
			novo_no.proximo = null;
			auxiliar2.proximo = novo_no;
		}
			 
	}
	´´´


Ótimo, como novo_no é o último, o próximo dele pode ser null. Agora vamos imaginar que a lista possui nós e o meu nó é menor que o primeiro nó. Por exemplo, em  uma lista: 2,3,5 e 6 (em ordem) eu desejo inseri o 1. O nosso loop iria parar na primeira comparação, pois "auxiliar.obterValor().compareTo(novo_no.obterValor() )" retornaria 1. Isso nos levaria a entrar no *else* e aí encontramos mais um problema, pois novo_no.proximo não poderia ser null. Ele deveria ser, na verdade primeiro. 
	´´´java
	public void inserirNoMeio(T  valor) {
		No<T> novo_no = new No<T>(valor);
	
		No<T> auxiliar = primeiro;
		No<T> auxiliar2 = null;
		
		while((auxiliar != null) && ( auxiliar.obterValor().compareTo(novo_no.obterValor() )) == -1  )
		{
 			auxiliar2 = auxiliar;
			auxiliar = auxiliar.proximo();
		}

	 	if(this.primeiro == null) { 
			this.primeiro = novo_no;
		else{
			novo_no.proximo = this.primeiro
			auxiliar2.proximo = novo_no;
		}
	}
	´´´


Okay, já estamos finalizando, tenha um  pouco mais de calma!!! Agora pense na última ocasião, onde a minha lista possui nós e eu quero inserir no meio de dois nós. Por exemplo, inserir o 4 (entre o 3 e o 5). Neste caso, auxiliar estaria em 5 e auxiliar2 em 3. Logicamente que o próximo do auxiliar2 será novo_no e o próximo de novo_no será 5.

Isso não seria possível com "novo_no.proximo = this.primeiro". Mas pensando bem, no caso de ele ser inserido no início, o auxiliar seria primeiro ainda (pois dizemos inicialmente que auxiliar = primeiro. Então posso trocar   "novo_no.proximo = this.primeiro" para  "novo_no.proximo = auxiliar" e isso funcionaria nos dois caso: inserir antes de todos e no meio de dois nós. 

O problema é que, caso o auxiliar seja o primeiro nó, auxiliar2 será null e isso ocasionaria um erro. Além disso, se queremos inserir no início, o "ponteiro" do primeiro deverá ser atualizado. Então vamos adicionar esse trecho:
	
	´´´java
	[...]
	else if(auxiliar == this.primeiro) {		
			novo_no.inserirProximo(this.primeiro);
			this.primeiro = novo_no;
	}
	[...]
	´´´
 

Vamos lá, veja como ficou:
	
	´´´java
	public void inserirNoMeio(T  valor) {
		No<T> novo_no = new No<T>(valor);
	
		No<T> auxiliar = primeiro;
		No<T> auxiliar2 = null;
		
		while((auxiliar != null) && ( auxiliar.obterValor().compareTo(novo_no.obterValor() )) == -1  )
		{
 			auxiliar2 = auxiliar;
			auxiliar = auxiliar.proximo();
		}

	 	if(this.primeiro == null) { 
			this.primeiro = novo_no;
		}else if(auxiliar == this.primeiro) {	
			novo_no.proximo = this.primeiro;
			this.primeiro = novo_no;
		}else{
			novo_no.proximo = auxiliar; 
			auxiliar2.proximo = novo_no;
		}	 
	}
	´´´

Pronto!

### 4.3 -Buscando na Lista

Podemos buscar um nó na lista pelo seu valor ou pelo seu índice. Vamos ver buscar antes de remover, pois ele irá nos ajudar a remover um Nó. 

#### 4.3.1 - Buscando um nó pelo seu valor

Para buscar é simples, devemos apenas executar o loop com um auxiliar percorrendo a lista até que o valor seja encontrado ou até chegar ao final da lista:
	
	´´´java
	public No<T> buscar(T valor) {
		 
		No<T> auxiliar = primeiro;
		 
		while((auxiliar != null) && (auxiliar.obterValor().compareTo( valor )) != 0  )
		{
			auxiliar = auxiliar.proximo;
		}
		
		return auxiliar;
	}
	´´´

#### 4.3.1 - Buscando um nó pelo índice

Podemos modificar um pouco esse método e buscar com índice
	
	´´´java
	public No<T> buscarPorIndice(int indice) {
		 
		No<T> auxiliar = primeiro;
		int contador = 0; 
		while((auxiliar != null) && (contador < indice))
		{
			auxiliar = auxiliar.proximo;
			contator++;
		}	
		return auxiliar;
	}
	´´´

Sim, é muito simples! 


#### 4.3.1 - Outras formas de Busca

Assim com a Pilha e Fila, podemos implementar métodos de busca que acessem o primeiro item:
	
	´´´java
	return this.primeiro
	´´´

ou o final:
	´´´java
	auxiliar = this.primeiro
	while((auxiliar.proximo != null))
	{
		auxiliar = auxiliar.proximo;
	}

	return auxilia;
	´´´

### 4.4 -Removendo da Lista

Remover um nó é similar à inserção e à busca, podemos remover no início, no final ou remover um nó específico baseado em valor ou índice dele. 

#### 4.4.1 - Removendo um nó no início

Bem, se estamos removendo do início é sinal que o segundo nó será o nosso novo início. O segundo nó é o próximo do primeiro, certo? Então que tal fazermos isso:
	
	´´´java
	public No<T> removerInicio() {
		 
		No<T> auxiliar = primeiro;
		primeiro = primeiro.próximo;
		auxiliar.proximo = null;
		return auxiliar;
	}
	´´´

#### 4.4.2 - Removendo um nó no final

Remover no final significa que o penúltimo nó será o novo último. Para ser considerado um último nó, na lista, este nó deve ter o seu próximo igual à null (não possui próximo). Então, vamos até o penúltimo nó e dizer que o próximo dele é *null*. Mas como fazemos isso? Assim:
	
	´´´java
	public No<T> removerFinal() {
		 
		No<T> auxiliar = primeiro;
		No<T> auxiliar2 = null;

		while((auxiliar.proximo != null))
		{
			auxiliar2 = auxiliar;
			auxiliar = auxiliar.proximo;
		}

		auxiliar2.proximo = null;

		return auxiliar;
	}
	´´´

#### 4.4.3 - Removendo um nó pelo seu valor

Já sabemos buscar pelo valor do Nó! Temos apenas que considerar algumas coisas referentes ao modo de deleção (início, meio ou final), assim como na inserção.

	´´´java
	public void removerPorValor(T valor) {
		No<T> novo_no = new No<T>(valor);
	
		No<T> auxiliar = primeiro;
		No<T> auxiliar2 = null;
		
		while((auxiliar != null) && (auxiliar.obterValor().compareTo( valor )) != 0  )
		{
			auxiliar2 = auxiliar;
			auxiliar = auxiliar.proximo;
		}

	
		if(auxiliar == null){
			System.out.println("Valor não existe na lista");
		}else if(auxiliar == this.primeiro) {	
			this.primeiro = auxiliar.próximo;
			return primeiro;
		}else{
			auxiliar2.proximo = auxiliar.próximo;
		}
	}
	´´´

#### 4.4.4 - Removendo um nó pelo índice

O código para remover pelo índice é similar à remoção como valor, adicionando o contato, como na busca por índice.

	´´´java
	public void removerPorIndice(int indice) {
		No<T> novo_no = new No<T>(valor);
	
		No<T> auxiliar = primeiro;
		No<T> auxiliar2 = null;
		
		int contador = 0; 
		while((auxiliar != null) && (contador < indice))
		{
			auxiliar = auxiliar.proximo;
			contator++;
		}

	
		if(auxiliar == null){
			System.out.println("Valor não existe na lista");
		}else if(auxiliar == this.primeiro) {	
			this.primeiro = auxiliar.próximo;
			return primeiro;
		}else{
			auxiliar2.proximo = auxiliar.próximo;
		}
	}
	´´´

#### 4.4.5 - Removendo um nó pelo índice

Pensando bem, criamos os métodos de busca por valor e por índice, não seria legal usar esses métodos para retornar o Nó e depois fazer a remoção? Isso fica como desafio.

Formalizando:

**1 - Implemente o métodos de removerPorValor e removerPorIndice usando o método de buscarPorValor e buscarPorIndice.**


**Overview**

```java
public class No<T extends Comparable<T>> {
	
	private T valor;
	private No proximo;
	
	public No(T valor) {
		this.valor = valor;
		proximo = null;
	}
	
	/**obtém o próximo nó */
	public No<T> obterProximo() {
		return this.proximo;
	}
	/**inserir o próximo nó */
	public void inserirProximo(No proximo) {
		this.proximo = proximo;
	}
	/**inserir o valor no nó */
	public void inserirValor(T valor) {
		this.valor= valor;
	}
	/**obter o valor do nó */
	public T obterValor() {
		return this.valor;
	}
	
	//métod toString para exibir o nó
	public String toString() {
		return this.valor.toString();
	}
	
}



public class Lista<T extends Comparable<T>> {
	
	public void inserir(T  valor) {
		No<T> novo_no = new No<T>(valor);
		
		No<T> auxiliar = primeiro;
		No<T> auxiliar2 = null;
		
		while((auxiliar != null) && ( auxiliar.obterValor().compareTo( novo_no.obterValor() )) == -1  )
		{
			auxiliar2 = auxiliar;
			auxiliar = auxiliar.obterProximo();
		}
		
		if(this.primeiro == null) { 
			this.primeiro = novo_no;
		
		}else if(auxiliar == this.primeiro) {
			
			novo_no.inserirProximo(this.primeiro);
			this.primeiro = novo_no;
			
		}else {
			novo_no.inserirProximo(auxiliar);
			auxiliar2.inserirProximo(novo_no);	
		}
	
	}

	public No<T> remover(T valor) {
		
		No<T> auxiliar = primeiro;
		No<T> auxiliar2 = null;

		while((auxiliar != null) && (auxiliar.obterValor().compareTo( valor )) != 0  )
		{
		
			auxiliar2 = auxiliar;
			auxiliar = auxiliar.obterProximo();
		}
		
		
		if(auxiliar == this.primeiro) {
			
			No retorno = this.primeiro;
			this.primeiro = this.primeiro.obterProximo();
			return retorno;
		
		}else if(auxiliar != null)
			auxiliar2.inserirProximo(auxiliar.obterProximo());
		
		return auxiliar;
		
	}

	public No<T> buscar(T valor) {
		 
		No<T> auxiliar = primeiro;
		 
		while((auxiliar != null) && (auxiliar.obterValor().compareTo( valor )) != 0  )
		{
			 
			auxiliar = auxiliar.obterProximo();
		}
		
	
		 
		return auxiliar;
	}
	 
	public String toString() {
		String s = "";
		No<T> auxiliar = primeiro;
		
		while(auxiliar != null)
		{
			//incrementa o valor
			s+= auxiliar.obterValor().toString() + " - ";
			//pula para o próximo
			auxiliar = auxiliar.obterProximo();
		}
		
		return s;
	} 
	
}


```



## 5 - Lista Duplamente Encadeada

A Lista duplamente encadeada, diferentemente da simplesmente, possui dois links para Nós, um para o próximo nó e outro para o nó anterior. Mas para quê? Com a Lista Simplesmente Encadeada já resolvemos os problemas do vetor, mas ainda assim queremos melhorar nosso algoritmo de busca. 

Vamos pensar um pouco: temos uma lista como 1.000 Nós (1,2,3,4... 1000). Desejamos buscar o item número 30, logo varemos 30 interações (nó a nó). Agora queremos buscar o item 29, e novamente faremos mais 29 interações, partindo do início. Agora se em uma lista pudéssemos sair do 30 e voltar para o 29. Nesse caso, só teríamos 1 interação. Legal, não é? 

A esta altura você deve está se perguntando: mais uma lista para aprender?! Não necessariamente, podemos apenas modificar o código da simplesmente encadeada, facilitando a nossa vida. Vejamos pela estrutura a seguir:

 	```java
    public class No<T> {
    	private T valor;
    	private No proximo;	
		private No anterior;
	
		public No(T valor) {
			this.valor = valor;
			proximo = null;
			anterior = null;
		}
    } 
	``` 

#### 5.1 - Inserindo na Lista Duplamente

Os código são similares a simplesmente, como já dito. Basta prestar atenção no novo atributo: o anterior.

#### 5.1.1 - Inserindo no início

Nada muda aqui! 

	´´´java
    public void inserirNoInicio(T  valor) {
    		No<T> novo_no = new No<T>(valor);
			novo_no.proximo = primeiro;
			primeiro = novo_no
	}

	´´´
 
#### 5.1.2 - Inserindo no final

Quase nada muda aqui! Apenas o link do nó anterior do novo_no que precisa ser considerado (novo_no.anterior = auxiliar).

	´´´java
    public void inserirNoFinal(T  valor) {
    		No<T> novo_no = new No<T>(valor);
			No auxiliar = primeiro;
			while(auxiliar.proximo != null) {
				auxiliar = auxiliar.proximo;
			}
			auxiliar.proximo = novo_no.proximo;
			novo_no.anterior = auxiliar;
	}


### 5.1.3 - Inserindo de forma ordenada

Vejamos o código da simplemente:


	public void inserirNoMeio(T  valor) {
		No<T> novo_no = new No<T>(valor);
	
		No<T> auxiliar = primeiro;
		No<T> auxiliar2 = null;
		
		while((auxiliar != null) && ( auxiliar.obterValor().compareTo(novo_no.obterValor() )) == -1  )
		{
 			auxiliar2 = auxiliar;
			auxiliar = auxiliar.proximo();
		}

	 	if(this.primeiro == null) { 
			this.primeiro = novo_no;
		}else if(auxiliar == this.primeiro) {	
			this.primeiro.anterior = novo_no
			novo_no.proximo = this.primeiro;			
			this.primeiro = novo_no;
		}else{
			novo_no.proximo = auxiliar;
			auxiliar.anterior = novo_no; 
			auxiliar2.proximo = novo_no;
			novo_no.anterior = auxilia2;
		}
	}


Ok! Olhando bem esse código é perceptível que não precisamos mais desse auxiliar2, pois agora podemos acessar auxiliar.anterior!

	public void inserirNoMeio(T  valor) {
		No<T> novo_no = new No<T>(valor);
	
		No<T> auxiliar = primeiro;
		
		while((auxiliar != null) && ( auxiliar.obterValor().compareTo(novo_no.obterValor() )) == -1  )
		{
			auxiliar = auxiliar.proximo();
		}

	 	if(this.primeiro == null) { 
			this.primeiro = novo_no;
		}else if(auxiliar == this.primeiro) {	
			this.primeiro.anterior = novo_no
			novo_no.proximo = this.primeiro;			
			this.primeiro = novo_no;
		}else{
			novo_no.proximo = auxiliar;
			auxiliar.anterior = novo_no; 
			auxiliar.anterior.proximo = novo_no;
			novo_no.anterior = auxilia.anterior;
		}
	}

#### 5.2 - Buscando na Lista Duplamente

Assim como na Lista Simples, podemos buscar um nó tanto pelo seu valor como pelo seu índice. Vamos ver buscar.

#### 5.2.1 - Buscando no início

A busca no início é similar à uma operação de pilha ou de fila, pois estamos interessados em remover de apenas uma das extremidade. Como queremos busca no início e já temos uma atributo que guarda esse valor, basta retorná-lo.

	´´´java
	public No<T> buscarInicio(T valor) {
			
		return primeiro;
	}
	´´´

#### 5.2.2 - Buscando no final

A busca no final é simples: vamos andando na lista até chegar ao final e então retornando o objeto. Para saber se um nó da lista é o último, basta verificar se o próximo dele é nulo. 

	´´´java
	public No<T> buscarNoFinal(T valor) {
		 
		No<T> auxiliar = primeiro;
		 
		while( auxiliar.proximo != null )
		{
			auxiliar = auxiliar.proximo;
		}
		
		return auxiliar;
	}
	´´´

Tanto essa busca como a busca no início pode ser aplicado na lista simples e na lista circular que veremos mais a frente. 

#### 5.2.3 - Buscando por valor em uma lista ordenada

A busca por valor não tem nada de diferente da busca por valor na lista simples. No entanto, caso a sua lista esteja ordenada, nós podemos otimizar essa busca. Imagine que a sua lista possui 10 elementos de valores inteiros e vocês quer buscar o elemento de valor 6, é muito provável que ela esteja no meio da lista. Mas não temos uma variável que guarda o meio da lista. Bem, poderíamos criá-la? Sim! Mas imagine que você quer buscar o elemento de valor 9 ou o de valor 2, seria muito custoso e nada generalista ter um atributos para cada setor da lista. 

Com base nisso, podemos abordar o problema de uma outra forma: imagine que você tenha criado um novo atributo que fica na posição da último nó buscado e com base nele você irá fazer as operações.

```java

public class Lista<T> {
	private No<T> primeiro;
	private No<T> noatual;
}

```
 
A cada busca, nós atualizamos esse ultimobuscado. 


```java

public No<T> buscar(T valor) {
 
No<T> auxiliar = primeiro;
 
while( auxiliar.proximo != null )
{
	auxiliar = auxiliar.proximo;
}
if(auxiliar != null)
	ultimobuscado = auxiliar;

return auxiliar;
}
```

Ok, mas isso não melhorou em nada a nossa busca, pelo contrário, eu tenho agora uma operação de comparação e outra de atribuição. Bem, para isso precisamos fazer a seguinte abordagem: dado o último nó buscado, verificamos se o valor é maior ou menor que ele, se for maior, vamos para o próximo, se for menor vamos para o anterior. 

```java
public No<T> buscarPorValor(T valor) {
	
		
	if(no_atual== null)
		no_atual = primeiro;
	
	while((no_atual != null) && (no_atual.obterValor().compareTo( valor )) != 0  )
	{
		if (no_atual.obterValor().compareTo(valor)==-1)
            no_atual = no_atual.obterProximo();
        else 
            no_atual=no_atual.obterAnterior();	
	}
	
	return no_atual;
}	
```

Que bacana, não é? Teste a quantidade de comparações necessárias para se buscar um valor, em uma sequência aleatória e logo verá que esse método é muito melhor que o da lista simples que inicia no inicio e varria toda a lista. Você pode usar o método *buscarCount* na Lista Duplamente. O pior caso dessa busca é igual à busca simples percorreremos n nós. Mas, na média, vamos percorrer apenas n/2. 

#### 5.2.4 - Buscando por índice

A busca pelo índice é similar. Mudamos apenas o valor pelo índice. 


```java
public class Lista<T> {
	private No<T> primeiro;
	private No<T> noatual;
	private Int index;
}
```


Agora estamos comparando um valor inteiro. Caso o índice seja menor fazemos um loop com incremento, caso contrário como decremento. 

```java
public No<T> buscarPorIndice(int indexbusca) {
	int i;
	
	if(no_atual == null){
		no_atual = primeiro;
		index = 0;
	}
	
	if (no_atual.obterValor().compareTo(valor)==-1){
            
			for(i = index; i < indexbusca; i++){
				if(no_atual == null)
					return null;

				no_atual = no_atual.obterProximo();
			}	
			

    } else {
            for(i = index; i > indexbusca; i--){
				if(no_atual == null)
					return null;

				no_atual = no_atual.obterProximo();
			}		
	}

	index = i;
	return no_atual;
}
```

É importante ainda sempre verificar se o nó é nulo, pois o índice pode ser maior que o tamanho da lista ou em caso do índice ser negativo.

#### 5.3 - Removendo na Lista Duplamente

A remoção na lista duplamente é como a lista simples, no entanto temos que ter uma atenção para o novo parâmetro do nó: o anterior. 

#### 5.3.1 - Removendo no início

Nós já conhecemos esse método, precisamos apenas adicionar o primeiro.anterior = null, por dois motivos: o primeiro nó não possui anterior a ele e eliminar a referência do nó removido da nossa lista;

```java
public No<T> removerInicio() {
	 
	No<T> auxiliar = primeiro;
	primeiro = primeiro.próximo;
	primeiro.anterior = null;
	auxiliar.proximo = null;
	return auxiliar;
}
```

#### 5.3.2 - Removendo no final

O mesmo vale para esse novo código.
	
```java
public No<T> removerFinal() {
	 
	No<T> auxiliar = primeiro;
	No<T> auxiliar2 = null;

	while((auxiliar.proximo != null))
	{
		auxiliar2 = auxiliar;
		auxiliar = auxiliar.proximo;
	}

	auxiliar.anterior = null;
	auxiliar2.proximo = null;

	return auxiliar;
}
```

Uma observação é importante aqui, podemos reduzir esse código utilizado o métodos de busca no final. 

```java
public No<T> removerFinal() {
	 
	No<T> auxiliar = buscarNoFinal();
	
	if(auxiliar != null){
		auxiliar.anterior = null;
		auxiliar.anterior.proximo = null;
	}

	return auxiliar;
}
```

#### 5.3.3 - Removendo por valor

Vamos usar a mesma abordagem do código anterior e utilizar o método de busca por valor.

```java
public No<T> removerPorValor() {
	 
	No<T> auxiliar = buscarPorValor();
	
	if(auxiliar != null){
		if(auxiliar.proximo != null)
			auxiliar.proximo.anterior = auxiliar.anterior;
			
		if(auxiliar.anterior != null)
			auxiliar.anterior.proximo = auxiliar.próximo;
	}

	return auxiliar;
}
```

#### 5.3.4 - Removendo por índice

Mas usam vez vamos reutilizar código, afinal para que serve utilizar Orientação a Objeto, se não fazemos uso das suas potencialidades?

```java
public No<T> removerPorValor() {
	 
	No<T> auxiliar = buscarPorÍndice();
	
	if(auxiliar != null){
		if(auxiliar.proximo != null)
			auxiliar.proximo.anterior = auxiliar.anterior;
			
		if(auxiliar.anterior != null)
			auxiliar.anterior.proximo = auxiliar.próximo;
	}

	return auxiliar;
}
```
**Overview**

```java
public class No<T extends Comparable<T>> {
	
	private T valor;
	private No proximo;
        private No anterior;
	
	public No(T valor) {
		this.valor = valor;
		proximo = null;
                
	}
	
	/**obtém o próximo nó */
	public No<T> obterProximo() {
		return this.proximo;
	}
        
        public No<T> obterAnterior() {
		return this.anterior;
	}
	/**inserir o próximo nó */
	public void inserirProximo(No proximo) {
		this.proximo = proximo;
	}
        
        public void inserirAnterior(No anterior) {
		this.anterior = anterior;
	}
	/**inserir o valor no nó */
	public void inserirValor(T valor) {
		this.valor= valor;
	}
	/**obter o valor do nó */
	public T obterValor() {
		return this.valor;
	}
	
	//métod toString para exibir o nó
	public String toString() {
		return this.valor.toString();
	}
	
}

public class ListaDuplamente< T extends Comparable<T>> {
    
    
	No<T> primeiro;
    No<T> no_atual = primeiro;
	
	
	public void inserir(T  valor) {
		No<T> novo_no = new No<T>(valor);
		No<T> auxiliar = primeiro;
		
		if(this.primeiro == null) { 
			this.primeiro = novo_no;
		
		}else{
		
			while((auxiliar.obterProximo() != null) && 
			( auxiliar.obterValor().compareTo( novo_no.obterValor() ) == -1 ) )
			{
				auxiliar = auxiliar.obterProximo();
			}
			
			if(auxiliar == this.primeiro) {
				
				if(this.primeiro.obterValor().compareTo( novo_no.obterValor() ) == -1 ) {
					
					this.primeiro.inserirProximo(novo_no);
					novo_no.inserirAnterior(this.primeiro);

				}else {
					
					novo_no.inserirProximo(this.primeiro);
					this.primeiro.inserirAnterior(novo_no);
					this.primeiro = novo_no;
				}
				
			}else {
				
				if(auxiliar.obterProximo() == null) {
					novo_no.inserirAnterior(auxiliar);
					auxiliar.inserirProximo(novo_no);
				}else {
				novo_no.inserirProximo(auxiliar);
				novo_no.inserirAnterior(auxiliar.obterAnterior());
	            auxiliar.obterAnterior().inserirProximo(novo_no);
	            auxiliar.inserirAnterior(novo_no);
				}
			}
			
		}
	
	}
        
       
	public No<T> remover(T valor) {//arrumada 
		
		No<T> auxiliar = primeiro;
		
                No<T> retorno =null;

		while((auxiliar != null) && (auxiliar.obterValor().compareTo( valor ) != 0)  )
		{
			auxiliar = auxiliar.obterProximo();
		}
		
		
		if(auxiliar == this.primeiro) {
			
			retorno = this.primeiro;
                        retorno.inserirProximo(null);
			this.primeiro = this.primeiro.obterProximo();
                        this.primeiro.inserirAnterior(null);
			
		
		}else if(auxiliar != null)
			auxiliar.obterAnterior().inserirProximo(auxiliar.obterProximo());
                auxiliar.obterProximo().inserirAnterior(auxiliar.obterAnterior());
                auxiliar.inserirProximo(null);
                auxiliar.inserirAnterior(null);
	
		
		return retorno;
		
	}
	
	
	public No<T> buscar(T valor) {
		
			
		if(no_atual== null)
			no_atual = primeiro;
		
		while((no_atual != null) && (no_atual.obterValor().compareTo( valor )) != 0  )
		{
			if (no_atual.obterValor().compareTo(valor)==-1){
                no_atual = no_atual.obterProximo();
            }
            else 
                no_atual=no_atual.obterAnterior();
	
			
		}
		
	
		
		return no_atual;
	}
	
	
	public String buscarCount(T valor) {
		
		int count = 0;
		
		if(no_atual== null)
			no_atual = primeiro;
		
		while((no_atual != null) && (no_atual.obterValor().compareTo( valor )) != 0  )
		{
			count++;
            if (no_atual.obterValor().compareTo(valor)==-1){
                no_atual = no_atual.obterProximo();
            }
            else 
                no_atual=no_atual.obterAnterior();
		}
		
		
		return "Achou "+no_atual.obterValor()+" com "+count + " passos";
	}
	

	public String toString() {
		String s = "";
		No<T> auxiliar = primeiro;
		
		while(auxiliar != null)
		{
			
			s+= auxiliar.obterValor().toString() + " - ";

			auxiliar = auxiliar.obterProximo();
		}
		
		return s;
	} 
	
}

```


## 6 - Lista Circular

A Listas Duplamente Encadeada supera o problema de voltar ao início, reduzindo o número de interações para achar nós próximos. Lembra do caso de busca o nó de valor 30 e depois o 29? Estendendo esse problema, imagine que queremos buscar o nó de valor 999, inicialmente faremos 999 interações. Agora queremos busca o nó de valor 10, teríamos que fazer 989 interações para voltar. Não seria interessante seguir até o final e ter um "portal" que nos leve ao início? Assim faríamos 11 interações apenas (1000, 1, 2, 3 ... 10). 

Tenho uma coisa importante para dizer: A Lista Circular possui esse portal. A sua estrutura é similar à Duplamente Encadeada, por isso não repetiremos o código aqui. Ela possui o mesmo tipo de nó e apenas algumas modificações nas operações. 


> O princípio básico aqui é que o primeiro nó é ligado ao último e o último é ligado ao primeiro. Assim, poderíamos andar até o final e chegar o início novamente.


#### 6.1 - Inserindo na Lista Circular

Vamos ver os métodos de inserção, neta seção.

#### 6.1.1 - Inserindo no início e final

A lista circular não possui início ou fim, nenhum nó tem links com valor nulo.  Temos o atributo primeiro apenas para nos ajudar nas operações, afinal precisamos sair de algum lugar. Até o primeiro nó possui um link para ele mesmo. Assim, toda inserção na lista é igual, mas antes disso vamos aos caso específicos.

#### 6.1.2 - Inserindo em uma lista vazia

veja o trecho do código a seguir, isso gera um nó com link para ele mesmo. Que louco em?

```java
this.primeiro =novo_no;
noAtual = this.primeiro;
this.primeiro.inserirProximo(novo_no);
this.primeiro.inserirAnterior(novo_no);
```

#### 6.1.3 - Inserindo em uma lista com apenas um nó
```java
No<T> temp = this.primeiro;
if(temp.obterProximo() == temp) {
	temp.inserirProximo(novo_no);
	temp.inserirAnterior(novo_no);
	novo_no.inserirAnterior(temp);
	novo_no.inserirProximo(temp);
```

#### 6.1.4 - Inserindo de, forma ordenada, um nó menor que o nó inicial

```java
novo_no.inserirProximo(this.primeiro);
novo_no.inserirAnterior(this.primeiro.obterAnterior());
this.primeiro.obterAnterior().inserirProximo(novo_no);
this.primeiro.inserirAnterior(novo_no);

this.primeiro = novo_no;
noAtual = this.primeiro.obterAnterior();
```

#### 6.1.5 - Todas os outros casos

```java
while( (novo_no.obterValor().compareTo(temp.obterValor() ) == 1)) { 
 	temp = temp.obterProximo();

	//fechou um ciclo
	if(temp == this.primeiro)
		break;
}


novo_no.inserirProximo(temp);
temp.obterAnterior().inserirProximo(novo_no);
novo_no.inserirAnterior(temp.obterAnterior());
temp.inserirAnterior(novo_no);
```

#### 6.2 - Buscando na Lista Circular

Como os métodos de buscar são similares, vamos fazer outra abordagem aqui que serve para a circular. Vamos criar um atributo chamado último nó que guardará não o último nó da lista, mas o último nó buscado e vamos fazer a busca a partir dele. Similar como fizemos na busca duplamente. Mas aqui, temos a vantagem do portal que nos permitirá sair de uma extremidade até outra.

Nessa abordagem nós consideramos que dada uma busca de um valor maior que o nó atual (último buscado) e considerando que a busca esteja uma uma posição bem inicia da lista (por exemplo 10% da lista) ou, no caso oposto, uma busca de um elemento de valor menor e a busca esteja em uma posição final da lista (por exemplo 90%). 

Nessas duas situações pensamos se é melhor seguir para frente ou para trás. Imagine uma busca em uma lista de 100 elementos ordenados, o último elemento é 90 e a o primeiro 0. A última busca está no quinto elemento de valor 5. É obvio que é melhor eu retornar até chegar ao outro lado da lista, do que seguir até o final da mesma. O mesmo ocorre se a última busca tenha sido 90 e queremos encontrar o elemento de valor 5, é melhor seguir até o outro lado da lista. 

Caso não tenha entendido, pense um pouco olhando essa imagem com a comparação do primeiro caso:

#### 6.2.1 - Buscando Nós sem andar muito

Inicialmente vamos criar flags para saber se devemos andar para frente ou para trás:

```java

if( (prior) || (!next))
	this.obterNoAnterior();
else if( (next) || (!prior)) 
	this.obterNoProximo();

```

Quem decidirá a direção são dois fatores: o valor que eu busco em comparação com o nó atual e a posição que estamos na lista, nessa abordagem temos mais um atributo chamado *qtdNo* que guarda a quantidade de nós que teremos na lista. Logicamente que os métodos de inserção e remoção precisam ser atualizados para esse controle. 


```java
boolean prior = true;
boolean next = true;

//valor buscado é menor que o currenteNode?
if(valor.compareTo(noAtual.obterValor())  == -1 )  {
			
	//estou em 90% do final da lista
	if(indiceNoAtual < qtdNo*0.9) {
		prior = false;
	}

}else if(valor.compareTo( noAtual.obterValor())  == 1 )  {

	//estou em 10% do final da lista
	if(indiceNoAtual < qtdNo*0.1) {
		next = false;
	}

}else {
	return noAtual;
}

```

O código completo é a junção dos dois trechos apresentados, com a adição de alguns elementos que visam verificar a parada *stop* e caminhar na lista. 

#### 6.3 - Removendo na Lista Circular

Para remover, precisamos considerar o novo link entre o primeiro e o último nó. Vejamos os códigos.

#### 6.3.1 - Removendo por valor

Observe que estamos utilizando a versão como o contador do qtdNo, você pode fazer isso em outros métodos. 

```java

public void remover(T valor) {
	
	No n= buscarOtim(valor);
	
	if(n != null) {
		qtdNo--;
		if(n == this.primeiro) {
			
			this.primeiro.obterAnterior().inserirProximo(this.primeiro.obterProximo());
			this.primeiro.obterProximo().inserirAnterior(this.primeiro.obterAnterior());
			this.primeiro = this.primeiro.obterProximo();
			
		}else {
			
			n.obterAnterior().inserirProximo(n.obterProximo());
			n.obterProximo().inserirAnterior(n.obterAnterior());
			
		}
		
	}
	
}

```


#### 6.3.2 - Removendo por índice

Aqui podemos utilizar a mesma busca por índice que a lista duplamente.

```java

public void remover(T valor) {

No n= buscarPorIndice(valor);

if(n != null) {
	qtdNo--;
	if(n == this.primeiro) {
		
		this.primeiro.obterAnterior().inserirProximo(this.primeiro.obterProximo());
		this.primeiro.obterProximo().inserirAnterior(this.primeiro.obterAnterior());
		this.primeiro = this.primeiro.obterProximo();
		
	}else {
		
		n.obterAnterior().inserirProximo(n.obterProximo());
		n.obterProximo().inserirAnterior(n.obterAnterior());
		
	}	
}	
}

```
**Overview**


```java

public class No <T extends Comparable<T>>{

	No prior;
	No next;
	T data;	
	
	public No(T data) {
		this.data = data;
	}
	public No(T data, No prior, No next) {
		this.data = data;
		this.prior = prior;
		this.next = next;
	}
	
	public No<T> obterAnterior() {
		return prior;
	}
	public void inserirAnterior(No prior) {
		this.prior = prior;
	}
	public No<T> obterProximo() {
		return next;
	}
	public void inserirProximo(No next) {
		this.next = next;
	}
	public T obterValor() {
		return data;
	}
	public void inseriValor(T data) {
		this.data = data;
	}
	public String toString() {
		return this.data.toString();
	}
}


public class ListaCircular<T extends Comparable<T>> {

	public No<T> primeiro;
	public No<T> noAtual;
	public int qtdNo = 0;
	public int indiceNoAtual = 0;
	
	public ListaCircular() {
		this.primeiro = null;
	}
  	
	public void inserir(T valor) {
		qtdNo++;
		No<T> novo_no = new No<T>(  valor);
		
		if(this.primeiro== null) {
			this.primeiro =novo_no;
			noAtual = this.primeiro;
			this.primeiro.inserirProximo(novo_no);
			this.primeiro.inserirAnterior(novo_no);
		}else {
		    No<T> temp = this.primeiro;
		    //apenas 1 nó
		    if(temp.obterProximo() == temp) {
	    		temp.inserirProximo(novo_no);
	    		temp.inserirAnterior(novo_no);
	    		novo_no.inserirAnterior(temp);
	    		novo_no.inserirProximo(temp);
	    		 
	    	//o nó inserido é menor que o primeiro nó
		    }else if(novo_no.obterValor().compareTo(this.primeiro.obterValor() ) == -1) {
	    	        	
		    	novo_no.inserirProximo(this.primeiro);
		    	novo_no.inserirAnterior(this.primeiro.obterAnterior());
		    	this.primeiro.obterAnterior().inserirProximo(novo_no);
		    	this.primeiro.inserirAnterior(novo_no);
		    	
		    	this.primeiro = novo_no;
		    	noAtual = this.primeiro.obterAnterior();
		    	
		    	    	
		    }else{
		    	
	    		//enquanto o novo nó for maior que o temp (até encontrar alguém maior
		    	//que ele
			    while( (novo_no.obterValor().compareTo(temp.obterValor() ) == 1)) { 
			     	temp = temp.obterProximo();
			
			    	//fechou um ciclo
			    	if(temp == this.primeiro)
			    		break;
			    }
			
			  
	    		novo_no.inserirProximo(temp);
	    		temp.obterAnterior().inserirProximo(novo_no);
				novo_no.inserirAnterior(temp.obterAnterior());
				temp.inserirAnterior(novo_no);
				
	    	}			
		}
	}

	public void remover(T valor) {
		
		No n= buscarOtim(valor);
		
		if(n != null) {
			qtdNo--;
			if(n == this.primeiro) {
				
				this.primeiro.obterAnterior().inserirProximo(this.primeiro.obterProximo());
				this.primeiro.obterProximo().inserirAnterior(this.primeiro.obterAnterior());
				this.primeiro = this.primeiro.obterProximo();
				
			}else {
				
				n.obterAnterior().inserirProximo(n.obterProximo());
				n.obterProximo().inserirAnterior(n.obterAnterior());
				
			}
			
		}
		
		
	}
	
	
	public No<T> buscar(Comparable valor) {
		No temp = this.primeiro;
		
		while(valor.compareTo( temp.obterValor() ) == 1) { 
			temp = temp.obterProximo();
	
	    	//fechou um ciclo ou passou do valor
	    	if((temp == this.primeiro) || (valor.compareTo( temp.obterValor() ) == -1))
	    		return null;
	    }
		
		return temp;
		 
		
	}
	
	
	public No<T> buscarOtim(Comparable valor) {
		
		boolean prior = true;
		boolean next = true;
		
		//valor buscado é menor que o currenteNode?
		if(valor.compareTo(noAtual.obterValor())  == -1 )  {
						
			//estou em 90% do final da lista
			if(indiceNoAtual < qtdNo*0.9) {
				prior = false;
			}
			
		}else if(valor.compareTo( noAtual.obterValor())  == 1 )  {
			
			//estou em 10% do final da lista
			if(indiceNoAtual < qtdNo*0.1) {
				next = false;
			}
			
		}else {
			return noAtual;
		}
			
		No stop = noAtual;
		
		if( (prior) || (!next))
			this.obterNoAnterior();
		else if( (next) || (!prior)) 
			this.obterNoProximo();
		
		
		while(valor.compareTo(noAtual.obterValor() ) != 0) { 
			if( (prior) || (!next))
				this.obterNoAnterior();
			else if( (next) || (!prior)) 
				this.obterNoProximo();
		
			//fechou um ciclo
			if(noAtual == stop)
				return null;
		}

		
		return noAtual;
		 
		
	}
	
	
	public No<T> obterNoProximo() {
		indiceNoAtual++;
		noAtual = noAtual.obterProximo();
		return noAtual;
	}
	
	public No<T>  obterNoAnterior() {
		indiceNoAtual--;
		noAtual = noAtual.obterAnterior();
		return noAtual;
	}

	public void resetCurrentNode() {
		this.noAtual = this.primeiro.obterAnterior();
	}
	
	public String toString() {
		String s = "";
		resetCurrentNode();
		No stop = noAtual;
		
		do {
			obterNoProximo();
			s+= noAtual .obterValor().toString() + " - ";
		}while(noAtual !=  stop);
		
		return s;
	} 
	
	
	
}
```



### 7 - Árvores

Árvores! Nessa **altura** você deve ter si perguntado: o que árvores tem haver com programação? **Folhas**? **Raiz**? **Ganhos**? Sim, tudo isso tem relação. A ideia da estrutura da dados Árvore é similar a estrutura de uma árvore, presente na natureza. Embora a representação seja de cabeça para baixo (e embora árvores não tenha cabeça), elas possuem uma raiz (primeiro nó), folhas (nós sem filhos), altura e muito mais.

Cada nó em uma árvore possui nós vinculados a eles que chamados de filho (São como os links próximo e anterior, mas aqui são substituídos por outas nomenclaturas)

### 7.1 - Árvore Binária de Busca (ABB)

Aqui temos os mesmos Nós que a lista, muito similar à da duplamente encadeada modificando apenas o atributo próximo para direito e o anterior para o esquerdo. Essas duas referências dos nós são, na verdade, filhos do nó que as contém. Por exemplo: Um nó B pode ter dois filhos: A e C, um à esquerda e outro à direta. Esse é o principal conceito de Árvore Binária: **cada nó possui no máximo dois nós**. Mas um Nó pode ter apenas 1 ou nenhum nó (não passando de dois).

#### Uma pausa para mais conceitos

Além dos nós e filhos, alguns outros conceitos são importantes quando falamos em Árvores. Por exemplo, uma árvores pode ter *altura* () e um nó pode está em um *nível* (). Um nó sem filhos é chamado de *nó folha*. Um *caminho ou percurso* é o conjunto de nós que nos fazem sair de um nó A e ir até um nó Z. O *nó raiz* é o nó cujo não possui antecedentes, ou seja, não tem pai. O nó raiz é o nó que fica no topo da árvore. 

Um elemento importante da árvore binária de busca é que, **ao inserir filhos, deve-se verificar se ele é maior ou menor que o pai. Se for menor, deverá ser um filho à esquerda e se for maior deverá ser um filho à direita**. Caso o nó já possua dois filhos, devemos andar pelos nós até encontrar um nó sem filhos, onde possamos alocá-lo.  

Árvore Binária é muito utilizada me buscas, pois reduz bastante a busca, em alguns casos. Um lista simplesmente encadeada, no pior caso realiza n operações para a busca, uma árvore, no pior caso realiza *log2 n* interações.

#### 7.1.1 - Nó

Como já mencionado, o Nó da árvore é similar ao nó da lista. Outro elemento importante que podemos adicionar o o atributo do nó pai. 

```java
public class No<T extends Comparable<T>> {

	No esquerdo;
	No direito;
	T valor;
	No pai;

	public No(T valor) {
		this.valor = valor;
	}
```	


#### 7.1.2 - Inserção

O princípio de inserção em uma ABB é que não há elementos repetidos. Assim, ao inserir um elemento, nós devemos buscar um local vazio cujo o seu pai seja menor que ele, se ele foi um filho à direita ou maior se ele for um filho à esquerda. Para isso, precisamos fazer a verificação do valor e andar para o próximo nó. 

Devemos considerar alguns aspectos, por exemplo se a árvores está vazia. Neste caso, o nó inserido será a raiz da árvore.


```java
public No inserirNo(No novo, No pai) {
		
		if(raiz == null) {
			raiz = novo;
```

Nós vamos criar um método anterior ao método inseritNo que só receberá um valor e criará o novo nó e passará a referência para o inserirNo. O usuário deverá usar apenas o inserir. Veja:

```java
public No inserirNo(T valor) {
		No<T> n = new No<T>(valor);
		return inserirNo(n, null);
		
	}
```

> Mas porque isso? Bem, estamos prevendo algumas coisas. Apenas aceite que assim tudo ficará mais fácil lá na frente, em especial porque utilizaremos recursividade para o inserirNo.

Ok, sabendo agora disso, a primeira chamada ao método inserirNo será com o parâmetro pai como *null*, lá dentro isso será convertido para raiz. Outro passo é verificar se o valor do nosso nó é maior ou menor, para os dois caso, precisamos verificar se o filho à esquerda ou direita é null (ou seja, há uma vaga disponível). Caso isso não seja verdade, precisamos chamar o métodos inseriNo recursivamente, mas agora atualizando o No pai. Nesse caso estamos pulando o nó (esse é um dos princípio da árvores, nela existem subárvores). 


```java
public No inserirNo(No novo, No pai) {
		
		if(pai == null)
			pai = raiz;
		
		if(raiz == null) {
			raiz = novo;
		}else {
			//menor
			if( novo.obterValor().compareTo(pai.obterValor()) == -1) {
				
				if(pai.obterNoEsquerdo() == null)
					pai.inserirEsquerdo(novo);
				else
					inserirNo(novo, pai.obterNoEsquerdo());
				
			}else {
				
				if(pai.obterNoDireito() == null)
					pai.inserirDireito(novo);
				else
					inserirNo(novo, pai.obterNoDireito());
			}
		}
		
		return novo;
		
	}
```

#### 7.1.3 - Busca

A busca na árvores é similar à insersão, pois estamos querendo percorrer um caminho até chegar o nosso nó. Caso encontremos um nó null pelo caminho significa que não há esse valor na árvore. Ao encontrar um elemento com valor igual ao buscado, retornamos esse valor. Em caso do elemento buscado ser maior, vamos para a subárove à direita. Em caso do elemento buscado ser menor, vamos para a subárvores à esquerda. 

```java
public No buscarNo(No novo, No pai) {
		
	if(pai == null)
		pai = raiz;
	
	if(novo == null){
		return null;
	}else if(novo.obterValor().compareTo(pai.obterValor()) == 0) {
		return novo;
	}if( novo.obterValor().compareTo(pai.obterValor()) == -1) {
		
		return buscarNo(novo, pai.obterNoEsquerdo());
			
	}else {
		
		return buscarNo(novo, pai.obterNoDireito());
	}
	
	
}
```

#### 7.1.4 - Remoção

A opreação de remoção em uma árvores é a mais complexa. Antes do métodos de remover precisamos identificar um possível substituto para o nó removido. Para isso vamos criar o método getSucessor que é responsável por retornar o sucessor de um nó dado.

```java
public No getSucessor(No atual, Boolean primeiraVez) {
		
		No sucessor  = null;
		
		if(primeiraVez)
			sucessor = atual.obterNoDireito();
		else
			sucessor = atual;
		
		if(sucessor.obterNoEsquerdo()!=null) {
			return getSucessor(sucessor.obterNoEsquerdo(), false);
		}
		    
		return sucessor; 
	}
```

Esse método retorna um nó que é o sucessor. Como pode ser observado ele é recursivo, no caso da primeira chamada, atualizamos o sucessor para ser o filho á direita. Após isso, estamos interessados em pegar o nó à direita que tenha um espaço vago à sua esquerda. Se isso não for o caso do nó imediatamente à direita, andamos na arvore agora sempre à esquerda em busca desse nó. 

Feito isso, podemos criar o nosso método de remoção. Existem vários caso, e vamos analisá-los um a um. Antes disso temos que ter em mente que queremos buscar o nó, então vamos utilizar as mesas técnicas de antes:

```java
if(currentno.obterValor().compareTo(valor) == 0) {
	//substituiremos o nó aqui
}else if( currentno.obterValor().compareTo(valor) == -1) {
	removerNo(valor, currentno.obterNoDireito());
}else {
	removerNo(valor, currentno.obterNoEsquerdo());
}
```

Será no primeiro if que implementaremos os casos. O nó a ser removido é:

1. é um nó folha? 
2. tem apenas um filho à direita?
3. tem apena um filho à esquerda?
4. tem dois filhos	(direita e esquerda) ?

Dentro do caso 4 precisamos verificar ainda:
1. não é o nó à direita do nó a ser excluído?
2. é o nó à direita do nó a ser excluído?

**Caso 1: é um nó folha?** 

Em caso dele ser um nó folha e for o nó raiz, ou seja, a árvore só possui esse elemento, podemo apenas dizer que o nó raiz é nulo, esvaziando por completo a árvore. Caso o nó folha seja um filho à direita do seu pai, limpamos a referência do filho à direita do pai. O mesmo ocorre para caso ele seja um filho à esquerda.

```java
if((currentno.obterNoDireito()== null) && (currentno.obterNoEsquerdo() == null)) {
				
	if(currentno == this.raiz)
		this.raiz = null;
	
	else if(currentno == currentno.pai.obterNoDireito() )
		currentno.pai.inserirDireito(null);
	else 
		currentno.pai.inserirEsquerdo(null);

}
```


**Caso 2: tem apenas um filho à direita?** 


O segundo caso verifica se ele tem apenas um filho à direita, ou seja, o o filho à esquerda é nulo. Caso o nó seja o raiz, dizemos que a nova raiz será o único filho existente (é como se ele herdasse tudo!). Caso ele seja um filho á direita do pai dele, nós passamos o filho dele para o pai (como se o pai assumisse a guarda do neto). No caso dele ser um filho à esquerda, fazemos o mesmo. 


```java
else if (currentno.obterNoEsquerdo()== null){
	
	if(currentno == this.raiz)
		this.raiz = this.raiz.obterNoDireito();
	
	else if(currentno == currentno.pai.obterNoDireito() )
		currentno.pai.inserirDireito( currentno.obterNoDireito() );
	
	else 
		currentno.pai.inserirEsquerdo( currentno.obterNoDireito() );	
}
```

**Caso 3: tem apena um filho à esquerda?** 

O terceiro caso verifica se ele tem apenas um filho à esquerda, ou seja, o filho à direita é nulo. Caso o nó seja o raiz, dizemos que a nova raiz será o único filho existente. Caso ele seja um filho á direita do pai dele, nós passamos o filho esquerdo dele para o pai, assumindo o seu lugar de filho direito. Caso ele seja um filho à esquerda, o seu filho assume o seu lugar de filho esquerdo. 

```java
else if (currentno.obterNoDireito() == null){
	
	if(currentno == this.raiz)
		this.raiz = this.raiz.obterNoEsquerdo();
	
	else if(currentno == currentno.pai.obterNoDireito() )
		currentno.pai.inserirDireito( currentno.obterNoEsquerdo() );
	
	else 
		currentno.pai.inserirEsquerdo( currentno.obterNoEsquerdo() );
}
```

**Caso 4: tem dois filhos** 

O caso quatro é mais complexo, pois precisamos analisar os subcasos. Vamos lá:

**Caso 4.1: não é o nó à direita do nó a ser excluído**

Caso o sucessor não seja o filho direito do nó que queremos excluir, podemos apneas fazer uma truca. Inserimos o filho direito do sucessor no lugar do filho esquerdo do pai e inseridos o filho direito do nó a ser excluido como filho direito do sucessor. Ou seja, o sucessor assume a guarda do filho que ficará sem pai, pois antes passou o seu filho direito para o pai dele. Sabemos que o pai tem essa disponibilidade pelo próprio algoritmo de obter o sucessor. 

```java
if(sucessor != currentno.obterNoDireito()) {
	
	sucessor.pai.inserirEsquerdo( sucessor.obterNoDireito() );
	sucessor.inserirDireito( currentno.obterNoDireito() );
}
```

**Caso 4.2:  é um nó raiz?**

Bem, feito isso vamos fazer o que já fizemos antes, mas agora passando o próprio sucesso como filho à esquerda ou direita, se for o caso:

```java
if(currentno == this.raiz )
   raiz = sucessor;
else if(currentno == currentno.pai.obterNoDireito()) 
	currentno.pai.inserirDireito(sucessor);
else 
    currentno.pai.inserirEsquerdo(sucessor);
			
```	

#### 7.1.5 - Percurso

Percurso em Árvores é uma forma de percorrer todos os nós em uma determinada ordem. Temos alguns percurso padrões que são: Em Ordem, Pré-Ordem e Pós-Ordem. Para todas as abordagens, podemos utilizar algoritmos recursivos.

**Pré-Ordem**
Os passo para esse percurso é: 1. Vistar a raiz. 2. Percorrer a sua subárvore esquerda em pré-ordem. 3. Percorrer a sua subárvore direita em pré-ordem. 

```java

public void preOrdem(No no) {
	if (no != null) {
		System.out.println(no.valor);
		emOrdem(no.filhoEsquerdo);
		emOrdem(no.filhoDireito);
	}
}

```
**In-Ordem**

Os passo para esse percurso é: 1. Percorrer a sua subárvore esquerda em in-ordem. 2. Vistar a raiz. 3. Percorrer a sua subárvore direita em in-ordem.

```java

public void emOrdem(No no) {
	if (no != null) {
		emOrdem(no.filhoEsquerdo);
		System.out.println(no.valor);
		emOrdem(no.filhoDireito);
	}
}

```
**Pós-Ordem**

Os passo para esse percurso é: 1. Percorrer a sua subárvore esquerda em pós-ordem. 2. Percorrer a sua subárvore direita em pós-ordem. 3. Vistar a raiz.

```java

public void posOrdem(No no) {
	if (no != null) {
		posOrdem(no.filhoEsquerdo);
		posOrdem(no.filhoDireito);
		System.out.println(no.valor);
	}
}

```

**Overview**

```java
public class Arvore<T extends Comparable<T>> {
	No raiz;
	
	public Arvore() {
		this.raiz = null;
	}
	
	public No inserirNo(T valor) {
		No<T> n = new No<T>(valor);
		return inserirNo(n, null);
		
	}
	public No inserirNo(No novo, No pai) {
		
		if(pai == null)
			pai = raiz;
		
		if(raiz == null) {
			raiz = novo;
		}else {
			//menor
			if( novo.obterValor().compareTo(pai.obterValor()) == -1) {
				
				if(pai.obterNoEsquerdo() == null)
					pai.inserirEsquerdo(novo);
				else
					inserirNo(novo, pai.obterNoEsquerdo());
				
			}else {
				
				if(pai.obterNoDireito() == null)
					pai.inserirDireito(novo);
				else
					inserirNo(novo, pai.obterNoDireito());
			}
		}
		
		return novo;
		
	}
	
	
	public No buscarNo(No novo, No pai) {
		
		if(pai == null)
			pai = raiz;
		
		if(novo == null){
			return null;
		}else if(novo.obterValor().compareTo(pai.obterValor()) == 0) {
			return novo;
		}if( novo.obterValor().compareTo(pai.obterValor()) == -1) {
			
			buscarNo(novo, pai.obterNoEsquerdo());
				
		}else {
			
			buscarNo(novo, pai.obterNoDireito());
		}
		
		return novo;
		
	}
	

	public No removerNo(T valor) {
		return removerNo(valor, null);
	}
	
	public No removerNo(T valor, No currentno) {
		
		No noret = null;
		
		if(currentno == null) 
			currentno = raiz;
		
		//igual
		if(currentno.obterValor().compareTo(valor) == 0) {
			//System.out.println(currentno.obterValor() + "é igual");
			//é um nó folha?
			if((currentno.obterNoDireito()== null) && (currentno.obterNoEsquerdo() == null)) {
				
				if(currentno == this.raiz)
					this.raiz = null;
				
				else if(currentno == currentno.pai.obterNoDireito() )
					currentno.pai.inserirDireito(null);
				else 
					currentno.pai.inserirEsquerdo(null);
			
			//tem apena sum filho à direita?
			}else if (currentno.obterNoDireito() == null){
				
				if(currentno == this.raiz)
					this.raiz = this.raiz.obterNoEsquerdo();
				
				else if(currentno == currentno.pai.obterNoDireito() )
					currentno.pai.inserirDireito( currentno.obterNoEsquerdo() );
				
				else 
					currentno.pai.inserirEsquerdo( currentno.obterNoEsquerdo() );
			
			//tem apena sum filho à esquerda?
			}else if (currentno.obterNoEsquerdo()== null){
				
				if(currentno == this.raiz)
					this.raiz = this.raiz.obterNoDireito();
				
				else if(currentno == currentno.pai.obterNoDireito() )
					currentno.pai.inserirDireito( currentno.obterNoDireito() );
				
				else 
					currentno.pai.inserirEsquerdo( currentno.obterNoDireito() );
			
			//tem dois filhos	
			}else {
				
				No sucessor = this.getSucessor(currentno, true);
				System.out.println("O sucessor é:" + sucessor+"\n");
				
				if(sucessor != currentno.obterNoDireito()) {
					
					sucessor.pai.inserirEsquerdo( sucessor.obterNoDireito() );
					sucessor.inserirDireito( currentno.obterNoDireito() );
				}
				
				
				//é a raiz
				if(currentno == this.raiz )
				   raiz = sucessor;
				
				//é o filho a esquerda
				else if(currentno == currentno.pai.obterNoDireito()) 
						currentno.pai.inserirDireito(sucessor);
				else 
						currentno.pai.inserirEsquerdo(sucessor);
			
				sucessor.inserirEsquerdo( currentno.obterNoEsquerdo() );
				
			}
			
			
			
		}else if( currentno.obterValor().compareTo(valor) == -1) {
			//System.out.println(currentno.obterValor() + "é menor que "+valor);
			removerNo(valor, currentno.obterNoDireito());
		}else {
			//System.out.println(currentno.obterValor() + "é mairo que "+valor);
			removerNo(valor, currentno.obterNoEsquerdo());
			
		}
	
		
		return null;
	}
	
	
	public No getSucessor(No atual, Boolean primeiraVez) {
		
		No sucessor  = null;
		
		if(primeiraVez)
			sucessor = atual.obterNoDireito();
		else
			sucessor = atual;
		
		if(sucessor.obterNoEsquerdo()!=null) {
			return getSucessor(sucessor.obterNoEsquerdo(), false);
		}
		    
		return sucessor; 
	}
	
	
	public void emOrdem(No no) {
		if (no != null) {
			emOrdem(no.filhoEsquerdo);
			System.out.println(no.valor);
			emOrdem(no.filhoDireito);
		}
	}
	
	public void preOrdem(No no) {
		if (no != null) {
			System.out.println(no.valor);
			emOrdem(no.filhoEsquerdo);
			emOrdem(no.filhoDireito);
		}
	}
	
	
	public void posOrdem(No no) {
		if (no != null) {
			posOrdem(no.filhoEsquerdo);
			posOrdem(no.filhoDireito);
			System.out.println(no.valor);
		}
	}
	
}
```




### 7.2 - Árvore AVL

Existe um grande problema em árvores binárias. Dado o método de inserção, se inseríamos elementos em ordem: 1, 2, 3, 4 ... n. Isso se tornaria uma lista, pois os nós seriam sempre inseridos à direta do nó mais à direita. Com a finalidade de remover esse problema é que foi criada a estrutura de dados Árvore AVL. Como princípio básico, a cada inserção e remoção é verificado o nível de balanceamento e caso esse nível passe do limite são feitas operações, que chamamado de rotação, para que essa estrutura permança balanceada. 

#### 7.2.2 - Questões sobre Balanceamento

#### 7.2.2 - Nó



#### 7.2.3 - Inserção

#### 7.2.4 - Remoção


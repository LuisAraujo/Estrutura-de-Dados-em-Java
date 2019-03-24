# Estrutura de Dados I

Esse repositório contém as implementações das estruturas criadas em sala  e resoluções de algumas questões das listas. Neste arquivo é possível ler e ter uma breve noção de Estrutura de Dados.

[*Esse documento está em construção, deixe-me saber se há algum erro: luisaraujo.ifba@gmail.com*]

# 1 - Estrutura de Dados

O que é uma estrutura de dados? Como o próprio nome diz é uma forma de organizar informações. Ou seja, passamos de um patamar que usávamos tipos primitivos como Inteiro, Character e outros para tipos mais complexos, como Pilha, Fila, Árvore e outros.

Essa disciplina tem como objetivo apresentar estruturas já consolidadas da área de computação que buscam resolver diversos problemas. É importante ressaltar que uma Estrutura de Dados é formada por Dados (organizado segundo alguma lógica) e operações permitidas, vinculadas a essas dados.

> Estrutura de Dados envolve dados organizados de alguma forma e operações vinculadas aos dados que garantem que os mesmos permaneçam com a mesma organização após inserções e deleções.

Alguns estruturas são utilizadas como forma de facilitar o armazenamento de informações, permitindo a recuperação de modo mais rápido. Logicamente que tudo depende do contexto do problema. Por exemplo, não é recomendável utilizar uma Pilha para um problema que envolve fila, como uma fila de Banco por exemplo.

## 1.1 - Modelagem Computacional

Modelagem Computacional é um área da Computação que visa, modelar computacionalmente alguns cenários ou problemas. Basicamente, buscamos transpor elementos do mundo real para o computador e para isso precisamos usar a "abstração". Logicamente que não iremos modelar algo da natureza em sua perfeição, e muitas vezes não precisamos. Assim, muitas vezes modelamos apenas os elementos essenciais, arte proveniente da abstração: pode de focar em elementos principais, ignorando elementos eventuais ou menos importante (para um contexto específico).

Desse modo, podemos criar classe - quando falamos em POO - com seus métodos que simulem um determinado elemento a ser modelador. Por exemplo: Carro possui uma marca, placa, modelo, ano de fabricação, motor e pode acelerar, frear, virar à esquerda e direita e por ai vai. 

Em estrutura de dados faremos constantemente esse exercício, modelaremos elementos do mundo real, eliminando suas características eventuais, focando apenas nos elementos principais. Isso ocorre com Pilhas, Filas, Árvore entre outras estruturas. 


#2 - Pilha

A primeira estrutura de dados que vamos ver é a Pilha. A pilha é uma estrutura bastante simples que tem a seguinte característica: 

> Um elemento entra sempre no topo e, ao remover um elemento só podemos remover o elemento do topo. 

Essa característica significa dizer que não podemos remover qualquer elementos desejado, é necessário obedecer esta ordem. Pense em uma pilha de pratos de louça que a nossa mãe tanto ama, já pensou em remover um prato que está no meio da pilha e por essa decisão deixar cair os pratos de cima? Não quero nem imaginar o problemão.

Logicamente que o mais pudente é retirar os pratos de cima e colocar em algum outo lugar, até que possamos - com segurança - pegar o prato desejado. Então, vamos criar um algoritmo simples para isso:

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

Então:

- Uma classe Item 
- Um vetor


Mas uma estrutura de dados não é formada apenas por locais onde podemos armazenar coisas ou objetos soltos no ar. Devemos criar operações que **garantam uma certa organização**, neste caso a organização da pilha: entra no topo, sai do topo. É interessante observar, caso ainda não tenha pensado nisso, que o elemento que entra do último é o primeiro a sair. Por esse motivo, a pilha é chamada de FIFO (*First In, First Out*).

Então, além dos dados, temos:

- Operação de inserir
- Operação de remover


**Inserindo dados**

Mas como controlar que vou inserir no topo? Bem isso é simples, vamos pensar que temos um vetor de 10 elementos e no inicio todos são nulos. 

    [null, null, null, null, null, null, null, null, null, null]

Eu posso inserir na posição com menor índice que possui o valor *null*, neste caso o 0.

    ["Prato A", null, null, null, null, null, null, null, null, null]

Se desejo inserir novamente, eu coloco na próxima posição com menor índice que esteja vazia (null).

	["Prato A", "Prato B", null, null, null, null, null, null, null, null]


Você certamente já percebeu que eu precisaria verificar, posição por posição até chegar à uma vazia:

	int pos_vazia - 0;
	while( (i< tamanho_fila) && (fila[i] != null) )
		pos_vazia++;

	if(pos_vazia < tamanho_fila)
		fila[i] = "Prato C";


Nossa!!! Mas isso é muito custoso, não acha? Pense em uma Fila de  1 milhão de dados, quando tivermos ao menos 50% da Pilha com dados. Teremos 500 mil comparações, no final teremos 1 milhão de comparações apenas para inserir um único elemento.

**Usando um Topo**

Uma solução para esse problema é, criar uma variável que armazenará o valor (índice) do topo e assim, poderemos sempre inserir em uma posição vazia. No primeiro caso que apresentamos o topo poderia ser -1 (pois a Pilha está vazia)
	
	topo = -1
	[null, null, null, null, null, null, null, null, null, null]

Seguiremos:

	topo = 0
	["Prato A", null, null, null, null, null, null, null, null, null]
	
	topo = 1
	["Prato A", "Prato B", null, null, null, null, null, null, null, null]

Mas como ficaria esse algoritmo?

	topo++;
	fila[topo] = "Prato C";

Só isso? Sim!!! Além de ter menos linhas, temos menos acesso aos dados. Agora, quando a pilha estiver com 50% de dados, teremos a mesma quantidade de operação que ele como 100% dos dados. **Que legal!!!**


**Removendo dados**

Analogicamente, na solução antiga precisaríamos percorrer todo o vetor até encontrar uma posição onde o próximo elemento é nulo, guardar este valor e colocar um valor nulo no local.

	["Prato A", "Prato B", "Prato C", "Prato D", null, null, null, null, null, null]


- fila na posição 0 + 1 é null?
- fila na posição 1 + 1 é null?
- fila na posição 2 + 1 é null?
- guarde o null 
- coloque null em fila na posição 2
	
	["Prato A", "Prato B", "Prato C", "Prato D", null, null, null, null, null, null]

Sim, podemos usar o loop;

- Enquanto fila n + 1 diferente de null
	- n++
- Se n < tamanho da fila
	- guarde o valor na posicao n 
	- coloque null em fila na posição n 


Já percebemos que essa solução não é ideal, por motivos claros e sabemos que o uso de uma variável de controle como o topo é ideal. Mas como ficaria esse código? Vamos ver:

	String item = fila[topo]
	topo--
	return item

Pois é, só isso!!! Assim como a inserção, a remoção é muito simples. Logicamente que isso deve ser inserido em uma função, mas isso veremos mais a frente. 


**Verificações, porque não?**

>  You have a erro of type 'StackOverflow' on line 4 - Fila.java

Sim, ninguém quer ver um erro similar no seu mega projeto que demorou 10 dias para ser implementado, horas antes de vencer o prazo de envio ao professor da disciplinas. Certamente o papo de "O cachorro comeu minha atividade" não vai colar. Então, precisamos fazer verificações no nosso projeto, para eliminar de uma vez por todas esses erros. 

Um pilha pode ser implementada como vetor ou como fila, neste caso estamos aprendendo como implementá-las em vetor e isso tem algumas limitações como por exemplo um tamanho máximo fixo de elementos que ele aceita. Assim, existem dois motivos para verificarmos uma pilha baseada em vetor: *inserir em uma pilha cheia e remover em uma pilha vazia*.

A condição para um pilha está vazia é simples e já vimos aqui, é justamente o estado inicial dela, onde o topo é -1. 

	if(topo == -1)
		pilhavazia = true

Já a condição para ela está cheia ainda não vimos e vou dizer agora: basta que o topo seja igual ao tamanho do vetor - 1. Isso porque inserimos no vetor na posição "topo" e se topo é igual a o tamanho do vetor ou maior, não poderemos inserir em uma posição inválida.

	topo = 3
	["Prato A", "Prato B", "Prato C", "Prato D"]

Podemo inserir no topo? Vejamos:

- O topo será incrementado, ou seja virará 4
- Inserimos no vetor na posição 

Isso certamente ocorrerá em erro, pois em um vetor de 4 posições (tamanho igual a 4), temos a primeira posição 0 e a última válida 3. Ou seja, achamos um limite que é justamente quando o topo é igual à 3 (tamanho - 1).

	if(topo == tamanho_fila - 1)
		pilhacheia = treu

**Observações**

Alguns exemplos aqui são didáticos, no sentido de que você entenda o problema. O código a seguir pode apresentar algumas diferenças, mas isso não impacta na solução do problema. Caso ainda ache que um algoritmo pode ser solucionado de apenas uma única forma, espero que reflita sobre isso. Esse é o momento! 

**Overview**

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



#3 - Fila
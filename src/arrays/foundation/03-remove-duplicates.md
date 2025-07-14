### 1. usando array temporário
> *dado um array `arr[]` de inteiros, remova os elementos duplicados*

a lógica por trás dessa solução é:
1. uma estrutura para guardar apenas valores únicos encontrados até agora
2. um contador para saber quantos únicos já temos
    * usamos esse contador para saber até onde o array temporário é válido
    * o array temporário ainda armazena lixo nas posições restantes (valor não preenchidos ou repetidos)
3. um loop inteiro para verificar se o valor atual já existe na lista de únicos

```java
public class RemoveDuplicates {
	public static int[] removeDuplicates(int[] arr) {
		int[] temp = new int[arr.length]; // cria um array temporário
		int counter = 0; // inicializa a variável que conta quantos elementos são não duplicados de arr

		for (int i = 0; i < arr.length; i++) {
			duplicate = false;

			for (int j = 0; j < counter; j++) {
				if (arr[i] == temp[j]) {
					duplicate = true;
					break;
				}
			}

			if (!duplicate) {
				temp[counter++] = arr[i];
			}
		}

		int[] result = new int[counter];
		for (int i = 0; i < counter; i++) {
			result[i] = temp[i];
		}

		return result;
	}
}
```

*enxugando a var booleana:*
```java
public class RemoveDuplicates {
	public static int[] removeDuplicates(int[] arr) {
		int[] temp = new int[arr.length];
		int counter = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < counter; j++) {
				if (arr[i] == temp[j]) {
					break;
				}
			}

			if (j == counter) {
				temp[counter++] = arr[i];
			}
		}

		int[] result = new int[counter];
		for (int i = 0; i < counter; i++) {
			result[i] = temp[i];
		}
 	}
}
```
* se o segundo loop `for` do index `j` completou sem dar break, significa que o valor atual não está presente na lista e se qualifica como elemento não duplicado
* por isso, ao final da iteração `j == counter` deve ser `true`
##### complexidade
* **tempo**
  O(n²), porque para cada elemento `arr[i]` fazemos um loop `counter` (que pode ser quase `i`)
* **espaço**
  O(n), usamos `temp[]` com tamanho igual ao do array original
#### 2. solução in-place
> *dado um array não ordenado `arr[]` de inteiros, remova os elementos duplicados in-place*

a lógica para não precisar criar um array temporário:
1. manter um ponteiro de escrita (`writeIndex`) que indica onde o próximo valor único deve ser inserido
2. para cada elemento, verificar se ele já apareceu antes entre os elementos válidos
    * é um elemento válido aquele que se encontra entre `arr[0]` a `arr[writeIndex - 1]`
3. se for um elemento novo (não duplicado) escreva nessa posição e incremente `writeIndex`
```java
public static int removeDuplicatesInPlace(int[] arr) {
	int writeIndex = 0; // onde escreveremos o próximo elemento único

	for (int i = 0; i < arr.length; i++) {

		// verifica se já apareceu nos elementos anteriores
		for (int j = 0; j < writeIndex; j++) {
			if (arr[i] == arr[j]) {
				break;
			}
		}

		if (j == writeIndex) {
			arr[writeIndex++] = arr[i];
		}
	}

	return writeIndex; // indica a quantidade de elementos únicos
}
```
a chave dessa solução é entender que, como o array é não ordenado, precisamos comparar cada elementos com os demais a partir de um ponteiro de escrita

entrada:
```java
arr = {1, 2, 2, 3, 1}
```

|i|arr[i]|Verifica duplicado entre arr[0..tamanho-1]?|Ação|arr (parcial)|tamanho|
|---|---|---|---|---|---|
|0|1|—|escreve em 0|[1, _, _, _, _]|1|
|1|2|1|escreve em 1|[1, 2, _, _, _]|2|
|2|2|1, 2 → duplicado|ignora|[1, 2, _, _, _]|2|
|3|3|1, 2 → novo|escreve em 2|[1, 2, 3, _, _]|3|
|4|1|1, 2, 3 → duplicado|ignora|[1, 2, 3, _, _]|3|
resultado:
- `arr[0..tamanho-1] = {1, 2, 3}`
- `tamanho = 3`

esses "espaços vazios" que aparecem na explicação, tipo `[1, _, _, _, _]`, **não existem de verdade** no array.
* são uma ***representação visual** pra ajudar a entender **o que foi sobrescrito e o que ainda está “sem uso lógico”**, mas **todos os elementos continuam lá fisicamente**

ex)
```java
int[] arr = {1, 2, 2, 3, 1};
int writeIndex = 0;
```

depois de sobrescrever `arr[writeIndex++] = arr[i]` algumas vezes:
```java
// digamos que writeIndex == 3
// então o array está assim:
arr = {1, 2, 3, 3, 1}; // ← os valores nas posições 3 e 4 são "sujos"
```

o que significa:
- os **valores em `arr[3]` e `arr[4]` ainda estão ali fisicamente**, mas **não fazem parte do conjunto “limpo” sem duplicatas**.
- eles são **lixo lógico**, mas não deixam de ser dados do array original

então:
- o array **continua com todos os valores ocupados**, mesmo os duplicados.
- a variável `writeIndex` (ou `k`, `pos`, etc.) **é quem define qual porção do array é “válida”** após a remoção dos duplicados
- a notação `[1, _, _, _, _]` é **didática** — só pra mostrar visualmente o que foi "mantido"

se o array **não é "encurtado" fisicamente**, então o que fizemos foi **empurrar os dados "válidos" pro começo**, e **ignorar o resto**
* isso não é um problema, na verdade é intencional e aceito em soluções in-place, considerada como padrão em resolução de exercícios
---

> *dado um array ordenado `arr[]` de inteiros, remova os elementos duplicados in-place*

se já pegamos a lógica do exercício anterior, essa solução fica fácil. ao invés de realizar a comparação entre todos os elementos do array e o valor atual, basta comparar o elemento atual com o anterior
* isso pode ser feito usando novamente um ponteiro de escrita que servirá para comparar o elemento atual e o anterior e para sobrescrever os elementos in-place

```java
public static int removeDuplicatesSortes(int[] arr) {
	if (arr.length == 0) return 0;

	int writeIndex = 1;
	
	for (int i = 0; i < arr.length; i++) {
		if (arr[i] != arr[writeIndex - 1]) {
			arr[writeIndex++] = arr[i];
		}
	}

	return writeIndex;
}
```
* se `arr[i] != arr[writeIndex - 1]`, então é um valor novo
* tempo: **O(n)**, super eficiente
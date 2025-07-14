> dado um array de inteiros `arr[]`, o trabalho é mover todos os zeros para o final do array mantendo a ordem relativa de elementos diferentes de zero

```
input  arr[] = [1, 2, 0, 4, 3, 0, 5, 0]  
output arr[] = [1, 2, 4, 3, 5, 0, 0, 0]  
explanation -- three 0s that are moved to the end.

input  arr[] = [10, 20, 30]  
output arr[] = [10, 20, 30]  
explanation -- no change in array as there are no 0s.  
  
input  arr[] = [0, 0]  
output arr[] = [0, 0]  
explanation -- no change in array as there are all 0s.
```

### 1. **usando array temporário - tempo O(n), espaço O(n)**
a ideia é criar um array temporário de mesmo tamanho do array de input
- primeiro, copiar todos os elementos diferentes de zero de `arr[]` para `temp[]`
- para as posições remanescentes, preencher com 0
- finalmente, copiar todos os elementos de `temp[]` para `arr[]`

*precauções*
- estamos trabalhando com dois arrays e, nesse caso, precisaremos de dois ponteiros: `i` para `arr[]` e `j` para `temp[]`
```
input  arr[] = [1, 2, 0, 4, 3, 0, 5, 0] 
```
- quando `i = 2` teremos que `arr[2] = 0` é um elemento nulo do array
- esse elemento deverá ser pulado na lógica de iteração
- quando pulado, se `temp[i] = arr[i]`, então `temp[2]` será um elemento ignorado e não preenchido
- ficaremos com um array cheio de buracos vazios e por isso precisamos do ponteiro `j`: ele mantem o controle manual das posições de `temp[]` a cada iteração

```java
public class PushZeros {
	public static void pushZerosToEnd(int arr[]) {
		int[] temp = new int[arr.length];

		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				temp[j++] = arr[i];
			}
		}

		// tratar posições remanescentes a partir de onde o ponteiro j parou
		while (j < arr.length) {
			temp[j++] = 0;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = temp[i];
		}
	}
}
```

### 2. duas travessias - tempo O(n), espaço O(1)
a ideia é mover todos os zeros de um array o atravessando duas vezes

*primeira travessia*: trocando elementos diferentes de zero
* atravesse o array e mantenha um **contador** de elementos diferentes de zero.
    * o contador será inicializado em 0 e apontará para onde o próximo elemento diferente de zero deve ser colocado no array
* se o elemento é diferente de zero, colocamos ele em `arr[count]` e *incrementamos* o contador
* depois de atravessar todos os elementos, todos os elementos diferentes de zero serão trocados para frente, mantendo sua ordem original

*segunda travessia*: preencher posições restantes com zero
* depois da primeira travessia, todos os elementos diferentes de zero estarão no começo do array
    * o contador estará apontando para o índice onde o primeiro zero deve ser colocado
* iteramos do *contador ao fim do array* preenchendo todas as posições com 0

```java
public class ShiftAllZeros {
	public static void shiftZeros(int[] arr) {
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[count] != 0) {
				arr[count++] = arr[i];
			}
		}

		while (count < arr.length) {
			arr[count++] = 0;
		}
	}
}
```

### 3. uma travessia - tempo O(n), espaço O(1)
a ideia é similar com a abordagem de duas travessias, onde tínhamos um ponteiro `count` que acompanha onde o próximo elemento diferente de 0 deve ser colocado
* entretanto, ao encontrar um elemento diferente de zero, ao invés de colocar diretamente o elemento em `arr[count]`, trocaremos o elemento diferente de zero com `arr[count]`
* e quando encontrar um elemento igual a zero, nenhuma troca será feita, de tal modo que `count` agora aguarda para ser trocado com o próximo elemento diferente de zero encontrado em `arr[i]`
* isso vai garantir que, se tivermos algum zero em `arr[count]`, ele será empurrado para o fim do array e não será sobrescrito

```java
//input
int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
// index 0. 1. 2. 3. 4. 5. 6. 7. 
int count = 0;

// como arr[0] = 1, trocar(arr[count], arr[i]) = trocar(arr[0], arr[0])
// incrementamos count para 1

// como arr[1] = 2, trocar(arr[count], arr[i]) = trocar(arr[1], arr[1])
// incrementamos count para 2

// como arr[2] = 0, nenhuma troca será feita
// count permanece em 2

// como arr[3] = 4, trocar(arr[count], arr[i]) = trocar(arr[2], arr[3])
// incrementamos count para 3

// como arr[4] = 3, trocar(arr[count], arr[i]) = trocar(arr[3], arr[4])
// incrementamos count para 4

// como arr[5] = 0, nenhuma troca será feita
// count permanece em 4

// como arr[6] = 5, trocar(arr[count], arr[i]) = trocar(arr[4], arr[6])
// incrementamos count para 5

// como arr[7] = 0, nenhuma troca é feita
// count permanece em 5
```
* observe que o ponteiro tem um "delay" em relação ao ponteiro index, justamente para acompanhar onde a próxima troca deve ser feita

```java
public static void shiftZeros(int[] arr) {
	int count = 0;

	for (int i = 0; i < arr.length; i++) {
		if (arr[i] != 0) {
		
			int temp = arr[i];
			arr[i] = arr[count];
			arr[count] = temp;

			count++;
		}
	}
}
```
* se lembre que nesse troca estamos assumindo que `arr[count]` carrega um elemento igual a zero, e que `arr[i]` corresponde a um elemento não nulo que deve ser trocado de lugar
* no começo do array, pode ser que tenhamos `i = count`, mas depois de percorrer todo o array, esses índices não caminharão mais juntos
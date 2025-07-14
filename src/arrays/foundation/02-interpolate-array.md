## 02 - interpolar dois arrays
#### *a) arrays de mesmo tamanho*
```
input:
arr1 = [1, 3, 5]
arr2 = [2, 4, 6]

output:
[1, 2, 3, 4, 5, 6]

```
usaremos um loop que percorre os dois arrays ao mesmo tempo e preenche um novo array de forma alternada
- elementos do primeiro array recebem posições pares
- elementos do segundo array recebem posições ímpares

precisaremos também de uma variável auxiliar `j` que tem o trabalho de permitir a manipulação dos índices do novo array gerado, mantendo a variável auxiliar `i` para manipular apenas os dois arrays
```java
public class InterpolateArray {
	public static void intercalar(int[] arr1, int[] arr2) {
		int[] resultado = new int[arr1.length * 2]; // [arr1.length + arr2.length]

		int j = 0;
		for (int i = 0; i < arr1.length; i++) {
			result[j++] = arr1[i];
			result[j++] = arr2[i];
		}
	}
}
```

resultado visual:
```
passo 1 → resultado[0] = arr1[0] = 1
          resultado[1] = arr2[0] = 2

passo 2 → resultado[2] = arr1[1] = 3
          resultado[3] = arr2[1] = 4

passo 3 → resultado[4] = arr1[2] = 5
          resultado[5] = arr2[2] = 6

```

*obs: sobre `j++`*
```java
resultado[j++] = arr1[i];
```
1. use o valor atual de `j` como índice
2. depois, incremente `j`

`j++` **usa o valor atual primeiro** e **só depois incrementa**, então **o índice 0 é usado perfeitamente**.

se fosse `++j`, aí sim o incremento viria **antes** do uso — e você acabaria pulando o índice 0.

#### *b) arrays de tamanhos diferentes*
quando o array têm tamanhos diferentes, o loop precisa de cuidados extras, senão corremos o risco de acessar um índice inexistente em um dos arrays e isso estoura um `ArrayIndexOutOfBoundsException`

exemplificando:
```
arr1 = [1, 3, 5, 7]        // tamanho 4
arr2 = [2, 4, 6]           // tamanho 3

resultado.length = 7       // 4 + 3
```
```java
int j = 0;
for (int i = 0; i < resultado.length; i++) {
	resultado[j++] = arr1[i];
	resultado[j++] = arr2[i];
}
```
- o problema aqui é que quando `i = 3` temos um `ArrayIndexOutOfBoundsException` porque `arr2[3]` não existe

para resolver esse exercício precisamos seguir o seguinte algoritmo:
1. intercalar até o menor tamanho comum
2. depois, adicionar o que sobrar do array maior

* para resolver se lembre que vamos receber como argumento os dois arrays e não saberemos qual deles é o maior.

```java
public class IntercalarArray {
	public static int[] intercalar(int[] arr1, int[] arr2) {
		int[] resultado = new int[arr1.length + arr2.length];

		int min = Math.min(arr1.length, arr2.length);
		int j = 0;

		for (int i = 0; i < min; i++) {
			resultado[j++] = arr1[i];
			resultado[j++] = arr2[i];
		}

		// se tiver, adiciona o que sobrou de arr1
		for (int i = min; i < arr1.length; i++) {
			resultado[j++] = arr1[i];
		}

		// se tiver, adiciona o que sobrou de arr2
		for (int i = min; i < arr2.length; i++) {
			resultado[j++] = arr2[i];
		}

		return resultado;
	}
}
```
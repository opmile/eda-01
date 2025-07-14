## 01 - rotação para direita (clockwise)
> dado um array e um número `d`, rotacione os elementos para direita `d` vezes

o que é "rotacionar para direita"?
   significa que cada elemento do array se move `N` casas para a direita, e os que "caírem fora" do fim do array voltam para o começo
* cada elemento é movido de sua posição original para uma nova posição, de forma circular:

```
array original:    [1, 2, 3, 4, 5]

rotacionar 1x →    [5, 1, 2, 3, 4]
rotacionar 2x →    [4, 5, 1, 2, 3]
rotacionar 3x →    [3, 4, 5, 1, 2]
```

1. ***rotacionando os elementos um por um***:
   a cada iteração, empurramos os elementos em uma posição para a direita, de forma circular, o último elemento se torna o primeiro. performando essa operação `d` vezes a rotacionar os elementos para a direita em `d` posições
- o problema dessa solução é a questão da complexidade, de O(n * d).

2. ***algoritmo de reversão***
   a melhor solução (pelo menos a mais prática) parte da observação que se rotacionarmos o array em `d` posições, os últimos `d` elementos virão primeiro e os `(n - d)` elementos estarão no fim (se `n` corresponde ao tamanho do array).
- primeiro revertemos todos os elementos do array
- depois, revertemos os primeiros `d` elementos
- por fim, revertemos os últimos `(n - d)` elementos para a rotação final do array
  

e se `d` for maior que `n`?
observe o seguinte exemplo:
```
input -- arr[] = {1, 2, 3}, d = 4  
output -- {3, 1, 2}  
the array is rotated as follows:

- first rotation -- arr[] = {3, 1, 2}
- second rotation -- arr[] = {2, 3, 1}
- third rotation -- arr[] = {1, 2, 3}
- fourth rotation -- arr[] = {3, 1, 2}
```
- notamos que rotacionar um array de tamanho `n = 3` o faz retornar ao seu formato original
- rotacionamos quatro vezes para direita, mas a primeira rotação é igual a primeira
- então o real efeito de rotacionar `d` vezes é equivalente a `d %= n`, que corresponde ao resto da divisão de `d` por `n`

---
*obs: relembrando como reverter array*
* usamos a técnica *Two Pointers*, em que teremos dois ponteiros para manipular os índices do array.
* um ponteiro esquerdo que começa no inicio e um ponteiro direito que começa no final do array
* para cada iteração dentro do loop, armazenaremos o valor do ponteiro direito em uma variável temporária, assim trocando o valor entre o ponteiro direito e o esquerdo, e em seguida atribuindo o ponteiro esquerdo para o valor guardado na variável

```java
public class ReverseArray {
	public static void reverse(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int temp = arr[right];
			arr[left] = arr[right];
			arr[right] = temp;

			left++;
			right--;
		}
	}
}
```
---

teremos apenas uma sutil mudança: agora precisamos implementar um método que recebe como argumentos justamente a definição dos ponteiros, ao invés de já defini-los dentro do método.


*solução:*
```java
// implementando algoritmo de reversão
public class RotateArray {
	public static void reverse(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
            
            start++;
            end--;
		}
	}

	public static void rotate(int[] arr, int d) {
		int n = arr.length;
		
		// reverter todo o array
		reverse(arr, 0, n - 1);

		// reverter os primeiros d elementos
		reverse(arr, 0, d - 1); 

		// reverter os últimos n - d elementos
		reverse(arr, d, n - 1);
	}
}
```
* `d - 1` corresponde ao último elemento a ser rotacionado (estamos trabalhando com índices!)
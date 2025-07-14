> gere um array com os `n` primeiros números primos

## **função que checa se um número é primo**
```java
public static boolean isPrime(int n) {
	if (n < 2) return false;
	for (int i = 2; i * i <= n; i++) {
		if (n % i == 0) return false;
	}
	return true;
}
```

um número primo é **aquele que só pode ser dividido por 1 e por ele mesmo**. ou seja, ele tem **exatamente dois divisores**
* 2 é primo (divisores: 1, 2)
* 3 é primo (divisores: 1, 3)
* 7 é primo (divisores: 1, 7)
* 4 NÃO é primo (divisores: 1, 2, 4)

#### **`if (n < 2) return false;`**
nenhum número menor que 2 é primo
ex) `isPrime(1)` - `false`

#### **`for (int i = 2; i * i <= n; i++)`**
aqui estamos testando se algum número entre 2 e a raiz quadrada de `n` divide `n`
* queremos checar se o número tem algum divisor entre `2` e `n - 1`, porque se tiver, a função deve retornar `false` porque esse número não é primo
  ex) se `n = 17`, testaremos `2, 3, 4` (porque 4^2 = 16 < 17)
> mas por que não fazer `for (int i = 2; i < n; i++)`

poderíamos até ceder a essa implementação, mas acabaríamos perdendo por performance já que estamos testando mais divisores do que precisamos
ex) *testar até `i < n`*
```java
n = 100
for (int i = 2; i < 100; i++)
```
* aqui testaremos 98 valores! demora muito!

ex) *teste até `i * i <= n` (ou seja, até `√n`)
```java
n = 100
for (int i = 2; i * i <= 100; i++)
```
* você*= vai até `i = 10`, porque `10 * 10 = 100`. só 9 valores testados

> mas por que só até a raiz quadrada de `n`?

se `n` tem um divisor maior que `√n`, então ele também tem um divisor menor que `√n`
ex) `n = 100`
- `100 = 10 * 10` (ok)

- `100 = 2 * 50`
- `100 = 4 * 25`
- `100 = 5 * 20`
- `100 = 10 * 10` ← aqui é a **virada**
- `100 = 20 * 5`
- `100 = 25 * 4`
- `100 = 50 * 2`
  observe que depois de chegar na raiz, os fatores só se invertem. ou seja, se 100 tem um divisor como 25 (>10), então obrigatoriamente ele já teve 4 (<10) como divisor
* nesse caso, já teríamos descoberto isso antes mesmo de chegar em 25, pior ainda, tivemos que testar 98 números

então `for (int i = 2; i * i <= n; i++)` significa que testaremos até a raiz quadrada de n, porque se n tiver algum divisor maior que isso, ele já teria aparecido antes como um divisor menor correspondente

#### **`if (n % i == 0) return false`**
- `%` é o operador de **resto da divisão**.
- ee `n % i == 0`, significa que `i` **divide `n` exatamente**, ou seja, `n` **não é primo**.

#### **`return true`**
* se **nenhum número entre 2 e √n dividiu `n`**, então `n` **é primo**.

#### ex) `isPrime(7)`
```java
i = 2 → 7 % 2 != 0  
i = 3 → 7 % 3 != 0  
(i * i = 9 > 7) → para o loop  
→ não achou nenhum divisor → return true
```
#### ex) `isPrime(9)`
```java
i = 2 → 9 % 2 != 0  
i = 3 → 9 % 3 == 0 → return false  
```

## **função geradora de primos**
```java
public static boolean isPrime(int n) {
	if (n < 2) return false;
	for (int i = 2; i * i <= n; i++) {
		if (n % i == 0) return false;
	}
	return true;
}

public static int[] generatePrimes(int quantity) {
	int[] primes = new int[quantity];
	int element = 2;

	// abordagem for equivocada e corrigida abaixo!!
	for (int i = 0; i < quantity; i++) {
		if (isPrime(element)) {
			primes[i] = element;
		}
		element++;
	}
	return primes;
}
```

o seguinte trecho de código:
```java
int[] primes = new int[quantity];
int number = 2;


for (int i = 0; i < quantity; i++) {
		if (isPrime(number)) {
			primes[i] = number;
		}
		number++;
	}
```
* aqui o for avança o índice `i` independentemente de `number` ser primo ou não
* se `number` não for primo, o slot `primes[i]` vai ficar sem valor válido, ou até vazio com zero dependendo da lógica
* resultado? acabamos com um array cheio de buracos ou números errados, e menos primos do que deveria


não é equivalente a esse:
```java
int[] primes = new int[quantity];
int number = 2;
int index = 0;

while (index < quantity) {
	if (isPrime(number)) {
		prime[index++] = number;
	}
	number++;
}
```
* aqui o laço só avança o `index` quando encontra um número primo
* ou seja, garante exatamente `quantity` de primos

mas e se quisermos usar um `for` por teimosia?
então precisaremos de controle manual da variável de índice `i`, ao passo que o incremento vai para `number`
```java
for (int i = 0; i < quantity; number++) {
	if (isPrime(number)) {
		prime[i++] = number;
	}
}
```

*código solução:*
```java
public class GeneratePrimes {
	public static booblean isPrime(int n) {
		if (n < 2) return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

	public static int[] generatePrimes(int quantity) {
		int[] primes = new int[quantity];
		int number = 2;

		for (int i = 0; i < quantity; number++) {
			if (isPrime(number)) {
				primes[i] = number;
				i++;
			}
		}
		return primes;
	}
}
```
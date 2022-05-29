package challanges.playground;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class PlaygroundApplication {

	public static void main(String[] args) {
		System.out.println("resultado: " + calculate(Collections.singletonList("IV")));
	}

	public static Integer calculate(List<String> numerosRomanos) {
		Integer I = 1, V = 5, X = 10, L = 50, C = 100;

		List<String> listaNumerosRomanos = Arrays.asList(new String[]{"I", "V", "X", "L", "C"});

		Integer total = 0;

		for (String numero : numerosRomanos) {
			char[] numeroStringList = numero.toCharArray();

			Long tamanhoListaNumerosRomanos = numerosRomanos.stream().count();

			for (int i=0 ; i < tamanhoListaNumerosRomanos ; i++) {
				String letraString = String.valueOf(numeroStringList[i]);

				Integer valorletra = getValorLetra(letraString);

				if (i < tamanhoListaNumerosRomanos) {
					String proximaLetraString = String.valueOf(numeroStringList[i+1]);

					Integer valorProximaLetra = getValorLetra(proximaLetraString);

					if(valorletra <= valorProximaLetra){
						//se o valor da direita for igual ou maior
						total -= valorletra;
					} else {
						total += valorletra;
					}
				} else {
					total += valorletra;
				}
			}


		}

		return total;
	}

	private static Integer getValorLetra(String letra) {
		switch (letra) {
			case "I":
				return 1;
			case "V":
				return 5;
			case "X":
				return 10;
			case "L":
				return 50;
			case "C":
				return 100;
			default:
				return 0;
		}
	}
}

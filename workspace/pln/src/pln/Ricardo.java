package pln;

import java.util.ArrayList;

public class Ricardo {
	private String texto;
	private int vetor[];
	private int nVogais, nConsoantes;

	public Ricardo(String texto) {
		this.texto = texto;
		this.vetor = new int[this.texto.length()];
	}

	// alterado
	public void verificadorDeSequencia(String out) {
		int a = 0;
		int b = 0;
		this.vetor = new int[this.texto.length()];
		for (int i = 0; i < out.length(); i++) {
			char letra = out.charAt(i);
			char antecessor;
			if (i == 0) {
				antecessor = ' ';
			} else {
				antecessor = out.charAt(i - 1);
			}
			if (vogal(letra, antecessor)) {
				// System.out.println(letra + ", vogal");
				this.vetor[i] = 1;
				a++;
			} else {
				// System.out.println(letra + ", consoante");
				this.vetor[i] = 2;
				b++;
			}
		}
		nVogais = a;
		nConsoantes = b;
	}

	public boolean vogal(char letra, char antecessor) {
		switch (letra) {
		case 'a':
			return true;
		case 'e':
			return true;
		case 'i':
			return true;
		case 'o':
			return true;
		case 'u':
			return true;
		case 'y':
			if (vogal(antecessor, ' ')) {
				return false;
			} else {
				return true;
			}
		default:
			return false;
		}
	}

	public boolean terminaS(String out) {
		char s = out.charAt(out.length() - 1);
		if (s == 's') {
			return true;
		} else {
			return false;
		}
	}

	// alterado
	public boolean estrelaD(char ult, char penul, char ant) {
		if ((!this.vogal(ult, penul)) && (!this.vogal(penul, ant)) && (ult == penul)) {
			return true;
		}
		return false;
	}

	public boolean estrelaO(String out, int ultima, int penultima, int antepenultima) {
		int posUlt = out.length() - 1;
		if (antepenultima == 2 && penultima == 1 && ultima == 2) {
			if (out.charAt(posUlt) != 'x' || out.charAt(posUlt) != 'w' || out.charAt(posUlt) != 'y') {
				return true;
			}
		}
		return false;
	}

	// alterado
	public int valorM() {
		int atual = 0, proximo = 0;
		int m = 0;
		for (int i = 0; i < (this.vetor.length - 1); i++) {
			atual = this.vetor[i];
			proximo = this.vetor[i + 1];
			if (atual == 1) {
				if (proximo == 2) {
					m++;
				}
			}
		}
		return m;
	}

	// meu código

	public boolean contemVogal(String palavra) {

		for (int i = 0; i < palavra.length() - 1; i++) {
			char letra = palavra.charAt(i);
			char letraAnt = palavra.charAt(i + 1);
			if (this.vogal(letra, letraAnt)) {
				return true;
			}

		}

		return false;

	}

	public String regra1A(String palavra) {
		String resultado = "";
		String concat = "";
		int posicao = 0;
		/*
		 * char letra = palavra.charAt(palavra.length()-2); if(palavra.length()
		 * - 5 > 0){
		 * 
		 * //para os casos sses e ies if(letra == 'e'){
		 * if((palavra.charAt(palavra.length()-3)) == 's' &&
		 * (palavra.charAt(palavra.length()-4)) == 's'){ concat = "ss"; posicao
		 * = palavra.length() - 4;
		 * 
		 * 
		 * } else if((palavra.charAt(palavra.length()-3)) == 'i'){ concat = "i";
		 * posicao = palavra.length() - 3; } }
		 * 
		 * } //para o caso ss if(letra == 's'){ concat = "ss"; posicao =
		 * palavra.length() - 2; } else{ concat = ""; posicao =
		 * palavra.length()-1; }
		 */
		ArrayList<String> array = new ArrayList<String>();
		for (int i = 5; i > 0; i--) {
			String temp = "";
			for (int j = 1; j < i; j++) {
				temp = palavra.charAt(palavra.length() - j) + temp;
			}
			System.out.println(temp);
			array.add(temp);
		}
		for (String temp : array) {
			// caso sses ->ss
			if (temp.equals("sses")) {
				concat = "ss";
				posicao = palavra.length() - 4;
				break;
			}
			// caso ies->i
			else if (temp.equals("ies")) {
				concat = "i";
				posicao = palavra.length() - 3;
				break;
			}
			// caso ss -> ss
			else if (temp.equals("ss")) {
				concat = "ss";
				posicao = palavra.length() - 2;
				break;
			}
			// caso s-> ' '
			else if (temp.equals("s")) {
				concat = "";
				posicao = palavra.length() - 1;
			}
		}
		// gera a string nova
		for (int i = 0; i < posicao; i++) {
			resultado = resultado + palavra.charAt(i);
		}

		resultado = resultado + concat;

		return resultado;
	}

	// verificar se uma palavra esta em 1b
	//funcionando
	public boolean verifRegra1B(String palavra) {

		String resultado = "";

		this.verificadorDeSequencia(this.texto);

		// caso eed e ed
		if (palavra.charAt(palavra.length() - 1) == 'd') {

			if (palavra.charAt(palavra.length() - 2) == 'e' && palavra.charAt(palavra.length() - 3) == 'e') {

				for (int i = 0; i < (palavra.length() - 3); i++) {
					resultado = resultado + palavra.charAt(i);
				}

				this.verificadorDeSequencia(resultado);
				if (this.valorM() > 0) {
					return true;
				}
				return false;

			} else if (palavra.charAt(palavra.length() - 2) == 'e') {
				for (int i = 0; i < (palavra.length() - 2); i++) {
					resultado = resultado + palavra.charAt(i);
				}
				if (this.contemVogal(resultado)) {
					return true;
				} else {
					return false;
				}

			}

			else {
				return false;
			}

		}

		else if (palavra.charAt(palavra.length() - 1) == 'g') {
			if (palavra.charAt(palavra.length() - 2) == 'n' && palavra.charAt(palavra.length() - 3) == 'i') {
				for (int i = 0; i < (palavra.length() - 3); i++) {
					resultado = resultado + palavra.charAt(i);
				}

				this.verificadorDeSequencia(resultado);
				if (this.contemVogal(resultado)) {
					return true;
				} else {
					return false;
				}
			}

		}

		return false;

	}

	// funcionando
	public String regra1B(String palavra) {

		String resultado = "";

		this.verificadorDeSequencia(this.texto);

		// caso eed e ed
		if (palavra.charAt(palavra.length() - 1) == 'd') {

			if (palavra.charAt(palavra.length() - 2) == 'e' && palavra.charAt(palavra.length() - 3) == 'e') {

				for (int i = 0; i < (palavra.length() - 3); i++) {
					resultado = resultado + palavra.charAt(i);
				}

				this.verificadorDeSequencia(resultado);
				if (this.valorM() > 0) {
					return resultado + "ee";
				}
				return palavra;

			} else if (palavra.charAt(palavra.length() - 2) == 'e') {
				for (int i = 0; i < (palavra.length() - 2); i++) {
					resultado = resultado + palavra.charAt(i);
				}
				if (this.contemVogal(resultado)) {
					return resultado;
				} else {
					return palavra;
				}

			}

			else {
				return palavra;
			}

		}

		else if (palavra.charAt(palavra.length() - 1) == 'g') {
			if (palavra.charAt(palavra.length() - 2) == 'n' && palavra.charAt(palavra.length() - 3) == 'i') {
				for (int i = 0; i < (palavra.length() - 3); i++) {
					resultado = resultado + palavra.charAt(i);
				}

				this.verificadorDeSequencia(resultado);
				if (this.contemVogal(resultado)) {
					return resultado;
				} else {
					return palavra;
				}
			}

		}

		return palavra;

	}

	// funcionando
	public String regra1B2(String palavra) {
		String resultado = "";
		String concat = "";
		int posicao = 0;
		this.verificadorDeSequencia(palavra);
		if (this.verifRegra1B(palavra)) {
			String temp = "" + palavra.charAt(palavra.length() - 2) + palavra.charAt(palavra.length() - 1);
			if (temp.equals("at")) {
				concat = "ate";
				posicao = palavra.length() - 2;
			} else if (temp.equals("bl")) {
				concat = "ble";
				posicao = palavra.length() - 2;
			} else if (temp.equals("iz")) {
				concat = "ize";
				posicao = palavra.length() - 2;
			}

			//verificar o *d
			if (this.estrelaD(palavra.charAt(palavra.length() - 1), palavra.charAt(palavra.length() - 2),
					palavra.charAt(palavra.length() - 3))) {
				
				char last = palavra.charAt(palavra.length() - 1);
				//verifica o != l,s,z
				if (last != 'l' && last != 's' && last != 'z') {
					for (int i = 0; i < palavra.length() - 1; i++) {
						resultado = resultado + palavra.charAt(i);
					}
					return resultado;
				} else {
					return palavra;
				}

			}

			if (palavra.length() > 2) {
				if (this.valorM() == 1) {
					int t = palavra.length();
					if ((!this.vogal(palavra.charAt(t - 1), palavra.charAt(t - 2)))
							&& (this.vogal(palavra.charAt(t - 2), palavra.charAt(t - 3)))
							&& (!this.vogal(palavra.charAt(t - 3), ' ')) && palavra.charAt(t - 1) != 'w'
							&& palavra.charAt(t - 1) != 'x' && palavra.charAt(t - 1) != 'y') {
						return palavra + "e";

					}
					return palavra;

				}
			}
			for (int i = 0; i < posicao; i++) {
				resultado = resultado + palavra.charAt(i);
			}

			resultado = resultado + concat;
		}
		return resultado;

	}

	// funcionando
	public String regra1C(String palavra) {

		String resultado = "";
		if (palavra.charAt(palavra.length() - 1) == 'y') {
			for (int i = 0; i < palavra.length() - 1; i++) {
				resultado = resultado + palavra.charAt(i);
			}
			if (this.contemVogal(resultado)) {
				return resultado + "i";
			}

		}

		return palavra;
	}

	// funcionando
	public String regra3(String palavra) {

		String resultado = "";
		String concat = "";
		int posicao = 0;

		ArrayList<String> array = new ArrayList<String>();
		if (palavra.length() > 3) {
			for (int i = 6; i > 3; i--) {
				String temp = "";
				for (int j = 1; j < i; j++) {
					temp = palavra.charAt(palavra.length() - j) + temp;

				}
				array.add(temp);
			}
			for (String aux : array) {
				if (aux.equals("icate")) {
					concat = "ic";
					posicao = palavra.length() - 5;
					for (int i = 0; i < posicao; i++) {
						resultado = resultado + palavra.charAt(i);
					}

					this.verificadorDeSequencia(resultado);
					if (this.valorM() > 0) {
						return resultado + concat;
					}

				}
				if (aux.equals("ative")) {
					concat = "";
					posicao = palavra.length() - 5;
					for (int i = 0; i < posicao; i++) {
						resultado = resultado + palavra.charAt(i);
					}

					this.verificadorDeSequencia(resultado);
					if (this.valorM() > 0) {
						return resultado + concat;
					}

				}

				if (aux.equals("alize")) {
					concat = "al";
					posicao = palavra.length() - 5;
					for (int i = 0; i < posicao; i++) {
						resultado = resultado + palavra.charAt(i);
					}

					this.verificadorDeSequencia(resultado);
					if (this.valorM() > 0) {
						return resultado + concat;
					}
				}
				if (aux.equals("iciti")) {
					concat = "ic";
					posicao = palavra.length() - 5;
					for (int i = 0; i < posicao; i++) {
						resultado = resultado + palavra.charAt(i);
					}

					this.verificadorDeSequencia(resultado);
					if (this.valorM() > 0) {
						return resultado + concat;
					}
				}
				if (aux.equals("ical")) {
					concat = "ic";
					posicao = palavra.length() - 4;
					for (int i = 0; i < posicao; i++) {
						resultado = resultado + palavra.charAt(i);
					}

					this.verificadorDeSequencia(resultado);
					if (this.valorM() > 0) {
						return resultado + concat;
					}
				}
				if (aux.equals("ful")) {
					concat = "";
					posicao = palavra.length() - 3;
					for (int i = 0; i < posicao; i++) {
						resultado = resultado + palavra.charAt(i);
					}

					this.verificadorDeSequencia(resultado);
					if (this.valorM() > 0) {
						return resultado + concat;
					}
				}
				if (aux.equals("ness")) {
					concat = "";
					posicao = palavra.length() - 4;
					for (int i = 0; i < posicao; i++) {
						resultado = resultado + palavra.charAt(i);
					}

					this.verificadorDeSequencia(resultado);
					if (this.valorM() > 0) {
						return resultado + concat;
					}
				}

			}
		}
		return palavra;
	}

	// termina aqui

	public static void main(String[] args) {
		Ricardo teste = new Ricardo("sing");

		System.out.println(teste.regra1B(teste.texto));
	}

}

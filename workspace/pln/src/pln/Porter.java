package pln;


import java.util.ArrayList;
import java.util.Scanner;




public class Porter {
	
	private String texto = "roll";
	private int vetor[] = new int[texto.length()];
	private int nVogais, nConsoantes;
	
	
	

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

	public boolean vogal(char letra, char antecessor){
		switch(letra){
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
			if(vogal(antecessor, ' ')){
				return false;
			}else{
				return true;
			}
		default:
			return false;
		}
	}
	
	public boolean terminaS(char s){
		//char s = out.charAt(out.length()-1);
		if(s == 's'){
			return true;
		}else{
			return false;
		}
 	}
	
	public boolean estrelaD(int ultimo, int penultimo, char ult, char penult){
		if(ultimo == 2 && penultimo == 2){
			if(ult == penult){
				return true;
			}
		}
		return false;
	}
	
	public boolean estrelaO(String out, int ultima, int penultima,
			int antepenultima){
		int posUlt = out.length()-1;
		if(antepenultima == 2 && penultima == 1 && ultima == 2){
			if(out.charAt(posUlt) != 'x' || out.charAt(posUlt) != 'w' || out.charAt(posUlt) != 'y'){
				return true;
			}
		}
		return false;
	}
	
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
	public String regra2(String entrada){
		int m = 1;
		String out = "";
		if(m > 0){
			if(entrada.charAt(entrada.length()-1) == 'l' &&
					entrada.charAt(entrada.length()-2) == 'a' &&
					entrada.charAt(entrada.length()-3) == 'n' &&
					entrada.charAt(entrada.length()-4) == 'o' &&
					entrada.charAt(entrada.length()-5) == 'i' &&
					entrada.charAt(entrada.length()-6) == 't' &&
					entrada.charAt(entrada.length()-7) == 'a' ){
				for(int i = 0;i<entrada.length()-7;i++){
					out = out+ entrada.charAt(i);		
				}
				out = out + "ate";
			}
			else if(entrada.charAt(entrada.length()-1) == 'l' &&
					entrada.charAt(entrada.length()-2) == 'a' &&
					entrada.charAt(entrada.length()-3) == 'n' &&
					entrada.charAt(entrada.length()-4) == 'o' &&
					entrada.charAt(entrada.length()-5) == 'i' &&
					entrada.charAt(entrada.length()-6) == 't'){
				for(int i = 0;i<entrada.length()-6;i++){
					out = out+ entrada.charAt(i);		
				}
				out = out + "tion";
			}
			else if(entrada.charAt(entrada.length()-1) == 'i' &&
					entrada.charAt(entrada.length()-2) == 'c' &&
					entrada.charAt(entrada.length()-3) == 'n' &&
					entrada.charAt(entrada.length()-4) == 'e'){
				for(int i = 0;i<entrada.length()-4;i++){
					out = out+ entrada.charAt(i);	
				}
				out = out + "ence";
			}
			else if(entrada.charAt(entrada.length()-1) == 'i' &&
					entrada.charAt(entrada.length()-2) == 'c' &&
					entrada.charAt(entrada.length()-3) == 'n' &&
					entrada.charAt(entrada.length()-4) == 'a'){
				for(int i = 0;i<entrada.length()-4;i++){
					out = out+ entrada.charAt(i);	
				}
				out = out + "ance";
			}
			else if(entrada.charAt(entrada.length()-1) == 'r' &&
					entrada.charAt(entrada.length()-2) == 'e' &&
					entrada.charAt(entrada.length()-3) == 'z' &&
					entrada.charAt(entrada.length()-4) == 'i'){
				for(int i = 0;i<entrada.length()-4;i++){
					out = out+ entrada.charAt(i);		
				}
				out = out + "ize";
			}
			else if(entrada.charAt(entrada.length()-1) == 'i' &&
					entrada.charAt(entrada.length()-2) == 'l' &&
					entrada.charAt(entrada.length()-3) == 'b' &&
					entrada.charAt(entrada.length()-4) == 'a'){
				for(int i = 0;i<entrada.length()-4;i++){
					out = out+ entrada.charAt(i);
					
				}
				out = out + "able";	
			}
			else if(entrada.charAt(entrada.length()-1) == 'i' &&
					entrada.charAt(entrada.length()-2) == 'l' &&
					entrada.charAt(entrada.length()-3) == 'l' &&
					entrada.charAt(entrada.length()-4) == 'a'){
				for(int i = 0;i<entrada.length()-4;i++){
					out = out+ entrada.charAt(i);
					
				}
				out = out + "al";	
			}
			else if(entrada.charAt(entrada.length()-1) == 'i' &&
					entrada.charAt(entrada.length()-2) == 'l' &&
					entrada.charAt(entrada.length()-3) == 't' &&
					entrada.charAt(entrada.length()-4) == 'n' &&
					entrada.charAt(entrada.length()-5) == 'e'){
				for(int i = 0;i<entrada.length()-5;i++){
					out = out+ entrada.charAt(i);
					
				}
				out = out + "ent";
			}
			else if(entrada.charAt(entrada.length()-1) == 'i' &&
					entrada.charAt(entrada.length()-2) == 'l' &&
					entrada.charAt(entrada.length()-3) == 'e'){
				for(int i = 0;i<entrada.length()-3;i++){
					out = out+ entrada.charAt(i);
					
				}
				out = out + "e";
			}
			else if(entrada.charAt(entrada.length()-1) == 'i' &&
					entrada.charAt(entrada.length()-2) == 'l' &&
					entrada.charAt(entrada.length()-3) == 's' &&
					entrada.charAt(entrada.length()-4) == 'u' &&
					entrada.charAt(entrada.length()-5) == 'o'){
				for(int i = 0;i<entrada.length()-5;i++){
					out = out+ entrada.charAt(i);
					
				}
				out = out + "ous";
			}
			else if(entrada.charAt(entrada.length()-1) == 'n' &&
					entrada.charAt(entrada.length()-2) == 'o' &&
					entrada.charAt(entrada.length()-3) == 'i' &&
					entrada.charAt(entrada.length()-4) == 't' &&
					entrada.charAt(entrada.length()-5) == 'a' &&
					entrada.charAt(entrada.length()-6) == 'z' &&
					entrada.charAt(entrada.length()-7) == 'i' ){
				for(int i = 0;i<entrada.length()-7;i++){
					out = out+ entrada.charAt(i);		
				}
				out = out + "ize";
			}
			else if(entrada.charAt(entrada.length()-1) == 'n' &&
					entrada.charAt(entrada.length()-2) == 'o' &&
					entrada.charAt(entrada.length()-3) == 'i' &&
					entrada.charAt(entrada.length()-4) == 't' &&
					entrada.charAt(entrada.length()-5) == 'a'){
				for(int i = 0;i<entrada.length()-5;i++){
					out = out+ entrada.charAt(i);
					
				}
				out = out + "ate";
			}
			else if(entrada.charAt(entrada.length()-1) == 'r' &&
					entrada.charAt(entrada.length()-2) == 'o' &&
					entrada.charAt(entrada.length()-3) == 't' &&
					entrada.charAt(entrada.length()-4) == 'a'){
				for(int i = 0;i<entrada.length()-4;i++){
					out = out+ entrada.charAt(i);
					
				}
				out = out + "ate";	
			}
			else if(entrada.charAt(entrada.length()-1) == 'm' &&
					entrada.charAt(entrada.length()-2) == 's' &&
					entrada.charAt(entrada.length()-3) == 'i' &&
					entrada.charAt(entrada.length()-4) == 'l' &&
					entrada.charAt(entrada.length()-5) == 'a'){
				for(int i = 0;i<entrada.length()-5;i++){
					out = out+ entrada.charAt(i);
					
				}
				out = out + "al";
			}
			else if(entrada.charAt(entrada.length()-1) == 's' &&
					entrada.charAt(entrada.length()-2) == 's' &&
					entrada.charAt(entrada.length()-3) == 'e' &&
					entrada.charAt(entrada.length()-4) == 'n' &&
					entrada.charAt(entrada.length()-5) == 'e' &&
					entrada.charAt(entrada.length()-6) == 'v' &&
					entrada.charAt(entrada.length()-7) == 'i' ){
				for(int i = 0;i<entrada.length()-7;i++){
					out = out+ entrada.charAt(i);		
				}
				out = out + "ive";
			}
			else if(entrada.charAt(entrada.length()-1) == 's' &&
					entrada.charAt(entrada.length()-2) == 's' &&
					entrada.charAt(entrada.length()-3) == 'e' &&
					entrada.charAt(entrada.length()-4) == 'n' &&
					entrada.charAt(entrada.length()-5) == 'l' &&
					entrada.charAt(entrada.length()-6) == 'u' &&
					entrada.charAt(entrada.length()-7) == 'f' ){
				for(int i = 0;i<entrada.length()-7;i++){
					out = out+ entrada.charAt(i);		
				}
				out = out + "ful";
			}
			else if(entrada.charAt(entrada.length()-1) == 's' &&
					entrada.charAt(entrada.length()-2) == 's' &&
					entrada.charAt(entrada.length()-3) == 'e' &&
					entrada.charAt(entrada.length()-4) == 'n' &&
					entrada.charAt(entrada.length()-5) == 's' &&
					entrada.charAt(entrada.length()-6) == 'u' &&
					entrada.charAt(entrada.length()-7) == 'o' ){
				for(int i = 0;i<entrada.length()-7;i++){
					out = out+ entrada.charAt(i);		
				}
				out = out + "ous";
			}
			else if(entrada.charAt(entrada.length()-1) == 'i' &&
					entrada.charAt(entrada.length()-2) == 't' &&
					entrada.charAt(entrada.length()-3) == 'i' &&
					entrada.charAt(entrada.length()-4) == 'l' &&
					entrada.charAt(entrada.length()-5) == 'a'){
				for(int i = 0;i<entrada.length()-5;i++){
					out = out+ entrada.charAt(i);
					
				}
				out = out + "al";
			}
			else if(entrada.charAt(entrada.length()-1) == 'i' &&
					entrada.charAt(entrada.length()-2) == 't' &&
					entrada.charAt(entrada.length()-3) == 'i' &&
					entrada.charAt(entrada.length()-4) == 'v' &&
					entrada.charAt(entrada.length()-5) == 'i'){
				for(int i = 0;i<entrada.length()-5;i++){
					out = out+ entrada.charAt(i);
					
				}
				out = out + "ive";
			}
			else if(entrada.charAt(entrada.length()-1) == 'i' &&
					entrada.charAt(entrada.length()-2) == 't' &&
					entrada.charAt(entrada.length()-3) == 'i' &&
					entrada.charAt(entrada.length()-4) == 'l' &&
					entrada.charAt(entrada.length()-5) == 'i' &&
					entrada.charAt(entrada.length()-6) == 'b'){
				for(int i = 0;i<entrada.length()-6;i++){
					out = out+ entrada.charAt(i);		
				}
				out = out + "ble";
			}
			else{
				out = entrada;
			}
		}
		return out;
	}
	public String regra4(String entrada){
		 int m = 2;
		String out = "";
		if(m > 1){
			if(entrada.charAt(entrada.length()-1) == 'l' &&
					entrada.charAt(entrada.length()-2) == 'a'){
				for(int i = 0;i<entrada.length()-2;i++){
					out = out+ entrada.charAt(i);	
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 'e' &&
					entrada.charAt(entrada.length()-2) == 'c' &&
					entrada.charAt(entrada.length()-3) == 'n' &&
					entrada.charAt(entrada.length()-4) == 'a'){
				for(int i = 0;i<entrada.length()-4;i++){
					out = out+ entrada.charAt(i);	
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 'e' &&
					entrada.charAt(entrada.length()-2) == 'c' &&
					entrada.charAt(entrada.length()-3) == 'n' &&
					entrada.charAt(entrada.length()-4) == 'e'){
				for(int i = 0;i<entrada.length()-4;i++){
					out = out+ entrada.charAt(i);	
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 'r' &&
					entrada.charAt(entrada.length()-2) == 'e'){
				for(int i = 0;i<entrada.length()-2;i++){
					out = out+ entrada.charAt(i);	
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 'c' &&
					entrada.charAt(entrada.length()-2) == 'i'){
				for(int i = 0;i<entrada.length()-2;i++){
					out = out+ entrada.charAt(i);	
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 'e' &&
					entrada.charAt(entrada.length()-2) == 'l' &&
					entrada.charAt(entrada.length()-3) == 'b' &&
					entrada.charAt(entrada.length()-4) == 'a'){
				for(int i = 0;i<entrada.length()-4;i++){
					out = out+ entrada.charAt(i);	
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 'e' &&
					entrada.charAt(entrada.length()-2) == 'l' &&
					entrada.charAt(entrada.length()-3) == 'b' &&
					entrada.charAt(entrada.length()-4) == 'i'){
				for(int i = 0;i<entrada.length()-4;i++){
					out = out+ entrada.charAt(i);	
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 't' &&
					entrada.charAt(entrada.length()-2) == 'n' &&
					entrada.charAt(entrada.length()-3) == 'a'){
				for(int i = 0;i<entrada.length()-3;i++){
					out = out+ entrada.charAt(i);	
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 't' &&
					entrada.charAt(entrada.length()-2) == 'n' &&
					entrada.charAt(entrada.length()-3) == 'e' &&
					entrada.charAt(entrada.length()-4) == 'm' &&
					entrada.charAt(entrada.length()-5) == 'e'){
				for(int i = 0;i<entrada.length()-5;i++){
					out = out+ entrada.charAt(i);
					
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 't' &&
					entrada.charAt(entrada.length()-2) == 'n' &&
					entrada.charAt(entrada.length()-3) == 'e' &&
					entrada.charAt(entrada.length()-4) == 'm'){
				for(int i = 0;i<entrada.length()-4;i++){
					out = out+ entrada.charAt(i);	
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 't' &&
					entrada.charAt(entrada.length()-2) == 'n' &&
					entrada.charAt(entrada.length()-3) == 'e'){
				for(int i = 0;i<entrada.length()-3;i++){
					out = out+ entrada.charAt(i);
					
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 'n' &&
					entrada.charAt(entrada.length()-2) == 'o' &&
					entrada.charAt(entrada.length()-3) == 'i'){
				if(entrada.charAt(entrada.length()-4) == 's' ||
					entrada.charAt(entrada.length()-4) == 't'){
					for(int i = 0;i<entrada.length()-3;i++){
						out = out+ entrada.charAt(i);
						
					}
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 'u' &&
					entrada.charAt(entrada.length()-2) == 'o'){
						for(int i = 0;i<entrada.length()-2;i++){
							out = out+ entrada.charAt(i);	
						}
					}
			else if(entrada.charAt(entrada.length()-1) == 'm' &&
					entrada.charAt(entrada.length()-2) == 's' &&
					entrada.charAt(entrada.length()-3) == 'i'){
				for(int i = 0;i<entrada.length()-3;i++){
					out = out+ entrada.charAt(i);
					
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 'e' &&
					entrada.charAt(entrada.length()-2) == 't' &&
					entrada.charAt(entrada.length()-3) == 'a'){
				for(int i = 0;i<entrada.length()-3;i++){
					out = out+ entrada.charAt(i);
					
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 'i' &&
					entrada.charAt(entrada.length()-2) == 't' &&
					entrada.charAt(entrada.length()-3) == 'i'){
				for(int i = 0;i<entrada.length()-3;i++){
					out = out+ entrada.charAt(i);
					
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 's' &&
					entrada.charAt(entrada.length()-2) == 'u' &&
					entrada.charAt(entrada.length()-3) == 'o'){
				for(int i = 0;i<entrada.length()-3;i++){
					out = out+ entrada.charAt(i);
					
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 'e' &&
					entrada.charAt(entrada.length()-2) == 'v' &&
					entrada.charAt(entrada.length()-3) == 'i'){
				for(int i = 0;i<entrada.length()-3;i++){
					out = out+ entrada.charAt(i);
					
				}
			}
			else if(entrada.charAt(entrada.length()-1) == 'e' &&
					entrada.charAt(entrada.length()-2) == 'z' &&
					entrada.charAt(entrada.length()-3) == 'i'){
				for(int i = 0;i<entrada.length()-3;i++){
					out = out+ entrada.charAt(i);
					
				}
			}
			else{
				out = entrada;
			}
		}
		return out;
	}
	public String regra5a(String entrada){
		int m = 2;
		String out = "";
		if(m > 1 && entrada.charAt(entrada.length()-1) == 'e'){
			for(int i = 0;i<entrada.length()-1;i++){
				out = out + entrada.charAt(i);
			}
		}
		else{
			out = entrada;
		}
		return out;
	}
	public String regra5b(String entrada){
		int m = 2;
		String out = "";
		if(m > 1 && estrelaD(vetor[entrada.length()-1], vetor[entrada.length()-2],
				entrada.charAt(entrada.length()-1), entrada.charAt(entrada.length()-2))){
			
			for(int i = 0;i<entrada.length()-1;i++){
				out = out + entrada.charAt(i);
			}
		}
		else{
			out = entrada;
		}
		
		return out;
	}
	
	
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

	// funcionando
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

			// verificar o *d
			//if (this.estrelaD(palavra.charAt(palavra.length() - 1), palavra.charAt(palavra.length() - 2),
					//palavra.charAt(palavra.length() - 3))) {
	
			if (this.estrelaD(vetor[palavra.length()-1], vetor[palavra.length()-2],palavra.charAt(palavra.length() - 1), palavra.charAt(palavra.length() - 2))) {

				char last = palavra.charAt(palavra.length() - 1);
				// verifica o != l,s,z
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

	public String run(String input) {
		String resultadoFinal = input;

		resultadoFinal = resultadoFinal.toLowerCase();
		char last = resultadoFinal.charAt(resultadoFinal.length() - 1);
		
		//caso 1a
		if(last == 's'){
			
			resultadoFinal = this.regra1A(resultadoFinal);
			last = resultadoFinal.charAt(resultadoFinal.length() - 1);
		}
		
		//regra 1b e 1b2
		if(this.verifRegra1B(resultadoFinal)){
			
			resultadoFinal = this.regra1B2(this.regra1B(resultadoFinal));
			last = resultadoFinal.charAt(resultadoFinal.length() - 1);
		}
		
		if(last == 'y'){
			
			resultadoFinal = this.regra1C(resultadoFinal);
			
		}
		
		if(resultadoFinal.length() > 4){
			//regra2
			resultadoFinal = this.regra2(resultadoFinal);
		}
		
		if(resultadoFinal.length() > 4){
			//regra3
			resultadoFinal = this.regra3(resultadoFinal);
		}
		
		if(resultadoFinal.length() > 5){
			//regra4
			resultadoFinal = this.regra4(resultadoFinal);
		}
		
		last = resultadoFinal.charAt(resultadoFinal.length() - 1);
		
		//regra 5a
		if(last == 'e'){
			resultadoFinal = this.regra5a(resultadoFinal);
			
		}
		
		last = resultadoFinal.charAt(resultadoFinal.length() - 1);
		
		//regra 5b
		if(last == 'l' ){
			resultadoFinal = this.regra5b(resultadoFinal);
		}
		
		
		
		return resultadoFinal;

	}

}

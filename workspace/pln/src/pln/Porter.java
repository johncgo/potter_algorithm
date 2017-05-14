package pln;

import java.io.InputStream;
import java.util.Scanner;

import javax.print.attribute.Size2DSyntax;


public class Porter {
	
	private static String texto = "roll";
	private static int vetor[] = new int[texto.length()];
	private static int nVogais, nConsoantes;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		verificadorDeSequencia(texto, vetor, 0, 0);
		int m = 0;
		m = valorM(m, vetor);
	}
	
	public static void verificadorDeSequencia(String out, int[] vector, int a, int b){
		for(int i = 0; i < out.length();i++){
			char letra = out.charAt(i);
			char antecessor;
			if(i==0){
				antecessor = ' ';
			}else{
				antecessor = out.charAt(i-1);
			}
			if(vogal(letra, antecessor)){
				//System.out.println(letra + ", vogal");
				vector[i] = 1;
				a++;
			}else{ 
				//System.out.println(letra + ", consoante");
				vector[i] = 2;
				b++;
			}
		}
		nVogais = a;
		nConsoantes = b;
	}
	
	public static boolean vogal(char letra, char antecessor){
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
	
	public static boolean terminaS(char s){
		//char s = out.charAt(out.length()-1);
		if(s == 's'){
			return true;
		}else{
			return false;
		}
 	}
	
	public static boolean estrelaD(int ultimo, int penultimo, char ult, char penult){
		if(ultimo == 2 && penultimo == 2){
			if(ult == penult){
				return true;
			}
		}
		return false;
	}
	
	public static boolean estrelaO(String out, int ultima, int penultima,
			int antepenultima){
		int posUlt = out.length()-1;
		if(antepenultima == 2 && penultima == 1 && ultima == 2){
			if(out.charAt(posUlt) != 'x' || out.charAt(posUlt) != 'w' || out.charAt(posUlt) != 'y'){
				return true;
			}
		}
		return false;
	}
	
	public static int valorM(int m,int[] vector){
		int atual = 0, proximo = 0;
		for(int i = 0; i< (vector.length -1);i++ ){
			atual = vector[i];
			proximo = vector[i+1];
			if(atual == 1){
				if(proximo == 2){
					m++;
				}
			}
		}		
		return m;
	}
	
	public static String regra2(String entrada, int m){
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
	public static String regra4(String entrada, int m){
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
	public static String regra5a(String entrada, int m){
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
	public static String regra5b(String entrada, int m){
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
}

package pln;

import java.io.InputStream;
import java.util.Scanner;

import javax.print.attribute.Size2DSyntax;


public class Porter {
	
	private static String texto = "yakuzay";
	private static int vetor[] = new int[texto.length()];
	private static int nVogais, nConsoantes;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		verificadorDeSequencia(texto, vetor, 0, 0);
		int m = 0;
		m = valorM(m, vetor);
		System.out.println("m: " + m + "\nv: " + nVogais + "\nc: " + nConsoantes);
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
	
	public static boolean terminaS(String out){
		char s = out.charAt(out.length()-1);
		if(s == 's'){
			return true;
		}else{
			return false;
		}
 	}
	
	public static boolean estrelaD(int ultimo, int penultimo, char ult, char penult){
		if(ultimo == 2 && penultimo == 2){
			return true;
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
	

}

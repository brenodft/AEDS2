import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Q07 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String title, link, text;
		boolean stopReading = false;
		int patternCount[];
		patternCount = new int[25];
		do {
			title = input.nextLine();
			if (title.length() == 3 && title.equalsIgnoreCase("FIM")) {
				stopReading = true;
			} else {
				link = input.nextLine();
				text = captureHTML(title, link);
				checkPatterns(text, patternCount);
				printResult(patternCount, title);
			}
		} while (!stopReading);


		input.close();
	}

	// Método para capturar o conteúdo HTML de uma URL
	public static String captureHTML(String title, String link) {
		String text = "", line = "";
		try {
			URI uri = new URI(link);
			URL url = uri.toURL();
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			line = br.readLine();

			while (line != null) {
				text += line;
				line = br.readLine();
			}

			br.close();
		} catch (MalformedURLException exception) {
			exception.printStackTrace();
		} catch (URISyntaxException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		return text;
	}

	// Método para verificar os caracteres no texto capturado
	public static void checkPatterns(String text, int patternCount[]) {
		for (int i = 0; i < 25; i++) {
			patternCount[i] = 0;
		}

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == 'a') {
				patternCount[0]++;
			} else if (text.charAt(i) == 'e') {
				patternCount[1]++;
			} else if (text.charAt(i) == 'i') {
				patternCount[2]++;
			} else if (text.charAt(i) == 'o') {
				patternCount[3]++;
			} else if (text.charAt(i) == 'u') {
				patternCount[4]++;
			} else if (text.charAt(i) == (char)225) {
				patternCount[5]++;
			} else if (text.charAt(i) == (char)233) {
				patternCount[6]++;
			} else if (text.charAt(i) == (char)237) {
				patternCount[7]++;
			} else if (text.charAt(i) == (char)243) {
				patternCount[8]++;
			} else if (text.charAt(i) == (char)250) {
				patternCount[9]++;
			} else if (text.charAt(i) == (char)224) {
				patternCount[10]++;
			} else if (text.charAt(i) == (char)232) {
				patternCount[11]++;
			} else if (text.charAt(i) == (char)236) {
				patternCount[12]++;
			} else if (text.charAt(i) == (char)242) {
				patternCount[13]++;
			} else if (text.charAt(i) == (char)249) {
				patternCount[14]++;
			} else if (text.charAt(i) == (char)227) {
				patternCount[15]++;
			} else if (text.charAt(i) == (char)245) {
				patternCount[16]++;
			} else if (text.charAt(i) == (char)226) {
				patternCount[17]++;
			} else if (text.charAt(i) == (char)234) {
				patternCount[18]++;
			} else if (text.charAt(i) == (char)238) {
				patternCount[19]++;
			} else if (text.charAt(i) == (char)244) {
				patternCount[20]++;
			} else if (text.charAt(i) == (char)251) {
				patternCount[21]++;
			} else if (isConsonant(text.charAt(i)) == true) {
				patternCount[22]++;
			}
			if (text.charAt(i) == '<' && text.charAt(i + 1) == 'b' && text.charAt(i + 2) == 'r' && text.charAt(i + 3) == '>') {
				patternCount[23]++;
				i += 3;
			}
			if (text.charAt(i) == '<' && text.charAt(i + 1) == 't' && text.charAt(i + 2) == 'a' && text.charAt(i + 3) == 'b' && text.charAt(i + 4) == 'l' && text.charAt(i + 5) == 'e' && text.charAt(i + 6) == '>') {
				patternCount[24]++;
				i += 6;
			}
		}
	}

	// Método para verificar se um caractere é uma consoante
	public static boolean isConsonant(char input) {
		boolean result = false;

		if (input >= 'a' && input <= 'z') {
			result = true;
		}
		return result;
	}
	// Método para imprimir o resultado
	public static void printResult(int patternCount[], String title) {
		System.out.println("a(" + patternCount[0] + ") e(" + patternCount[1] + ") i(" + patternCount[2] + ") o(" + patternCount[3] + ") u(" + patternCount[4]+ ") " + (char)225 + "(" + patternCount[5] + ") " + (char)233 + "(" + patternCount[6] + ") " + (char)237 + "(" +  patternCount[7] + ") " + (char)243 + "(" +  patternCount[8] + ") " + (char)250 + "(" + patternCount[9] + ") " + (char)224 + "(" + patternCount[10] + ") " + (char)232 + "(" + patternCount[11] + ") " + (char)236 + "(" +  patternCount[12] + ") " + (char)242 + "(" +  patternCount[13] +  ") " + (char)249 + "(" +  patternCount[14] + ") " + (char)227 + "(" + patternCount[15] + ") " + (char)245 + "(" +  patternCount[16] + ") " + (char)226 + "(" +  patternCount[17] + ") " + (char)234 + "(" +  + patternCount[18] + ") " + (char)238 + "(" +  patternCount[19] + ") " + (char)244 + "(" +  patternCount[20] + ") " + (char)251 + "(" +  patternCount[21] + ") consonant(" + patternCount[22] + ") <br>(" + patternCount[23] + ") <table>(" + patternCount[24] + ") " + title);
	}

}

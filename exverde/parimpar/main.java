import java.util.Scanner;
class main{
	public static char parimpar(int numero){
		if(numero %2 == 0){
			return 'P';
		} else{
			return 'I';
		}
}

	public static boolean endwhile(int numero){
		if(numero != 0) {
			return true;
		} else{
			return false;
		}
}

	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int num = 0;
		do{
			num = sc.nextInt();
			if (num != 0){ 
				System.out.println(parimpar(num));
			}
		} while(endwhile(num));
	}
}

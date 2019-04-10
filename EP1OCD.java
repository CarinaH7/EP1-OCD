EP1OCD (2).java
Semana passada
3 de abr
N
Nicole Anginoli Costa criou e compartilhou 1 item em
Pasta do Google Drive
EP-OCD
Java
EP1OCD (2).java
C
Pode editar
Você
package ep1ocd;

import java.util.Scanner;

public class EP1OCD {

    /* Transforma o vetor char em int*/
    static int [] vetorInt(String num){
        char[] c = num.toCharArray();
        int [] res= new int[c.length];
        for(int i=0;i<c.length;i++){
            res[i]=Integer.parseInt(String.valueOf(c[i]));
        }
        return res;
    }
    /*Inicializa todos os valores do vetor com 0 */
    static int [] acertarCasas(int tam,int [] vet1){
      
        int [] res=new int[tam];
        int dif= tam-vet1.length;
        int j=dif; //contatdor
        for(int i=0;i<dif;i++){
            res[i]=0;
        }
        for(int i=0;i<vet1.length;i++){
            res[j]=vet1[i];
            j++;
        }
        return res;
    }
    /* Faz o complemento de 2 */
    static int [] complementoDeDois(int [] vet){
        int [] res =new int[vet.length];
        int[] um={1};
        um=acertarCasas(vet.length,um);
        for(int i=0;i<res.length;i++){
            if(vet[i]==0) res[i]=1;
            else res[i]=0;
        }
	int sobe = 0;
	for (int j = res.length-1; j >=0; j--){
	    int aux = res[j] + um[j] + sobe;
	    switch (aux){
		case 0: 
		    res[j] = 0;
		    sobe = 0;
		    break;
		case 1: 
		    res[j] = 1;
		    sobe = 0;
		    break;
		case 2: 
		    res[j] = 0;
		    sobe = 1;
		    break;
		case 3: 
		    res[j] = 1;
		    sobe = 1;
		    break;
	    }
        }
	
	
        return res;
    }
    static int [] subtracao(int [] vet1, int[] vet2){
    
        int [] num2 =complementoDeDois(vet2);

        int [] res=soma(vet1,num2);

        return res;
    }
    static int[] soma(int[] vet1, int[] vet2) {

        int[] resp = new int[vet1.length + 1]; 
        int sobe = 0;
        for (int i = vet1.length - 1; i >= 0; i--) {
            int aux = vet1[i] + vet2[i] + sobe;
            if (aux == 0) {
                resp[i + 1] = 0;
                sobe = 0;
            } else if (aux == 1) {
                resp[i + 1] = 1;
                sobe = 0;
            } else if (aux == 2) {
                resp[i + 1] = 0;
                sobe = 1;
            } else if (aux == 3) {
                resp[i + 1] = 1;
                sobe = 1;
            }
        }
        resp[0] = sobe;
        return resp;
    }


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Numero de bits: ");
        int tam= sc.nextInt();
	System.out.println("OPERACOES:");
	System.out.println("1:	soma");
	System.out.println("2:	subtracao");
	System.out.println("3:	multiplicacao");
	System.out.println("4:	divisao");
	System.out.print("Digite o indice da operacao: ");

	int op = sc.nextInt();
       
	System.out.print("Binario 1: ");
	String s1 = sc.next();
        
	System.out.print("Binario 2: ");
	String s2 = sc.next();
        
        int [] num1=vetorInt(s1);
        num1=acertarCasas(tam,num1);

        int [] num2=vetorInt(s2);
        num2=acertarCasas(tam,num2);
	
	switch (op){
	    case 1: for (int a : soma (num1, num2))
			System.out.print(a);
		    break;
	    case 2: for (int a : subtracao (num1, num2))
			System.out.print(a);
		    break;	
	}
	System.out.println("");
    }
}
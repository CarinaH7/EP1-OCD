package ep1ocd;

import java.util.Scanner;

public class EP1OCD {

    static char[] vetorChar(String num) {
        char[] ch = num.toCharArray();
        return ch;
    }
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
    static int [] complementoDeDois(int [] num){
        int [] res =new int[num.length];
        int[] um={1};
        um=acertarCasas(num.length,um);
        for(int i=0;i<res.length;i++){
            if(num[i]==0) res[i]=1;
            else res[i]=0;
        }
        res=soma(res,um); //Problema:essa soma aumenta o tamanho do res em 1
        return res;
    }
    static int [] subtracao(int [] vet1, int[] vet2){
        int [] num1=acertarCasas(vet1.length+1,vet1);
        int [] num2 =complementoDeDois(vet2);

        int [] res=soma(num1,num2);

        return res;
    }
    static int[] soma(int[] vet1, int[] vet2) {
    //o vetor tem tamanho +1 pq as vezes sobra aquele 1 em cima e a soma fica com um bit a mais no final, posso estar fazendo a conta errado, mas se nao me engano é assim
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
        resp[0] = sobe; // como pode sobra o "1" no final, coloquei a casa 0 separada, e tipo mesmo se for zero aqui, isso nao afeta o numero pq é zero a esquerda, só nao sei quanto ao sinal se da algum problema
        return resp;
    }


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Numero de bits: ");
        int tam= sc.nextInt();
        
                
        String s1 = sc.next();
        String s2 = sc.next();
        
        int [] num1=vetorInt(s1);
        num1=acertarCasas(tam,num1);

        int [] num2=vetorInt(s2);
        num2=acertarCasas(tam,num2);

        int [] sub= subtracao(num1,num2);
        for (int i : sub) {
            System.out.print(i);
        }
        System.out.println("");
       //fiz os testes colocando numeros diretos ja que ainda nao arrumamos a entrada
        int[] a = {0,1, 1, 0, 1};
        int[] b = {0,0, 1, 1, 1};
        for (int num : soma(a, b)) {
            System.out.print(num);
        } 
     
    }

}
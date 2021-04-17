package aps;
/*
Julio Cesar Menezes Carvalho   Ra: 20999569
Gustavo Gonzaga Viana   Ra: 20951318
José Eduardo Pedralino da Silva    Ra: 20934383
Lucas Babolim de Carvalho   Ra: 20996446

*/
import java.util.Random;
import java.util.Scanner;

public class POTA_APS {
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        Random rand = new Random();
        int vet1[] = new int[5];
        int vet2[] = new int[10];
        int vet3[] = new int[50];
        int vet4[] = new int[100];
        int vet5[] = new int[1000];
        int vet6[] = new int[10000];
        

        //------------------------------------------------------------------------
        // 
        for (int i = 0; i < vet1.length; i++) {
            vet1[i] = rand.nextInt(10000) + 1;
        }

        // BubbleSort
        Long inicioBubbleSort1 = System.currentTimeMillis();
        BubbleSort(vet1.clone());
        Long fimBubbleSort1 = System.currentTimeMillis();
       // System.out.println("Tempo do BubbleSort com " + numero + " = : " + (fimBubbleSort1 - inicioBubbleSort1));

        // InsertionSort
        Long inicioInsertionSort1 = System.currentTimeMillis();
        InsertionSort(vet1.clone());
        Long fimInsertionSort1 = System.currentTimeMillis();
       // System.out.println("Tempo do InsertionSort com " + numero + " = : " + (fimInsertionSort1 - inicioInsertionSort1));

        // SelectionSort
        Long inicioSelectionSort1 = System.currentTimeMillis();
        SelectionSort(vet1.clone());
        Long fimSelectionSort1 = System.currentTimeMillis();
       // System.out.println("Tempo do SelectionSort com " + numero + " = : " + (fimSelectionSort1 - inicioSelectionSort1));

        // Mergesort
        Long inicioMergesort1 = System.currentTimeMillis();
        Mergesort(vet1.clone(), 0, vet1.length - 1);
        Long fimMergesort1 = System.currentTimeMillis();
       // System.out.println("Tempo do Mergesort com " + numero + " = : " + (fimMergesort1 - inicioMergesort1));

        
       //QuickSort
       Long inicioQuickSort = System.currentTimeMillis();
       QuickSort(vet1.clone(), 0, vet1.length - 1);
       Long fimQuickSort1 = System.currentTimeMillis();

        //----------------------------------------------------------------------------
      

    }

    public static int BubbleSort(int[] vet) {

        int tam = vet.length;
        boolean invertido = false;
        int contbubble = 0;
        do {

            invertido = false;

            for (int i = 1; i < tam; i++) {
            contbubble++;
                if (vet[i - 1] > vet[i]) {
                    int aux = vet[i];
                    vet[i] = vet[i - 1];
                    vet[i - 1] = aux;
                    invertido = true;
                    
                }
            }
            
            // tam--;

        } while (invertido == true);
System.out.println("Cont do BubbleSort: " + contbubble);
        return contbubble;
    }

    public static void InsertionSort(int[] vet) {
        int tam = vet.length;
        int cont = 0;
        for (int i = 1; i < tam; i++) {
            int j = i;
            while (j > 0 && vet[j - 1] > vet[j]) {
                cont++;
                int aux = vet[j];
                vet[j] = vet[j - 1];
                vet[j - 1] = aux;
                j--;
                
            }
        }
        System.out.println("Cont do Insertionsort: " + cont);
    }

    public static void SelectionSort(int vet[]) {
        int cont = 0;
        int minimo;
        for (int i = 0; i < vet.length - 1; i++) {
            minimo = i;
            
            for (int j = i + 1; j < vet.length; j++) {
                cont++;
                if (vet[j] < vet[minimo]) {
                    minimo = j;
                
                        
                }
                int temp = vet[i];
                vet[i] = vet[minimo];
                vet[minimo] = temp;

            }

        }
        System.out.println("Cont do Selectionsort: " + (cont));
    }

    public static void Mergesort(int A[], int p, int r) {
       int cont = 0;
       cont++;
        if (p < r) {
            int q = (p + r) / 2;
            Mergesort(A, p, q);
            Mergesort(A, q + 1, r);
            Intercala(A, p, q, r); 
        
        }
        System.out.println("Cont do Mergesort: " + cont);
           }

    public static void Intercala(int A[], int p, int q, int r) {
        
        int i, j, k;
        int B[] = new int[A.length];
        for (i = p; i <= q; i++) {
            B[i] = A[i];
        }
        for (j = q + 1; j <= r; j++) {
            B[r + q + 1 - j] = A[j];
        }
        i = p;
        j = r;
        for (k = p; k <= r; k++) {
            if (B[i] <= B[j]) {
                A[k] = B[i];
                i++;
            } else {
                A[k] = B[j];
                j--;
            }
            
           
        }        
    
    }

public static void QuickSort(int vetor[], int ini, int fim){
        int cont = 0;
        cont++;
        if(ini < fim){
            int meio = particionar(vetor, ini, fim);
            QuickSort(vetor, ini, meio-1);
            QuickSort(vetor, meio+1, fim);
        }
        System.out.println("Cont do QuickSort" + cont);
    }
    
    public static int particionar(int vetor[], int ini, int fim){
        int i = ini+1;
        int j = fim, aux;
        while(i <= j){
            if(vetor[i] < vetor[ini])
                i++;
            else{
                if(vetor[j] > vetor[ini])
                    j--;
                else{
                    aux = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                    i++;
                    j--;
                }
            }
        }
        aux = vetor[ini];
        vetor[ini]= vetor[j];
        vetor[j] = aux;
        return j;
    }

}
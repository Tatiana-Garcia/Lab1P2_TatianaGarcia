/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_tatianagarcia;

import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author tatig
 */
public class Lab1P2_TatianaGarcia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        int opcion;
        
        do {
            System.out.println();
            System.out.println("--> Menu <--");
            System.out.println("1 -> Torres de Hanoi");
            System.out.println("2 -> Fechas");
            System.out.println("3 -> Sumatoria Pi");
            System.out.println("4 -> Salida");
            System.out.println();
            System.out.println("Ingrese una opcion: ");
            opcion = leer.nextInt();
            leer.nextLine();
            
            switch (opcion)
            {
                case 1: {
                    System.out.println("TORRES DE HANOI");
                    System.out.println("\n Escriba el numero de discos: ");
                    int n = leer.nextInt();
                    
                    Hanoi(n,1,2,3);
                    
                    break;
                }  
                case 2: {
                    
                    System.out.println("\nFECHAS");
                    System.out.println("Escriba una cadena (si espacios en fechas): ");
                    String cadena;
                    cadena = leer.nextLine(); 
                    
                    //cadena,12/12/2023, hola,12/11/2023
                    
                    String t[]= cadena.split(",");
                    
                    for(int i = 0; i<t.length;i++){
                        if(t[i].contains("/"))
                        {
                            System.out.println(t[i]+"-- es fecha");
                        }
                        else
                        {
                            System.out.println(t[i] +"-- no es fecha");
                        }
                        
                    }
                    for(int i = 0; i<t.length;i++){
                        if(t[i].contains("/"))
                        {
                           if(t[i].contains(" ")){
                               System.out.println("No debe contener espacios en fechas");
                           }
                           else{
                                System.out.println("");
                                String cad = t[i];
                                String array[] = new String[3];
                                int array2[] = new int[3];
                                int con =0;

                                StringTokenizer st = new StringTokenizer(cad, "/");
                                while (st.hasMoreElements()) {
                                    array[con]= (String) st.nextElement();
                                    array2[con]= Integer.parseInt(array[con]);
                                    con++;
                                }

                                if(array2[2]>0){
                                    if(array2[1]<13&&array2[0]<32)
                                    {
                                        Date creac = new Date(array2[2]-1900, array2[1]-1, array2[0]);
                                        System.out.println(creac);
                                    }
                                    else {
                                        System.out.println("Fallo en el ingreso de fechas");
                                    }
                                }
                                else {
                                    System.out.println("Fallo en el ingreso de fechas");
                                }
                           }
                                
                        }
                        
                        else
                        {
                        }
                        
                    }
                    
                    
                    
                    break;
                }

                case 3: {
                    System.out.println("Sumatoria Pi");
                    System.out.println("\n Escriba un limite: ");
                    int num = leer.nextInt();
                    
                    System.out.println("La respuesta es: "+Pi(num,num));
                    
                    break;
                }
                
                default: 
                {
                    System.out.println("FIN DEL PROGRAMA");
                    break; 
                }
            }
            
        }while (opcion < 4);
        
    }//Fin del main 
    
    public static void Hanoi(int n, int origen, int auxiliar, int destino)
    {
        if(n==1)
        {
            System.out.println(" mover disco "+n+" de "+origen+" a "+destino);
            return;
        }
        else{
            Hanoi(n-1,origen,destino,auxiliar);
        }
        
        System.out.println(" mover disco "+n+" de "+origen+" a "+destino);
        Hanoi(n-1,auxiliar,origen,destino);
        //return;
         
    }
    public static double Pi(int n, int k){
        double exp = Math.pow(-1,n);
        double max = exp/((2*n)+1);
        if(n == 0)
        {
            return max;
        }
        else
        {
            
            double res = max+Pi(n-1,k);
            System.out.println(res);
            if(n ==k)
            {
                res = res*4;
            }
            return res;
        }
    }
    
}//Fin de l aclase

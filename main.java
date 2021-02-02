
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/**
 *
 * @author Uburrato
 */
/**
// nota para el proximo trabajo que haga para alguna empresa, como este mismo.
//debo escribir todas las variables en ingles, verbs and nouns must be differinciated dependening on the action of such elements.
// no more spanglish because some people don't understand and its onlty good person that is writing but code is hella confusing this way so, no, no more spanish from now on!!!
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws FileNotFoundException, NoSuchElementException, IOException {
      
  Scanner choose = new Scanner(System.in);
    String choice = null;
    int menu = 0;
    while (menu != 6) {
      System.out.println("\nSeleccione una Opcion:");
      System.out.println("1 - Generar nuevo Archivo ");
      System.out.println("2 - Leer Archivo Generado");
      System.out.println("3 - Ordena Archivo ");
      System.out.println("4 - Lee Archivo Ordenado ");
      System.out.println("5 - Buscar numero en Archivo");
      System.out.println("6 - Salir");
      choice = choose.nextLine(); //
      switch (Integer.parseInt(choice)) {
      case 1:
        try {

          System.out.println("Ingrese cantidad de numeros a crear: ");
          Scanner cantidadNumeros = new Scanner(System.in);
          int nro = Integer.parseInt(cantidadNumeros.nextLine());
          System.out.println("Se han creado: " + nro + " valores al azar");
          PrintWriter writer = new PrintWriter("filename.txt", "UTF-8");
          for (int i = 0; i < nro; i++) {
            int valorDado = (int) (Math.random() * 1000);
            writer.println(valorDado);
          }
          writer.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
      case 2:

        System.out.println("\n");
        File archivo = new File("filename.txt"); //
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
          System.out.print("["+ linea+"]");
        }
        break;

      case 3:
        // agarrar numeros del archivo y pasarlos a un array
        // Bubble sort - QuickSort - Heapsort + timer

        File archivo3 = new File("filename.txt"); //
        FileReader fr3 = new FileReader(archivo3);
        BufferedReader br3 = new BufferedReader(fr3);

        int cantLineas = cantidadLineas();
        int contador = 0;

        int arreglo[] = new int[cantLineas];
        String linea3;

        while ((linea3 = br3.readLine()) != null) {
          arreglo[contador] = Integer.parseInt(linea3);
          contador = contador + 1;
        }

        System.out.println("Seleccione tipo de ordenamiento: ");
        System.out.println("1 - Sort");
        System.out.println("2 - Quicksort");
        System.out.println("3 - Burbuja ");
        System.out.println("4 - Parallel Sort ");
        System.out.println("5 - HeapSort");

        Scanner tipoOrden = new Scanner(System.in);
        int tpo = Integer.parseInt(tipoOrden.nextLine());

        switch (tpo) {
        case 1:
          System.out.println("Se ha ordenado con el metodo Sort");
          sort(arreglo);
          break;
        case 2:
          System.out.println("Se ha ordenado con el metodo QuickSort");
          sort(arreglo);
          break;
        case 3:
          System.out.println("Se ha ordenado con el metodo Burbuja");
          burbuja(arreglo);
          break;
        case 4:
          System.out.println("Se ha ordenado con el  Parallel sort");
          parallelsort(arreglo);
          break;
        case 5:
          System.out.println("Se ha ordenado con el metodo Heapsort");
          heapSort(arreglo, cantLineas);
          break;
        }

        break;

      case 4:
        System.out.println("\n");
        File javasort = new File("ordenado.txt"); //
        FileReader javasortfr = new FileReader(javasort);
        BufferedReader javasortbr = new BufferedReader(javasortfr);
        String javasortlinea;
        while ((javasortlinea = javasortbr.readLine()) != null) {
          System.out.println(javasortlinea);
        }
        break;

      case 5:

        int count = 0;
        boolean find = false;
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese numero a buscar\n");
        String num = s.next();
        String line = "";

        try {

          FileInputStream fin = new FileInputStream("filename.txt");
          Scanner sc = new Scanner(fin);

          while (sc.hasNextLine()) {
            count++;
            line = sc.nextLine();

            if (line.equals(num)) {
              System.out.println("Se encontro el numero: " + line + " en la linea " + String.valueOf(count));
              find = true;
            }

          } // ENDWHILE
          sc.close();
          if (!find) {
            System.out.println("No se encontro el numero: " + num);
          }
        } catch (IOException ioe) {
          ioe.printStackTrace();
        }

        break;

      case 6:
        System.out.println("Se ha terminado.");
        System.exit(0);
        break;

      default:

      }
    }
  }

  public static int cantidadLineas() throws FileNotFoundException, IOException {

    File archivo4 = new File("filename.txt"); //
    FileReader fr4 = new FileReader(archivo4);
    BufferedReader br4 = new BufferedReader(fr4);
    int lineas4 = 0;
    String pepe;

    while ((pepe = br4.readLine()) != null) {
      lineas4 = lineas4 + 1;
    }
    return lineas4;
  }

  // metoto Array.sort utiliza el algoritmo quicksort y se utilizara en ambos
  // metodos
  public static int[] sort(int arreglo[]) throws FileNotFoundException, UnsupportedEncodingException {
    Arrays.sort(arreglo);
    PrintWriter writer = new PrintWriter("ordenado.txt", "UTF-8");
    for (int i = 0; i < arreglo.length; i++) {

    }
    writer.println(Arrays.toString(arreglo));
    writer.close();

    return arreglo;
  }

  public static int[] parallelsort(int arreglo[]) throws FileNotFoundException, UnsupportedEncodingException {

    Arrays.parallelSort(arreglo);

    PrintWriter writer = new PrintWriter("ordenado.txt", "UTF-8");
    for (int i = 0; i < arreglo.length; i++) {

    }
    writer.println(Arrays.toString(arreglo));
    writer.close();

    return arreglo;
  }

  public static int[] burbuja(int arreglo[]) throws FileNotFoundException, UnsupportedEncodingException {

    PrintWriter writer = new PrintWriter("ordenado.txt", "UTF-8");
    /* Bucle desde 0 hasta la longitud del array -1 */
    for (int i = 0; i < arreglo.length - 1; i++) {

      /* Bucle anidado desde 0 hasta la longitud del array -1 */
      for (int j = 0; j < arreglo.length - 1; j++) {

        /*
         * Si el número almacenado en la posición j es mayor que el de la posición j+1
         * (el siguiente del array)
         */ if (arreglo[j] > arreglo[j + 1]) {

          /* guardamos el número de la posicion j+1 en una variable (el menor) */
          int temp = arreglo[j + 1];
          /* Lo intercambiamos de posición */
          arreglo[j + 1] = arreglo[j];
          arreglo[j] = temp;

        }

      }

    }

    writer.println(Arrays.toString(arreglo));
    writer.close();
    return arreglo;
  }

  public static int[] heapSort(int[] arreglo, int length) throws FileNotFoundException, UnsupportedEncodingException {
    PrintWriter writerr = new PrintWriter("ordenado.txt", "UTF-8");
    int temp;
    int size = length - 1;
    for (int i = (length / 2); i >= 0; i--) {
      heapify(arreglo, i, size);
    }

    for (int i = size; i >= 0; i--) {
      temp = arreglo[0];
      arreglo[0] = arreglo[size];
      arreglo[size] = temp;
      size--;
      heapify(arreglo, 0, size);
    }

    writerr.println(Arrays.toString(arreglo));
    writerr.close();
    return arreglo;

  }

  public static int[] heapify(int[] arreglo, int i, int heapSize)
      throws FileNotFoundException, UnsupportedEncodingException {
    int a = 2 * i;
    int b = 2 * i + 1;
    int largestElement;
    if (a <= heapSize && arreglo[a] > arreglo[i]) {
      largestElement = a;
    } else {
      largestElement = i;
    }
    if (b <= heapSize && arreglo[b] > arreglo[largestElement]) {
      largestElement = b;
    }
    if (largestElement != i) {
      int temp = arreglo[i];
      arreglo[i] = arreglo[largestElement];
      arreglo[largestElement] = temp;
      heapify(arreglo, largestElement, heapSize);

    }

    return arreglo;
  }
    
}



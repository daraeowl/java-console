
import java.io.BufferedReader;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

class Main {

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
          System.out.println(linea);
        }
        break;

      case 3:
        // agarrar numeros del archivo y pasarlos a un array
        // Bubble sort - QuickSort - Heapsort + timer
        try {

          Scanner fin = new Scanner(new File("filename.txt"));
          int[] arr = new int[100];
          int i = 0;

          while (fin.hasNextLine()) {
            arr[i++] = fin.nextInt();
            System.out.println((fin));

          }
        } catch (IOException ioe) {
          System.out.println(ioe);
        }

        break;

      case 4:

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
}

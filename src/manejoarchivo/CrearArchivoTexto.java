package manejoarchivo;

import clases.RegistroCuenta;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CrearArchivoTexto {

    private Formatter salida;

    public void abrirArchivo() {
        try {
            salida = new Formatter("Clientes.txt");
        } catch (SecurityException securityException) {
            System.err.println("No tiene acceso de escritura a este archivo");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al crear archivo");
            System.exit(1);

        }
    }

    public void agregarRegistros() {
        RegistroCuenta registro = new RegistroCuenta();
        Scanner entrada = new Scanner(System.in);
        System.out.printf("%s\n%s\n\n",
                "Para terminar la entrada, escriba fin ",
                "cuando se le pida que escriba los datos de entrada y que oprima intro");
        System.out.printf("%s\n%s",
                "Escriba el numero de cuentas (>0), primer nombre, apellido paterno y saldo.", "?");

        while (!entrada.hasNext("fin")) {
            try {
                registro.establecerCuenta(entrada.nextInt());
                registro.establecerPrimerNombre(entrada.next());
                registro.establecerApellidoPaterno(entrada.next());
                registro.establecerSaldo(entrada.nextDouble());

                if (registro.obtenerCuenta() > 0) {
                    salida.format("%d %s %s %.2f\n", registro.obtenerCuenta(),
                            registro.obtenerPrimerNombre(), registro.obtenerApellidoPaterno(),
                            registro.obtenerSaldo());
                } else {
                    System.out.println("El numero de cuenta debe ser mayor a 0");
                }
            } catch (FormatterClosedException formatterClosedException) {
                System.err.println("Error al escribir el archivo");
                return;
            } catch (NoSuchElementException elementException) {
                System.err.println("Entrada invalida. Intente de nuevo");
                entrada.nextLine();
            }
            System.out.printf("%s %s\n%s", "Escriba el numero de cuenta (>0)",
                    "primer nombre, apellido paterno, saldo", "?");
        }

    }

    public void cerrarArchivo() {
        if (salida != null) {
            salida.close();
        }
    }
}

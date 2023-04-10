package manejoarchivo;

public class PruebaCreacionArchivo {

    public static void main(String[] args) {
        CrearArchivoTexto aplicacion = new CrearArchivoTexto();

        aplicacion.abrirArchivo();
        aplicacion.agregarRegistros();
        aplicacion.cerrarArchivo();

        LeerArchivoTexto aplicacion2 = new LeerArchivoTexto();

        aplicacion2.abrirArchivo();
        aplicacion2.leerRegistroa();
        aplicacion2.cerraarArchivo();
    }

}

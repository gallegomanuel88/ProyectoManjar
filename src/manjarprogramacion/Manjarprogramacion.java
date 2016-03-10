package manjarprogramacion;

import javax.swing.JOptionPane;

/**
 *
 * @author gallegomanue88
 */
public class Manjarprogramacion {

    public static void main(String[] args) {
        Metodos obj1 = new Metodos ();
        
        for (boolean b = false; b == false;) {

            switch (Integer.parseInt(JOptionPane.showInputDialog("La opcion:\n\n1.) Reproduce un campeon aleatorio\n2.) Leer archivo de jugadores y cargar en el arrayList\n3.) Añadir una puntuacion\n4.) Ordenar Arrylist por orden de puntuaciones\n5.) Escribir puntuaciones en archivo\n6.) Jugar\n7.) Salir"))) {
                case 1:
                    obj1.leerArchivo(obj1.generarNumero());
                    break;
                case 2:
                    obj1.leerArchivoPuntuaciones();
                    break;
                case 3:
                    obj1.añadirPuntuacion();
                    break;
                case 4:
                    obj1.ordenarArray();
                    break;
                case 5:
                    obj1.escribirArchivoPuntuaciones ();
                    break;
                case 6:
                    obj1.jugar();
                    system("CLS");
                    break;
                case 7:
                    b = true;
                    break;

                default:
                    break;
            }

        }
    }

    private static void system(String cls) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

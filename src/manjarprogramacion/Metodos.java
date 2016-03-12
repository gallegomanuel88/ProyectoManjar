package manjarprogramacion;

import JFrame.PanelCanciones;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
 *
 * @author gallegomanuel88
 */
public class Metodos {

    public static Clip clip;
    public String ruta = "/voces/";
    public static String campeonActual;
    public static int puntosActual;
    Jugadores objJugadores;
    ArrayList <Jugadores> arrayJugadores = new ArrayList();
   
    /**
     * Genera un numero aleatorio entre el 1 y el 129.
     * @return retorna el numero aleatorio generado.
     */
    public int generarNumero() {
        int numeroAleatorio = (int) (Math.random() * 129 + 1);
        return numeroAleatorio;
    }

    /**
     * Este metodo lee el archivo "voces.txt" y busca el numero del campeon que proporciona la variable "int n". Cuando encuentra el numero del campeon llama al metodo sonido(nombre del campeon).
     * 
     * @param n este parametro va a ser comparado con el numero del campeon buscado en el archivo. Este numero sera el return del metodo generarNumero.
     */
    public void leerArchivo(int n) {
        File f;
        Scanner sc = null;
        try {
            f = new File("src/manjarprogramacion/voces.txt");
            sc = new Scanner(f);

            while (sc.hasNextLine()) {
                String res = sc.nextLine();
                //System.out.println(res);
                String[] arrayNumeroYNombre = res.split(",");
                if (Integer.parseInt(arrayNumeroYNombre[0]) == n) {
                    System.out.println(arrayNumeroYNombre[1]);
                    campeonActual = arrayNumeroYNombre[1];
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado"+ex.getMessage());
        } finally {
            sc.close();
        }
    }

    /**
     * Abre un archivo de sonido .wav con el mismo nombre que el contenido de campeon actual.
     */
    public void sonido() {
     PanelCanciones x = new PanelCanciones();
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + campeonActual + ".wav")));
            clip.start();
            System.out.println("En sonido: "+campeonActual);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
        }finally{
            x.setVisible(true);
            
        }
    }
    
    public void sonidoMenu(String sound) {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + sound + ".wav")));
            clip.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
        }finally{
        }
    }

    /**
     * Este metodo lee el archivo "jugadores.txt" y carga los los datos leidos en el arrayList "arrayJugadores" de clase jugadores.
     */
    public void leerArchivoPuntuaciones() {
        
        File f;
        Scanner sc = null;
        try {
            f = new File("src/manjarprogramacion/jugadores.txt");
            sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String res = sc.nextLine();
                String[] arrayPuntuacionYNombre = res.split(",");
                objJugadores= new Jugadores(Integer.parseInt(arrayPuntuacionYNombre[0]),arrayPuntuacionYNombre[1]);
                arrayJugadores.add(objJugadores);
             
                campeonActual=arrayPuntuacionYNombre[1];
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } finally {
            sc.close();
        }
    }
    
    /**
     * Este metodo ordena el arrayList "arrayJugadores" de clase jugadores cargado anteriormente por el metodo leerPuntuaciones ().
     */
    public void ordenarArray (){
        Collections.sort(arrayJugadores);
    }
    
    /**
     * Este metodo sobreescribe los datos almacenados en el arrayList "arrayJugadores" de clase jugadores, en el archivo "jugadores.txt".
     */
    public void escribirArchivoPuntuaciones (){
        File f;
        PrintWriter pr = null;
        try {
            f = new File ("src/manjarprogramacion/jugadores.txt");
            pr = new PrintWriter (f);
            for(Jugadores j:arrayJugadores){
            pr.println (j.puntuacionNombre());
            }
        }
        catch (FileNotFoundException ex){
            System.out.println("Archivo no encontrado");
        }
        finally {
            pr.close();
            puntosActual = 0;
        }
    }
    
    /**
     * Este metodo añade una puntuacion y jugador al arraylist "arrayJugadores" de clase Jugadores.
     */
    public void añadirPuntuacion (String nombreInvocador){
        objJugadores = new Jugadores (puntosActual,nombreInvocador);
        arrayJugadores.add(objJugadores);
    }
    
    public void comprobarCampeon (String campeon){
        
        if (campeon.equalsIgnoreCase(campeonActual)){
            JOptionPane.showMessageDialog(null, "Has acertado");
            puntosActual= (puntosActual+5);
        } 
    }
    
    public String devolverPuntuacion (){
        return String.valueOf(puntosActual);
    }
    
    //NO USAR ESTES METODOS EN JFRAME
    public String imprimir (int n){
        //for(Jugadores j:arrayJugadores){
        //    System.out.println(j.toString());
        //}    
        return arrayJugadores.get(n).toString();
    }
    
   
   /* public void jugar(){
        leerArchivoPuntuaciones();
        for (boolean b = false; b == false;) {

            switch (Integer.parseInt(JOptionPane.showInputDialog("La opcion:\n\n1.) Jugar\n2.) Ver puntuaciones\n3.) Salir"))) {
                case 1:
                    puntosActual=0;
                    leerArchivo(generarNumero());
                    comprobarCampeon ();
                    leerArchivo(generarNumero());
                    comprobarCampeon ();
                    leerArchivo(generarNumero());
                    comprobarCampeon ();
                    leerArchivo(generarNumero());
                    comprobarCampeon ();
                    leerArchivo(generarNumero());
                    comprobarCampeon ();
                    añadirPuntuacion ();
                    ordenarArray ();
                    escribirArchivoPuntuaciones ();
                    break;
                case 2:
                    ordenarArray();
                    imprimir();
                    break;
                case 3:
                    b = true;
                    break;
                default:
                    break;
            }

        }
    }*/
}

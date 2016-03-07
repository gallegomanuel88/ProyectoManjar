package manjarprogramacion;

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

/**
 *
 * @author gallegomanuel88
 */
public class Metodos {

    public Clip clip;
    public String ruta = "/voces/";
    Jugadores objJugadores;
    ArrayList <Jugadores> arrayJugadores = new ArrayList();

    public int generarNumero() {
        int numeroAleatorio = (int) (Math.random() * 129 + 1);
        return numeroAleatorio;
    }

    public void leerArchivo(int n) {
        File f;
        Scanner sc = null;
        try {
            f = new File("src/manjarprogramacion/voces.txt");
            sc = new Scanner(f);

            while (sc.hasNextLine()) {
                String res = sc.nextLine();
                System.out.println(res);
                String[] arrayNumeroYNombre = res.split(",");
                if (Integer.parseInt(arrayNumeroYNombre[0]) == n) {
                    System.out.println(arrayNumeroYNombre[1]);
                    sonido(arrayNumeroYNombre[1]);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } finally {
            sc.close();
        }
    }

    public void sonido(String archivo) {

        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + archivo + ".wav")));
            clip.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
        }
    }

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
                
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } finally {
            sc.close();
        }
    }
    public void ordenarArray (){
        for(Jugadores j:arrayJugadores){
            System.out.println(j.toString());
        }
        Collections.sort(arrayJugadores);
        for(Jugadores j:arrayJugadores){
            System.out.println(j.toString());
        }
    }
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
        }
    }
    
    public void añadirPuntuacion (){
        objJugadores = new Jugadores (800,"Jorge");
        arrayJugadores.add(objJugadores);
    }
}

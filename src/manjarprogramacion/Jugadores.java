package manjarprogramacion;


        
/**
 *
 * @author pablolago97
 */
public class Jugadores implements Comparable<Jugadores>{
    
    private int puntuacion;
    public String jugador;

    public Jugadores() {
    }

    public Jugadores(int puntuacion, String jugador) {
        this.puntuacion = puntuacion;
        this.jugador = jugador;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    @Override
    public String toString() {
        return "Jugador: " + jugador + "  Puntuacion: " + puntuacion;
    }
    
    public String puntuacionNombre () {
        return puntuacion+","+jugador;
    }

    @Override
    public int compareTo(Jugadores t) {
        if(puntuacion<t.puntuacion){
            return 1;
        }else if(puntuacion==t.puntuacion){
            return 0;
        }else{
            return -1;
        }
    }

    

}
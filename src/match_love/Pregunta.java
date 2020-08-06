package match_love;

/**
 *
 * @author Larios
 */
public class Pregunta {

    public final int numero;
    public final String pregunta;
    public final String[] respuestas;
    RESPUESTA selectRespuesta;
    public int indexSelectRespuesta;

    public Pregunta(int numero, String pregunta, String[] respuestas) {
        this.numero = numero;
        this.pregunta = pregunta;
        this.respuestas = respuestas;
        selectRespuesta = RESPUESTA.NONE;
        indexSelectRespuesta = -1;
    }

    public String getRespuesta() {
        if (indexSelectRespuesta == -1) {
            throw new Error("Esta pregunta aún no tiene una respuesta");
        }
        return respuestas[indexSelectRespuesta];
    }
    
    @Override
    public String toString() {
        String splitResp = "";
        for (int i = 0; i < respuestas.length; i++) {
            splitResp += respuestas[i];
            if (i < respuestas.length - 1) {
                splitResp += "\n";
            }
        }

        return "Pregunta " + numero + "\n" + pregunta + "\n" + splitResp;
    }

    enum RESPUESTA {
        A, B, C, D, E, F, G, NONE
    }
    
}

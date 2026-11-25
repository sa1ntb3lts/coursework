import java.util.Random;

public class Dado {
    // Atributo
    private int[] caras;

    // Constructor
    public Dado(int[] caras) {
        this.caras = caras;
    }

    // Metodo
    public int lanzarDado() {
        Random rnd = new Random();
        int rndIndex = rnd.nextInt(caras.length);

        return rndIndex + 1;
    }
}

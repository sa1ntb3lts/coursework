public class Main {
    public static void main(String[] args) {
        Dado dado = new Dado(new int[] {1, 2, 3, 4});

        System.out.println("Tu dado cayo en la cara: " + dado.lanzarDado());

    }
}

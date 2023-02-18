import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        int[] sizes = { 10, 100, 1000, 10000 };
        double[] sparsities = { 1.0, 0.1, 0.01, 0.001, 1.0 / Math.log(10), 1.0 / (10 * 10) };

        for (int size : sizes) {
            for (double sparsity : sparsities) {
                double[][] matrix = generateSparseMatrix(size, sparsity, rand);
                double[] vector = generateVector(size, rand);

                long start = System.nanoTime();
                double[] result = MatrixVectorProduct.matrixVectorProduct(matrix, vector);
                long end = System.nanoTime();

                double time = (end - start) / 1e6;
                System.out.printf("Size: %d, Sparsity: %.3f, Time: %.3f ms%n", size, sparsity, time);
            }
        }
    }

    public static double[][] generateSparseMatrix(int size, double sparsity, Random rand) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (rand.nextDouble() < sparsity) {
                    matrix[i][j] = rand.nextDouble();
                }
            }
        }
        return matrix;
    }

    public static double[] generateVector(int size, Random rand) {
        double[] vector = new double[size];
        for (int i = 0; i < size; i++) {
            vector[i] = rand.nextDouble();
        }
        return vector;
    }
}

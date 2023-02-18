public class MatrixVectorProduct {
    public static double[] matrixVectorProduct(double[][] matrix, double[] vector) {
        int m = matrix.length;
        int n = matrix[0].length;
        assert n == vector.length;

        double[] result = new double[m];
        for (int i = 0; i < m; i++) {
            double sum = 0.0;
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j] * vector[j];
            }
            result[i] = sum;
        }

        return result;
    }
}
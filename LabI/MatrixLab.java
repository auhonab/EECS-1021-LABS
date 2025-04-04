import java.util.*;

public class MatrixLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first matrix values: ");
        String firstMatrixInput = scanner.nextLine();

        System.out.print("Enter the second matrix values: ");
        String secondMatrixInput = scanner.nextLine();

        System.out.print("Enter the desired operation: ");
        String operation = scanner.nextLine();

        final int DIMENSION = (int) Math.sqrt(firstMatrixInput.split(" ").length);

        int[][] matrixA = parseMatrix(firstMatrixInput, DIMENSION, DIMENSION);
        int[][] matrixB = parseMatrix(secondMatrixInput, DIMENSION, DIMENSION);

        int[][] resultMatrix = computeMatrixExpression(matrixA, matrixB, operation);

        System.out.println(matrixToString(resultMatrix));
    }

    private static int[][] parseMatrix(String s, int rowCount, int colCount) {
        String[] values = s.split(" ");
        int[][] matrix = new int[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                matrix[i][j] = Integer.parseInt(values[i * colCount + j]);
            }
        }
        return matrix;
    }

    private static int[][] computeMatrixExpression(int[][] a, int[][] b, String op) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        switch (op) {
            case "+":
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        result[i][j] = a[i][j] + b[i][j];
                    }
                }
                break;
            case "-":
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        result[i][j] = a[i][j] - b[i][j];
                    }
                }
                break;
            case "*":
                result = new int[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        for (int k = 0; k < cols; k++) {
                            result[i][j] += a[i][k] * b[k][j];
                        }
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
        return result;
    }

    private static String matrixToString(int[][] mat) {
        StringJoiner joiner = new StringJoiner("\n");
        for (int[] row : mat) {
            joiner.add(Arrays.toString(row));
        }
        return joiner.toString();
    }
}

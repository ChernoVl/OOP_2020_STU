package sk.stuba.fei.uim.oop.matrix;

import java.util.*;

public class Matrix<T extends Number> {

    private int row;
    private int column;
    private T[][] matrix;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Matrix() {
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public T[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(T[][] matrix) {
        this.matrix = matrix;
    }

    //    public T[][] generateMatrix(int row, int column){
//        Random rnd = new Random();
//        T[][] matrix = new T[row][column];
//        for(int i = 0; i < row; i++){
//            for(int j = 0; j < column; j++){
//                matrix[i][j] = rnd.nextInt(10);
//            }
//        }
//        return matrix;
//    }

    public T[][] multiplication(Matrix<T> matrix2){

        Double sum = 0.0;
        Double[][] answer = new Double[this.row][matrix2.getColumn()];
        for(int i = 0; i < row; i++) {
            for (int k = 0; k < row; k++) {
                for (int j = 0; j < column; j++) {
                    sum += Double.valueOf(String.valueOf(matrix[i][j])) * Double.valueOf(String.valueOf(matrix2.getMatrix()[j][k]));
                }
                answer[i][k] = sum;
                sum = 0.;
            }
        }
        matrix = (T[][])answer;
        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                str.append(matrix[i][j]);
                str.append(' ');
            }
            str.append('\n');
        }
        return str.toString();
    }
}

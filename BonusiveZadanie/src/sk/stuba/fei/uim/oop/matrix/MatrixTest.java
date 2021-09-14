package sk.stuba.fei.uim.oop.matrix;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MatrixTest {
    Reader fReader;
    Print fPrint;
    @Before
    public void init(){
        fReader = new FReader("matrix.csv");
        fPrint = new FPrint("out.csv");


    }

    @Test
    public void getMessageTest(){
        System.out.println(fReader.getMessage());
    }

    @Test
    public void sendMessageTest(){
        fPrint.sendMessage("d");
    }

    @Test
    public void generateMatrix() {
        Integer[][] int1 = {{1, 2, 3}, {5, 3, 1}, {6, 4, 2, 4}};
        Integer[][] int2 = {{1, 2, 3}, {5, 3, 1}, {6, 4, 2, 4}};

        Matrix<Integer> m1 = new Matrix<>(3, 3);
        m1.setMatrix(int1);
        Matrix<Integer> m2 = new Matrix<>(3,3);
        m2.setMatrix(int2);

        System.out.println(m1);
        m1.multiplication(m2);
        System.out.println(m1);
    }
}

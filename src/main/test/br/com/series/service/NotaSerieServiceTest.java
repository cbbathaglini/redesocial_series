package br.com.series.service;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class NotaSerieServiceTest {

    @Test
    public void test_adicionar_nota_comentario(){
        String input = "add 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


    }
}

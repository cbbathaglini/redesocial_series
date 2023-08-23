package br.com.series.view;

import br.com.series.model.Usuario;
import br.com.series.model.notaserie.NotaSerie;
import br.com.series.model.serie.Serie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class NotaSerieViewTest {

    @Mock
    private NotaSerieView notaSerieView;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        notaSerieView = Mockito.mock(NotaSerieView.class);
    }

    @Test
    public void test_adicionarNotaComentario(){
        NotaSerieView notaSerieView = new NotaSerieView();

        //Scanner scanner = new Scanner(System.in);
        String input = "6\n1\n'comentarios aqui'";
        //Mockito.when(scanner.nextLine()).thenReturn("6");


        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        Mockito.when(scanner.nextLine()).thenReturn("6");
        notaSerieView.informarSerie();
        Assert.assertEquals("a","a");

    }
}

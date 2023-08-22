import br.com.series.model.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        options();
    }

    public static void options() {

        Scanner in = new Scanner(System.in);
        String option = "-1";

        //fixando o  usuário
        Usuario usuario = new Usuario(1,"euaqui","euaqui@email.com");
        while(!"12".equals(option)){
            all_options();
            System.out.println("Informe uma opção: ");
            option = in.nextLine();
            switch (option) {
                case "1": //cadastrar uma série
                    //TODO
                    //desenvolver a lógica que cadastra uma série no banco de dados
                    break;

                case "...":
                    break;

                case "7": //Adicionar série na minha lista de séries
                    // TODO
                    // usar o objeto usuario da linha 18
                    // adicionar
                    // depois de adicionar, exiba a sua lista de séries
                    break;

                case "8": //REMOVER série na minha lista de séries
                    // TODO
                    // remover
                    // depois de remover, exiba a sua lista de séries
                    break;

                case "....":
                    break;

                case "12":
                    System.out.println("Finalizando...");
                    System.exit(1);
                    break;
            }
        }
    }

    public static void all_options(){
        System.out.println("------------------------------------------");
        System.out.println(" 1 - Cadastrar uma série");
        System.out.println(" 2 - Listar séries");
        System.out.println(" 3 - Procurar série");
        System.out.println(" 4 - Adicionar uma nota e um comentário para a série");
        System.out.println(" 5 - Procurar série");
        System.out.println(" 6 - Visualizar média das notas de uma série");
        System.out.println(" 7 - Adicionar série na minha lista de séries");
        System.out.println(" 8 - Remover série da minha lista de séries");
        System.out.println(" 9 - Adicionar série na minha lista de séries favoritas");
        System.out.println(" 10 - Remover série da minha lista de séries");
        System.out.println(" 11 - Alterar situação de uma das minhas séries");
        System.out.println(" 12 - Sair");
        System.out.println("------------------------------------------");
    }


}
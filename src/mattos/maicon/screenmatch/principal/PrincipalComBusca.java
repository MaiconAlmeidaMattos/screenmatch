package mattos.maicon.screenmatch.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mattos.maicon.screenmatch.excecao.ErroDeConversaoDeAnoException;
import mattos.maicon.screenmatch.modelos.Titulo;
import mattos.maicon.screenmatch.modelos.TituloOmdb;

import javax.sound.midi.Soundbank;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new GsonBuilder().
                setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        String busca = "";
        List<Titulo> listaDeTitulos = new ArrayList<>();


        while( !busca.equalsIgnoreCase( "sair" ) ) {


            System.out.println("Qual filme deseja pesquisar? ");
            busca = scanner.nextLine();

            if( busca.equalsIgnoreCase( "sair" ) ){
                break;
            }

            String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=368fde0a";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());


                String json = response.body();
                System.out.println(json);



                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);


                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("\nTitulo já convertido: ");
                System.out.println(meuTitulo);

                listaDeTitulos.add( meuTitulo );
            } catch (NumberFormatException e) {
                System.out.println("Erro nas informações retornadas: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca: " + e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println( listaDeTitulos );
        FileWriter escrita = new FileWriter( "titulos.json" );
        escrita.write( gson.toJson( listaDeTitulos ) );
        escrita.close();
        System.out.println( "O programa finalizou corretamente!" );



    }
}

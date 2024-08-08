package mattos.maicon.screenmatch.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mattos.maicon.screenmatch.modelos.Titulo;
import mattos.maicon.screenmatch.modelos.TituloOmdb;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.Scanner;


public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Qual filme deseja pesquisar? ");
        var nomeParaBusca = scanner.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + nomeParaBusca + "&apikey=368fde0a";

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri( URI.create( endereco ) )
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());


            String json = response.body();
            System.out.println( json );

            Gson gson = new GsonBuilder().setFieldNamingPolicy( FieldNamingPolicy.UPPER_CAMEL_CASE ).create();

            TituloOmdb meuTituloOmdb = gson.fromJson( json, TituloOmdb.class );
            System.out.println( meuTituloOmdb );


            Titulo meuTitulo = new Titulo( meuTituloOmdb );
            System.out.println( "\nTitulo já convertido: " );
            System.out.println( meuTitulo );

        } catch( NumberFormatException e ){
            System.out.println( "Erro nas informações retornadas: " + e.getMessage() );
        } catch( IllegalArgumentException e ){
            System.out.println( "Algum erro de argumento na busca: " + e.getMessage() );
        }

        finally {
            System.out.println( "O programa finalizou corretamente!" );
        }


    }
}

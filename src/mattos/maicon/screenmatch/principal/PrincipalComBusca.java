package mattos.maicon.screenmatch.principal;

import com.google.gson.Gson;
import mattos.maicon.screenmatch.modelos.Titulo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Qual filme deseja pesquisar? ");
        var nomeParaBusca = scanner.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + nomeParaBusca + "&apikey=368fde0a";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri( URI.create( endereco ) )
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        String json = response.body();
//        System.out.println( json );

        Gson gson = new Gson();
        Titulo meuTitulo = gson.fromJson( json, Titulo.class );
        System.out.println( meuTitulo );



    }
}

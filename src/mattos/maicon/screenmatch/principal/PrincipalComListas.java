package mattos.maicon.screenmatch.principal;

import mattos.maicon.screenmatch.modelos.Filme;
import mattos.maicon.screenmatch.modelos.Serie;
import mattos.maicon.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {

    public static void main(String[] args){

        Filme meuFilme = new Filme( "O Poderoso chefão", 1970 );
        meuFilme.avalia(9);
        Filme outroFilme = new Filme( "Avatar", 2023 );
        outroFilme.avalia(6);
        Filme filmeDoPaulo = new Filme( "Dogville", 2003 );
        filmeDoPaulo.avalia(10);
        Serie lost = new Serie( "Lost" , 2000 );

        List<Titulo> lista = new ArrayList<>();
        lista.add( filmeDoPaulo );
        lista.add( meuFilme );
        lista.add( outroFilme );
        lista.add( lost );

        for( Titulo titulo : lista ){
            System.out.println( titulo.getNome() );
            if( titulo instanceof Filme filme && filme.getClassificacao() > 2 ) {
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        ArrayList<String> buscaPorArtirtas = new ArrayList<>();
        buscaPorArtirtas.add( "Zé Ramalho" );
        buscaPorArtirtas.add( "Adam Sandler" );
        buscaPorArtirtas.add( "Maicon" );
        System.out.println( buscaPorArtirtas );

        Collections.sort( buscaPorArtirtas );
        System.out.println( buscaPorArtirtas );

        Collections.sort( lista );
        System.out.println( lista );

        lista.sort( Comparator.comparing( Titulo::getAnoDeLancamento ) ) ;
        System.out.println( lista );






        
    }
}

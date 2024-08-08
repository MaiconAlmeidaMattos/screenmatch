package mattos.maicon.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    @SerializedName("Title")
    private String nome;

    @SerializedName("Year")
    private int anoDeLancamento;

    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo( TituloOmdb tituloOmdb ){
        this.nome = tituloOmdb.title();
        this.anoDeLancamento = Integer.valueOf( tituloOmdb.year() );
        this.duracaoEmMinutos = Integer.valueOf( tituloOmdb.runtime().substring(0,2) );
    }

    // GETTER E SETTER NOME
    public void setNome( String nome ) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    // GETTER E SETTER ANO DE LANÇAMENTO
    public void setAnoDeLancamento( int anoDeLancamento ) {
        this.anoDeLancamento = anoDeLancamento;
    }
    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    // GETTER E SETTER INCLUIDO NO PLANO
    public void setIncluidoNoPlano( boolean incluidoNoPlano ) {
        this.incluidoNoPlano = incluidoNoPlano;
    }
    public boolean getIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    // GETTER E SETTER DURAÇÃO EM MINUTOS
    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    // GETTER SOMA DAS AVALIAÇOES
    public double getSomaDasAvaliacoes(){
        return somaDasAvaliacoes;
    }

    // GETTER TOTAL DE AVALIAÇÕES
    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }




    public void exibeFichaTecnica(){
        System.out.println( "Nome do Filme: " + nome );
        System.out.println( "Ano de lançamento: " + anoDeLancamento );
    }

    public void avalia( double nota ){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo( Titulo outroTitulo ) {
        return this.getNome().compareTo( outroTitulo.getNome() );
    }

    @Override
    public String toString() {
        return """
            nome = %s 
            Ano de Lançamento = %d
            Duração em minutos = %d
            """.formatted( this.nome, this.anoDeLancamento, this.duracaoEmMinutos );
    }


}

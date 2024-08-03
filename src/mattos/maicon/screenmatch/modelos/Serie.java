package mattos.maicon.screenmatch.modelos;

public class Serie extends Titulo{
    private int temporadas;
    private int episodiosPorTemporada;
    private boolean ativa;
    private int minutosPorEpisodio;

    public Serie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }


    //    GETTER E SETTER TEMPORADA
    public int getTemporadas() {
        return temporadas;
    }
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    //    GETTER E SETTER EPISODIOS POR TEMPORADA
    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }
    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    //    GETTER E SETTER ATIVA
    public boolean getAtiva() {
        return ativa;
    }
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    //    GETTER E SETTER MINUTOS POR EPISODIO
    public int getMinutosPorEpisodio() {
        return this.minutosPorEpisodio;
    }
    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }


    @Override
    public int getDuracaoEmMinutos() {
        return this.temporadas * this.episodiosPorTemporada * this.minutosPorEpisodio;
    }

    @Override
    public String toString() {
        return "Serie: " + this.getNome() + " (" + this.getAnoDeLancamento() + ") ";
    }


}

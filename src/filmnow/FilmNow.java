package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes.
 *
 * @author eliane
 *
 */
public class FilmNow {

    private static final int TAMANHOF = 100;
    private static final int TAMANHOH = 10;

    private Filme[] filmes; //uma representacao simploria da lista de filmes
    private Filme[] hotList;

    /**
     * Cria o FilmNow.
     */
    public FilmNow() {
        this.filmes = new Filme[TAMANHOF];
        this.hotList = new Filme[TAMANHOH];
    }

    /**
     * Acessa a lista de filmes mantida.
     * @return O array de filmes.
     */
    public Filme[] getFilmes() {
        return this.filmes.clone();
    }

    public Filme[] getHotList() {
        return this.hotList.clone();
    }

    /**
     * Acessa os dados de um filme específico.
     * @param posicao Posição do filme no sistema.
     * @return Dados do filme. Null se não há filme na posição.
     */
    public Filme getFilme(int posicao) {
        return filmes[posicao];
    }

    /**
     * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior.
     * @param posicao Posição do filme.
     * @param nome Nome do filme.
     * @param ano Ano de lançamento do filme.
     * @param local Local onde o filme pode ser assitido.
     */
    public String cadastraFilme(int posicao, String nome, String ano, String local) {
        if (posicao < 1 || posicao > TAMANHOF) {
            return "POSIÇÃO INVÁLIDA";
        }
        if (nome.isEmpty() || local.isEmpty()) {
            return "FILME INVALIDO";
        }

        Filme filme = new Filme(nome, ano, local);
        if (verificaFilme(filme)) {
            return "FILME JA ADICIONADO";
        }

        this.filmes[posicao] = filme;
        return "FILME ADICIONADO";
    }
    private boolean verificaFilme(Filme filme) {
        for (Filme value : filmes) {
            if (value == null) continue;

            if (filme.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean atribuirHot(int posicaoFilme, int posicaoHot) {
        Filme filme = this.filmes[posicaoFilme];

        if (isHot(filme)) {
            return false;
        }
        if (posicaoFilme > TAMANHOF || posicaoFilme < 1) {
            return false;
        }
        if (posicaoHot > TAMANHOH || posicaoHot < 1) {
            return false;
        }
        this.hotList[posicaoHot] = filme;
        return true;
    }

    public boolean isHot(Filme filme) {
        for (Filme value : this.hotList) {
            if (value == null) continue;

            if (value.equals(filme)) {
                return true;
            }
        }
        return false;
    }

    public void removerHot(int posicao) {
        this.hotList[posicao] = null;
    }
}
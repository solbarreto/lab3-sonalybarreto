package filmnow;

public class Filme {

    private String nome;

    private String ano;

    private String local;

    public Filme(String nome, String ano, String local) {
        this.nome = nome;
        this.ano = ano;
        this.local = local;
    }

    public String getNome() {
        return this.nome;
    }

    public String getAno() {
        return this.ano;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Filme)) {
            return false;
        }
        Filme filme = (Filme) o;
        return filme.getNome().equals(this.nome) && filme.getAno().equals(this.ano);
    }

    public String toString() {
        return this.nome + ", " + this.ano + "\n" + this.local;
    }

}
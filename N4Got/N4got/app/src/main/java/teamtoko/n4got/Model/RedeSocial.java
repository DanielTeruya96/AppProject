package teamtoko.n4got.Model;

/**
 * Created by Tokencio on 01/07/2016.
 */
public class RedeSocial {
    private int imag;
    private String nome;

    public RedeSocial(String fa, int fb) {
        this.nome = fa;
        this.imag = fb;
    }


    public int getImag() {
        return imag;
    }

    public void setImag(int imag) {
        this.imag = imag;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

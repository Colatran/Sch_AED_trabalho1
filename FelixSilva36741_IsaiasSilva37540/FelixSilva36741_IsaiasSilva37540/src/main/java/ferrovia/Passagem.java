package ferrovia;

import java.util.Date;

/**
 *
 * @author Félix Silva a36741
 * @author Isaías Samuel a37540
 */
public class Passagem {
    private int id;
    private Date dataHora;
    private boolean comParagem;
    private int linha;
    private Estacao estacao;
    private Comboio comboio;
    
    /**
     * 
     * @param i Id da passagem.
     * @param para Se foi efetuada paragem.
     * @param lin Linha da passagem.
     * @param e Objeto da Estacao em que foi efetuada.
     * @param c Objeto do Comboio que efetuou a passagem.
     */
    public Passagem(int i, boolean para, int lin, Estacao e, Comboio c){
        id = i;
        dataHora = new Date();
        comParagem  = para;
        linha = lin;
        estacao = e;
        comboio = c;
        
        System.out.println(toString());
    };
    
    /**
     * 
     * @return Se tem paragem ou nao.
     */
    public boolean temParagem(){
        return comParagem;
    } 
    
    /**
     * 
     * @return O objeto da estacao á qual a passagem foi efetuada.
     */
    public Estacao getEstacao(){
        return estacao;
    }
    
    /**
     * 
     * @return Uma string com os dados da passagem.
     */
    public String toString(){
        String parou = ";";
        if (comParagem) parou = " - Paragem;";
        
        return " -Passagem:" + id + " - Comboio:" + comboio.getSigal() + " - Localidade: " + estacao.getLocalidade() +
                " - " + dataHora + " - linha:" + linha + parou;
    }
}

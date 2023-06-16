package ferrovia;

import java.util.TreeMap;

/**
 *
 * @author Félix Silva a36741
 * @author Isaías Samuel a37540
 */
public class RF {
    private TreeMap<String, Comboio> comboios;
    private TreeMap<String, Estacao> estacoes;
    
    
    public RF(){
        estacoes = new TreeMap<>();
        comboios = new TreeMap<>();
    }
    
    /**
     * 
     * @param sgl Sigla de identificacao do comboio.
     * @return Se o comboio foi adicionado.
     */
    public boolean addComboio(String sgl){
        if(comboios.containsKey(sgl)) {
            System.out.println("***ERRO*** Comboio ja existente!!!");
            return false;
        }
        else {
            comboios.put(sgl, new Comboio(sgl));
            return true;
        }
    }
    
    /**
     * 
     * @param sgl Sigla de identificacao da estacao.
     * @param loc Localidade da estacao.
     * @return Se a estacao foi adicionada.
     */
    public boolean addEstacao(String sgl, String loc){
        if(estacoes.containsKey(sgl)) {
            System.out.println("***ERRO*** Estacao ja existente!!!");
            return false;
        }
        else {
            estacoes.put(sgl, new Estacao(sgl, loc));
            return true;
        }
    }
    
    /**
     * 
     * @param est Sigla de identificacao da estacao.
     * @param estDeLigacao Sigla de identificacao 2a da estacao.
     * @return Se a ligacao foi adicionada.
     */
    public boolean addLigacaoAEstacao(String est, String estDeLigacao){
        if(estacoes.get(est).addLigacao(estacoes.get(estDeLigacao)) &&
                estacoes.get(estDeLigacao).addLigacao(estacoes.get(est))){
            System.out.println("Ligacao entre a estacao " + est + " e " + estDeLigacao + " criada!");
            return true;
        }
        else return false;
    }
    
    /**
     * 
     * @param comb Sigla do comboio que vai efetuar a passagem.
     * @param est Sigla da estacao por onde se vai efetuar a passagem.
     * @param lin Linha por onde se vai efetuar a passagem.
     * @param para Se e passagem com paragem.
     * @return Se a passagem foi efetuada.
     */
    public boolean passarComboioPorEstacao(String comb, String est, int lin, boolean para){
        if(!comboios.containsKey(comb)) {
            System.out.println("***ERRO*** Comboio nao existe!!!");
            return false;
        }
        else if(!estacoes.containsKey(est)) {
            System.out.println("***ERRO*** Estacao nao existe!!!");
            return false;
        }
        else return comboios.get(comb).passarPorEstacao(estacoes.get(est), lin, para);
    }
    
    /**
     * 
     * @param sgl Sigla de identificacao da estacao.
     * @return Uma string com os dados de todas as passagens pela estacao.
     */
    public String passagensEmEstacaoToString(String sgl){
        if(!estacoes.containsKey(sgl)){
            return "***ERRO*** Estacao " + sgl + "nao existe!!!";
        }
        else return estacoes.get(sgl).passagensToString();
    }
    
    /**
     * 
     * @param sgl Sigla de identificacao do comboio.
     * @return Uma string com os dados de todas as paragens do comboio.
     */
    public String paragensDeComboioToString(String sgl){
        if(!comboios.containsKey(sgl)){
            return "***ERRO*** Comboio " + sgl + "nao existe!!!";
        }
        else return comboios.get(sgl).paragensToString();
    }
    
}

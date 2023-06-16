package ferrovia;

import java.util.LinkedList;

/**
 *
 * @author Félix Silva a36741
 * @author Isaías Samuel a37540
 */
public class Comboio {
    private String sigla;
    private LinkedList<Passagem> passagens;
    private static int passagemId = 0;
    
    /**
     * 
     * @param sgl Sigla do comboio.
     */
    public Comboio(String sgl){
        sigla = sgl;
        passagens = new LinkedList<>();
        
        System.out.println("Novo Comboio: " + sigla);
    }
    
    /**
     * 
     * @return A sigla do comboio.
     */
    public String getSigal() {
        return sigla;
    }
    
    /**
     * 
     * @return O objeto da ultima estacao pela qual este comboio passou ou null caso ainda nao tenha passado por nenhuma.
     */
    public Estacao ultimaEstacao(){
        if(passagens.isEmpty()) return null;
        else return passagens.get(passagens.size() - 1).getEstacao();
    }
    
    /**
     * 
     * @param est O objeto da estacao pela qual se pretende efetuar a passagem.
     * @param lin A linha pela qual se pretende efetuar a passagem.
     * @param para Se efetua paragem.
     * @return Se a passagem foi efetuada.
     */
    public boolean passarPorEstacao(Estacao est, int lin, boolean para){
        Estacao ultimaE = ultimaEstacao();
        if(ultimaE == null || ultimaE.temLigacao(est)){
            Passagem p = new Passagem(passagemId, para, lin, est, this);
            passagemId++;
            return passagens.add(p) && est.addPassagem(p);
        }
        else {
            System.out.println("***ERRO*** As estacoes nao tem ligacao!!!");
            return false;
        }
    }
    
    /**
     * 
     * @return Uma string com os dados das passagens com paragem.
     */
    public String paragensToString(){
        String mensagem = "Paragens do comboio " + sigla + ":\n";
        
        for (Passagem passagem : passagens) {
            if(passagem.temParagem()) {
                mensagem += passagem.toString();
                mensagem += "\n";
            }
        }
        
        return mensagem;
    }
}

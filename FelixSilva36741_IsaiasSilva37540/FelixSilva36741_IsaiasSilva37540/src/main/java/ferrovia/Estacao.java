package ferrovia;

import java.util.LinkedList;

/**
 *
 * @author Félix Silva a36741
 * @author Isaías Samuel a37540
 */
public class Estacao {
    private String sigla;
    private String local;
    private LinkedList<Estacao> ligacoes;
    private LinkedList<Passagem> passagens;
    
    /**
     * 
     * @param sgl Sigla da estacao
     * @param loc Localidade da estacao
     */
    public Estacao(String sgl, String loc){
        sigla = sgl;
        local = loc;
        ligacoes = new LinkedList<>();
        passagens = new LinkedList<>();
        
        System.out.println("Nova Estacao: " + sgl + " em " + loc);
    }
    
    /**
     * 
     * @return Uma string com a localidade da estacao.
     */
    public String getLocalidade(){
        return local;
    }
    
    /**
     * 
     * @param outra O objeto da estacao que se quer adicionar ligacao.
     * @return Se foi adicionada ligacao.
     */
    public boolean addLigacao(Estacao outra){
        if(temLigacao(outra)){
            System.out.println("***ERRO*** Ligacao ja existente!!!");
            return false;
        }
        else return ligacoes.add(outra);
    }
    
    /**
     * 
     * @param outra O objeto da estacao que se quer verificar se tem ligacao.
     * @return Se tem ligacao com outra.
     */
    public boolean temLigacao(Estacao outra){
        return ligacoes.contains(outra);
    }
    
    /**
     * 
     * @param p O objeto da passagem.
     * @return Se a passagem foi efetuada.
     */
    public boolean addPassagem(Passagem p){
        return passagens.add(p);
    }
    
    /**
     * 
     * @return Uma string com os dados de todas as passagens por esta estacao.
     */
    public String passagensToString(){
        String mensagem = "Passagens na Estacao " + sigla + ":\n";
        
        for (Passagem passagem : passagens) {
            mensagem += passagem.toString();
            mensagem += "\n";
        }
        
        return mensagem;
    }
}

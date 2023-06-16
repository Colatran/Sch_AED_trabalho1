package principal;

import ferrovia.RF;

/**
 *
 * @author Félix Silva a36741
 * @author Isaías Samuel a37540
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RF rf = new RF();
        
        rf.addComboio("AA00");
        rf.addComboio("BB11");
        rf.addComboio("BB11");
        System.out.println();
        
        rf.addEstacao("VREA0", "Vila Real");
        rf.addEstacao("VREA1", "Vila Real");
        rf.addEstacao("PORTO", "Porto");
        rf.addEstacao("PORTO", "Porto");
        System.out.println();
        
        rf.addLigacaoAEstacao("VREA0", "VREA1");
        rf.addLigacaoAEstacao("VREA1", "PORTO");
        rf.addLigacaoAEstacao("VREA1", "VREA0");
        System.out.println();
        
        rf.passarComboioPorEstacao("AA00", "VREA0", 0, true);
        rf.passarComboioPorEstacao("AA00", "VREA1", 1, false);
        rf.passarComboioPorEstacao("AA00", "PORTO", 1, true);
        rf.passarComboioPorEstacao("VREA0", "AA00", 0, true);
        rf.passarComboioPorEstacao("AA00", "AA00", 0, true);
        rf.passarComboioPorEstacao("AA00", "PORTO", 0, true);
        System.out.println();
        
        System.out.print(rf.paragensDeComboioToString("AA00"));
        System.out.println();
        
        System.out.print(rf.passagensEmEstacaoToString("VREA0"));
        System.out.print(rf.passagensEmEstacaoToString("VREA1"));
        System.out.print(rf.passagensEmEstacaoToString("PORTO"));
    }
    
}

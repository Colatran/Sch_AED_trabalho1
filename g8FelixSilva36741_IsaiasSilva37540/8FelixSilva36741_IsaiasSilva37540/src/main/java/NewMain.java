import set.TreeSet;

public class NewMain {
    static void Espaco() {
        System.out.println("x--------------------x");
        System.out.println();
        System.out.println();
    }
    
    static void Size(TreeSet<Integer> colecao, String nome) {
        System.out.println(nome + ": Size: " + colecao.size() + ";");
    }
    static void Empty(TreeSet<Integer> colecao, String nome) {
        if(colecao.isEmpty()) System.out.println(nome + ": Esta vazia;");
        else System.out.println(nome + ": Nao esta vazia;");
    }
    
    static void Contains(TreeSet<Integer> colecao, int valor, String nome) {
        if(colecao.contains(valor)) System.out.println(nome + ": Tem " + valor + ";");
        else System.out.println(nome + ": Nao tem " + valor + ";");
    }
    static void Add(TreeSet<Integer> colecao, int valor, String nome) {
        System.out.print(nome + ": Add:" + valor);
        if(colecao.add(valor)) System.out.println(": Adicionado;");
        else System.out.println(": Ja tem;");
    }
    static void Remove(TreeSet<Integer> colecao, int valor, String nome) {
        System.out.print(nome + ": Remove: " + valor);
        if(colecao.remove(valor)) System.out.println(": Removido;");
        else System.out.println(": Nao foi removido;");
    }
    
    static void ContainsAll(TreeSet<Integer> colecao1, String nome1, TreeSet<Integer> colecao2, String nome2) {
        if(colecao1.containsAll(colecao2)) System.out.println(nome1 + ": Contem todos os valores de " + nome2 + ";");
        else System.out.println(nome1 + ": Nao contem todos os valores de " + nome2 + ";");
    }
    static void AddAll(TreeSet<Integer> colecao1, String nome1, TreeSet<Integer> colecao2, String nome2){        
        colecao1.addAll(colecao2);
        System.out.println(nome1 + ": Adicionados os valoes de " + nome2 + ";");
    }
    static void Clear(TreeSet<Integer> colecao, String nome) {
        colecao.clear();
        System.out.println(nome + ": Clear;");
    }
    
    static void PrintList(TreeSet<Integer> colecao, String nome) {
        System.out.println(nome + ": " + colecao.toString());
    }
    static void Equals(TreeSet<Integer> colecao1, String nome1, TreeSet<Integer> colecao2, String nome2) {
        if(colecao1.equals(colecao2)) System.out.println(nome1 + " e " + nome2 + " sao o mesmo objeto;");
        else System.out.println(nome1 + " e " + nome2 + " sao objetos diferentes;");
    }
    
    public static void main(String[] args) {
        TreeSet<Integer> MySetA = new TreeSet<>();
        TreeSet<Integer> MySetB = new TreeSet<>();
        
        Add(MySetA, 1, "MySetA");
        Add(MySetA, 2, "MySetA");
        Add(MySetA, 3, "MySetA");
        Add(MySetA, 4, "MySetA");
        Add(MySetA, 5, "MySetA");
        Add(MySetA, 1, "MySetA");
        System.out.println();
        
        Contains(MySetA, 0, "MySetA");
        Contains(MySetA, 1, "MySetA");
        System.out.println();
        
        Remove(MySetA, 0, "MySetA");
        Remove(MySetA, 1, "MySetA");
        Remove(MySetA, 3, "MySetA");
        PrintList(MySetA, "MySetA");
        Espaco();
        
        Size(MySetA, "MySetA");
        Empty(MySetA, "MySetA");
        Size(MySetB, "MySetB");
        Empty(MySetB, "MySetB");
        Espaco();
        
        PrintList(MySetA, "MySetA");
        PrintList(MySetB, "MySetB");
        AddAll(MySetB, "MySetB", MySetA, "MySetA");
        PrintList(MySetB, "MySetB");
        Espaco();
        
        Add(MySetA, 1, "MySetA");
        Add(MySetA, 3, "MySetA");
        PrintList(MySetA, "MySetA");
        PrintList(MySetB, "MySetB");
        ContainsAll(MySetA, "MySetA", MySetB, "MySetB");
        ContainsAll(MySetB, "MySetB", MySetA, "MySetA");
        Espaco();
        
        PrintList(MySetA, "MySetA");
        PrintList(MySetB, "MySetB");
        MySetA.removeAll(MySetB);
        System.out.println("MySetA: Removidos os valoes de MySetB;");
        PrintList(MySetA, "MySetA");
        Espaco();
        
        Add(MySetA, 2, "MySetA");
        Add(MySetA, 4, "MySetA");
        PrintList(MySetA, "MySetA");
        PrintList(MySetB, "MySetB");
        MySetA.retainAll(MySetB);
        System.out.println("MySetA: Retidos os valores de MySetB;");
        PrintList(MySetA, "MySetA");
        Espaco();
        
        Clear(MySetA, "MySetA");
        Clear(MySetB, "MySetB");
        PrintList(MySetA, "MySetA");
        Size(MySetA, "MySetA");
        Espaco();
        
        TreeSet<Integer> MySetC = MySetA;
        Equals(MySetA, "MySetA", MySetB, "MySetB");
        Equals(MySetA, "MySetA", MySetC, "MySetC");
        Espaco();
        
        Add(MySetA, 1, "MySetA");
        Add(MySetA, 2, "MySetA");
        Add(MySetA, 3, "MySetA");
        Add(MySetA, 4, "MySetA");
        Add(MySetA, 5, "MySetA");
        PrintList(MySetA, "MySetA");
        System.out.println("MySetA: Min: " + MySetA.min().toString());
        System.out.println("MySetA: Max: " + MySetA.max().toString());
        Espaco();
        
        MySetB.addAll(MySetA.subSet(2, 4));
        System.out.println("MySetB: Adiconados os valores de 2 a 4 de MySetA;");
        PrintList(MySetB, "MySetB");
        Clear(MySetB, "MySetB");
        Espaco();
        
        MySetB.addAll(MySetA.tailSet(3));
        System.out.println("MySetB: Adiconados os valores a partir de 3 de MySetA;");
        PrintList(MySetB, "MySetB");
        Clear(MySetB, "MySetB");
        Espaco();
        
        MySetB.addAll(MySetA.headSet(3));
        System.out.println("MySetB: Adiconados os valores ate 3 de MySetA;");
        PrintList(MySetB, "MySetB");
        Espaco();
    }
}

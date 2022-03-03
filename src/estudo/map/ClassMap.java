package estudo.map;

import java.util.*;

public class ClassMap {
    public void estudoMetodosMap() {
        /* Para manipular Map precisamos indicar o tipo da chave e do
        valor. Exemplo: Map<Integer, Boolean>
        */
        System.out.println();
        System.out.println("Crie e adicione carros em um conjunto que relacione seus modelos e seus consumos");
        Map<String, Double> carros = new HashMap<>() {{
            put("gol", 14.4);
            put("uno", 13.9);
            put("opala", 10.2);
            put("hb20", 12.3);
            put("kwid", 11.6);
            put("mobi", 10.4);
            put("corsa", 10.4);
        }};
        System.out.println(carros);
        System.out.println();
        System.out.println("Substitua o consumo do carro gol para 15,2 KM/L:");
        carros.put("gol", 15.2);
        System.out.println(carros);
        System.out.println();
        System.out.println("Confira se o modelo tucson está inserido: ");
        System.out.println("Tucson está inserido? : " + carros.containsKey("tucson"));
        System.out.println();
        System.out.println("Confira se o modelo 'uno' está inserido: ");
        System.out.println("Uno está inserido? : " + carros.containsKey("uno"));
        System.out.println();
        System.out.println("Exiba o consumo do uno: " + carros.get("uno"));
        System.out.println();
        System.out.println("Exiba os modelos: ");
        /* Para exibir todos os modelos utilizamos a função keySet().
           Esta retorna as keys, neste caso um String que são os modelos
           dos carros em forma de um Set<String>. Com o Set em mãos, podemos
           simplesmente printa-lo no console.
        */
        Set<String> modelos = carros.keySet();
        System.out.println(modelos);
        System.out.println();
        System.out.println("Exiba os consumos");
        /* Para exibir todos os consumos usamos a função values().
           Esta retorna os valores, neste caso um Double que são os consumos
           dos carros em forma de Collection<Double>. Com o Collection em mãos,
           basta printar no console.
        */
        Collection<Double> consumos = carros.values();
        System.out.println(consumos);
        System.out.println();
        System.out.println("Exiba o modelo mais econômico e seu consumo: ");
        /* Precisamos relacionar os dois (keys e values). Utilizamos a função
           entrySet(), que retorna um Set<Map.Entry<String, Double>>, para
           trabalhar com os dois (keys e values) separadamente.
        */
        Double consumoMaisEficiente = Collections.max(carros.values());
        Set<Map.Entry<String, Double>> entries = carros.entrySet();
        String modeloMaisEficiente;
        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumoMaisEficiente)) {
                modeloMaisEficiente = entry.getKey();
                // caso tenha mais de um consumo mais eficiente
                System.out.println("Modelo mais eficiente: " + modeloMaisEficiente);
                System.out.println("Consumo mais eficiente: " + consumoMaisEficiente);
            }
        }
        System.out.println();
        System.out.println("Exiba o modelo menos econômico e seu modelo");
        Double consumoMenosEconomico = Collections.min(carros.values());
        String modeloMenosEconomico;
        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumoMenosEconomico)) {
                modeloMenosEconomico = entry.getKey();
                System.out.println("Modelo menos econômico: " + modeloMenosEconomico);
                System.out.println("Consumo menos econômico: " + consumoMenosEconomico);
            }
        }
        System.out.println();
        System.out.println("Exiba a soma do consumo: ");
        Iterator<Double> iterator = consumos.iterator();
        Double next, somaConsumos = 0.0;
        while (iterator.hasNext() == true) {
            next = iterator.next();
            somaConsumos += next;
        }
        System.out.println("Soma dos consumos = " + somaConsumos);
        System.out.println();
        System.out.println("Exiba a media dos consumos: " + somaConsumos / carros.size());
        System.out.println();
        System.out.println("Remova os modelos com o consumo igual a 10,2KM/L: ");
        Iterator<Double> iterator1 = consumos.iterator();
        while (iterator1.hasNext() == true) {
            if (iterator1.next().equals(10.2)) {
                iterator1.remove();
            }
        }
        System.out.println();
        System.out.println("Exiba todos os carros na ordem que foi informado:");
        Map<String, Double> carrosOrdenados = new LinkedHashMap<>() {{
            put("gol", 14.4);
            put("uno", 13.9);
            put("opala", 10.2);
            put("hb20", 12.3);
            put("kwid", 11.6);
            put("mobi", 10.4);
            put("corsa", 10.4);
        }};
        System.out.println(carrosOrdenados);
        System.out.println();
        System.out.println("Exiba o dicionário ordenado pelo modelo: ");
        Map<String, Double> carrosOrdenadosModelo = new TreeMap<>(carros);
        System.out.println(carrosOrdenadosModelo);
        System.out.println();
        System.out.println("Apague o dicionário de carros: ");
        carros.clear();
        System.out.println();
        System.out.println("Confira se o dicionário está vazio: " + carros.isEmpty());
    }

    public void ordenacaoMap() {
        System.out.println();
        System.out.println("===Ordem aleatoria===\n");
        Map<String, Livro> livros = new HashMap<>();
        inserirInfoMap(livros);
        printInfoMap(livros);
        System.out.println("===Ordem de inserção===\n");
        Map<String, Livro> livros1 = new LinkedHashMap<>();
        inserirInfoMap(livros1);
        printInfoMap(livros1);
        System.out.println("===Ordem alfabética dos autores===\n");
        Map<String, Livro> livros2 = new TreeMap<>(livros);
        printInfoMap(livros2);
        System.out.println("===Ordem alfabética nome dos livros===\n");
        Set<Map.Entry<String, Livro>> livros3 = new TreeSet<>(new ComparatorNome());
        livros3.addAll(livros.entrySet());
        printInfoSet(livros3);
        System.out.println("===Ordem de acordo com a quantidade de páginas===\n");
        Set<Map.Entry<String, Livro>> livros4 = new TreeSet<>(new ComparatorPaginas());
        livros4.addAll(livros.entrySet());
        printInfoSet(livros4);

    }

    private void printInfoSet(Set<Map.Entry<String, Livro>> s) {
        for (Map.Entry<String, Livro> liv : s) {
            System.out.println("Autor : " + liv.getKey());
            System.out.println("Título do livro : " + liv.getValue().getNome());
            System.out.println("Quantidade de páginas : " + liv.getValue().getPaginas());
            System.out.println();
        }
    }

    private void printInfoMap(Map<String, Livro> totalLivros) {
        for (Map.Entry<String, Livro> l : totalLivros.entrySet()) {
            System.out.println("Autor : " + l.getKey());
            System.out.println("Título do livro : " + l.getValue().getNome());
            System.out.println("Quantidade de páginas : " + l.getValue().getPaginas());
            System.out.println();
        }
    }

    private void inserirInfoMap(Map<String, Livro> l) {
        l.put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 298));
        l.put("Duhigg, Charles", new Livro("O Poder do Hábito", 135));
        l.put("Hanari, Yuval Noah", new Livro("21 Lições para o Século 21", 405));
        l.put("Oda, Eiichiro", new Livro("One Piece", 1041));
        l.put("Miura, Kentaro", new Livro("Berserk", 381));
    }
}


class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(nome, livro.nome) && Objects.equals(paginas, livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorPaginas implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return Integer.compare(l1.getValue().getPaginas(), l2.getValue().getPaginas());
    }
}
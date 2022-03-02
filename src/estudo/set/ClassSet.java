package estudo.set;

import java.util.*;

public class ClassSet {

    public void estudoMetodosSet() {
        //algumas formas de iniciar o Set
        //HashSet<Double> notas = new HashSet<>();
        //Set<Double> notas1 = new HashSet<>();
        //Set<Double> notas = Set.of(7d, 12.3, 3.5, 7d, 5d);
        //notas.add(1d);

        System.out.println("Crie um Set e adicione:");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 12.3, 3.5, 7d, 5d));
        System.out.println(notas);
        System.out.println();
        System.out.println("Confira se a nota 5.0 está no conjunto");
        System.out.println("Nota 5 está contida? : " + notas.contains(5d));
        System.out.println();
        System.out.println("Exiba a menor nota do conjunto: " + Collections.min(notas));
        System.out.println();
        System.out.println("Exiba a maior nota do conjunto: " + Collections.max(notas));
        System.out.println();
        System.out.println("Informe a soma dos valores:");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0, next, next1;
        while (iterator.hasNext() == true) {
            next = iterator.next();
            soma += next;
        }
        System.out.println("Soma= " + soma);
        System.out.println();
        System.out.println("Exiba a media das notas= " + soma / notas.size());
        System.out.println();
        System.out.println("remova a nota 7: ");
        notas.remove(7d);
        System.out.println(notas);
        System.out.println();
        System.out.println("Remova as notas menores que 7: ");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext() == true) {
            next1 = iterator1.next();
            if (next1 < 7) {
                iterator1.remove();
            }
        }
        System.out.println(notas);
        System.out.println();
        System.out.println("Exiba as notas na ordem que foi informada");
        //para fazer isso basta utilizar o LinkedHashSet<>;
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(12.3);
        notas2.add(3.5);
        notas2.add(7d);
        notas2.add(5d);
        System.out.println(notas2);
        System.out.println();
        System.out.println("Exiba todas as notas na ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);
        System.out.println();
        System.out.println("Apague todo o conjunto: ");
        notas.clear();
        System.out.println(notas);
        System.out.println();
        System.out.println("Confira se o conjuto está vazio: " + notas.isEmpty());
        System.out.println();
        System.out.println("Confira se o conjunto 3 está vazio: " + notas3.isEmpty());
    }

    public void ordenacaoSet() {
        System.out.println("Ordem aleatoria:");
        Set<Serie> minhasSeries = new HashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("breaking bad", "drama", 60));
            add(new Serie("the office", "comedia", 24));
            add(new Serie("arrow", "ação", 40));
        }};
        for (Serie s : minhasSeries) {
            System.out.println(s.getNome() + '-' + s.getGenero() + '-' + s.getDuracao());
        }
        System.out.println();
        System.out.println("ordem de inserção: ");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("breaking bad", "drama", 60));
            add(new Serie("the office", "comedia", 24));
        }};
        for (Serie s : minhasSeries1) {
            System.out.println(s.getNome() + '-' + s.getGenero() + '-' + s.getDuracao());
        }
        System.out.println();
        System.out.println("Ordem natural (Tempo do episodio)");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        System.out.println(minhasSeries2);
        System.out.println();

        System.out.println("Ordem Nome/Genero/Tempo de episodio");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEp());
        minhasSeries3.addAll(minhasSeries);
        for (Serie s:minhasSeries3) {
            System.out.println(s.getNome() + '-' + s.getGenero() + '-' + s.getDuracao());
        }
    }
}

class Serie implements Comparable<Serie> {
    private String nome;
    private String genero;
    private Integer duracao;

    public Serie(String nome, String genero, Integer duracao) {
        this.nome = nome;
        this.genero = genero;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", desc='" + genero + '\'' +
                ", duracao=" + duracao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(nome, serie.nome) && Objects.equals(genero, serie.genero) && Objects.equals(duracao, serie.duracao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, duracao);
    }

    @Override
    public int compareTo(Serie s) {
        int tempoEp = Integer.compare(this.getDuracao(), s.getDuracao());

        if (tempoEp != 0) {
            return tempoEp;
        } else {
            return this.getGenero().compareTo(s.getGenero());
        }
    }
}

/* Essa classe serve para comparar o nome genero e tempo de duração
   primeiro compara os nomes, caso forem iguais compara os generos,
   caso forem iguais, compara o tempo. Se tudo for igual, é o mesmo
   objeto, portanto, não entra pra TreeSet<>. Isso permite usar
   TreeSet<> sem se preocupar com ela não inserir um elemento só por
   causa de um atributo igual. Além de comparar, o compareTo retorna
   valores negativos caso o objeto que invoca a função é menor(se na
   ordem alfabética ele vem primeiro) que o argumento, portanto é
   exibido em ordem alfabética.
 */
class ComparatorNomeGeneroTempoEp implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;
        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;
        return Integer.compare(s1.getDuracao(), s2.getDuracao());
    }
}
package exercicio;

import java.util.*;

public class ExercicioMap {
    public void executarExercicio() {
        System.out.println("Crie e adicione ao dicionário a relação entre estado e população: ");
        Map<String, Integer> estados = new HashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        printInfoMap(estados);
        System.out.println();
        System.out.println("Susbstitua a população de RN por 3,534,165: ");
        estados.replace("RN", 3534165);
        printInfoMap(estados);
        System.out.println();
        System.out.println("Confira se o estado de PB está presente, caso nao esteja insira-o com 4,039,277 de população:");
        if (estados.containsKey("PB") == false) {
            estados.put("PB", 4039277);
        }
        printInfoMap(estados);
        System.out.println();
        System.out.println("Exiba a população de PE: ");
        System.out.println(estados.get("PE"));
        System.out.println();
        System.out.println("Exiba todos os estados e suas populaçoes em que ordem foi informada: ");
        Map<String, Integer> estadosOrdemInsercao = new LinkedHashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534165);
            put("PB", 4039277);
        }};
        printInfoMap(estadosOrdemInsercao);
        System.out.println();
        System.out.println("Exiba os estados e suas populaçoes em ordem alfabética: ");
        Map<String, Integer> estadosOrdemAlfabetica = new TreeMap<>();
        estadosOrdemAlfabetica.putAll(estados);
        printInfoMap(estadosOrdemAlfabetica);
        System.out.println();
        System.out.println("Exiba o estado com a menor população e sua quantidade: ");
        Integer menorPopulacao = Collections.min(estados.values());
        Set<Map.Entry<String, Integer>> entries = estados.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue().equals(menorPopulacao)) {
                System.out.println("Estado: " + entry.getKey());
                System.out.println("População: " + entry.getValue());
            }
        }
        System.out.println();
        System.out.println("Exiba o estado com a maior população e sua quantidade: ");
        Integer maiorPopulacao = Collections.max(estados.values());
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue().equals(maiorPopulacao)) {
                System.out.println("Estado: " + entry.getKey());
                System.out.println("População: " + entry.getValue());
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Exiba a soma das populações desses estados: ");
        Integer somaPopulacoes = 0, next;
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            next = iterator.next().getValue();
            somaPopulacoes += next;
        }
        System.out.println("Soma das populações: "+somaPopulacoes);
        System.out.println();
        System.out.println("Exiba a media da população desse dicionário: ");
        System.out.println("Média das populações: "+(double)somaPopulacoes/estados.size());
        System.out.println();
        System.out.println("Remova os estados com a população menor que 4 Milhões de habitantes: ");
        Iterator<Map.Entry<String, Integer>> iterator1 = entries.iterator();
        while(iterator1.hasNext()){
            next = iterator1.next().getValue();
            if(next.compareTo(4000000) < 0){
                iterator1.remove();
            }
        }
        printInfoMap(estados);
        System.out.println();
        System.out.println("Apague o dicionário de estados");
        estados.clear();
        printInfoMap(estados);
        System.out.println();
        System.out.println("Verifique se o dicionário está vazio: ");
        System.out.println("Está vazio? " + estados.isEmpty());
    }

    private void printInfoMap(Map<String, Integer> todosEstados) {
        for (Map.Entry<String, Integer> te : todosEstados.entrySet()) {
            System.out.println("Estado: " + te.getKey());
            System.out.println("População: " + te.getValue());
            System.out.println();
        }
    }
}

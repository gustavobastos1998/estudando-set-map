package estudo;

import estudo.map.ClassMap;
import estudo.set.ClassSet;
import exercicio.ExercicioMap;


public class Main {
    public static void main(String[] args) {
        ClassSet cs = new ClassSet();
        cs.estudoMetodosSet();
        cs.ordenacaoSet();
        ClassMap cm = new ClassMap();
        cm.estudoMetodosMap();
        cm.ordenacaoMap();
        ExercicioMap em = new ExercicioMap();
        em.executarExercicio();
    }
}

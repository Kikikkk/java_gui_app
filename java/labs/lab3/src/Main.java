package labs.lab3.src;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public Main(String[] args) {
    }

    public static void main(String[] args) {
        List<Mammal> mammals = new ArrayList<>();
        mammals.add(new Hedgehog());
        mammals.add(new Hedgehog());
        mammals.add(new Manul());
        mammals.add(new Lynx());

        List<Hedgehog> hedgehogs = new ArrayList<>();
        List<Manul> manuls = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<Chordate> chordates = new ArrayList<>();
        List<Insectivore> insectivores = new ArrayList<>();
        List<Carnivore> carnivores = new ArrayList<>();

        segregate(mammals, hedgehogs, cats, carnivores);
        System.out.println("Hedgehogs: " + hedgehogs);
        System.out.println("Сats: " + cats);
        System.out.println("Сarnivores: " + carnivores);
        System.out.println("___________________________");

        carnivores.add(new Manul());
        chordates.clear();
        manuls.clear();
        cats.clear();
        segregate(carnivores, chordates, manuls, cats);
        System.out.println("Chordates: " + chordates);
        System.out.println("Manuls: " + manuls);
        System.out.println("Cats: " + cats);
        System.out.println("___________________________");

        carnivores.clear();
        segregate(hedgehogs, insectivores, carnivores, carnivores);
        System.out.println("Insectivores: " + insectivores);
        System.out.println("Carnivores: " + carnivores);
        System.out.println("___________________________");
    }

    public static void segregate(Collection<? extends Chordate> srcCollection, Collection<? super Hedgehog> collection1,
                                 Collection<? super Manul> collection2, Collection<? super Lynx> collection3) {
        for (Chordate animal : srcCollection) {
            if (animal instanceof Hedgehog) {
                collection1.add((Hedgehog) animal);
            } else if (animal instanceof Manul) {
                collection2.add((Manul) animal);
            } else if (animal instanceof Lynx) {
                collection3.add((Lynx) animal);
            }
        }
    }
}

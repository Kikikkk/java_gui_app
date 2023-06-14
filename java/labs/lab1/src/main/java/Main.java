package labs.lab1.src.main.java;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение от 1 до 6, чтобы выбрать метод передвижения главного героя. Чтобы завершить программу введите esc");
        Hero hero = new Hero(new WalkStrategy());

        String input;
        while(!(input = scanner.next()).equals("esc")) {
            switch (input) {
                case "1":
                    hero.setMoveStrategy(new WalkStrategy());
                    hero.move();
                    break;
                case "2":
                    hero.setMoveStrategy(new RunStrategy());
                    hero.move();
                    break;
                case "3":
                    hero.setMoveStrategy(new HorseStrategy());
                    hero.move();
                    break;
                case "4":
                    hero.setMoveStrategy(new PortalStrategy());
                    hero.move();
                    break;
                default:
                    System.out.println("Неверная команда");
            }
        }
        System.out.println("Выход из программы");
        scanner.close();
    }
}

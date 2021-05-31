import AwardedEntities.Animal;
import AwardedEntities.Person;
import AwardedEntities.Owner;
import Awards.Wearing;
import Badges.Emblem;
import Graphics.MainFrame;

public class Main {
    public static void main(String[] args) {
        Emblem emblem=new Emblem("asd",35,Wearing.CENTER,"sd","ds");
        Person person=new Person(emblem);

        Animal animal = new Animal(emblem);
        Owner owner=new Owner(animal);
        System.out.println(owner.askAboutAnimalsThank());
        System.out.println(person.askAboutThank());
        new MainFrame();
    }
}

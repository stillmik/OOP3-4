package AwardedEntities;

public class Owner {

    private Animal animal;
    public Owner(Animal animal){
        this.animal=animal;
    }

    public String askAboutAnimalsThank(){
        return animal.getThank().getThankedFor();
    }


}

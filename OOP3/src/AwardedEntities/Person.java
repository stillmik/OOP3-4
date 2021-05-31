package AwardedEntities;

import Badges.Medal;
import Thanks.Thank;

public class Person extends AwardedEntity {

    public Person(Thank thank) {
        setThank(thank);
    }

    public String askAboutThank(){
        return getThank().getThankedFor();
    }
}

import config.Config;
import interfaces.Politician;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Politician trump = (Politician) context.getBean("Trump");
        Politician biden = (Politician) context.getBean("Biden");
        Politician merkel = (Politician) context.getBean("Merkel");

        trump.doPolitic();
        biden.doPolitic();
        merkel.doPolitic();
    }
}

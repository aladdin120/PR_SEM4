package config;

import entities.Biden;
import entities.Merkel;
import entities.Trump;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean("Trump")
    public Trump trump() {
        return new Trump();
    }

    @Bean("Biden")
    public Biden biden() {
        return new Biden();
    }

    @Bean("Merkel")
    public Merkel merkel() {
        return new Merkel();
    }
}

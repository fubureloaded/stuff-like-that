package pokemonpattern.example.components;

import org.springframework.stereotype.Component;

@Component
public class Component1 {

    public String doSomeStuff(String param) {
        //something bad happen
        //throw new NullPointerException();
        return param.toUpperCase();
    }
}

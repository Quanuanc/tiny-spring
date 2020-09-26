package org.example.tinyioc;

public class HelloService {

    private String text;

    public void hello() {
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }
}

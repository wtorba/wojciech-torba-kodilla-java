package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String poem, PoemDecorator poemDecorator) {
        String prettyPoem = poemDecorator.decorate(poem);
        System.out.println(prettyPoem);
    }
}

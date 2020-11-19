package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
//import com.kodilla.stream.lambda.Executor;
//import com.kodilla.stream.lambda.ExpressionExecutor;
//import com.kodilla.stream.lambda.Processor;
//import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {

    public static void main(String[] args) {

        String poem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
        String betterPoem;
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify(poem, a -> "ABC "+a+" XYZ");
        poemBeautifier.beautify(poem, a -> a.toUpperCase());
        poemBeautifier.beautify(poem, a -> {return new StringBuffer(a).reverse().toString();});
        poemBeautifier.beautify(poem, a -> {
            StringBuffer sbA = new StringBuffer();
            char[] aArray = a.toCharArray();
            for (int i = 0; i < a.length(); i++) {
                sbA.append(aArray[i]).append(" ");
            }
            return sbA.toString();
        });

        //1 ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        //2 Processor processor = new Processor();
        //1 processor.execute(executeSaySomething);
        //2 Executor codeToExecute = () -> System.out.println("This is an example text.");
        //2 processor.execute(codeToExecute);
        //2 processor.execute(() -> System.out.println("This is an example text."));

        //3 ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        //3 expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        //3 expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        //3 expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        //3 expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        //3 System.out.println("Calculating expressions with method references");
        //3 expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        //3 expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        //3 expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        //3 expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
    }
}

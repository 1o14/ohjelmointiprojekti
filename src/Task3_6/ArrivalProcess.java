package Task3_6;

import eduni.distributions.Poisson;

public class ArrivalProcess {
    private Poisson poissonGenerator; // Poisson-jakauman olio
    private double lambda;  // Poisson-jakauman keskiarvo

    // Konstruktorissa määritellään lambda (Poisson jakauman keskiarvo)
    public ArrivalProcess(double lambda) {
        this.lambda = lambda;
        this.poissonGenerator = new Poisson(lambda);  // Luodaan Poisson-jakauma, jossa on "lambda"
    }

    // Metodi, joka luo Poisson-jakauman mukaisia saapumisia
    public int createArrivalEvent() {
        // Käytetään Poisson-jakaumaa saapumistapahtuman luomiseen
        return (int) poissonGenerator.sample();  // Poisson-luokka generoi saapumisen
    }

    public static void main(String[] args) {
        ArrivalProcess arrivalProcess = new ArrivalProcess(3.0);  // lambda = 3, joka on Poisson-jakauman keskiarvo

        // Luodaan 10 saapumistapahtumaa ja tulostetaan ne
        for (int i = 0; i < 10; i++) {
            int event = arrivalProcess.createArrivalEvent();  // Luodaan uusi saapumistapahtuma
            System.out.println("Arrival event: " + event);  // Tulostetaan saapumistapahtuma
        }
    }
}

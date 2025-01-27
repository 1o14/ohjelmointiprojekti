package eduni.distributions;

public class Poisson {
    private double mean;  // Poisson-jakauman keskiarvo

    // Konstruktori, joka ottaa keskiarvon ja tarkistaa, että se on positiivinen
    public Poisson(double mean) {
        if (mean <= 0) {
            throw new IllegalArgumentException("Poisson: The mean must be greater than 0.");  // Heittää virheen, jos keskiarvo on 0 tai negatiivinen
        }
        this.mean = mean;
    }

    // Metodi, joka generoi satunnaisen arvon Poisson-jakaumasta
    public long sample() {
        double L = Math.exp(-mean);  // L on e:n potenssiin -mean (Poissonin jakauman laskentakaava)
        double p = 1.0;  // P-arvo, joka luo satunnaisuutta
        long k = 0;  // Tapahtumien laskuri

        // Poisson-jakauman generaattori: toistetaan niin kauan, kun p > L
        do {
            k++;  // Lisää tapahtumien määrää
            p *= Math.random();  // Kerrotaan p:llä satunnaisluvulla
        } while (p > L);  // Toistetaan niin kauan, kun p on suurempi kuin L

        return k - 1;  // Palautetaan k-1, koska aloitimme laskemisen yhdellä
    }
}

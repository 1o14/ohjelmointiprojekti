package Task3_2;

public class AgeDistribution {
    public static void main(String[] args) {
        int totalAges = 1000; // Kuinka monta ikää generoidaan
        int[] ageCounts = new int[4]; // Ikäryhmät: 20, 21, 22, 23

        // Ikäjakauma satunnaislukuvälien perusteella
        for (int i = 0; i < totalAges; i++) {
            int random = (int) (Math.random() * 100) + 1; // Satunnainen luku 1–100
            if (random <= 30) {
                ageCounts[0]++; // 30 % -> Ikä 20
            } else if (random <= 70) {
                ageCounts[1]++; // 40 % -> Ikä 21
            } else if (random <= 90) {
                ageCounts[2]++; // 20 % -> Ikä 22
            } else {
                ageCounts[3]++; // 10 % -> Ikä 23
            }
        }

        System.out.println("Age  Count");
        System.out.println("20   " + ageCounts[0]);
        System.out.println("21   " + ageCounts[1]);
        System.out.println("22   " + ageCounts[2]);
        System.out.println("23   " + ageCounts[3]);
    }
}

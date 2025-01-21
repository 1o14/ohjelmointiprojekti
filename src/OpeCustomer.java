

public class OpeCustomer {
    private int id;
    private long startTime;
    private long endTime;
    private static int iDcount = 1;

    public OpeCustomer() {
        id = iDcount++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) { //varmistetaan että id on suurempi kuin 0
            this.id = id;
        } else {
            System.out.println("Id:n pitää olla suurempi kuin 0");
        }
    }
        //Samaan tyyliin loput getterit ja setterit
        public long calculatTime () {
            return endTime - startTime;
        }
        public void setStartTime(long start) {
        startTime = start;
        }
        public void setEndTime(long end) {
        endTime = end;
        }
        public long calculateTime(long start, long end) {
        return endTime - startTime;
        }
        public static void main(String[] args) {
            OpeCustomer customer = new OpeCustomer();
            customer.setStartTime(123);
            customer.setEndTime(654);
            System.out.println("Asiakkaalla meni " + customer.calculatTime() + " aikaa palvelussa.");
        }
    }



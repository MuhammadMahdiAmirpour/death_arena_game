package ir.ac.kntu.logic;

public enum Caliber {
    SEVEN(7),
    FIVE(5);

    private final int caliber;
    Caliber(int caliber) {
        this.caliber = caliber;
    }

    @Override
    public String toString() {
        return "Caliber{" +
                "caliber=" + caliber +
                '}';
    }

    public int getAccuracyChanges() {
        switch (caliber) {
            case 5:
                return -10;
            case 7:
                return 15;
            default:
                return 0;
        }
    }

    public int getDamageChanges() {
        if (caliber == 7){
            return 10;
        }
        return 0;
    }
}

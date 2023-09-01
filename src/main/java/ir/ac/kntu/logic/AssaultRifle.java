package ir.ac.kntu.logic;

public class AssaultRifle extends Gun {
    public AssaultRifle(Caliber caliber) {
        super(caliber);
        setGun(caliber.getAccuracyChanges() + 50, caliber.getDamageChanges() + 10, "AR");
    }
}

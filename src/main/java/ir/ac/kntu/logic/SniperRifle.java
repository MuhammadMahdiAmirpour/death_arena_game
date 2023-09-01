package ir.ac.kntu.logic;

import ir.ac.kntu.util.RandomHelper;

public class SniperRifle extends Gun {

    public SniperRifle(Caliber caliber, boolean scope) {
        super(caliber);
        String name = "SR";
        if (scope) {
            name += "-Scope";
        }
        int rand = 0;
        if (scope) {
            rand = RandomHelper.nextInt(15);
            if (rand < 5) {
                rand = 15 - rand;
            }
        }
        setGun(rand + caliber.getAccuracyChanges() + 60, caliber.getDamageChanges() + 20, name);
    }

}
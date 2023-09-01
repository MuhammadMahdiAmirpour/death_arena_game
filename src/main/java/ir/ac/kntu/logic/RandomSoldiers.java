package ir.ac.kntu.logic;

import ir.ac.kntu.util.RandomHelper;

import java.util.ArrayList;

public final class RandomSoldiers {

    public static Soldier newRandomSoldier() {
        int rand = RandomHelper.nextInt(3);
        Gun gun = null;
        if (rand == 0) {
            gun = new AssaultRifle(Caliber.FIVE);
        } else if (rand == 1) {
            gun = new AssaultRifle(Caliber.SEVEN);
        } else if (rand == 2) {
            gun = new SniperRifle(Caliber.FIVE, RandomHelper.nextBoolean());
        } else if (rand == 3) {
            gun = new SniperRifle(Caliber.SEVEN, RandomHelper.nextBoolean());
        }

        rand = RandomHelper.nextInt(100);
        if (rand < 10) {
            rand = 100 - rand;
        }
        int health = rand;
        return new Soldier(health, gun.getDamage(), gun);
    }

    public static Soldier getRandomSoldier(ArrayList<Soldier> side) {
        int random = RandomHelper.nextInt(side.size());
        Soldier soldier = side.get(random);
        if (!soldier.isDead()) {
            return soldier;
        } else {
            return getRandomSoldier(side);
        }
    }

    public static ArrayList<Soldier> getRandomSoldiers(int size) {
        ArrayList<Soldier> tempList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            tempList.add(newRandomSoldier());
        }
        for (int i = 0; i < size; i++) {
            tempList.get(i).setId(i + 1);
        }
        return new ArrayList<>(tempList);
    }
}
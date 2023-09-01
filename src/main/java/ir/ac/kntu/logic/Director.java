package ir.ac.kntu.logic;

import java.util.ArrayList;

import ir.ac.kntu.util.RandomHelper;

public class Director {

    private final ArrayList<Soldier> groupA;
    private final ArrayList<Soldier> groupB;

    private GraphicsEngine graphicsEngine;

    private Soldier currentASoldier;
    private Soldier currentBSoldier;

    private VictoryState victoryState;

    public Director(GraphicsEngine graphicsEngine) {

        this.graphicsEngine = graphicsEngine;
        int size = graphicsEngine.getSizeOfTeam();
        groupA = new ArrayList<>(RandomSoldiers.getRandomSoldiers(size));
        groupB = new ArrayList<>(RandomSoldiers.getRandomSoldiers(size));
        victoryState = VictoryState.NOT_FINISHED;
        graphicsEngine.initialize(groupA, groupB);
    }

    public void startGameLoop() {
        while (isDone() == VictoryState.NOT_FINISHED) {
            currentASoldier = RandomSoldiers.getRandomSoldier(groupA);
            currentBSoldier = RandomSoldiers.getRandomSoldier(groupB);
            boolean firstA = RandomHelper.nextBoolean();
            int accRoll1 = RandomHelper.nextInt(101);
            int accRoll2 = RandomHelper.nextInt(101);
            if (firstA) {
                attack(currentASoldier, currentBSoldier, accRoll1, accRoll2);
                graphicsEngine.visualizeFight(currentASoldier, currentBSoldier, accRoll1, accRoll2, 1,
                        groupA, groupB);
            } else {
                attack(currentBSoldier, currentASoldier, accRoll2, accRoll1);
                graphicsEngine.visualizeFight(currentASoldier, currentBSoldier, accRoll1, accRoll2, 2,
                        groupA, groupB);

            }
            graphicsEngine.visualizeDeath(currentASoldier, currentBSoldier);
        }
        victoryState = isDone();
        graphicsEngine.visualizeVictoryCondition(victoryState);
    }

    public void attack(Soldier soldier1, Soldier soldier2, int accRoll1, int accRoll2) {
        if (soldier1.getGun().getAccuracy() >= accRoll1) {
            soldier2.healthCheck(soldier1.getDamage());
        }
        if (!soldier2.isDead() && soldier2.getGun().getAccuracy() >= accRoll2) {
            soldier1.healthCheck(soldier2.getDamage());
        }
    }


    public enum VictoryState {
        WIN_A, WIN_B, NOT_FINISHED
    }

    public VictoryState isDone() {
        boolean isDoneA = true;
        boolean isDoneB = true;
        for (Soldier soldier : groupA) {
            if (soldier.getHealth() > 0) {
                isDoneA = false;
                break;
            }
        }
        for (Soldier soldier : groupB) {
            if (soldier.getHealth() > 0) {
                isDoneB = false;
                break;
            }
        }
        if (isDoneA && !isDoneB) {
            return VictoryState.WIN_B;
        } else if (!isDoneA && isDoneB) {
            return VictoryState.WIN_A;
        } else {
            return VictoryState.NOT_FINISHED;
        }
    }

}
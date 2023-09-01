package ir.ac.kntu.logic;

import java.util.ArrayList;

public interface GraphicsEngine {


    public void initialize(ArrayList<Soldier> groupA, ArrayList<Soldier> groupB);

    void visualizeFight(Soldier currentASoldier, Soldier currentBSoldier,
                        int acc1, int acc2, int first,
                        ArrayList<Soldier> teamA, ArrayList<Soldier> teamB);

    public void visualizeDeath(Soldier a, Soldier b);

    public void visualizeVictoryCondition(Director.VictoryState victoryState);

    int getSizeOfTeam();
}

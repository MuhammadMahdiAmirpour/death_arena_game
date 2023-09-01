package ir.ac.kntu.logic;

public class Soldier {
    private int health;
    private final int damage;
    private final Gun gun;
    private int id;

    public Soldier(int health, int damage, Gun gun) {
        this.health = health;
        this.damage = damage;
        this.gun = gun;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }

    public Gun getGun() {
        return gun;
    }

    public int getId() {
        return this.id;
    }

    public void healthCheck(int injury) {
        health -= injury;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean isDead() {
        return health == 0;
    }
    @Override
    public String toString() {
        return "[ID@" + id +
                " |Health@" + Integer.toString(health).concat("  ").substring(0, 3) +
                " " + gun.toString() + " ]";
    }
}
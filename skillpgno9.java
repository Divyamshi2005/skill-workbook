// Singleton pattern for managing game state
class GameManager {
    private static GameManager instance;

    private int score;

    private GameManager() {
        score = 0;
    }

    public static synchronized GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void increaseScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }
}

// Factory Method pattern for creating different types of enemies
abstract class Enemy {
    protected String name;
    protected int health;

    public abstract void attack();

    public String getName() {
        return name;
    }
}

class Zombie extends Enemy {
    public Zombie() {
        name = "Zombie";
        health = 100;
    }

    @Override
    public void attack() {
        System.out.println("Zombie attacks with its claws!");
    }
}

class Robot extends Enemy {
    public Robot() {
        name = "Robot";
        health = 150;
    }

    @Override
    public void attack() {
        System.out.println("Robot fires its laser beams!");
    }
}

// Abstract Factory pattern for creating different types of weapons and power-ups
interface GameItemFactory {
    Weapon createWeapon();
    PowerUp createPowerUp();
}

class EasyGameItemFactory implements GameItemFactory {
    @Override
    public Weapon createWeapon() {
        return new Dagger();
    }

    @Override
    public PowerUp createPowerUp() {
        return new HealthPotion();
    }
}

class HardGameItemFactory implements GameItemFactory {
    @Override
    public Weapon createWeapon() {
        return new Sword();
    }

    @Override
    public PowerUp createPowerUp() {
        return new Shield();
    }
}

// Weapon hierarchy
abstract class Weapon {
    protected String name;

    public String getName() {
        return name;
    }

    public abstract void use();
}

class Dagger extends Weapon {
    public Dagger() {
        name = "Dagger";
    }

    @Override
    public void use() {
        System.out.println("Using dagger to attack!");
    }
}

class Sword extends Weapon {
    public Sword() {
        name = "Sword";
    }

    @Override
    public void use() {
        System.out.println("Swinging sword to attack!");
    }
}

// Power-up hierarchy
abstract class PowerUp {
    protected String name;

    public String getName() {
        return name;
    }

    public abstract void apply();
}

class HealthPotion extends PowerUp {
    public HealthPotion() {
        name = "Health Potion";
    }

    @Override
    public void apply() {
        System.out.println("Using health potion to restore health!");
    }
}

class Shield extends PowerUp {
    public Shield() {
        name = "Shield";
    }

    @Override
    public void apply() {
        System.out.println("Equipping shield for protection!");
    }
}

public class skillpgno9 {
    public static void main(String[] args) {
        GameManager gameManager = GameManager.getInstance();

        // Simulate a game level with different settings
        GameItemFactory gameItemFactory = new HardGameItemFactory();

        Enemy enemy = new Robot();
        Weapon weapon = gameItemFactory.createWeapon();
        PowerUp powerUp = gameItemFactory.createPowerUp();

        System.out.println("Level 1");
        System.out.println("Enemy: " + enemy.getName());
        System.out.println("Weapon: " + weapon.getName());
        System.out.println("Power-up: " + powerUp.getName());

        enemy.attack();
        weapon.use();
        powerUp.apply();

        gameManager.increaseScore(100);
        System.out.println("Score: " + gameManager.getScore());
    }
}
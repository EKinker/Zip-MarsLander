import org.junit.Assert;
import org.junit.Test;

public class SimulationTest {

    @Test
    public void runSimulationLanding() {
        int[] burns = {200, 200, 200, 200, 200, 200, 200, 200, 200,
                100, 100, 100, 100,
                150, 125, 120, 100, 100, 100, 103,
                100, 100, 100, 100};
        BurnStream burnSource = new BurnDataStream(burns);
        Simulation game = new Simulation(new Vehicle(5000));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(okay, Vehicle.SUCCESS);
    }

    @Test
    public void runSimulationCrash() {
        int[] burns = {0,0,0,0,0};
        BurnStream burnSource = new BurnDataStream(burns);
        Simulation game = new Simulation(new Vehicle(5000));
        int okay = game.runSimulation(burnSource);
        //Sorry test.  If you drop your ship from orbit and never burn, you're going to make a crater on the surface of Mars.  No one is walking away with a bruised sternum.
        //Mars may be a 1/3G, but the atmosphere is thinner, so it would fall 5 times faster.
        Assert.assertEquals(Vehicle.DEAD, okay);  //changed from "CRASHED" to "DEAD".
    }

    @Test
    public void runSimulationComputer() {
        BurnStream burnSource = new OnBoardComputer();
        Simulation game = new Simulation(new Vehicle(10000));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(okay, Vehicle.SUCCESS);
    }

    @Test
    public void runSimulationComputerRandom() {
        BurnStream burnSource = new OnBoardComputer();
        Simulation game = new Simulation(new Vehicle(Simulation.randomAltitude()));
        //Simulation game = new Simulation(new Vehicle(15000));
        int okay = game.runSimulation(burnSource);
        Assert.assertEquals(okay, Vehicle.SUCCESS);
    }

}
package Simulation.model.simulation;

import java.util.List;

import Simulation.model.Coord;

public class Launcher {

	public static void main(String[] args) {
			Simulation sim = new Simulation(10, 10, 1,0);
			//System.out.println(sim.up());
			
			sim.down();
			sim.right();
			sim.down();
			sim.right();
			sim.down();
			sim.right();
			sim.down();
			sim.right();
			sim.down();
			sim.right();
			sim.down();
			sim.right();
			sim.down();
			sim.right();
			sim.down();
			sim.right();
			sim.down();
			sim.right();
			sim.down();
			sim.right();
			sim.affEnvironnement();

			AutoNav autoNav = new AutoNav(sim);
			List<Coord> listMove = autoNav.dumpNav();
			System.out.println(listMove);
			sim.affEnvironnement();
			sim.affView();
			sim.affRobotDiscoveredMap();
			System.out.println(sim.getDistanceTraveled());
			System.out.println(sim.getNbCmd());
			System.out.println(sim.getNbSeeingObst());
			System.out.println(sim.getNbMetObst());

	}

}

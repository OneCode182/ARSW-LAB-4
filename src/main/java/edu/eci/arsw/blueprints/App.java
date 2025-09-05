package edu.eci.arsw.blueprints;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bps = ac.getBean(BlueprintsServices.class);
        Blueprint bp1 = new Blueprint("alice", "house",
                new Point[]{new Point(0, 0), new Point(10, 10)});
        Blueprint bp2 = new Blueprint("alice", "car",
                new Point[]{new Point(20, 20), new Point(30, 30)});
        Blueprint bp3 = new Blueprint("bob", "tree",
                new Point[]{new Point(5, 5), new Point(15, 15)});

        bps.addNewBlueprint(bp1);
        bps.addNewBlueprint(bp2);
        bps.addNewBlueprint(bp3);

        System.out.println("Planos de Alice:");
        Set<Blueprint> aliceBps = bps.getBlueprintsByAuthor("alice");
        aliceBps.forEach(System.out::println);

        System.out.println("\nPlano específico (bob, tree):");
        System.out.println(bps.getBlueprint("bob", "tree"));

        System.out.println("\nTodos los planos:");
        bps.getAllBlueprints().forEach(System.out::println);
    }
}

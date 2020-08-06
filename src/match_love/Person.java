package match_love;

/**
 *
 * @author Larios
 */
public class Person {
    public String name;
    public double points;
    
    public Person(String name, double points) {
        this.name = name;
        this.points = points;
    }
    
    public String getFormatNamePoint() {
        return name + " -> " + points + "% de compatibilidad";
    }
    
    @Override
    public String toString() {
        return "Nombre: "+name+"\nCantidad de puntos: "+points;
    }
}

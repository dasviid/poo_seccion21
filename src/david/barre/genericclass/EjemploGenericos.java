package david.barre.genericclass;

import java.util.Objects;

public class EjemploGenericos {
    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.addObjetos(new Animal("Carrera", "Caballo"));
        transporteCaballos.addObjetos(new Animal("Grillo", "Caballo"));
        transporteCaballos.addObjetos(new Animal("Tunquen", "Caballo"));
        transporteCaballos.addObjetos(new Animal("Topocalma", "Caballo"));
        transporteCaballos.addObjetos(new Animal("Facundo", "Caballo"));
        imprimirCamion(transporteCaballos);
        System.out.println("=========");

        Camion<Maquinaria> tranMaquinas = new Camion<>(3);
        tranMaquinas.addObjetos(new Maquinaria("Bulldozer"));
        tranMaquinas.addObjetos(new Maquinaria("Grua Horquilla"));
        tranMaquinas.addObjetos(new Maquinaria("Perforadora"));
        imprimirCamion(tranMaquinas);


        System.out.println("=========");
        Camion<Automovil> tranAutos = new Camion<>(3);
        tranAutos.addObjetos(new Automovil("Toyota"));
        tranAutos.addObjetos(new Automovil("Chevrolet"));
        tranAutos.addObjetos(new Automovil("Ford"));
        imprimirCamion(tranAutos);

    }

    public static <T> void imprimirCamion(Camion<T> camion) {
        for (T a : camion) {
            if (a instanceof Animal) {
                System.out.println(((Animal) a).getNombre() + " del tipo " + ((Animal) a).getTipo());
            }
            if (a instanceof Automovil) {
                System.out.println(((Automovil) a).getMarca());
            }
            if (a instanceof Maquinaria) {
                System.out.println(((Maquinaria) a).getTipo());
            }
        }
    }
}

package errorEx;

public class ErrorSimulation {

    public static void simulateError(){
        causeError();
    }

    public static void causeError(){
        //Esto también es una excepción personalizada, modifacar el mensaje
        throw new RuntimeException("Se ha producido un error crítico");
    }
}

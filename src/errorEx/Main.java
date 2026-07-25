package errorEx;

public class Main {
    public static void main(String[] args) {
        try{
        ErrorSimulation.simulateError();
        }catch(RuntimeException e){
            System.out.println("Mensaje del error: " + e.getMessage());
            System.out.println("Detalles: ");
            e.printStackTrace();

            }
        }
    }


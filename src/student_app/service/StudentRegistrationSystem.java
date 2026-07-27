package student_app.service;

import student_app.exception.DuplicateStudentException;
import student_app.exception.StudentNotFoundException;
import student_app.model.Student;

import java.util.*;

public class StudentRegistrationSystem {

    private final Map<String,Student> studentMap = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);


    public void showMenu(){
        System.out.println("===== MENÚ =====");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Eliminar estudiante");
        System.out.println("3. Mostrar todos los estudiantes");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");

    }

    public int selectOption(){
        while (!scanner.hasNextInt()) {
            System.out.println("Debe ingresar una opción válida.");
            scanner.next();
        }

        int option = scanner.nextInt();
        scanner.nextLine();

        return option;
    }

    public void registerProcess(){
        System.out.println("Ingrese el nombre del estudiante: ");
        String studentName =  scanner.nextLine();
        System.out.println("Ingrese el Id del estudiante: ");
        String studentId = scanner.next();

        System.out.println("Ingrese la edad del estudiante: ");
        int studentAge = scanner.nextInt();
        scanner.nextLine();

        try{
        validateUniqueStudent(studentId);
        validateStudentRegistration(studentName,studentAge,studentId);
        }catch (IllegalArgumentException | DuplicateStudentException e){
            showError(e);
            return;
        }

        studentMap.put(studentId, new Student(studentName, studentAge, studentId));

        System.out.println("Estudiante registrado con éxito");
    }

    private void showError(Exception e){
        System.out.println("===Error===");
        System.out.println(e.getMessage());
        System.out.println("Volviendo al menú...");
    }

    public void validateUniqueStudent(String studentId) throws DuplicateStudentException{
        if (studentMap.containsKey(studentId)){
            throw new DuplicateStudentException("El estudiante con el Id " + studentId + " ya existe");
        }
    }

    public void validateStudentRegistration(String studentName, int studentAge, String studentId){

        if(studentAge < 17 ||  studentAge > 100){
            throw new IllegalArgumentException("La edad debe estar entre 17 y 100");
        }
        if(studentName.isBlank()){
            throw new IllegalArgumentException("El nombre del estudiante no puede estar vacio");
        }
        if(studentId.length() != 6){
            throw new IllegalArgumentException("El id debe tener 6 caracteres");
        }
        if (!Character.isUpperCase(studentId.charAt(0))) {
            throw new IllegalArgumentException("La primera posición debe ser una letra mayúscula");
        }
        for (int i = 1; i < studentId.length(); i++) {
            if (!Character.isDigit(studentId.charAt(i))) {
                throw new IllegalArgumentException("Los últimos 5 caracteres deben ser números");
            }
        }
        // Con expresiones regulares quedaria asi
        //        if (!studentId.matches("[A-Z]\\d{5}")) {
        //            throw new IllegalArgumentException(
        //                    "El ID debe tener una letra mayúscula seguida de 5 dígitos (ejemplo: A12345)"
        //            );
        //        }

    }

    public void deleteStudent() throws StudentNotFoundException{
        System.out.println("Ingrese el Id del estudiante a eliminar: ");
        String studentId = scanner.next();

        if (!studentMap.containsKey(studentId)){
            throw new StudentNotFoundException("El estudiante con el Id " + studentId + " no fue encontrado");
        }

        studentMap.remove(studentId);
        System.out.println("Estudiante con el Id " + studentId + "fue eliminado correctamente");

    }

    public void listAllStudent(){
        if (studentMap.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        for (Student student : studentMap.values()) {
            System.out.println(student);
        }
    }


    public void executeOption(int option){
        switch (option){
            case 1:
            registerProcess();
                break;
            case 2:
                try{
                     deleteStudent();
                }catch (StudentNotFoundException e){
                    showError(e);
                }
                break;
            case 3:
            listAllStudent();
                break;
            case 4:
                return;
            default:
                System.out.println("Opción inválida.");
        }
    }

    public void executeApp(){
        int option;
        do{
            showMenu();
            option = selectOption();
            executeOption(option);

        }while(option != 4);

    }

}

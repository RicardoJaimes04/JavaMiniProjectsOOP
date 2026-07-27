package student_app.exception;

public class DuplicateStudentException extends Exception{
    public DuplicateStudentException(String message) {
        super(message);
    }
}

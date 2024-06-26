
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;


public class Main {
    private static final Scanner key = new Scanner(System.in);
    private static int opcion;
    private static Amazon amazon;
    public static void main(String[] args) {
        FileCast fileCast = new FileCast();
         amazon= fileCast.getFile("Amazon.dat");
        if(amazon!=null){
            menu(amazon);
        }else{
            amazon=new Amazon();
            menu(amazon);
        }
        key.close();
    }
    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al intentar limpiar la pantalla: " + e.getMessage());
        }
    }
    public static void menu(Amazon amazon){
        do {
            clearScreen();
            System.out.println("==============Main Menu=================");
            System.out.println("1. Catálogo");
            System.out.println("2. Ingresar");
            System.out.println("3. Crear nueva cuenta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = key.nextInt();
            }catch(InputMismatchException ex){
                opcion=0;
                key.next();
            }
            switch (opcion) {
                case 1:
                    showCategory();
                    break;
                case 2:
                    logIn();
                    break;
                case 3:
                    createAccount();
                    break;
                case 4:
                    System.out.println("Chau");
                    break;
                default:
                    System.out.println("Opción inválida, Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private static void logIn() {
    }

    private static void showCategory() {
    }

    public static void createAccount(){
        do {
            System.out.println("Crear nueva cuenta:");
            System.out.println("1. Crear cliente");
            System.out.println("2. Crear empresa");
            System.out.println("0. Cancelar");
            System.out.print("Seleccione el tipo de cuenta que desea crear (1 o 2): ");
            try {
                opcion = key.nextInt();
            } catch (InputMismatchException ex) {
                opcion = 0;
                key.next();
            }
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    newClient();
                    break;
                case 2:
                    newBuisnes();
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }while (opcion!=0);
    }

    private static void newClient() {
        boolean flag=false;
        String name;
        String password;
        Address address;
        String mail;
        long number;
        int dni;
        System.out.println("Ingrese su nombre");
        name= key.nextLine();
        do {
            System.out.println("Ingrese una contraseña");
            password = key.nextLine();
            System.out.println("Verifique la contraseña");
            if (key.nextLine().equals(password)){
                flag=true;
            }else {
                System.out.println("Las contraseñas no coinciden intente devuelta");
                clearScreen();
            }
        }while (!flag);
        address = newAddress();
        do {
            System.out.println("Ingrese un mail:");
            mail= key.nextLine();
            if(!Account.emailValidation(mail)){
                System.out.println("Formato incorrecto");
            } else if (amazon.mailExist(mail)) {
                System.out.println("Este mail ya esta registrado");
            }else {
                flag=false;
            }
        }while (flag);
        do{
            try {
                System.out.println("Ingrese un numero de telefono :");
                number= key.nextLong();
            } catch (NoSuchElementException ex){

            }

        }while (!flag);


        User client = new User();

    }

    private static Address newAddress() {
        boolean flag=false;
        ECountry country = null;
        int postalCode = 0;
        String street;
        do {
            System.out.println("Seleccione el pais:");
            for (ECountry e : ECountry.values()) {
                System.out.println((e.ordinal()+1)+". "+e.name());
            }
            try {
                opcion= key.nextInt()-1;
                for(ECountry e : ECountry.values()){
                    if(opcion==e.ordinal()){
                        country=e;
                    }
                }
                flag=true;
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                key.next();
            }catch (NullPointerException ex) {
                System.out.println(ex.getMessage());
            }
        } while (!flag);
        do{
            System.out.println("Ingrese su codigo postal:");
            try {
                postalCode= key.nextInt();
                flag=false;
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                key.next();
            }
        } while (flag);
        System.out.println("Ingrese su direccion (ej: pepito 2456):");
        street=key.nextLine();
        return new Address(country,postalCode,street);
    }
}
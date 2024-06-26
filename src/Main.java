
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;


public class Main {
    private static final Scanner key = new Scanner(System.in);
    private static int option;
    private static Amazon amazon;
    private static boolean flag;
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
                option = key.nextInt();
            }catch(NoSuchElementException ex){
                option=0;
                key.next();
            }catch (IllegalStateException e){
                option=0;
            }
            switch (option) {
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
        } while (option != 4);
    }

    private static void logIn() {

    }

    private static void showCategory() {
        EDepartment department;
        do {
            System.out.println("Seleccione una categoria");
            System.out.println("0. Salir");
            for (EDepartment e : EDepartment.values()) {
                System.out.println((e.ordinal()+1)+". "+e.name());
            }
            try {
                option= key.nextInt()-1;
                for(EDepartment e : EDepartment.values()){
                    if(option==e.ordinal()){
                        department=e;
                    }
                }
                showProducts(department);
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                key.next();
            }catch (NullPointerException ex) {
                System.out.println(ex.getMessage());
            }


        }while (option!=-1);
    }

    public static void createAccount(){
        do {
            System.out.println("Crear nueva cuenta:");
            System.out.println("1. Crear cliente");
            System.out.println("2. Crear empresa");
            System.out.println("0. Cancelar");
            System.out.print("Seleccione el tipo de cuenta que desea crear (1 o 2): ");
            try {
                option = key.nextInt();
            } catch (NoSuchElementException ex) {
                option = 3;
                key.next();
            }
            switch (option) {
                case 0:
                    break;
                case 1:
                    newClient();

                    break;
                case 2:
                    newBusiness();
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }while (option<0 || option>2);
    }

    private static Business newBusiness() {
        Business business = new Business(newName(),newPassword(),newAddress(),newMail(),newNumber());
        amazon.addAccount(business);
        return business;
    }

    private static User newClient() {
        User client =new User(newName(),newPassword(),newAddress(),newMail(),newNumber(),newDni());
        amazon.addAccount(client);
        return client;
    }
    private static String newName(){
        String name = "";
        flag =true;
        do {
            try {
                System.out.println("Ingrese su nombre");
                name = key.nextLine();
                flag=false;
            }catch (NoSuchElementException ex){
                key.next();
            }
        }while(flag);
        return name;
    }
    private static String newPassword(){
        String password="";
        flag =true;
        do {
            System.out.println("Ingrese una contraseña");
            try {
                password = key.nextLine();
                System.out.println("Verifique la contraseña");
                if (key.nextLine().equals(password)) {
                    flag = true;
                } else {
                    System.out.println("Las contraseñas no coinciden intente devuelta");
                    clearScreen();
                }
            }catch (NoSuchElementException ex){
                key.next();
            }
        }while (!flag);
        return password;
    }
    private static String newMail(){
        String mail = "";
        flag=true;
        do {
            System.out.println("Ingrese un mail:");
            try {
                mail = key.nextLine();

                if (!Account.emailValidation(mail)) {
                    System.out.println("Formato incorrecto");
                } else if (amazon.mailExist(mail)) {
                    System.out.println("Este mail ya esta registrado");
                } else {
                    flag = false;
                }
            }catch(NoSuchElementException ex){
                key.next();
            }
        }while (flag);
        return mail;
    }
    private static long newNumber(){
       long number = 0;
       flag=false;
        do{
            try {
                System.out.println("Ingrese un numero de telefono :");
                number= key.nextLong();
                flag=true;
            } catch (NoSuchElementException ex){
                key.next();
            }

        }while (!flag);
        return number;
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
                option= key.nextInt()-1;
                for(ECountry e : ECountry.values()){
                    if(option==e.ordinal()){
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
    private static int newDni(){
        int dni = 0;
        flag=false;
        do{
            try {
                System.out.println("Ingrese su Dni :");
                dni= key.nextInt();
                flag=true;
            } catch (NoSuchElementException ex){
                key.next();
            }

        }while (!flag);
        return dni;
    }
}
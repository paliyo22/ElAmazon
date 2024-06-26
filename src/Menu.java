import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private HashMap<String, User> users;
    private HashMap<String, Business> businesses;

    public Menu() {
        this.users = new HashMap<>();
        this.businesses = new HashMap<>();
        User user = new User(12345678, 100.0, 50.0, "password123");
        user.setName("cliente1");
        users.put(user.getName(), user);

        Business business = new Business("empresa1", "password123");
        businesses.put(business.getName(), business);
    }

    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al intentar limpiar la pantalla: " + e.getMessage());
        }
    }


    public void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            clearScreen();
            System.out.println("Main Menu");
            System.out.println("1. Catálogo");
            System.out.println("2. Login");
            System.out.println("3. Crear nueva cuenta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = scanner.nextInt();
            }catch(InputMismatchException ex){
                opcion=0;
            }
            switch (opcion) {
                case 1:
                    mostrarCatalogo(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    crearCuenta(scanner);
                    break;
                case 4:
                    System.out.println("Chau");
                    break;
                default:
                    System.out.println("Opción inválida, Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private void crearCuenta(Scanner scanner) {
        System.out.println("Crear nueva cuenta:");
        System.out.println("1. Crear cliente");
        System.out.println("2. Crear empresa");
        System.out.print("Seleccione el tipo de cuenta que desea crear (1 o 2): ");
        int tipoCuenta = scanner.nextInt();

        scanner.nextLine();

        switch (tipoCuenta) {
            case 1:
                crearCliente(scanner);
                break;
            case 2:
                crearEmpresa(scanner);
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private void crearCliente(Scanner scanner) {
        System.out.println("Creación de nuevo cliente:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("DNI: ");
        int dni = scanner.nextInt();

        System.out.print("Gasto máximo permitido: ");
        double maxExpense = scanner.nextDouble();

        System.out.print("Dinero disponible: ");
        double dinero = scanner.nextDouble();

        scanner.nextLine();

        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        User nuevoCliente = new User(dni, maxExpense, dinero, password);
        nuevoCliente.setName(nombre);

        users.put(nombre, nuevoCliente);

        System.out.println("Nuevo cliente creado exitosamente.");
    }

    private void crearEmpresa(Scanner scanner) {
        System.out.println("Creación de nueva empresa:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        Business nuevaEmpresa = new Business(nombre, password);

        businesses.put(nombre, nuevaEmpresa);

        System.out.println("Nueva empresa creada exitosamente.");
    }


    private void mostrarCatalogo(Scanner scanner) {
        System.out.println("Catálogo de Productos:");
        for (Business business : businesses.values()) {
            for (Product product : business.getProductList()) {
                System.out.println("Producto n: " + product.getId());
                System.out.println(product);
                System.out.println("---------------------------------");
            }
        }
    }

    private void login(Scanner scanner) {
        System.out.print("Ingrese su nombre de usuario: ");
        String username = scanner.next();
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.next();

        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            mostrarClienteMenu(scanner, users.get(username));
        } else if (businesses.containsKey(username) && businesses.get(username).getPassword().equals(password)) {
            mostrarEmpresaMenu(scanner, businesses.get(username));
        } else {
            System.out.println("Usuario o contraseña incorrectos. Regresando al menú principal.");
        }
    }

    private void mostrarClienteMenu(Scanner scanner, User cliente) {
        int opcion;

        do {
            System.out.println("Menú Cliente");
            System.out.println("1. Ver perfil");
            System.out.println("2. Ir de compras");
            System.out.println("3. Ver compras");
            System.out.println("4. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Perfil del cliente:");
                    System.out.println("ID: " + cliente.getId());
                    System.out.println("DNI: " + cliente.getDni());
                    System.out.println("Gasto máximo: $" + cliente.getMaxExpense());
                    System.out.println("Dinero disponible: $" + cliente.getMoney());
                    break;
                case 2:
                    mostrarCatalogo(scanner);
                    System.out.print("Ingrese el ID del producto que desea agregar al carrito (0 para volver): ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    if (productId == 0) {
                        break;
                    }

                    boolean encontrado = false;
                    for (Business business : businesses.values()) {
                        for (Product product : business.getProductList()) {
                            if (product.getId() == productId) {
                                cliente.comprarProducto(product);
                                encontrado = true;
                                break;
                            }
                        }
                        if (encontrado) {
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Compras del cliente:");
                    for (ShoppingRecord record : cliente.getShoppingList()) {
                        System.out.println(record);
                        for (Product p : record.getShoppingList()) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private void mostrarEmpresaMenu(Scanner scanner, Business empresa) {
        int opcion;

        do {
            System.out.println("Menú Empresa");
            System.out.println("1. Ver perfil");
            System.out.println("2. Ver productos");
            System.out.println("3. Agregar productos");
            System.out.println("4. Regresar al menú principal");
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Perfil de la empresa:");
                    System.out.println("ID: " + empresa.getId());
                    System.out.println("Nombre: " + empresa.getName());
                    break;
                case 2:
                    System.out.println("Productos de la empresa:");
                    for (Product product : empresa.getProductList()) {
                        System.out.println(product);
                    }
                    break;
                case 3:
                    agregarProducto(scanner, empresa);
                    break;
                case 4:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }
    private void agregarProducto(Scanner scanner, Business empresa) {
        scanner.nextLine();
        System.out.println("Ingrese los detalles del nuevo producto:");

        System.out.print("Nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        System.out.print("Cantidad en stock: ");
        int stock = scanner.nextInt();

        System.out.print("Precio del producto: ");
        double precioProducto = scanner.nextDouble();

        System.out.print("Días para entregar: ");
        int diasEntrega = scanner.nextInt();

        String nombreEmpresa = empresa.getName();

        Product nuevoProducto = new Product(nombreEmpresa,nombreProducto,stock,precioProducto,diasEntrega);

        empresa.addProduct(nuevoProducto);

        System.out.println("Producto agregado correctamente: " + nuevoProducto);
    }
}

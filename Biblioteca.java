import java.util.*;

public class Biblioteca{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        ArrayList<Documento> documentos = new ArrayList<Documento>();
        ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        boolean salir = false;
        String seleccion;

        System.out.println("Bienvenido al sistema de la biblioteca\n");

        while(!salir){
            System.out.println("=== MENU DE OPCIONES ===");
            System.out.println("¿Que desea hacer?");
            System.out.println("1. Ingresar nuevos documentos");           
            System.out.println("2. Obtener el titulo de una publicacion");
            System.out.println("3. Calcular la cantidad de documentos de una materia");   
            System.out.println("4. Ver la cantidad de revistas de una materia");
            System.out.println("5. Mostrar informacion de todos los libros de la biblioteca");
            System.out.println("6. Registrar cliente");
            System.out.println("7. Mostrar clientes");
            System.out.println("8. Prestamo a un cliente");
            System.out.println("9. Salir");

            seleccion = scan.nextLine();

            switch(seleccion){
                case "1":
                    ingresarDocumentos(documentos);
                    break;
                case "2":
                    obtenerTitulo(documentos);
                    break;
                case "3":
                    calcularMateria(documentos);
                    break;
                case "4":
                    calcularMateriaRevistas(documentos);
                    break;
                case "5":
                    mostrarLibros(documentos);
                    break;
                case "6":
                    registrarCliente(clientes);
                    break;
                case "7":
                    mostrarClientes(clientes);
                    break;
                case "8":
                    prestamoCliente(clientes, documentos, prestamos);
                    break;
                case "9":
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("Ingrese un valor numerico valido");
            }
        }
    }

    public static void ingresarDocumentos(ArrayList<Documento> documentos){
        Scanner scan = new Scanner(System.in);
        String seleccion;

        int id;
        String titulo;
        String autor;
        String editorial;
        String materia;
        int cantidad;
        boolean estado;
        String year;
        int numero; 
        String arbitro;

        System.out.println("=== REGISTRO DE DOCUMENTOS ===");
        System.out.println("\nDe que tipo desea agregar?");
        System.out.println("\n1. Libro\t2.Revista\t3.Articulo");

        seleccion = scan.nextLine();

        switch(seleccion){
            case "1":
                System.out.println("\n=== LIBRO ===");
                System.out.println("Ingrese el id");
                id = Integer.parseInt(scan.nextLine());
                System.out.println("Ingrese el titulo");
                titulo = scan.nextLine();
                System.out.println("Ingrese la materia");
                materia = scan.nextLine();
                System.out.println("Ingrese la cantidad de ejemplares");
                cantidad = Integer.parseInt(scan.nextLine()); 
                System.out.println("Ingrese el autor");
                autor = scan.nextLine();
                System.out.println("Ingrese la editorial");
                editorial = scan.nextLine();

                Libro libro = new Libro(id, titulo, materia, cantidad, editorial, autor);
                documentos.add(libro);

                System.out.println("\nDocumento agregado exitosamente");
                break;
            case "2":
                System.out.println("\n=== REVISTA ===");
                System.out.println("Ingrese el id");
                id = Integer.parseInt(scan.nextLine());
                System.out.println("Ingrese el titulo");
                titulo = scan.nextLine();
                System.out.println("Ingrese la materia");
                materia = scan.nextLine();
                System.out.println("Ingrese la cantidad de ejemplares");
                cantidad = Integer.parseInt(scan.nextLine()); 
                System.out.println("Ingrese el año");
                year = scan.nextLine();
                System.out.println("Ingrese el numero");
                numero = Integer.parseInt(scan.nextLine());

                Revista revista = new Revista(id, titulo, materia, cantidad, year, numero);
                documentos.add(revista);

                System.out.println("\nDocumento agregado exitosamente");
                break;
            case "3":
                System.out.println("\n=== ARTICULO ===");
                System.out.println("Ingrese el id");
                id = Integer.parseInt(scan.nextLine());
                System.out.println("Ingrese el titulo");
                titulo = scan.nextLine();
                System.out.println("Ingrese la materia");
                materia = scan.nextLine();
                System.out.println("Ingrese la cantidad de ejemplares");
                cantidad = Integer.parseInt(scan.nextLine()); 
                System.out.println("Ingrese el arbitro");
                arbitro = scan.nextLine();

                Articulo articulo = new Articulo(id, titulo, materia, cantidad, arbitro);
                documentos.add(articulo);

                System.out.println("\nDocumento agregado exitosamente");
                break;
            default:
                System.out.println("Ingrese un valor numerico valido...");
        }
    }

    public static void obtenerTitulo(ArrayList<Documento> documentos){
        Scanner scan = new Scanner(System.in);
        int id;
        int notFound;

        System.out.println("\nIngrese el id del documento al cual le desea obtener el titulo:");
        id = Integer.parseInt(scan.nextLine());

        for(Documento documento : documentos){
            if(documento.getId() == id)
                System.out.println("El titulo del documento es: " + documento.getTitulo());
        }
    }

    public static void calcularMateria(ArrayList<Documento> documentos){
        Scanner scan = new Scanner(System.in);
        String materia;
        int cantidad = 0;

        System.out.println("\nIngrese la materia que desea verificar:");
        materia = scan.nextLine();

        for(Documento documento : documentos){
            if(documento.getMateria().equals(materia)){
                cantidad++;
            }
        }

        System.out.println("\nLa cantidad de documentos de esta materia: " + cantidad);
    }

    public static void calcularMateriaRevistas(ArrayList<Documento> documentos){
        Scanner scan = new Scanner(System.in);
        String materia;
        int cantidad = 0;

        System.out.println("\nIngrese la materia que desea verificar:");
        materia = scan.nextLine();

        for(Documento documento : documentos){
            if(documento.getMateria().equals(materia))
                if(documento instanceof Revista)
                    cantidad++;
        }

        System.out.println("\nLa cantidad de revistas de esta materia: " + cantidad);
    }

    public static void mostrarLibros(ArrayList<Documento> documentos){

        if(documentos.size() >= 0){
            for(Documento documento : documentos){
                if(documento instanceof Libro)
                    System.out.println(documento);
            }
        }
    }

    public static void registrarCliente(ArrayList<Cliente> clientes){
        Scanner scan = new Scanner(System.in);
        int id;
        String nombre;
        String direccion;

        System.out.println("\n=== REGISTRO DE CLIENTE ===");
        System.out.println("Ingrese el nombre del cliente");
        nombre = scan.nextLine();

        System.out.println("Ingrese la direccion del cliente");
        direccion = scan.nextLine();

        id = clientes.size()+1;

        Cliente cliente = new Cliente(id, nombre, direccion);
        clientes.add(cliente);

        System.out.println("\nCliente registrado correctamente...");
    }

    public static void mostrarClientes(ArrayList<Cliente> clientes){

        for(Cliente cliente : clientes){
            System.out.println(cliente);
        }
    }

    public static void prestamoCliente(ArrayList<Cliente> clientes, ArrayList<Documento> documentos, ArrayList<Prestamo> prestamos){
        Scanner scan = new Scanner(System.in);
        String seleccion;
        String fechaSolicitud;
        String fechaDevolucion;
        int id;
        int idCliente;

        System.out.println("\n=== PRESTAMO A UN CLIENTE ===");
        System.out.println("¿Que desea registrar? 1. Prestamo a un cliente\t2. Devolución de una publicacion\t3. Prorrogar una fecha");
        seleccion = scan.nextLine();

        switch(seleccion){
            case "1":
                System.out.println("Ingrese el id del documento que se prestara");
                id = Integer.parseInt(scan.nextLine());
                System.out.println("Ingrese la fecha de solicitud");
                fechaSolicitud = scan.nextLine();
                System.out.println("Ingrese la fecha de devolución");
                fechaDevolucion = scan.nextLine();
                System.out.println("Ingrese el id del cliente");
                idCliente = Integer.parseInt(scan.nextLine());

                for(Documento documento : documentos){
                    if(documento.getId() == id)
                        documento.prestar();
                }

                Prestamo prestamo = new Prestamo(id, fechaSolicitud, fechaDevolucion);
                prestamos.add(prestamo);

                for(Cliente cliente : clientes){
                    if(cliente.getId() == id)
                        cliente.agregarPrestamo(prestamo);
                }

                System.out.println("");
                break;
            case "2":

                System.out.println("Ingrese el id del documento que se prestara");
                id = Integer.parseInt(scan.nextLine());
                System.out.println("Ingrese el id del cliente");
                idCliente = Integer.parseInt(scan.nextLine());

                

                if(prestamos.size() != 0){
                    for(Cliente cliente : clientes){
                        if(cliente.getId() == id)
                            cliente.devolverPrestamo(id);
                    }
                }
                else
                    System.out.println("No hay prestamos realizados actualmente");
                
                break;
            case "3":
                System.out.println("Ingrese el id del documento que se prestara");
                id = Integer.parseInt(scan.nextLine());

                if(prestamos.size() != 0){
                    for(Prestamo thisPrestamo : prestamos){
                        if(thisPrestamo.getIdPublicacion() == id){
                            System.out.println("Ingrese la nueva fecha de devolucion");
                            fechaDevolucion = scan.nextLine();

                            thisPrestamo.setFechaDevolucion(fechaDevolucion);
                        }
                    }
                }
                else
                    System.out.println("No hay prestamos realizados actualmente");
                break;
        }
    }
}
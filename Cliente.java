public class Cliente{

    private int id;
    private String nombre;
    private String direccion;
    private int cantidadPublicaciones;
    private Prestamo[] prestamos = new Prestamo[5];

    public Cliente(int id, String nombre, String direccion){
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId(){
        return id;
    }

    public void agregarPrestamo(Prestamo prestamo){

        boolean asignado = false;
        
        if(cantidadPublicaciones >= prestamos.length){
            System.out.println("El cliente ya ha solicitado 5 prestamos actualmente, no puede asignarle mas hasta que devuelva una publicacion al menos...");
        }

        while(!asignado){
            for(int i = 0; i < prestamos.length; i++){
                if(prestamos[i] == null && !asignado){
                    prestamos[i] = prestamo;
                    asignado = true;
                    cantidadPublicaciones++;
                }
            }
        }
    }

    public void devolverPrestamo(int idPublicacion){
        for(int i = 0; i < prestamos.length; i++){
            if(prestamos[i] != null){
                if(prestamos[i].getIdPublicacion() == idPublicacion){
                    prestamos[i] =  null;
                    cantidadPublicaciones--;
                }
            }   
        }
    }

    public void mostrarPrestamos(){
        for(int i = 0; i < prestamos.length; i++)
            System.out.println(prestamos[i]);
    }

    public String toString(){
        return "\nId: " + id + "\nNombre: " + nombre + "\nDireccion: " + direccion + "\nCantidad de publicaciones prestadas: " + cantidadPublicaciones;
    }
}
public class Prestamo{

    private int idPublicacion;
    private String fechaSolicitud;
    private String fechaDevolucion;
    
    public Prestamo(int idPublicacion, String fechaSolicitud, String fechaDevolucion){
        this.idPublicacion = idPublicacion;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion){
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getIdPublicacion(){
        return idPublicacion;
    }

    public String toString(){
        return "\nPrestamo de la publicación: " + idPublicacion + "\nFecha de solicitud: " + fechaSolicitud + "\nFecha de devolución: " + fechaDevolucion + "\n";
    }
}
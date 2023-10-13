public class Libro extends Documento{

    private String editorial;

    public Libro(int id, String titulo, String materia, int cantidad, String editorial, String autor){
        super(id, titulo, materia, cantidad);
        this.editorial = editorial;
        this.autor = autor;
    }

    public String toString(){

        String state;
        if(estado == true)
            state = "Disponible";
        else
            state = "Agotado";

        return "\nId: " + id + "\nTitulo: " + "\nMateria: " + materia + "\nCantidad de ejemplares: " + cantidad + "\nEditorial: " + editorial + "\nAutor: " + autor + "\nEstado: " + state;
    }
}
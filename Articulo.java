public class Articulo extends Documento{

    String arbitro;

    public Articulo(int id, String titulo, String materia, int cantidad, String arbitro){
        super(id, titulo, materia, cantidad);
        this.arbitro = arbitro;
    }

    public String toString(){

        String state;
        if(estado == true)
            state = "Disponible";
        else
            state = "Agotado";

        return "\nId: " + id + "\nTitulo: " + "\nMateria: " + materia + "\nCantidad de ejemplares: " + cantidad + "\nArbitro: " + arbitro + "\nEstado: " + state;
    }
}
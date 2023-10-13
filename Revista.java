public class Revista extends Documento{

    private String year;
    private int numero; 

    public Revista(int id, String titulo, String materia, int cantidad, String year, int numero){
        super(id, titulo, materia, cantidad);
        this.year = year;
        this.numero = numero;
    }  

    public String toString(){
        
        String state;
        if(estado == true)
            state = "Disponible";
        else
            state = "Agotado";

        return "\nId: " + id + "\nTitulo: " + "\nMateria: " + materia + "\nCantidad de ejemplares: " + cantidad + "\nAño: " + year + "\nNumero: " + numero + "\nEstado: " + state;
    }
}
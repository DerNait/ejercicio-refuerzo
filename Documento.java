public abstract class Documento{

    protected int id;
    protected String titulo;
    protected String autor;
    protected String materia;
    protected int cantidad;
    protected boolean estado;

    public Documento(int id, String titulo, String materia, int cantidad){
        this.id = id;
        this.titulo = titulo;
        this.materia = materia;
        this.cantidad = cantidad;
        this.estado = true;
    }

    public String getTitulo(){
        return titulo;
    }

    public int getId(){
        return id;
    }

    public String getMateria(){
        return materia;
    }

    public void prestar(){
        if(cantidad > 1)
            cantidad--;
        else if(cantidad == 1){
            cantidad--;
            estado = false;
        }
        else
            System.out.println("Ya no tenemos este documento disponible");
    }

    public void devolver(){
        cantidad++;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }
}
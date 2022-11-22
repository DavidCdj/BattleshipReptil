
package batlleship;

class Score {
    private String nombre;
    private int edad,bu;
    public  Score(String nombre,int edad, int bu)
    {
        this.nombre=nombre;
        this.edad=edad;
        this.bu=bu;
    }
    
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public int getEdad() {
        return edad;
    }

    
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    public int getBu() {
        return bu;
    }

   
    public void setBu(int bu) {
        this.bu = bu;
    }
    
    
}


package batlleship;


class Barcos 
{
    private int linea;
    private int col;
    private int conta;
    public  Barcos(int linea, int col)
    {
        this.linea=linea;
        this.col=col;
    }
    

   
    public int getLinea() {
        return linea;
    }

    
    public void setLinea(int linea) {
        this.linea = linea;
    }

   
    public int getCol() {
        return col;
    }

    
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * @return the conta
     */
    public int getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(int conta) {
        this.conta = conta;
    }
    
}

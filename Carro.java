public class Carro {
    private String tipo;
    private String marca;
    private String modelo;
    private int ano;
    private int numeroPortas;
    private String placa;


    public Carro(String tipo, String marca, String modelo, int ano, int numeroPortas , String placa) {
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.numeroPortas = numeroPortas;
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String toString() {
        return 
        " - Tipo: " + tipo +
        "\n - Marca: " + marca + 
        "\n - Modelo: " + modelo + 
        "\n - Ano: " + ano + 
        "\n - Numero de Portas: " + numeroPortas +
        "\n - Placa: " + placa + 
        "\n";
    }

}


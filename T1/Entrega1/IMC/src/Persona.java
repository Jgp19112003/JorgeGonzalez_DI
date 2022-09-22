public class Persona {

    String nombre, DNI, sexo;
    double peso, altura;
    int edad;

    public Persona(String nombre, String sexo, int edad) {
        this.nombre = nombre;
        this.DNI = "Defecto";
        this.sexo = sexo;
        this.peso = 0;
        this.altura = 0;
        this.edad = edad;
    }

    public Persona() {
        this.nombre = "Defecto";
        this.DNI = "0";
        this.sexo = "Defecto";
        this.peso = 0;
        this.altura = 0;
        this.edad = 0;
    }

    public Persona(String nombre, String DNI, String sexo, double peso, double altura, int edad) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
    }

    public Persona(String nombre, String sexo, double peso, double altura, int edad) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
    }

    public int calcularIMC() {
        double peso_ideal;
        peso_ideal = (peso / (Math.pow(2, altura)));
        if (peso_ideal < 20) {
            toString();
            System.out.println(nombre + sexo + peso + altura + edad);
            System.out.println("Estas en tu peso ideal");
            return -1;
        } else if (peso_ideal >= 20 && peso_ideal <= 25) {
            toString();
            System.out.println(nombre + sexo + peso + altura + edad);
            System.out.println("Estas por debajo de tu peso");
            return 0;
        } else {
            toString();
            System.out.println(nombre + sexo + peso + altura + edad);
            System.out.println("Estas en sobrepeso");
            return 1;
        }

    }


    public boolean esMayorDeEdad() {
        if (this.edad >= 18) {
            return true;
        } else {
            System.out.println("Menor de edad");
            return false;
        }


    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", sexo='" + sexo + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", edad=" + edad +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

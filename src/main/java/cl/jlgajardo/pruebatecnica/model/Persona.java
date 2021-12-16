package cl.jlgajardo.pruebatecnica.model;

public class Persona {
    private long id;
    private String nombre;
    private String apellido;
    private long telefono;
    private String rut;
    private String fechaNacimiento;
    private Direccion direccion;
    private long activo;


    public long getId() {
        return id;
    }

    public Persona setId(long id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Persona setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Persona setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public long getTelefono() {
        return telefono;
    }

    public Persona setTelefono(long telefono) {
        this.telefono = telefono;
        return this;
    }

    public String getRut() {
        return rut;
    }

    public Persona setRut(String rut) {
        this.rut = rut;
        return this;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Persona setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Persona setDireccion(Direccion direccion) {
        this.direccion = direccion;
        return this;
    }

    public long getActivo() {
        return activo;
    }

    public Persona setActivo(long activo) {
        this.activo = activo;
        return this;
    }
}

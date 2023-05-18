package com.srchicharron.dancingqueen.model;

import com.srchicharron.dancingqueen.util.Utils;
import jakarta.persistence.*;

@Entity(name = "MASCOTA")
@Table(name = "MASCOTA")
public class Mascota {
    public static final String TABLE_NAME= "MASCOTA";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;

    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "FECHA_NACIMIENTO")
    private String fechaNacimiento;

    @Basic(optional = false)
    @Column(name = "PESO")
    private Float peso;

    @Basic(optional = false)
    @Column(name = "NOTAS")
    private String notas;

//    @Basic(optional = false)
//    @Column(name = "ID_CLIENTE")
//    private int idCliente;
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @Basic(optional = true)
    @Column(name = "SEXO")
    private String sexo;

    @Basic(optional = true)
    @Column(name = "ESPECIE")
    private String especie;

    @Basic(optional = true)
    @Column(name = "RAZA")
    private String raza;

    @Transient
    private String edad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

//    public int getIdCliente() {
//        return idCliente;
//    }
//
//    public void setIdCliente(int idCliente) {
//        this.idCliente = idCliente;
//    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void ageDef(){
        Utils utils=new Utils();
        setEdad(utils.ageCalculator(this.getFechaNacimiento()));
    }
}

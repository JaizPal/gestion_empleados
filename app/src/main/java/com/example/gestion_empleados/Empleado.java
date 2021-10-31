package com.example.gestion_empleados;

public class Empleado {

    public static final String[] DEPARTAMENTOS = { "RRHH", "Marketing", "Comercial", "Logística", "Dirección",
            "Operario", "Otro" };
    private String apellido;
    private String departamento;
    private double salario;

    public Empleado(String apellido, String departamento, double salario) {
        this.apellido = apellido;
        this.departamento = setDepartamento(departamento);
        this.salario = salario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDepartamento() {
        return departamento;
    }

    /*
     * Si el departamento pasado por parámetros no es uno de los que están
     * establecidos se asignará como "Otro".
     */
    public String setDepartamento(String departamento) {
        for (int i = 0; i < DEPARTAMENTOS.length; i++) {
            if (departamento.equals(DEPARTAMENTOS[i])) {
                return departamento;
            }
        }
        return "Otro";
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}

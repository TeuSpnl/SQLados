package model;

public class Department {
    
    private int code;
    private String name;
    private String responsible;

    public Department(int code, String name, String responsible){
        this.code = code;
        this.name = name;
        this.responsible = responsible;
    }   

    public Department(){
        this.code = 0;
        this.name = "";
        this.responsible = "";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    } 

    public String[] departmentToString(){
        String[] s = new String[3];
        s[0] = "Codigo: " + Integer.toString(this.code);
        s[1] = "Nome: " + this.name;
        s[2] = "Responsavel: " + this.responsible;
        return s;
    }
    
}

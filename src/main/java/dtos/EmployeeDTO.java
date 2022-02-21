package dtos;

import entities.Employee;

public class EmployeeDTO {
    private int id;
    private String address;
    private String name;

    public EmployeeDTO(Employee e) {
        this.id = e.getId();
        this.address = e.getAddress();
        this.name = e.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.EmployeeDTO;
import facades.EmployeeFacade;
import utils.EMF_Creator;
import facades.FacadeExample;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

//Todo Remove or change relevant parts before ACTUAL use
@Path("/employee")
public class Employee {


    private static final EmployeeFacade ef = new EmployeeFacade();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllCustomers() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (entities.Employee e: ef.getAllEmployees()) {
            employeeDTOList.add(new EmployeeDTO(e));
        }
        return Response.ok().entity(GSON.toJson(employeeDTOList)).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployeeById(@PathParam("id") int id) {
        return Response.ok().entity(GSON.toJson(new EmployeeDTO(ef.getEmpById(id)))).build();
    }

    @GET
    @Path("/highestpaid")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getHighestPaidEmp() {
        return Response.ok().entity(GSON.toJson(new EmployeeDTO(ef.getEmployeesWithHighestSalary()))).build();
    }

    @GET
    @Path("name/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployeeByName(@PathParam("name") String name) {
        return Response.ok().entity(GSON.toJson(new EmployeeDTO(ef.getEmployeesByName(name)))).build();
    }

}

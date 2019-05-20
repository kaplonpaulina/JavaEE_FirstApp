import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ClientRest {

    public static void main(String[] args) {
        String urlTraget = "http://localhost:8080/pl.agh.edu.soa.lab1-web/api/MyApi/students";

        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/pl.agh.edu.soa.lab1-web/api/MyApi/students");
        Response response = target.request().header(HttpHeaders.AUTHORIZATION, "Bearer " + "... encoded token ...").get();

        if (response.getStatus() != 200) {
            System.out.println("Failed with error code:" + response.getStatus());
        }

        System.out.println(response.readEntity(String.class));
        response.close();

        Form form = new Form();

        form.param("id", "222").param("name", "Paulin").param("gender", "m").param("photo", "photo").param("faculty", "aaa").param("grades", "5.0");

        Entity<Form> entity = Entity.form(form);
        ResteasyWebTarget target2 = client.target("http://localhost:8080/pl.agh.edu.soa.lab1-web/api/MyApi/addStudent");
        Response response1 = target2.request(MediaType.APPLICATION_JSON).post(entity);

        if (response1.getStatus() != 201) {
            System.out.println("failed:" + response1.getStatus());
        }

        response1.close();

    }


}

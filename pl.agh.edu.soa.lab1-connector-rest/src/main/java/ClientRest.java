import com.google.protobuf.InvalidProtocolBufferException;
import models.StudentP;
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
        String urlTraget = "http://localhost:8080/pl.agh.edu.soa.lab1-web/api/MyApi";

        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/pl.agh.edu.soa.lab1-web/api/MyApi/students");
        Response response = target.request().header(HttpHeaders.AUTHORIZATION, "Bearer " + "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwcHAiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvcGwuYWdoLmVkdS5zb2EubGFiMS13ZWIvYXBpL3VzZXJzL2xvZ2luIiwiaWF0IjoxNTU4Mzg0NDYyLCJleHAiOjE1NTgzODUzNjJ9.d4bmV6WbvDyyICQJwVZxcipBUGzXZDNPNQGHtjDs5XYsEWOskqJmIGjvPPTkd1XGoUK6daiipglEuzmzEC1lcg").get();

        if (response.getStatus() != 200) {
            System.out.println("Failed with error code:" + response.getStatus());
        }

        System.out.println(response.readEntity(String.class));
        response.close();

        String photo = "iVBORw0KGgoAAAANSUhEUgAAAoAAAAGrCAIAAADfLLEcAAAABmJLR0QA/wD/AP+gvaeTAAAHaklEQVR4nO3YPUpcARhG4cwwiSJDfiCdpJnKqXUJNlZWbsHK5bgFKysrN6G19sE2kzSDEvRmC8FAzh18nhW81XfgmwzD8A4A+L+m9QAAeIsEGAACAgwAAQEGgIAAA0BAgAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQECAASAgwAAQEGAACAgwAAQEGAACAgwAAQEGgIAAA0BAgAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQECAASAgwAAQEGAACAgwAAQEGAACAgwAAQEGgIAAA0BAgAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQECAASAgwAAQmNUDYIP9vLp6vL+vV2S29/Y+Hx/XK2BTCTC83o+Li9XlZb0i8+XkRIDh1bygASAgwAAQEGAACAgwAAQEGAACAgwAAQEGgIAAA0BAgAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQECAASAgwAAQEGAACAgwAAQEGAACAgwAAQEGgIAAA0BAgAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQECAASAgwAAQEGAACAgwAAQEGAACAgwAAQEGgIAAA0BAgAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQECAASAgwAAQEGAACAgwAAQEGAACAgwAAQEGgIAAA0BAgAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQGBWD2CkHu/uXtbresXYPa9W9YTS82q1vr2tV4zddGdne7msVzBGk2EY6g2M0d3BgdsK/25nf395c1OvYIy8oAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQECAASAgwAAQEGAACAgwAAQEGAACAgwAAQEGgIAAA0BAgAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQECAASAgwAAQEGAACAgwAAQEGAACAgwAAQEGgIAAA0BAgAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQECAASAgwAAQEGAACAgwAAQEGAACAgwAAQEGgIAAA0BAgAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABCbDMNQbGKPfDw8vT0/1irH7fnb26/q6XpH5dHT07fy8XjF2062t97u79QrGaFYPYKScjL8xnc/rCaXpfL61WNQrYFN5QQNAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQECAASAgwAAQEGAACAgwAAQEGAACAgwAAQEGgIAAA0BAgAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQECAASAgwAAQEGAACAgwAAQEGAACAgwAAQEGgIAAA0BAgAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQECAASAgwAAQEGAACAgwAAQEGAACAgwAAQEGgIAAA0BAgAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQECAASAgwAAQEGAACAgwAAQEGAACAgwAAQEGgIAAA0BAgAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoDArB4AG+zr6enHw8N6RebDYlFPgA02GYah3gAAb44XNAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQECAASAgwAAQEGAACAgwAAQEGAACAgwAAQEGgIAAA0BAgAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQECAASAgwAAQEGAACAgwAAQEGAACAgwAAQEGgIAAA0BAgAEgIMAAEBBgAAgIMAAEBBgAAgIMAAEBBoCAAANAQIABICDAABAQYAAICDAABAQYAAICDAABAQaAgAADQECAASAgwAAQEGAACAgwAAQEGAACAgwAAQEGgIAAA0BAgAEgIMAAEPgDMbI99ybDVNsAAAAASUVORK5CYII=";


        Form form = new Form();
        form.param("id", "3013").param("name", "Sabina2").param("gender", "female").param("photo", null)
                .param("faculty", "wiet").param("grades", "5.0");
        Entity<Form> entity = Entity.form(form);
        ResteasyWebTarget target1 = client.target("http://localhost:8080/pl.agh.edu.soa.lab1-web/api/MyApi/addStudent");
        Response response1 = target1.request(MediaType.APPLICATION_JSON).header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwcHAiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvcGwuYWdoLmVkdS5zb2EubGFiMS13ZWIvYXBpL3VzZXJzL2xvZ2luIiwiaWF0IjoxNTU4NDIyNTA0LCJleHAiOjE1NTg0MjM0MDR9.5oj7kH9FZQNGoIS8Vmf0-VELql6qC-NMEACrW5fHN2YVjrdQ_0d_nq3pcEg-tY0e0JxL-srDFBQuapHd3HKcuA").post(entity);

        if (response1.getStatus() != 201) {
            System.out.println("Failed: " + response1.getStatus());
        }
        response1.close();




        ResteasyWebTarget target2 = client.target("http://localhost:8080/pl.agh.edu.soa.lab1-web/api/MyApi/proto?id=3013");
        Response response2 = target2.request().get();

        try {
            System.out.println(StudentP.StudentProto.parseFrom(response2.readEntity(byte[].class)));
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        response2.close();


    }


}

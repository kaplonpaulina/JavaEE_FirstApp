package main;

import controllers.Conroller;
import controllers.ConrollerService;

import javax.xml.ws.BindingProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class Main {
    private static void setCred(Conroller service) {
        BindingProvider provider = (BindingProvider) service;
        provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "a");
        provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "a");
    }

    private static byte[] getImage(String imageName) throws IOException {
        File file = new File(imageName);
        FileInputStream imageInFile = new FileInputStream(file);
        byte[] imageData = new byte[(int) file.length()];
        imageInFile.read(imageData);
        return imageData;
    }

    public static void main(String[] args) throws IOException {
        ConrollerService service = new ConrollerService();
        Conroller server = service.getConrollerPort();

        setCred(server);

        String path = "./pl.agh.edu.soa.lab1-connector/src/main/java/main/images/";


        byte[] malePhoto = getImage(path+"male.png");
        byte[] femalePhoto = getImage(path+"female.png");
        byte[] nonBinaryPhoto = getImage(path+"nanBInary.png");


        List<String> eaiiibCourses = new ArrayList<>(Arrays.asList("SOA","SP","KOMPILATORY","AI","WF"));
        List<String> otherCourses = new ArrayList<>(Arrays.asList("NIE SOA","NIE SP","NIE KOMPILATORY","NIE AI","NIE WF"));

        server.addStudent(1,"Paulina Kapłon",'f', femalePhoto, "EAIiIB", eaiiibCourses, (float) 5.0);
        server.addStudent(2,"Maria Skłodowksa",'f',femalePhoto,"CHEMIA",otherCourses, (float) 4.9);
        server.addStudent(3,"Mendelejew", 'm',malePhoto,"CHEMIA", otherCourses, (float) 4.6);
        server.addStudent(4,"I.T", 'n',nonBinaryPhoto,"GO HOME", otherCourses, (float) 3.0);


        System.out.println(server.listStudents("CHEMIA","m","down"));


        System.out.println(server.getStudent(2));


        System.out.println(server.getStudent(1).getPhoto());
        System.out.println(Base64.getDecoder().decode(server.getStudent(1).getPhoto()));

    }
}

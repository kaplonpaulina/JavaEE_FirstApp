
package controllers;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the controllers package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DelStudent_QNAME = new QName("http://controllers/", "delStudent");
    private final static QName _GetStudentResponse_QNAME = new QName("http://controllers/", "getStudentResponse");
    private final static QName _AddStudent_QNAME = new QName("http://controllers/", "addStudent");
    private final static QName _DelStudentResponse_QNAME = new QName("http://controllers/", "delStudentResponse");
    private final static QName _GetStudent_QNAME = new QName("http://controllers/", "getStudent");
    private final static QName _EditStudentResponse_QNAME = new QName("http://controllers/", "editStudentResponse");
    private final static QName _ListStudents_QNAME = new QName("http://controllers/", "listStudents");
    private final static QName _EditStudent_QNAME = new QName("http://controllers/", "editStudent");
    private final static QName _AddStudentResponse_QNAME = new QName("http://controllers/", "addStudentResponse");
    private final static QName _ListStudentsResponse_QNAME = new QName("http://controllers/", "listStudentsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: controllers
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListStudentsResponse }
     * 
     */
    public ListStudentsResponse createListStudentsResponse() {
        return new ListStudentsResponse();
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link DelStudentResponse }
     * 
     */
    public DelStudentResponse createDelStudentResponse() {
        return new DelStudentResponse();
    }

    /**
     * Create an instance of {@link GetStudentResponse }
     * 
     */
    public GetStudentResponse createGetStudentResponse() {
        return new GetStudentResponse();
    }

    /**
     * Create an instance of {@link DelStudent }
     * 
     */
    public DelStudent createDelStudent() {
        return new DelStudent();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link EditStudent }
     * 
     */
    public EditStudent createEditStudent() {
        return new EditStudent();
    }

    /**
     * Create an instance of {@link EditStudentResponse }
     * 
     */
    public EditStudentResponse createEditStudentResponse() {
        return new EditStudentResponse();
    }

    /**
     * Create an instance of {@link ListStudents }
     * 
     */
    public ListStudents createListStudents() {
        return new ListStudents();
    }

    /**
     * Create an instance of {@link GetStudent }
     * 
     */
    public GetStudent createGetStudent() {
        return new GetStudent();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link ListStudentsResponse.StudentList }
     * 
     */
    public ListStudentsResponse.StudentList createListStudentsResponseStudentList() {
        return new ListStudentsResponse.StudentList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DelStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "delStudent")
    public JAXBElement<DelStudent> createDelStudent(DelStudent value) {
        return new JAXBElement<DelStudent>(_DelStudent_QNAME, DelStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "getStudentResponse")
    public JAXBElement<GetStudentResponse> createGetStudentResponse(GetStudentResponse value) {
        return new JAXBElement<GetStudentResponse>(_GetStudentResponse_QNAME, GetStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DelStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "delStudentResponse")
    public JAXBElement<DelStudentResponse> createDelStudentResponse(DelStudentResponse value) {
        return new JAXBElement<DelStudentResponse>(_DelStudentResponse_QNAME, DelStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "getStudent")
    public JAXBElement<GetStudent> createGetStudent(GetStudent value) {
        return new JAXBElement<GetStudent>(_GetStudent_QNAME, GetStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "editStudentResponse")
    public JAXBElement<EditStudentResponse> createEditStudentResponse(EditStudentResponse value) {
        return new JAXBElement<EditStudentResponse>(_EditStudentResponse_QNAME, EditStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListStudents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "listStudents")
    public JAXBElement<ListStudents> createListStudents(ListStudents value) {
        return new JAXBElement<ListStudents>(_ListStudents_QNAME, ListStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "editStudent")
    public JAXBElement<EditStudent> createEditStudent(EditStudent value) {
        return new JAXBElement<EditStudent>(_EditStudent_QNAME, EditStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListStudentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controllers/", name = "listStudentsResponse")
    public JAXBElement<ListStudentsResponse> createListStudentsResponse(ListStudentsResponse value) {
        return new JAXBElement<ListStudentsResponse>(_ListStudentsResponse_QNAME, ListStudentsResponse.class, null, value);
    }

}

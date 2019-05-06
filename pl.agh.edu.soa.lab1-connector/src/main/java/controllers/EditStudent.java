
package controllers;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for editStudent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editStudent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="newName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="newPhoto" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="newFaculty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newCourses" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="grades" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editStudent", propOrder = {
    "id",
    "newName",
    "gender",
    "newPhoto",
    "newFaculty",
    "newCourses",
    "grades"
})
public class EditStudent {

    protected int id;
    protected String newName;
    @XmlSchemaType(name = "unsignedShort")
    protected int gender;
    protected byte[] newPhoto;
    protected String newFaculty;
    protected List<String> newCourses;
    protected float grades;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the newName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewName() {
        return newName;
    }

    /**
     * Sets the value of the newName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewName(String value) {
        this.newName = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     */
    public int getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     */
    public void setGender(int value) {
        this.gender = value;
    }

    /**
     * Gets the value of the newPhoto property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getNewPhoto() {
        return newPhoto;
    }

    /**
     * Sets the value of the newPhoto property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setNewPhoto(byte[] value) {
        this.newPhoto = value;
    }

    /**
     * Gets the value of the newFaculty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewFaculty() {
        return newFaculty;
    }

    /**
     * Sets the value of the newFaculty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewFaculty(String value) {
        this.newFaculty = value;
    }

    /**
     * Gets the value of the newCourses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the newCourses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNewCourses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNewCourses() {
        if (newCourses == null) {
            newCourses = new ArrayList<String>();
        }
        return this.newCourses;
    }

    /**
     * Gets the value of the grades property.
     * 
     */
    public float getGrades() {
        return grades;
    }

    /**
     * Sets the value of the grades property.
     * 
     */
    public void setGrades(float value) {
        this.grades = value;
    }

}

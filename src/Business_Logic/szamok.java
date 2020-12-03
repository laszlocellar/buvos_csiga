/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.io.File;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType
public class szamok {
  int szam;
  int sor;
  int oszlop;
  
  public szamok(int szam, int sor, int oszlop)
  {
      this.szam=szam;
      this.sor=sor;
      this.oszlop=oszlop;
  }
  
  public szamok()
  {
      
  }
  
  @XmlAttribute
  public int getSzam()
  {
      return szam;
  }
  
  @XmlElement
    public int getSor()
  {
      return sor;
  }
    
     @XmlElement
     public int getOszlop()
  {
      return oszlop;
  }
  

        public String toXML() {
         StringWriter swriter = new StringWriter();
         try {
            JAXBContext jaxbContext = JAXBContext.newInstance(this.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            jaxbMarshaller.marshal(this,swriter);
         } catch (JAXBException jaxbex) {jaxbex.printStackTrace();}
   
         String s = swriter.toString();
         if (s==null) s = "";
         
           return s;
     }
    
}

package org.mseco.xml.jaxbannotations;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace="http://ns.soacookbook.com/book",name="book") // like in russiandoll - only one element and that one is root
/**
<xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema"
           targetNamespace="http://ns.soacookbook.com/russiandoll"
           xmlns:tns="http://ns.soacookbook.com/russiandoll"
           elementFormDefault="unqualified">
<xsd:element name="book">
    <xsd:complexType>
        <xsd:sequence>
            <xsd:element name="title" type="xsd:string"/>
            <xsd:element name="author" type="xsd:string"/>
            <xsd:element name="category" type="xsd:string"/>
            <xsd:element name="price" type="xsd:float"/>
        </xsd:sequence>
    </xsd:complexType>
</xsd:element>
</xsd:schema>

 */
@XmlAccessorType(XmlAccessType.FIELD) 
/* indicates how the bind is done: 
 * 	FIELD - all fields,
 *  PUBLIC_MEMBERS - public fields, 
 *  PROPERTY - all getters and setters pair ,
 *  NONE - you have to manually decide wich fields with annotations
 * 
 */
@XmlType(namespace="http://ns.soacookbook.com/book")
/*
 * specifies the namespece of the xml type - if it's the same with namespace for
 * the type then both element and type declaration is in the same file and
 * namespace and when generated it does exactly this - otherwiese two different
 * schema file could be generated
 */ 
public class Book {
	@XmlElement(defaultValue="a",nillable=false,required=true)
	private String title;
}

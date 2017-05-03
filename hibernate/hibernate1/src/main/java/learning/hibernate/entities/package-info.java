/*
 *      There is a reason the previous code example only includes annotations from
the Hibernate package and no Java Persistence annotations. One of the (last-
minute) changes made to the JPA specification was the removal of package visibil-
ity of JPA annotations. As a result, no Java Persistence annotations can be placed in
a package-info.java file. If you need portable global Java Persistence metadata, put
it in an orm.xml file.

 */
//@org.hibernate.annotations.TypeDefs({
//    @org.hibernate.annotations.TypeDef(
//        name="monetary_amount_usd",
//        typeClass = MonetaryAmountType.class,
//        parameters = { @Parameter(name="convertTo", value="USD") }
//    ),
//    @org.hibernate.annotations.TypeDef(
//        name="monetary_amount_eur",
//        typeClass = MonetaryAmountType.class,
//        parameters = { @Parameter(name="convertTo", value="EUR") }
//    )
//})
@org.hibernate.annotations.NamedQueries({
    @org.hibernate.annotations.NamedQuery(
        name = "findItemsOrderByPrice",
        query = "select i from Item i order by i.initialPrice)"
    )
})

package learning.hibernate.entities;

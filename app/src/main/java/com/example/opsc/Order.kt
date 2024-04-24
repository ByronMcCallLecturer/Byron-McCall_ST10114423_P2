package com.example.opsc

class Order() {
    // properties of the customer and customer's order
    // lateinit as they will only be initialised later
    lateinit var productName: String
    lateinit var customerName: String
    lateinit var customerCell: String
    lateinit var orderDate: String

    // secondary constructor
    // constructor will be called when an 'Order' instance is created, with only
    // the product name provided. this() is used to call the primary constructor,
    // ensuring that all properties of the 'Order' class are initialised.
    constructor(pName: String) : this()
    {
        productName = pName
    }

    // secondary constructor
    // takes four parameters and is used when an 'Order' object with all the
    // parameters provided. Initialises the 'productName' property using this(pName)
    // to delegate the initialisation to the above's secondary constructor, which in
    // turn delegates to the primary constructor. Then it initialises the properties
    // in the parameters.
    constructor(pName: String, cName: String, cCell: String, oDate: String) : this(pName)
    {
        customerName = cName
        customerCell = cCell
        orderDate = oDate
    }


    override fun toString(): String {
        return "Customer Name: ${customerName}\n"+
                "Customer Cell: ${customerCell}\n"+
                "Order Date: ${orderDate}\n"
    }
}
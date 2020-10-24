# CECS343


'''java
          
    Database.getDatabase();  // gets singleton static Database
    
    Owner evan = new Owner();
    Product pizza = new Product();
    
    Database.getDatabase().add(evan); 
    Database.getDatabase().add(pizza); 
    
    
    Database.getDatabase().delete(evan); 
    Database.getDatabase().delete(pizza); 
          
          
    ArrayList<Owner> owners =  Database.getDatabase().selectOwner();
    ArrayList<Product> products =  Database.getDatabase().selectProduct();
          
'''

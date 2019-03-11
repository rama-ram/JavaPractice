import java.util.ArrayList;

public class Contacts {
	
	ArrayList<String> contacts;
	
	Contacts(){
		contacts = new ArrayList<String>();	
	}
	
	public void addContact(String name){
		
        if (!name.isEmpty())
            contacts.add(name.toLowerCase());
        //System.out.println("name added........" + name);
        
    }
    public void findContact(String name){
        int counter = 0;
        //System.out.println("counter is " + counter + "to find ......" + name);
        for(String contact: contacts)
        { if (contact.startsWith(name.toLowerCase())){
        counter++;
         //System.out.println("counter is " + counter);
        }
    }
        System.out.println(counter);
    }
    
    public static void main(String args[]){
    	
    	Contacts cont = new Contacts();
    	cont.addContact("test1");
    			cont.addContact("optes");
    	cont.addContact("test2");
    			cont.addContact("tes");
    			cont.findContact("tes");
    			
    }

}

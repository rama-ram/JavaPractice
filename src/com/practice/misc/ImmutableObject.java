public class ImmutableObject {

	public static void main(String args[]) {
		AddressMutable address = new AddressMutable("vijaya Street");

		EmployeeImmutable employeeImmutable = new EmployeeImmutable(1, address);
		// demo to show this is AddressMutable is an escaping reference
		AddressMutable address2 = employeeImmutable.getAddress();
		address2.setStreet("before changin street name");
		employeeImmutable.displayAll();

		address2.setStreet("i changed your street name without you knowing it");

		employeeImmutable.displayAll();
	}

}

final class EmployeeImmutable {
	private final int id;
	private AddressMutable address;

	public EmployeeImmutable(int id, AddressMutable address) {
		this.id = id;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public AddressMutable getAddress() {
		return new AddressMutable(address);
	}

	public void displayAll() {
		System.out.println("the Employee Immuatable id is : " + id + "address is : " + address.toString());
	}
}

class AddressMutable {
	private String street;

	public AddressMutable(String string) {
		this.street = string;
	}

	public AddressMutable(AddressMutable address) {
		// TODO Auto-generated constructor stub
	}

	public String getStreet() {
		return street;
	}

	public String toString() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}

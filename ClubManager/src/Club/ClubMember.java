package Club;

import java.util.ArrayList;

public class ClubMember {
	private String name;
	private String address;
	private int regYear;
	private String email;
	
	public ClubMember(String name, String address, int regYear, String email)
	{
		this.name = name;
		this.address = address;
		this.regYear = regYear;
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRegYear() {
		return regYear;
	}
	public void setRegYear(int regYear) {
		this.regYear = regYear;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void PrintMembers(ArrayList<ClubMember>clubMemberList)
	{
		
	}

	@Override
	public String toString() {
		return "ClubMember [name=" + name + ", address=" + address + ", regYear=" + regYear + ", email=" + email + "]";
	}
}

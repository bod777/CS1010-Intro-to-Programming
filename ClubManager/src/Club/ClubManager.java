package Club;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ClubManager {
	public static final int NAME = 0;
	public static final int ADDRESS = 1;
	public static final int YEAR_OF_REG = 2;
	public static final int EMAIL = 3;
	public static int groupid = 101;

	public static void main(String[]args)
	{
		ArrayList<ClubMember> clubMemberList = new ArrayList<ClubMember>();
		ArrayList<Group> groupsList = new ArrayList<Group>();
		try
		{
			FileReader fileR = new FileReader("/Users/Daniel/Documents/Trinity/Eclipse/Clubs/src/Members.txt");
			BufferedReader buffR = new BufferedReader(fileR);
			boolean endOfFile = false;
			
			while(!endOfFile)
			{
				String member = buffR.readLine();
				if(member != null)
				{
					String[]membersList = member.split(", ");
					String name = membersList[NAME];
					String address = membersList[ADDRESS];
					int regYear = Integer.parseInt(membersList[YEAR_OF_REG]);
					String email = membersList[EMAIL];
					ClubMember clubMember = new ClubMember(name, address, regYear, email);
					clubMemberList.add(clubMember);
				}
				else
				{
					endOfFile = true;
				}
				buffR.close();
				fileR.close();
			}
		}catch(FileNotFoundException e){
			System.err.println("File Not Found");
		}catch(IOException e){
			System.err.println("IO Exception");
		}
		
		ClubManager manager = new ClubManager();
		boolean quit = false;
		Scanner inputS = new Scanner(System.in);
		while(!quit)
		{
			System.out.println("Please select 1 to create a group, 2 to view club members, 3 to view details of a member...");
			
//			Assume user has selected CreateGroup and provided a group description:
			String groupDescription = "test";
			Group group = manager.createGroup(groupid++, groupDescription);
			groupsList.add(group);
			
//			User has chosen to view group members by name:
			manager.printMembers(clubMemberList);
			
//			User has selected to change user address or email and provided member's name:
			String membersName = "Jack";
			String newAddress = "Maynooth, Co Kildare";
			String newEmail = null;
			ClubMember member = manager.getMember(clubMemberList, membersName);
			manager.updateMember(member, newAddress, newEmail);
		}
		inputS.close();
	}
	
	public void printMembers(ArrayList<ClubMember>ClubMemberList)
	{
		for(int index = 0; index < ClubMemberList.size(); index++)
		{
			ClubMember clubMember = ClubMemberList.get(index);
			System.out.println(index + " - Name: " + clubMember.getName() + " Address: " + clubMember.getAddress() + " Year of registration: " 
					+ clubMember.getRegYear() + " Email: " + clubMember.getEmail());
		}
	}
	public ClubMember getMember(ArrayList<ClubMember>clubMemberList, String name)
	{
		boolean found = false;
		int index = 0;
		ClubMember member = null;
		
		while(!found && index < clubMemberList.size())
		{
			member = clubMemberList.get(index);
			if(name.equals(member))
			{
				return clubMemberList.get(index);
			}
			else
			{
				index++;
			}
		}
		return null;
	}
	public void updateMember(ClubMember member, String address, String email)
	{
		if(member != null)
		{
			if(address != null)
			{
				member.setAddress(address);
			}
			if(email != null)
			{
				member.setEmail(email);
			}			
		}
	}
	public Group createGroup(int groupid, String groupDescription)
	{
		return new Group(groupid, groupDescription, new ArrayList<ClubMember>());
	}
	public void addMemberToGroup(ClubMember member, Group group)
	{
		boolean memFound = false;
		for(int index = 0; index < group.getGroupMembers().size() || memFound == true; index++)
		{
			if(member.getName().equals(group.getGroupMembers().get(index).getName()))
			{
				memFound = true;
			}
		}
		if(memFound == false)
		{
			group.getGroupMembers().add(member);
		}
	}
	public void printGroupMembers(Group group)
	{
		if(group.getGroupMembers() != null && group.getGroupMembers().size() > 0)
		{
			for(int index = 0; index < group.getGroupMembers().size(); index++)
			{
					System.out.println(index + ": " + group.getGroupMembers().get(index).getName());
			}
		}
		else
		{
			System.out.println("Sorry, but that group is empty.");
		}
	}
	public void printGroupNamesAndNumberOfMembers(ArrayList<Group> groupsList)
	{
		if(groupsList != null && groupsList.size() > 0)
		{
			for(int index = 0; index < groupsList.size(); index++)
			{
				System.out.println("Group " + index + ":" + groupsList.get(index).getGroupDescription() + ", Number of Members: " 
						+ groupsList.get(index).getGroupMembers().size());
			}
		}
	}
}

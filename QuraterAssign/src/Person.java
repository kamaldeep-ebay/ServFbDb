
public class Person {

	String name;
	String id;
	String first_name;
	String last_name;
	String link;
	String username ;
	String birthday;
	String gender;
	String email;
	
	public Person(String name,String id,String first_name,String last_name,	String link,String username ,String birthday,
	String gender,String email) {
		// TODO Auto-generated constructor stub
		
		this.name=name;
		this.id=id;
		this.first_name=first_name;
		this.last_name=last_name;
		this.link=link;
		this.username =username;
		this.birthday=birthday;
		this.gender=gender;
		this.email=email;
		
	}
	
	public String getData()
	{
		StringBuffer strbuf = new StringBuffer();
		
		strbuf.append("name is : "+name+"\n");
		strbuf.append("id is : "+id+"\n");
		strbuf.append("First Name is : "+first_name+"\n");
		strbuf.append("Last Name is : "+last_name+"\n");
		strbuf.append("link is : "+link+"\n");
		strbuf.append("username is : "+username+"\n");
		strbuf.append("birthday is : "+birthday+"\n");
		strbuf.append("gender is : "+gender+"\n");
		strbuf.append("email is : "+email+"\n");
		
		return strbuf.toString();
		
	}
	
}

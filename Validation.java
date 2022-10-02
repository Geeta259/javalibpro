import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

public class Validation
{
	public boolean isValidString(String TextField)
	{
		boolean check=false;
		char[] character;
		
		if(TextField.length()>0)
		{
			character = TextField.toCharArray();
	for(int i=0;i<TextField.length();i++)
	{
		/*condition check it is alphabet or number ,,if any character in textfield satisfy this condition ,,then its a not a alphabet and throw error.*/
		
		if(character[i]>=33 && character[i]<=64 || character[i]>=91 &&character[i]<=96 ||character[i]==26)
		{
			check=true;
			break;

		}
		

	}


	}

	return check;
	}

 public boolean isValidNumber(String TextField)
        {
                boolean check=false;
                char[] character;
                if(TextField.length()>0)
                {
                        character = TextField.toCharArray();
                        for(int i=0;i<TextField.length();i++)
                        {

		
		/*condition check it is alphabet or number ,,if any character in textfield satisfy this condition ,,then its a not a number and throw error.*/

                                if(character[i]!='0'&&character[i]!='1'&&character[i]!='2'&&character[i]!='3'&&character[i]!='4'&&character[i]!='5'&&
                                        character[i]!='6'&&character[i]!='7'&&character[i]!='8'&&character[i]!='9')
                                {						
                                        check=true;
                                        break;
                                }
                        }
                }
                return check;
        }
        
public boolean isValidDate(String inDate)
{
		
		
		SimpleDateFormat dt=new SimpleDateFormat("dd/MM/yyyy");
		dt.setLenient(false);

		try
		{
			dt.parse(inDate.trim());
			//Date dat=dt.parse(inDate);
			
		}catch(ParseException pe)
		{
			return false;
		}	
	return true;
}

public boolean isValidEmail(String email)
{
/*tring echeck= "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z] {2,7}$";
	Pattern pat = Pattern.compile(echeck);
	if(pat.matcher(email).matches())
		return false;
	else
		return true;
	*/
	String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	return email.matches(regex);
	
	
}

}
function checkValidation()
{
    /*txtemail
txtcell
txtphone
txtstate
txtzipcode
txtadd2
txtadd1
lname	
fname
     * 
     * */
	
	
	
	var fname = document.getElementById("fname").value;
	var lanme = document.getElementById("lname").value;
	var txtadd1=document.getElementById("txtadd1").value;
	var txtadd2 = document.getElementById("txtadd2").value;
	var txtzipcode = document.getElementById("txtzipcode").value;
	var txtstate = document.getElementById("txtstate").value;
	var txtphone = document.getElementById("txtphone").value;
	var txtcell = document.getElementById("txtcell").value;
	var txtemail = document.getElementById("txtemail").value;
	
	
		    if(fname=="" || fname== null)
		    {
		    		alert("Please Enter the First Name");
		        
		        return false;
		    }
		    else
		    {
		        return true;
		    }
		    
		    
		    if(lanme=="" || lanme== null)
		    {
		    		alert("Please Enter the Last Name");
		        
		        return false;
		    }
		    else
		    {
		        return true;
		    }
		    
		    if((txtadd1=="" || txtadd1 == null) && (txtadd2=="" || txtadd2 == null))
		    {
		    		alert("Please Enter an Address");
		        
		        return false;
		    }
		    else
		    {
		        return true;
		    }
    
    
			    if(txtzipcode == "" || txtzipcode == null)
			    {
					alert("Please Enter the ZipCode");
			    
			    return false;
				}
				else
				{
				    return true;
				}
			    
			    
			    if(txtstate=="" || txtstate== null)
			    {
			    	alert("Please Enter the State");

			    		return false;
			    }
			    else
			    {
			    	return true;
			    }
			    
			    if(txtcell=="" || txtcell == null)
			    {
			    	alert("Please Enter the Cell# ");

			    	return false;
			    }
			    else
			    {
			    	return true;
			    }
			    
			    
			    if(txtphone == "" || txtphone == null)
			    {
			    	alert("Please Enter the Phone#");

			    	return false;
			    }
			    else
			    {
			    	return true;
			    }
			    
			    if(txtemail == "" || txtemail == null)
			    {
			    	alert("Please Enter the Phone#");

			    	return false;
			    }
			    else
			    {
			    	return true;
			    }
			    
}
			    
package com.asu.ss.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.mail.Session;
import javax.mail.Address;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.asu.ss.DAO.AccountsDAO;
import com.asu.ss.DAO.AllusersDAO;
import com.asu.ss.DAO.ExternalUserDAO;
import com.asu.ss.DAO.InternalUserDAO;
import com.asu.ss.DAO.MerchantClaimDAO;
import com.asu.ss.DAO.OTPDAO;
import com.asu.ss.DAO.SaltClassDAO;
import com.asu.ss.DAO.ToDoDAO;
import com.asu.ss.DAO.TransactionsDAO;
import com.asu.ss.pojo.Accounts;
import com.asu.ss.pojo.AllUsers;
import com.asu.ss.pojo.ExternalUser;
import com.asu.ss.pojo.MerchantClaim;
import com.asu.ss.pojo.OTP;
import com.asu.ss.pojo.SaltClass;
import com.asu.ss.pojo.Transactions;


public class modelClass {
	
	private static int transactionIDNumber=0;
	
	InternalUserDAO internaluserDAO;
	
	private AccountsDAO accountsDAO;
	
	private ToDoDAO todoDAO;
	
	private TransactionsDAO transactionsDAO;
	
	private OTPDAO otpDAO;
	
	private ExternalUserDAO externaluserDAO;
	
	private AllusersDAO allUsersDAO;
	
	private SaltClassDAO saltDAO;
	
	private MerchantClaimDAO merchantClaimDAO;
	
	private static String HOST = "smtp.gmail.com";
    private static String USER = "ssbankonlinebankingsystem@gmail.com";
    private static String PASSWORD = "group6@13";
    private static String PORT = "465";
    private static String FROM = "ssbankonlinebankingsystem@gmail.com";
 
    private static String STARTTLS = "true";
    private static String AUTH = "true";
    private static String DEBUG = "true";
    private static String SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    

	public modelClass() throws SQLException
	{
		
		internaluserDAO=new InternalUserDAO();
		
		accountsDAO=new AccountsDAO();
		
		todoDAO=new ToDoDAO();
		
		transactionsDAO=new TransactionsDAO();
		
		externaluserDAO=new ExternalUserDAO();
		
		otpDAO = new OTPDAO();
		
		allUsersDAO=new AllusersDAO();
		
		saltDAO=new SaltClassDAO();
		
		merchantClaimDAO=new MerchantClaimDAO();
	}
	
	public boolean verifyMerchantClaim(String merchantName, String cardNumber, String customerName, String cvv, String expiry, Integer amount) throws ParseException
	{
		
		AccountsDAO accountsDAO=new AccountsDAO();
		
		Accounts account=accountsDAO.find("cardNumber", cardNumber);
		
		Accounts merchantSelf=accountsDAO.find("userName", merchantName);
		
		ExternalUserDAO externalDAO=new ExternalUserDAO();
		
		if(account==null)
			
			return false;
		
		ExternalUser externaluser= externalDAO.find(account.getUserName());
		
		if(externaluser==null)
			
			return false;
		
		Integer cvv_account=account.getCVV();
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		
		String account_expiry=account.getCardExpiry().toString();
		
		Date accountExpiry_date=formatter.parse(account_expiry);
		
		Date expiry_userEntered=formatter.parse(expiry);
		
		if(customerName.equals(externaluser.getFirstName()+" "+externaluser.getLastName()) && (account.getBalance()>=amount) && cvv.equals(cvv_account.toString()) && accountExpiry_date.equals(expiry_userEntered))
		{
			
			account.setBalance(account.getBalance()-amount);
			
			merchantSelf.setBalance(merchantSelf.getBalance()+amount);
			
			accountsDAO.persist(account);
			
			accountsDAO.persist(merchantSelf);
			
			MerchantClaim claimTransaction=new MerchantClaim();
			
			claimTransaction.setAmount(amount);
			
			claimTransaction.setFromAccountNumber(merchantSelf.getAccountNumber());
			
			claimTransaction.setToAccountNumber(account.getAccountNumber());
			
			claimTransaction.setTransactionID(generateTransactionID()+"Merchant");		
						
			Timestamp currentTS=new Timestamp(new Date().getTime());
			
			Date currentTime=formatter.parse(currentTS.toString());
			
			claimTransaction.setTransactionDate(currentTime.toString());
			
			merchantClaimDAO.persist(claimTransaction);
			
			return true;
			
		}
		
		else
			
			
			return false;
		
	}
	
	public AllUsers hashPassword(AllUsers user) throws NoSuchAlgorithmException
	{		
		
		String password=user.getPassword();
		
		String chars = "abcdefghijklmnopqrstuvwxyz"
	            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	            + "0123456789!@%$%&^?|~'\"#+="
	            + "\\*/.,:;[]()-_<>";
	   final int PW_LENGTH = 10;
	   
	   Random rnd = new SecureRandom();
	   
	   StringBuilder salt = new StringBuilder();
	   
	   for (int i = 0; i < PW_LENGTH; i++)
	   {
		 salt.append(chars.charAt(rnd.nextInt(chars.length())));
	   }
	   
	   SaltClass saltObj=new SaltClass();
	   
	   saltObj.setSaltHash(salt.toString());
	   
	   saltObj.setUserName(user.getUserName());
	   
	   saltDAO.persist(saltObj);	   
	   
	   password=password + salt ;	   
		
		user.setPassword(passwordSalt(password));
		
		return user;
	}
	
	public String passwordSalt(String passSalt) throws NoSuchAlgorithmException
	{
		String hex="";
		
		final MessageDigest md=MessageDigest.getInstance("SHA-256");
		   
		   md.update(passSalt.getBytes());
		    
		    byte byteData[] = md.digest();
		    StringBuffer hexString = new StringBuffer();
			for (int i=0;i<byteData.length;i++) {
				hex=Integer.toHexString(0xff & byteData[i]);
				System.out.println("-----------------HEX--------------------"+hex);
			     	if(hex.length()==1) hexString.append('0');
			     	hexString.append(hex);
			}
			
			return hexString.toString();
		
	}
	
	public Transactions checkFunds(String account_to, String userName, int transferAmount)
	{
	
		Accounts from=accountsDAO.find("userName",userName);
		
		Accounts to= accountsDAO.find("accountNumber", account_to);
		
		if(to!=null && from!=null && from.getBalance()>=transferAmount)
		{			
			
			Transactions transaction=new Transactions();
			
			transaction.setTransactionID(generateTransactionID()+userName);
			
			transaction.setAmount(transferAmount);
			
			transaction.setToAccountNumber(account_to);
			
			transaction.setTransactionDate(new Date().toString());
			
			transaction.setFromAccountNumber(from.getAccountNumber());
			
			//transactionsDAO.persist(transaction);
			
			generateOTP(userName, transaction.getTransactionID());
			
			return transaction;
			
		}
		
		return null;			
		
	}
	
	public String generateTransactionID()
	{
		
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   //get current date time with Date()
		   Date date = new Date();
		   
		   Calendar cal = Calendar.getInstance();
		   
		   return dateFormat.format(cal.getTime()).toString();
		   
		
	}
	
	
	
	public Boolean changePassword(String userName, String oldPassword, String newPassword) throws NoSuchAlgorithmException
	{
		
		AllUsers user=allUsersDAO.findUser(userName);
		
		SaltClass salt=saltDAO.find("userName", userName);
		
		String hashedOld=passwordSalt(oldPassword+salt.getSaltHash());
		System.out.println(hashedOld);
		if(hashedOld.equals(user.getPassword()))
		{
			user.setPassword(newPassword);
			
			allUsersDAO.persist(hashPassword(user));
			
			if(user.getUserType().equals("Internal"))
				
				send("User name and Password",internaluserDAO.findInternalUser(userName).getEmail(), newPassword, userName);
			
			if(user.getUserType().equals("External"))
				
				send("User name and Password",externaluserDAO.find(userName).getEmail(), newPassword, userName);
			
			return true;
		}
		
		else
			
			return false;		
	}
	
	
	public Boolean ForgotPassword(String userName, String newPassword) throws NoSuchAlgorithmException
	{
		
		AllUsers user=allUsersDAO.findUser(userName);	
		
		user.setPassword(newPassword);
		
		allUsersDAO.persist(hashPassword(user));
		
		if(user.getUserType().equals("Internal"))
		
			send("User name and Password",internaluserDAO.findInternalUser(userName).getEmail(), newPassword, userName);
		
		if(user.getUserType().equals("External"))
			
			send("User name and Password",externaluserDAO.find(userName).getEmail(), newPassword, userName);
		
		System.out.println("-------NEW PASSWORD--------"+newPassword);
			
		return true;				
	}
	
	
	public void generateOTP(String userName, String transID)
	{
		
		OTP otp=new OTP();

		otp.setTransactionID(transID);
		
		otp.setUserName(userName);
		
		String chars = "abcdefghijklmnopqrstuvwxyz"
                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789!@%$%&^?|~'\"#+="
                + "\\*/.,:;[]()-_<>";

	   final int PW_LENGTH = 5;
	   
	   Random rnd = new SecureRandom();
	   
	   StringBuilder pass = new StringBuilder();
	   
	   for (int i = 0; i < PW_LENGTH; i++)
		   
	       pass.append(chars.charAt(rnd.nextInt(chars.length())));   
		
		otp.setOTP(pass.toString());
		
		Timestamp timestamp=new Timestamp(new Date().getTime());
		
	    otp.setDateOTPCreated(timestamp);
	    
	    otpDAO.persist(otp);
	    
	    ExternalUser externaluser=externaluserDAO.find(userName);
	    
	    send("OTP for your transaction",externaluser.getEmail(),otpDAO.find("transactionID",transID).getOTP(),userName);   
	 
	}
	
	public Boolean transferFunds(String TransactionID, String TransactionDate, String fromAccount, String toAccount, int transferAmount, String otp) throws ParseException
	{	
		
		Accounts to_account=accountsDAO.find("accountNumber",toAccount);
		
		Accounts from_account=accountsDAO.find("accountNumber",fromAccount);	
		
		OTP otp_transaction=otpDAO.find("transactionID",TransactionID);
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						
		String otpCreationAt=otp_transaction.getDateOTPCreated().toString();
		
		Date otpTime=formatter.parse(otpCreationAt);
		
		Timestamp currentTS=new Timestamp(new Date().getTime());
		
		Date currentTime=formatter.parse(currentTS.toString());
				
		if(otp_transaction.getOTP().equals(otp) && ((currentTime.getTime()-otpTime.getTime())<=1800000) && (transferAmount<1000000))//30 minutes!
			
		{
		
		from_account.setBalance(from_account.getBalance()-transferAmount);
		
		to_account.setBalance(to_account.getBalance()+transferAmount);
		
		accountsDAO.persist(to_account);	
		
		accountsDAO.persist(from_account);
		
		Transactions transaction=new Transactions();
		
		transaction.setTransactionID(TransactionID);
		
		transaction.setAmount(transferAmount);
		
		transaction.setToAccountNumber(toAccount);
		
		transaction.setTransactionDate(TransactionDate);
		
		transaction.setFromAccountNumber(fromAccount);
		
		transactionsDAO.persist(transaction);
		
		return true;
		
		}
		
		//If fund > 1000000 populate todo of one internal user requesting for authorization!
		
		else
			
			return false;		
	}	
	
	public void send(String subject, String toAddress, String toSend,String userName) {
		
		String Text="";
		
		if(subject.equalsIgnoreCase("OTP for your transaction"))
			
			Text="Your OTP is"+" "+toSend;
		
		else if(subject.equalsIgnoreCase("User name and Password"))
			
			Text="User name: "+userName+"\n"+"Password: "+toSend;
		
        Properties props = new Properties();
 
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.user", USER);
 
        props.put("mail.smtp.auth", AUTH);
        props.put("mail.smtp.starttls.enable", STARTTLS);
        props.put("mail.smtp.debug", DEBUG);
 
        props.put("mail.smtp.socketFactory.port", PORT);
        props.put("mail.smtp.socketFactory.class", SOCKET_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");
 
        try {
 
            //Obtain the default mail session
            Session session = Session.getDefaultInstance(props, null);
            session.setDebug(true);
 
            //Construct the mail message
            MimeMessage message = new MimeMessage(session);
            message.setText(Text);
            message.setSubject(subject);
            message.setFrom(new InternetAddress(FROM));
            message.addRecipient(RecipientType.TO, new InternetAddress(toAddress));
            message.saveChanges();
 
            //Use Transport to deliver the message
            Transport transport = session.getTransport("smtp");
            transport.connect(HOST, USER, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
 
	
	

}

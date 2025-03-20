package pojo;

public class Rest_pojo {
private String firstname;
private String lastname;
private int totalprice;
private boolean depositpaid;
private Booking_dates_pojo bookingdates;
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public int getTotalprice() {
	return totalprice;
}
public void setTotalprice(int totalprice) {
	this.totalprice = totalprice;
}
public boolean isDepositpaid() {
	return depositpaid;
}
public void setDepositpaid(boolean depositpaid) {
	this.depositpaid = depositpaid;
}
public Booking_dates_pojo getBookingdates() {
	return bookingdates;
}
public void setBookingdates(Booking_dates_pojo bookingdates) {
	this.bookingdates = bookingdates;
}
public String getAdditionalneeds() {
	return additionalneeds;
}
public void setAdditionalneeds(String additionalneeds) {
	this.additionalneeds = additionalneeds;
}
private String additionalneeds;



	
	
}

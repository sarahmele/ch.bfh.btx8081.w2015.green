package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * This class describes the "Address" Table for the Database<br>
 * <br>
 * 
 * @author Shpend Vladi, Luca Ramos<br>
 * <br>
 * 
 *         instance variables:<br>
 *         - int addressId<br>
 *         - String street<br>
 *         - String postal<br>
 *         - String city<br>
 * <br>
 *         Methods:<br>
 *         - getCity() returns String<br>
 *         - getPostal() returns String<br>
 *         - getStreet() returns String<br>
 *<br>
 *		   - setCity(String)<br>
 *  	   - setStreet(String)<br>
 * 		   - setPostal(String)<br>
 */

@Entity
public class Address {
	
	// All Attributes
	//--------------------------------------------------------------------------------
	@Id
	@GeneratedValue
	private int addressId;

	@Column
	private String street;
	@Column
	private String postal;
	@Column
	private String city;
	
	/**
	 * getStreet Method<br>
	 * The function to get the street<br><br>
	 * 
	 * @param none<br>
	 * @return street - String street
	 *   
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * setStreet Method<br>
	 * The function to set the street<br><br>
	 * @param street - String
	 *   
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * getPostal Method<br>
	 * The function to get the postal<br><br>
	 * 
	 * @param none<br>
	 * @return postal - String postal
	 *   
	 */
	public String getPostal() {
		return postal;
	}
	
	/**
	 * setPostal Method<br>
	 * The function to set the postal<br><br>
	 * @param postal - String
	 *   
	 */
	public void setPostal(String postal) {
		this.postal = postal;
	}
	
	/**
	 * getCity Method<br>
	 * The function to get the city<br><br>
	 * 
	 * @param none<br>
	 * @return city - String city
	 *   
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * setCity Method<br>
	 * The function to set the city<br><br>
	 * @param city - String
	 *   
	 */
	public void setCity(String city) {
		this.city = city;
	}
}
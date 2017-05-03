package commands;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class CommandExample {
	private String name;
	private int quantity;
	private double price;
	private Date date;
	private Boolean check;
	private MultipartFile file;
	private String select;
	private String password;
	private CommandCustom commandCustom;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public CommandCustom getCommandCustom() {
		return commandCustom;
	}
	public void setCommandCustom(CommandCustom commandCustom) {
		this.commandCustom = commandCustom;
	}
	public Boolean getCheck() {
		return check;
	}
	public void setCheck(Boolean check) {
		this.check = check;
	}
	
}

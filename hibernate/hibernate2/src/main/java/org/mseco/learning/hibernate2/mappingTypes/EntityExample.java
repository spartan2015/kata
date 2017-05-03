package org.mseco.learning.hibernate2.mappingTypes;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EntityExample {
	
	@Id
	private Long id;
	
	private boolean bool;
	private byte b;
	private int i;
	private long l;
	private short s;
	private float f;
	private double d;
	private BigDecimal bigd;	
	private String string;	
	
	@Temporal(TemporalType.DATE)
	private Date date;
	@Temporal(TemporalType.TIME)
	private Date time;
	@Temporal(TemporalType.TIMESTAMP) // will return a Timestamp
	private Date timestamp;	
	@Temporal(TemporalType.DATE)
	private Calendar calendar_timestamp;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar calendar_date;
	
	@Lob
	private byte[] byte_array;
	@Lob
	private String text;
	@Lob
	private Clob clob;
	@Lob
	private Blob blob;
		
	private AnySerializable serializable;
	
	private Class clazz;
	private Locale locale;
	private TimeZone timeZone;
	private Currency currency;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isBool() {
		return bool;
	}
	public void setBool(boolean bool) {
		this.bool = bool;
	}
	public byte getB() {
		return b;
	}
	public void setB(byte b) {
		this.b = b;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public long getL() {
		return l;
	}
	public void setL(long l) {
		this.l = l;
	}
	public short getS() {
		return s;
	}
	public void setS(short s) {
		this.s = s;
	}
	public float getF() {
		return f;
	}
	public void setF(float f) {
		this.f = f;
	}
	public double getD() {
		return d;
	}
	public void setD(double d) {
		this.d = d;
	}
	public BigDecimal getBigd() {
		return bigd;
	}
	public void setBigd(BigDecimal bigd) {
		this.bigd = bigd;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Calendar getCalendar_timestamp() {
		return calendar_timestamp;
	}
	public void setCalendar_timestamp(Calendar calendarTimestamp) {
		calendar_timestamp = calendarTimestamp;
	}
	public Calendar getCalendar_date() {
		return calendar_date;
	}
	public void setCalendar_date(Calendar calendarDate) {
		calendar_date = calendarDate;
	}
	public byte[] getByte_array() {
		return byte_array;
	}
	public void setByte_array(byte[] byteArray) {
		byte_array = byteArray;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Clob getClob() {
		return clob;
	}
	public void setClob(Clob clob) {
		this.clob = clob;
	}
	public Blob getBlob() {
		return blob;
	}
	public void setBlob(Blob blob) {
		this.blob = blob;
	}
	public AnySerializable getSerializable() {
		return serializable;
	}
	public void setSerializable(AnySerializable serializable) {
		this.serializable = serializable;
	}
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public TimeZone getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	
}

package pe.unmsm.fisi.dto;

public class Stat {

	private String countryCode;
	private Double stat;
	private int type;
	private Long month;
	private Long id;

	public Stat() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Double getStat() {
		return stat;
	}

	public void setStat(Double stat) {
		this.stat = stat;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Long getMonth() {
		return month;
	}

	public void setMonth(Long month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Stat [countryCode=" + countryCode + ", stat=" + stat + ", type=" + type + ", month=" + month + "]";
	}
}

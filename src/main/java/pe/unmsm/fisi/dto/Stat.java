package pe.unmsm.fisi.dto;

public class Stat {

	private String countryCode;
	private Double stat;
	private Integer type;
	private Integer month;
	private Integer id;

	public Stat() {
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Stat [countryCode=" + countryCode + ", stat=" + stat + ", type=" + type + ", month=" + month + "]";
	}
}

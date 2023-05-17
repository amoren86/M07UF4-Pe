package cat.institutmarianao.domain;

public class PhoneBookEntry {
	private String id;
	private String name;
	private String phone;

	public PhoneBookEntry() {
	}

	public PhoneBookEntry(String id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 71 * hash + (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final PhoneBookEntry other = (PhoneBookEntry) obj;
		return (id == null) ? (other.id == null) : id.equals(other.id);
	}

}
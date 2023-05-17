package cat.institutmarianao.domain.repository;

import java.util.List;

import cat.institutmarianao.domain.PhoneBookEntry;

public interface PhoneBookRepository {
	List<PhoneBookEntry> getAll();

	void add(PhoneBookEntry entry);

	void update(PhoneBookEntry entry);

	void delete(PhoneBookEntry entry);

	PhoneBookEntry get(String id);

	List<PhoneBookEntry> findByName(String name);

	List<PhoneBookEntry> findByPhone(String phone);

}

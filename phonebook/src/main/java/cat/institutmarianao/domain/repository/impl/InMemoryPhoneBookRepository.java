package cat.institutmarianao.domain.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cat.institutmarianao.domain.PhoneBookEntry;
import cat.institutmarianao.domain.repository.PhoneBookRepository;

@Repository
public class InMemoryPhoneBookRepository implements PhoneBookRepository {

	private final Map<String, PhoneBookEntry> phoneBook = new HashMap<>();

	public InMemoryPhoneBookRepository() {
		PhoneBookEntry[] entries = { new PhoneBookEntry("00001", "Emergencias", "112"),
				new PhoneBookEntry("00002", "Policía", "091"), new PhoneBookEntry("00003", "Guardia Civil", "062"),
				new PhoneBookEntry("00004", "Bomberos", "080"), new PhoneBookEntry("00005", "Bomberos", "085"),
				new PhoneBookEntry("00006",
						"Informar sobre accidentes o información sobre el clima y congestión de tráfico",
						"900 123 505"),
				new PhoneBookEntry("00007", "Cruz Roja Emergencias", "901 222 222"),
				new PhoneBookEntry("00008", "Instituto nacional de toxicología", "91 562 04 20"),
				new PhoneBookEntry("00009", "Teléfono Violencia de Género", "016"),
				new PhoneBookEntry("00010", "Teléfono Violencia de Género", "900 116 016"),
				new PhoneBookEntry("00011", "Información a la mujer", "900191010"),
				new PhoneBookEntry("00012", "Información a mujeres sordas", "900152152"),
				new PhoneBookEntry("00013", "Dirección General de Tráfico", "900 123 505"),
				new PhoneBookEntry("00014", "Teléfono de atención ciudadana", "060"),
				new PhoneBookEntry("00015", "Protección civil", "1006") };

		for (PhoneBookEntry entry : entries) {
			add(entry);
		}
	}

	@Override
	public List<PhoneBookEntry> getAll() {
		return new ArrayList<>(phoneBook.values());
	}

	@Override
	public void add(PhoneBookEntry phoneBookEntry) {
		phoneBook.put(phoneBookEntry.getId(), phoneBookEntry);
	}

	@Override
	public void update(PhoneBookEntry phoneBookEntry) {
		if (phoneBook.containsKey(phoneBookEntry.getId())) {
			PhoneBookEntry toUpdate = phoneBook.get(phoneBookEntry.getId());
			toUpdate.setName(phoneBookEntry.getName());
			toUpdate.setPhone(phoneBookEntry.getPhone());
		}
	}

	@Override
	public void delete(PhoneBookEntry phoneBookEntry) {
		String id = phoneBookEntry.getId();
		if (phoneBook.containsKey(id)) {
			phoneBook.remove(id);
		}
	}

	@Override
	public PhoneBookEntry get(String id) {
		return phoneBook.get(id);
	}

	@Override
	public List<PhoneBookEntry> findByName(String name) {
		List<PhoneBookEntry> result = new ArrayList<>();
		for (PhoneBookEntry entry : phoneBook.values()) {
			if (entry.getName().toUpperCase().contains(name.toUpperCase())) {
				result.add(entry);
			}
		}
		return result;
	}

	@Override
	public List<PhoneBookEntry> findByPhone(String phone) {
		List<PhoneBookEntry> result = new ArrayList<>();
		for (PhoneBookEntry entry : phoneBook.values()) {
			if (entry.getPhone().replace(" ", "").toUpperCase().contains(phone.replace(" ", "").toUpperCase())) {
				result.add(entry);
			}
		}
		return result;
	}
}

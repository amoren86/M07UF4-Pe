package cat.institutmarianao.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.junit.Test;

import cat.institutmarianao.domain.PhoneBookEntry;

public class PhoneBookRestServiceTest {
	private static final String SERVICE_URI = "http://localhost/phonebook/rest/phonebook";

	private static final Client CLIENT = ClientBuilder.newClient();

	private static final PhoneBookEntry[] PHONE_BOOK_ENTRIES = { new PhoneBookEntry("00001", "Emergencias", "112"),
			new PhoneBookEntry("00002", "Policía", "091"), new PhoneBookEntry("00003", "Guardia Civil", "062"),
			new PhoneBookEntry("00004", "Bomberos", "080"), new PhoneBookEntry("00005", "Bomberos", "085"),
			new PhoneBookEntry("00006",
					"Informar sobre accidentes o información sobre el clima y congestión de\r\n" + "tráfico",
					"900 123 505"),
			new PhoneBookEntry("00007", "Cruz Roja Emergencias", "901 222 222"),
			new PhoneBookEntry("00008", "Instituto nacional de toxicología", "91 562 04 20"),
			new PhoneBookEntry("00009", "Teléfono Violencia de Género", "016"),
			new PhoneBookEntry("00010", "Teléfono Violencia de Género", "900 116 016"),
			new PhoneBookEntry("00011", "Información a la mujer", "900 191 010"),
			new PhoneBookEntry("00012", "Información a mujeres sordas", "900 152 152"),
			new PhoneBookEntry("00013", "Dirección General de Tráfico", "900 123 505"),
			new PhoneBookEntry("00014", "Teléfono de atención ciudadana", "060"),
			new PhoneBookEntry("00015", "Protección civil", "1006") };

	@Test
	public void testGetPhonebookReturnAll() {
		/* Arrange */
		Response response = getAll();

		/* Assert */
		// Read the entity from the response in a list
		List<PhoneBookEntry> returnedEntries = response.readEntity(new GenericType<List<PhoneBookEntry>>() {
		});

		List<PhoneBookEntry> expectedEntries = Arrays.asList(PHONE_BOOK_ENTRIES);

		assertEquals(Response.Status.OK.toString(), response.getStatusInfo().toString());
		assertEquals(expectedEntries.size(), returnedEntries.size());
		assertTrue(returnedEntries.containsAll(expectedEntries));
		assertTrue(expectedEntries.containsAll(returnedEntries));
	}

	@Test
	public void testGetPhonebookIdReturnBook() {
		/* Arrange */
		PhoneBookEntry expectedEntry = PHONE_BOOK_ENTRIES[getRandomEntry()];

		Response response = get(expectedEntry.getId());

		/* Assert */
		// Check the response status
		PhoneBookEntry returnedEntry = response.readEntity(PhoneBookEntry.class);
		assertEquals(Response.Status.OK.toString(), response.getStatusInfo().toString());
		assertEquals(expectedEntry, returnedEntry);
	}

	@Test
	public void testGetPhonebookIdReturn404() {
		/* Arrange */
		Response response = get("UNKNOWN");

		/* Assert */
		// Check the response status
		assertEquals(Response.Status.NOT_FOUND.toString(), response.getStatusInfo().toString());
	}

	@Test
	public void testFindByNameReturnOK() {
		/* Arrange */
		String name = "Bomberos";

		List<PhoneBookEntry> expectedEntries = new ArrayList<>();
		for (PhoneBookEntry entry : PHONE_BOOK_ENTRIES) {
			if (entry.getName().toUpperCase().contains(name.toUpperCase())) {
				expectedEntries.add(entry);
			}
		}

		Response response = findByName(name);

		/* Assert */
		List<PhoneBookEntry> returnedEntries = response.readEntity(new GenericType<List<PhoneBookEntry>>() {
		});

		// Check the response status
		assertEquals(Response.Status.OK.toString(), response.getStatusInfo().toString());
		assertEquals(expectedEntries.size(), returnedEntries.size());
		assertTrue(returnedEntries.containsAll(expectedEntries));
		assertTrue(expectedEntries.containsAll(returnedEntries));
	}

	@Test
	public void testFindByPhoneReturnOK() {
		/* Arrange */
		String phone = "900 123";

		List<PhoneBookEntry> expectedEntries = new ArrayList<>();
		for (PhoneBookEntry entry : PHONE_BOOK_ENTRIES) {
			if (entry.getPhone().toUpperCase().contains(phone.toUpperCase())) {
				expectedEntries.add(entry);
			}
		}

		Response response = findByPhone(phone);

		/* Assert */
		List<PhoneBookEntry> returnedEntries = response.readEntity(new GenericType<List<PhoneBookEntry>>() {
		});

		// Check the response status
		assertEquals(Response.Status.OK.toString(), response.getStatusInfo().toString());
		assertEquals(expectedEntries.size(), returnedEntries.size());
		assertTrue(returnedEntries.containsAll(expectedEntries));
		assertTrue(expectedEntries.containsAll(returnedEntries));
	}

	@Test
	public void testPostPhonebookEntryReturnOK() {
		/* Arrange */
		// Prepare the entry to create
		PhoneBookEntry entry = new PhoneBookEntry("0", "TEST", "88888888888888");

		Response response = post(Entity.entity(entry, MediaType.APPLICATION_JSON));

		// Gets the URI from the response
		URI returnedUri = response.readEntity(URI.class);

		/* Assert */
		// Build the expected URI
		URI expectedUri = UriBuilder.fromUri(SERVICE_URI).port(8080).path(entry.getId()).build();

		// Check the response status
		assertEquals(Response.Status.OK.toString(), response.getStatusInfo().toString());

		// Check the uri
		assertEquals(expectedUri, returnedUri);

		/* Restore */
		// Delete expectedEntry
		delete(entry.getId());
	}

	@Test
	public void testPostPhonebookNullEntryReturn400() {
		/* Arrange */
		Response response = post(null);

		/* Assert */
		// Check the response status
		assertEquals(Response.Status.BAD_REQUEST.toString(), response.getStatusInfo().toString());
	}

	@Test
	public void testPutPhonebookEntryReturnOK() {
		/* Arrange */
		// Prepare the entry to create
		PhoneBookEntry entry = PHONE_BOOK_ENTRIES[getRandomEntry()];
		PhoneBookEntry expectedEntry = new PhoneBookEntry(entry.getId(), "MOD " + entry.getName(),
				"000 " + entry.getPhone());

		Response response = put(Entity.entity(expectedEntry, MediaType.APPLICATION_JSON));

		/* Assert */

		// Check the response status
		assertEquals(Response.Status.NO_CONTENT.toString(), response.getStatusInfo().toString());

		Response getResponse = get(expectedEntry.getId());
		PhoneBookEntry returnedEntry = getResponse.readEntity(PhoneBookEntry.class);
		assertEquals(expectedEntry, returnedEntry);

		// Restore entry
		response = put(Entity.entity(entry, MediaType.APPLICATION_JSON));

		// Check the response status
		assertEquals(Response.Status.NO_CONTENT.toString(), response.getStatusInfo().toString());

		getResponse = get(entry.getId());

		returnedEntry = getResponse.readEntity(PhoneBookEntry.class);
		assertEquals(entry, returnedEntry);
	}

	private int getRandomEntry() {
		int i = (int) (Math.random() * PHONE_BOOK_ENTRIES.length);
		return i;
	}

	private Response getAll() {
		// Prepare the URI of the ws resource to test
		URI uri = UriBuilder.fromUri(SERVICE_URI).port(8080).build();
		// Prepare the web target to invoke, from the uri
		WebTarget target = CLIENT.target(uri);

		// Prepare an invocation of the web target, accepting JSON responses for the
		// request, using GET HTTP method
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();

		// Expected PHONE_BOOK_ENTRIES for this test

		/* Act */
		// Do the invocation and get the response
		return invocation.invoke();
	}

	private Response get(String id) {
		// Prepare the URI of the ws resource to test
		URI uri = UriBuilder.fromUri(SERVICE_URI).port(8080).build();
		// Prepare the web target to invoke, adding the UNKNOWN to the uri
		WebTarget target = CLIENT.target(uri).path(id);

		// Prepare an invocation of the web target, accepting JSON responses for the
		// request, using GET HTTP method
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();

		/* Act */
		// Do the invocation and get the response
		return invocation.invoke();
	}

	private Response findByName(String name) {
		// Prepare the URI of the ws resource to test
		URI uri = UriBuilder.fromUri(SERVICE_URI).port(8080).build();
		// Prepare the web target to invoke, adding the UNKNOWN to the uri
		WebTarget target = CLIENT.target(uri).path("findByName").path(name);

		// Prepare an invocation of the web target, accepting JSON responses for the
		// request, using GET HTTP method
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();

		/* Act */
		// Do the invocation and get the response
		return invocation.invoke();
	}

	private Response findByPhone(String phone) {
		// Prepare the URI of the ws resource to test
		URI uri = UriBuilder.fromUri(SERVICE_URI).port(8080).build();
		// Prepare the web target to invoke, adding the UNKNOWN to the uri
		WebTarget target = CLIENT.target(uri).path("findByPhone").path(phone);

		// Prepare an invocation of the web target, accepting JSON responses for the
		// request, using GET HTTP method
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();

		/* Act */
		// Do the invocation and get the response
		return invocation.invoke();
	}

	private Response post(Entity<?> entity) {
		// Prepare the URI of the ws resource to test
		URI uri = UriBuilder.fromUri(SERVICE_URI).port(8080).build();
		// Prepare the web target to invoke
		WebTarget target = CLIENT.target(uri);

		// Prepare an invocation of the web target, accepting JSON responses for the
		// request, using POST HTTP method with the entry passed as JSON data
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildPost(entity);

		/* Act */
		// Do the invocation and get the response
		return invocation.invoke();
	}

	private Response put(Entity<?> entity) {
		// Prepare the URI of the ws resource to test
		URI uri = UriBuilder.fromUri(SERVICE_URI).port(8080).build();
		// Prepare the web target to invoke
		WebTarget target = CLIENT.target(uri);

		// Prepare an invocation of the web target, accepting JSON responses for the
		// request, using POST HTTP method with the entry passed as JSON data
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildPut(entity);

		/* Act */
		// Do the invocation and get the response
		return invocation.invoke();
	}

	private Response delete(String id) {
		URI uri = UriBuilder.fromUri(SERVICE_URI).port(8080).build();
		WebTarget target = CLIENT.target(uri).path(id);

		// Prepare an invocation of the web target using DELETE HTTP method with the
		// entry passed as JSON data
		Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildDelete();
		/* Act */
		// Do the invocation and get the response
		return invocation.invoke();
	}
}

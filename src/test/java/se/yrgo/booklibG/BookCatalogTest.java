package se.yrgo.booklibG;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookCatalogTest {

	private BookCatalog bc;
	private Book book1;

	public BookCatalogTest() {
		bc = new BookCatalog();
		book1 = new Book(1,"Learning Java","","","",0);
		bc.addBook(book1);
	}

	//G
	@Test
	public void testAddABook() {
		Book book2 = new Book(2, "Neuromancer", "William Gibson", "978 1 399 60777 3", "Gollancz", 297);
		bc.addBook(book2);
		try {
			Book foundBook = bc.findBook("Neuromancer");
			assertNotNull(foundBook);
			assertEquals("Neuromancer", foundBook.getTitle());
		} catch (BookNotFoundException e) {}
	}

	//G
	@Test
	public void testFindBook() {
		try {
			Book foundBook = bc.findBook("Learning Java");
		} catch (BookNotFoundException t1) {}
	}

	//G
	@Test
	public void testFindBookIgnoringCase() {
		try {
			Book foundBook = bc.findBook("leaRninG jAvA");
			assertNotNull(foundBook);
			assertEquals("Learning Java", foundBook.getTitle());
		} catch (BookNotFoundException t2) {}
	}

	//G
	@Test
	public void testFindBookWithExtraSpaces() {
		try {
			Book foundBook = bc.findBook(" Learning  Java ");
			assertNotNull(foundBook);
			assertEquals("Learning Java", foundBook.getTitle());
		} catch (BookNotFoundException t2) {}
	}

	//VG
	// This test should throw BookNotFoundException in order to pass.
	@Test
	public void testFindBookThatDoesntExist() throws BookNotFoundException {

	}

}

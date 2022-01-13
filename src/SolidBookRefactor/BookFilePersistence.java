package SolidBookRefactor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class BookFilePersistence implements BookPercitense{
	
	public void save(Book book) {
		String booksFilePath = 
				Book.BOOK_DIRECTORY_PATH + "/" + book.getTitle() + " " + new Date().getTime();
		BufferedWriter writer;
		try {
			writer  = new BufferedWriter(new FileWriter(booksFilePath));
			List<Page> pages = book.getPages();
			for(Page page: pages) {
				writer.write("......page "+ page.getNumber() + ".........");
				writer.newLine();
				writer.write(page.getContent());
				writer.newLine();
			}
			writer.close();
		}catch(IOException e) {
			throw new BookPercitenseException();
		}
		
	}
}

package com.example;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class List {
    public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			Scanner fileIn; // input file connection
			PrintWriter fileOut; // HTML file connection
			String filenameInList; // original file's name
			String filenameOut; // new HTML file's name
			int dotIndex; // position of . in filename
			String line = null; // a line from the input file

			// 1.  (or file path)

			System.out.println("Creation du fichier");
			filenameInList = "list.txt";
			// 2. check if file exists

			try {

				// Proggramme puisse lire le fichier
				fileIn = new Scanner(new FileReader(filenameInList));
				//Trouver le . avant l'extension
				dotIndex = filenameInList.lastIndexOf(".");
				if (dotIndex == -1) {
					filenameOut = filenameInList + ".html";
				} else {
					filenameOut = filenameInList.substring(0, dotIndex) + ".html";
				}
				//PrintWriter est une sous-classe de Writer, qui est utilisée pour imprimer 
				//des données formatées dans un OutputStream ou un autre Writer qu'il gère
				fileOut = new PrintWriter(filenameOut);

				// 4. determine if file is empty

				try {
					line = fileIn.nextLine();
				} catch (NoSuchElementException e) {
					System.out.println("Error: " + e.getMessage());
				}
				if (line == null) {
					System.out.println("This file is empty :(");
				} else {
					// 5. read each line and insert necessary <tags>
					fileOut.println("<html>");
					fileOut.println("<head>");
					fileOut.println("<meta charset='utf-8'>");
					fileOut.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
					fileOut.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>");
					fileOut.println("</head>");
					fileOut.println("<body'>");
					fileOut.println("<h1 class='m-5'>Liste des employées</h1>");
					fileOut.println("<div class='container m-5'>");
					fileOut.println("<div class='row'>");
					fileOut.println("<a  class='list-group-item list-group-item-action list-group-item-primary'  c.bertier.html'>");
					fileOut.println(line);
					fileOut.println("</a>");
					while (fileIn.hasNextLine()) {

						fileOut.println("<br>");
						line = fileIn.nextLine();

						if (line.isEmpty()) {
							fileOut.println("<br>");
						} else {
							fileOut.println("<div  id='btn' class='col-3 bg-light m-2 p-3'>");
							fileOut.println("<a class='list-group-item list-group-item-action list-group-item-primary' href='site_MSPR/index.html'>");
							fileOut.println(line);
							fileOut.println("</a>");
							fileOut.println("</div>");
						}

					}
					fileOut.println("</div>");
					fileOut.println("</div>");
					fileOut.println("</body>");
					fileOut.println("</html>");

					System.out.println("HTML list cree :)");
				}
				fileIn.close();
				fileOut.close();
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			}
		}

	}
}

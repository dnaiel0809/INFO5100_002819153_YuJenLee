import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

public class Main {
    public static void main(String[] args) {
        try {

            String xmlContent = "<BookShelf>\n" +
                    "    <Book>\n" +
                    "        <title>Java Programming</title>\n" +
                    "        <publishedYear>2022</publishedYear>\n" +
                    "        <numberOfPages>400</numberOfPages>\n" +
                    "        <authors>\n" +
                    "            <author>John Doe</author>\n" +
                    "            <author>Jane Doe</author>\n" +
                    "        </authors>\n" +
                    "    </Book>\n" +
                    "    <Book>\n" +
                    "        <title>Python Basics</title>\n" +
                    "        <publishedYear>2021</publishedYear>\n" +
                    "        <numberOfPages>250</numberOfPages>\n" +
                    "        <authors>\n" +
                    "            <author>Alice Smith</author>\n" +
                    "        </authors>\n" +
                    "    </Book>\n" +
                    "    <Book>\n" +
                    "        <title>Web Development</title>\n" +
                    "        <publishedYear>2023</publishedYear>\n" +
                    "        <numberOfPages>500</numberOfPages>\n" +
                    "        <authors>\n" +
                    "            <author>Bob Johnson</author>\n" +
                    "            <author>Charlie Brown</author>\n" +
                    "        </authors>\n" +
                    "    </Book>\n" +
                    "</BookShelf>\n";
            parseAndPrintXml(xmlContent);


            String jsonContent = "{\n" +
                    "  \"BookShelf\": {\n" +
                    "    \"Book\": [\n" +
                    "      {\n" +
                    "        \"title\": \"Java Programming\",\n" +
                    "        \"publishedYear\": 2022,\n" +
                    "        \"numberOfPages\": 400,\n" +
                    "        \"authors\": [\"John Doe\", \"Jane Doe\"]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"title\": \"Python Basics\",\n" +
                    "        \"publishedYear\": 2021,\n" +
                    "        \"numberOfPages\": 250,\n" +
                    "        \"authors\": [\"Alice Smith\"]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"title\": \"Web Development\",\n" +
                    "        \"publishedYear\": 2023,\n" +
                    "        \"numberOfPages\": 500,\n" +
                    "        \"authors\": [\"Bob Johnson\", \"Charlie Brown\"]\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  }\n" +
                    "}";
            parseAndPrintJson(jsonContent);

            addBookToJson(jsonContent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseAndPrintXml(String xmlContent) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(xmlContent.getBytes()));

            Element root = document.getDocumentElement();
            NodeList bookList = root.getElementsByTagName("Book");

            System.out.println("Parsed XML:");

            for (int i = 0; i < bookList.getLength(); i++) {
                Element book = (Element) bookList.item(i);
                String title = book.getElementsByTagName("title").item(0).getTextContent();
                NodeList authorsList = book.getElementsByTagName("author");
                String authors = "";

                for (int j = 0; j < authorsList.getLength(); j++) {
                    authors += authorsList.item(j).getTextContent();
                    if (j < authorsList.getLength() - 1) {
                        authors += ", ";
                    }
                }

                String publishedYear = book.getElementsByTagName("publishedYear").item(0).getTextContent();
                String numberOfPages = book.getElementsByTagName("numberOfPages").item(0).getTextContent();

                System.out.println("Title: " + title);
                System.out.println("Authors: " + authors);
                System.out.println("publishedYear: " + publishedYear);
                System.out.println("NumberOfPages: " + numberOfPages);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseAndPrintJson(String jsonContent) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonContent);

            System.out.println("Parsed JSON:\n" + jsonObject);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addBookToJson(String jsonContent) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonContent);


            JSONObject library = (JSONObject) jsonObject.get("BookShelf");
            JSONArray bookArray = (JSONArray) library.get("Book");


            JSONObject newBook = new JSONObject();
            newBook.put("title", "Intro of C/C++");
            JSONArray newAuthors = new JSONArray();
            newAuthors.add("[Daniel Lee]");
            newBook.put("authors", newAuthors);
            newBook.put("publishedYear", 1997);
            newBook.put("numberOfPages", 666);


            bookArray.add(newBook);

            System.out.println("\nUpdated JSON:\n" + jsonObject.toJSONString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
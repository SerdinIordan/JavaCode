package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * TODO Write javadoc
 */
@MultipartConfig
public class ImportFileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO 1: Obtain the username from the request instance
        String title = "Folosim metoda Post pentru a pune in DATA";
        PrintWriter out=response.getWriter();


        // Obtain the File object from the request instance
        Part file = request.getPart("uploadFile");

        // read the lines from CSV file and print the values
        // TODO 2: Replace T with Person
        List<Person> personsFromFile = readLines(file);
        // citeste datele din fiser si le pune in lista
        //trebuie Person

        // Set the response type
        response.setContentType("text/html");

        // TODO 6: Print a nice message to the response so the user will be notified of the result
        // TIP: The final text printed on the response should be something like this: "Hello <username>! You successfully imported 4 people. "
        String persons="";
        for (int i=0;i<personsFromFile.size();i++){
            persons=persons+personsFromFile.get(i);
        }
        out.write("<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<br>\n" +"Hello  "

                + request.getParameter("user") + "\n" +

                "\n" +"You successfully imported 4 people"+
                "</body> </html>" +"<br>" +persons);


    }

    /**
      TODO write javadoc
      @param file
     * @return
     */
    private List<Person> readLines(Part file) {
        List<Person> persons = new ArrayList<>();
        BufferedReader bufferedReader=null;
        Stream<String> stream=null;

        // TODO 3: Replace with try-with-resources
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            stream= bufferedReader.lines();
            persons=stream
                    .map(value->value.split(","))
                    .map(value->new Person(value[0],value[1],Long.valueOf(value[2]),Boolean.valueOf(value[3])))

                    .collect(toList());

           //persons=bufferedReader.lines()


        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO 4: Iterate through the lines of the reader using java streams.



        // TIP: Use map to get the current line
        // TIP: Use split() method for each line (check API documentation)
        // TIP: For Long and Boolean fields you should use valueOf() method
        // TIP: Use Collectors to return a List

        // after implementing the list, let's print it. It will print nicely if you have overridden the toString() method ;)

       /* persons.forEach(System.out :: println);

//        TODO 5: Sort the persons list by their age field
        try{
           persons=stream.sorted(Comparator.comparing(Person::getAge)).collect(toList());
        }catch(Exception e){
            e.printStackTrace();
        }*/

        // TIP: use lambda expression (only one line of code is needed to complete this step)


        // let's print again to check if it's sorted
        for (Person p:persons){
            System.out.println(p);
        }
       // persons.forEach(System.out :: println);

        return persons;
    }

    private class T {
    }

}

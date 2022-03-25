package mridul.rathore.shashankkenilproject.get_jsonData_from_server;

public class Note {

    String title;
    String body;

    public Note(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return
                "title= " + title+
                "\nbody= " + body ;
    }
}

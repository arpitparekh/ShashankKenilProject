package mridul.rathore.shashankkenilproject.xmlParsing;

public class News {

    String title;
    String description;

    News(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public News(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {

        description.trim();
        if(description.isEmpty()){
            return "title = " + title;
        }
        return "title = " + title+
                "\ndescription = " + description;
    }
}

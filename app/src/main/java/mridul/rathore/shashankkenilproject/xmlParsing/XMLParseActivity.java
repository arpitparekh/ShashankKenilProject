package mridul.rathore.shashankkenilproject.xmlParsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ArrayAdapter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityXmlparseBinding;

public class XMLParseActivity extends AppCompatActivity {

    private ActivityXmlparseBinding binding;
    private String url = "https://timesofindia.indiatimes.com/rssfeeds/-2128821991.cms";
    private ArrayList<News> newsArrayList;
    private News news;
    ArrayAdapter<News> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityXmlparseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        newsArrayList = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,newsArrayList);

        binding.listViewXML.setAdapter(adapter);
        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler();

        executor.execute(new Runnable() {
            @Override
            public void run() {

                SAXParserFactory factory = SAXParserFactory.newInstance();

                try {

                    SAXParser parser = factory.newSAXParser();
                    DefaultHandler defaultHandler = new DefaultHandler(){

                        boolean bTitle,bDescription;

                        @Override
                        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                            super.startElement(uri, localName, qName, attributes);

                            if(localName.equalsIgnoreCase("title")){

                                bTitle = true;
                                news = new News();
                            }
                            if(localName.equalsIgnoreCase("description")){

                                bDescription = true;
                            }

                        }

                        @Override
                        public void characters(char[] ch, int start, int length) throws SAXException {
                            super.characters(ch, start, length);

                            if(bTitle){

                                news.setTitle(new String(ch,start,length));

                            }
                            if(bDescription){
                                if(!new String(ch,start,length).trim().isEmpty()){  ///////////////////////////////////
                                    news.setDescription(new String(ch,start,length));
                                }

                            }

                        }

                        @Override
                        public void endElement(String uri, String localName, String qName) throws SAXException {
                            super.endElement(uri, localName, qName);

                            if(localName.equalsIgnoreCase("title")){

                                bTitle = false;

                            }
                            if(localName.equalsIgnoreCase("description")){

                                bDescription = false;

                                newsArrayList.add(news);

                               runOnUiThread(new Runnable() {
                                   @Override
                                   public void run() {
                                       adapter.notifyDataSetChanged();
                                       binding.listViewXML.setAdapter(adapter);
                                   }
                               });
                            }

                        }


                    };

                    parser.parse(url,defaultHandler);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }
}
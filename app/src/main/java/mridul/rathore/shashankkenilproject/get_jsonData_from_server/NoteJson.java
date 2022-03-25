package mridul.rathore.shashankkenilproject.get_jsonData_from_server;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class NoteJson{

	@SerializedName("noteJson")
	private List<NoteJsonItem> noteJson;

	public void setNoteJson(List<NoteJsonItem> noteJson){
		this.noteJson = noteJson;
	}

	public List<NoteJsonItem> getNoteJson(){
		return noteJson;
	}

	@Override
 	public String toString(){
		return 
			"NoteJson{" + 
			"noteJson = '" + noteJson + '\'' + 
			"}";
		}
}
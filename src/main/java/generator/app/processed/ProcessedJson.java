package generator.app.processed;

public class ProcessedJson {

	private String url;
	private int size;
	
	public ProcessedJson(String url, int size) {
		this.url = url;
		this.size = size;
	}
	
	public String getUrl() {
		return url;
	}
	
	public int getSize() {
		return size;
	}
}

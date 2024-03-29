package aroliveira.lab.structure.layout;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import aroliveira.lab.structure.base.EntityBean;
import aroliveira.lab.structure.util.TypedFieldConvertable;

@Entity(name="DRIVER")
public class Driver extends EntityBean{

	private static final long serialVersionUID = -8284590348914764695L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_LAYOUT")
	private Layout layout;

	@Transient
	private FileManager fileManager;

	@Transient
	private String fileName;

	public Driver(Layout layout, String fileName) {
		setLayout(layout);
		setFileName(fileName);
	}	
	
	public Layout getLayout() {
		return layout;
	}

	void setLayout(Layout layout) {
		
		if ( layout == null ) throw new RuntimeException("Layout cannot be null");

		this.layout = layout;
	}

	public String getFileName() {
		return fileName;
	}

	void setFileName(String fileName) {

		if ( fileName == null ) throw new RuntimeException("FileName cannot be null");
		
		if ( fileName.isEmpty() ) throw new RuntimeException("FileName cannot be empty");
		
		this.fileName = fileName;
	}

	public Map<String, TypedFieldConvertable> nextRegister() {
		
		if ( fileManager == null ) initializeFileManager();

		return layout.convertLine(fileManager.readLine());
	}
	
	private void initializeFileManager() {
		fileManager = new FileManager(getFileName());
	}

	@Override
	public String toString() {
		return "Driver from layout " + layout.getName();
	}

}

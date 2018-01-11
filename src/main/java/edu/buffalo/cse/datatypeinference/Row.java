package edu.buffalo.cse.datatypeinference;

import java.util.List;

public class Row {
	private Object[] data;
	public String getClassValue()
    {
        return (String)data[data.length-1];
    }
	public Object getAtIndex(int i)
    {
        return data[i];
    }
	
	public void parse( String row, List<Column> columns) {
		this.parse(row, columns, ",");
	}
	
	public void parse( String row, List<Column> columns, String delimiter) {
      String[] cols = row.split(delimiter);
      data = new Object[cols.length];

      int i = 0;
      for( Column col : columns ) {
          data[i] = col.convert(cols[i]);
          i++;
      }
  }
}

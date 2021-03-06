package edu.buffalo.cse.datatypeinference;

public class Column { //TODO Manual inspection of code before test
	
	 //private String name;
    private int index;
    private DataType type;
    private boolean process; //TODO Do we really need the bitset mask in 2018 ?

    public Column(int index) {
        this.index = index;
        //this.process = (process==1?true:false);
        //System.out.println("Set in Column constructor #"+this.index+" process? "+this.process);
    }

    public void setType(DataType type) {
        this.type = type;
        System.err.println("Created Column for #"+this.index+" "+this.type);
    }

    public DataType getType() {
        return type;
    }

    
    public Object convert( String data ) { // TODO Refer Olivers email about data type casts
        data = data.trim();
        if( type == DataType.NUMERIC ) {
           return Double.parseDouble( data );
        } else {
           return data;
        }
    }
}

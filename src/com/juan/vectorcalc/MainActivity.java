package com.juan.vectorcalc;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	private static final String TAG = "MainActivity";
	private static final String OPERATION_ARRAYLIST = null;
	private static final String VECTOR_ARRAYLIST = null;
//	private static final String OPERATION = null;
//	private static final String ANSWER = null;
	
	TextView operationText;
	String operation;
	
	Button mLparenthesesButton;
	Button mRparenthesesButton;
	Button mPlusButton;
    Button mMinusButton;
    Button mDelButton;
    
    Button mClearButton;
	Button mDotButton;
    Button mCrosssButton;
    Button mEqualButton;
 
    LinearLayout vectorLayout;
    EditText xText;
    EditText yText;
    EditText zText; 
	Button maButton;
    Button mbButton;
    Button mcButton;
    Button mdButton; 
	Button meButton;
    Button mfButton;
    Button mgButton;
    Button mhButton; 
    Button miButton;
    Button mjButton; 
    
    Vector a = new Vector(); //a = null;
    Vector b = new Vector(); //b = null;
    Vector c = new Vector(); //c = null;
    Vector d = new Vector(); //d = null;
    Vector e = new Vector(); //e = null;
    Vector f = new Vector(); //f = null;
    Vector g = new Vector(); //g = null;
    Vector h = new Vector(); //h = null;
    Vector i = new Vector(); //i = null;
    Vector j = new Vector(); //j = null;   
    
    //double e=0.0, f=0.0, g=0.0, h=0.0;
    //String e="0", f="0", g="0", h="0";
    

    TextView mVectorSelectorLabel;
    
    Button minsertButton;
    
    String xString;
    String yString;
    String zString;
    
    TextView answerText;
    
    Vector vectorSelector = null;   
    
    ArrayList<Object> operationList = new ArrayList<Object>(); // List<Object> operationList = new ArrayList<Object>();
    ArrayList<Object> vectorList = new ArrayList<Object>();
    Vector solvedVector = null;
    
    int operationCode = 0;
	//+ = 1
	//- = 2
	//. = 3
	//x = 4
    
    boolean takesVector = true;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		operationText = (TextView)findViewById(R.id.operation);
		
		mPlusButton = (Button)findViewById(R.id.buttonPlus);
		mMinusButton = (Button)findViewById(R.id.buttonMinus);
		
		mClearButton = (Button)findViewById(R.id.buttonClear);
		mDotButton = (Button)findViewById(R.id.buttonDot);
		mCrosssButton = (Button)findViewById(R.id.buttonCross); 
		
		
		vectorLayout = (LinearLayout)findViewById(R.id.vectorLayout);
		xText = (EditText)findViewById(R.id.xText);
		yText = (EditText)findViewById(R.id.yText);
		zText = (EditText)findViewById(R.id.zText);
		
		maButton = (Button)findViewById(R.id.vector_a);		
		mbButton = (Button)findViewById(R.id.vector_b);		 
		mcButton = (Button)findViewById(R.id.vector_c);		 
		mdButton = (Button)findViewById(R.id.vector_d);
		meButton = (Button)findViewById(R.id.vector_e);		
		mfButton = (Button)findViewById(R.id.vector_f);		 
		mgButton = (Button)findViewById(R.id.vector_g);		 
		mhButton = (Button)findViewById(R.id.vector_h);	
		miButton = (Button)findViewById(R.id.vector_i);	
		mjButton = (Button)findViewById(R.id.vector_j);			
		
		mVectorSelectorLabel = (TextView)findViewById(R.id.selectorLabel);
		minsertButton = (Button)findViewById(R.id.buttonInsert);
		
		answerText = (TextView)findViewById(R.id.answer);
		
		
		mPlusButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if( !operationList.isEmpty() && ( operationList.get(operationList.size() - 1).getClass() != Operator.class )){
					operationList.add(new Operator(1));
					takesVector = true;
					operationCode = 1;
					operationText.setText( operationText.getText().toString() + "+");					
				}
			}
		});
		
		mMinusButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if( !operationList.isEmpty() && operationList.get(operationList.size() - 1).getClass() != Operator.class){
					operationList.add(new Operator(2));
					takesVector = true;
					operationCode = 2;
					operationText.setText( operationText.getText().toString() + "-");					
				}
			}
		});

		mClearButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub 
				operationText.setText("");
				answerText.setText("");
				takesVector = true;
				solvedVector = null;				
				operationList.clear();   //(0, operationList.size() - 1);				
			}
		});		
		
		mDotButton.setOnClickListener(new View.OnClickListener() {	// (char)183
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if( !operationList.isEmpty() && operationList.get(operationList.size() - 1).getClass() != Operator.class){
					operationList.add(new Operator(3));
					takesVector = true;
					operationCode = 3;
					operationText.setText( operationText.getText().toString() + Character.toString((char)183) );
				}
			}
		});	
		
		mCrosssButton.setOnClickListener(new View.OnClickListener() {	// (char215)
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if( !operationList.isEmpty() && operationList.get(operationList.size() - 1).getClass() != Operator.class){
					operationList.add(new Operator(4));
					takesVector = true;
					operationCode = 4;
					operationText.setText( operationText.getText().toString() + Character.toString((char)215) );
				}
			}
		});	
		
		maButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				save();
				vectorSelector = a;
				mVectorSelectorLabel.setText("<A>");
				xText.setText( a.toStringX() );
				yText.setText( a.toStringY() );
				zText.setText( a.toStringZ() );
			}
		});	
		mbButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				save();
				vectorSelector = b;
				mVectorSelectorLabel.setText("<B>");
				xText.setText( b.toStringX() );
				yText.setText( b.toStringY() );
				zText.setText( b.toStringZ() );
			}
		});
		mcButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				save();
				vectorSelector = c;
				mVectorSelectorLabel.setText("<C>");
				xText.setText( c.toStringX() );
				yText.setText( c.toStringY() );
				zText.setText( c.toStringZ() );
			}
		});	
		mdButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				save();
				vectorSelector = d;
				mVectorSelectorLabel.setText("<D>");
				xText.setText( d.toStringX() );
				yText.setText( d.toStringY() );
				zText.setText( d.toStringZ() );
			}
		});	
		meButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				save();
				vectorSelector = e;
				mVectorSelectorLabel.setText("<E>");
				xText.setText( e.toStringX() );
				yText.setText( e.toStringY() );
				zText.setText( e.toStringZ() );
			}
		});	
		mfButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				save();
				vectorSelector = f;
				mVectorSelectorLabel.setText("<F>");
				xText.setText( f.toStringX() );
				yText.setText( f.toStringY() );
				zText.setText( f.toStringZ() );
			}
		});			
		mgButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				save();
				vectorSelector = g;
				mVectorSelectorLabel.setText("<G>");
				xText.setText( g.toStringX() );
				yText.setText( g.toStringY() );
				zText.setText( g.toStringZ() );
			}
		});	
		mhButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				save();
				vectorSelector = h;
				mVectorSelectorLabel.setText("<H>");
				xText.setText( h.toStringX() );
				yText.setText( h.toStringY() );
				zText.setText( h.toStringZ() );
			}
		});	
		miButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				save();
				vectorSelector = i;
				mVectorSelectorLabel.setText("<I>");
				xText.setText( i.toStringX() );
				yText.setText( i.toStringY() );
				zText.setText( i.toStringZ() );
			}
		});		
		miButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				save();
				vectorSelector = j;
				mVectorSelectorLabel.setText("<J>");
				xText.setText( j.toStringX() );
				yText.setText( j.toStringY() );
				zText.setText( j.toStringZ() );
			}
		});				
		
		minsertButton.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				//if (vectorSelector != null) return; // MAYBEEEEEEEEEEEEEEEEEEEE ???
				save();
				// TODO Auto-generated method stub
				if (takesVector == true )
				{	
					takesVector = false;
					//save();
					if (solvedVector != null)
					{
						//Vector vector = new Vector();
						double scalar = 0.0;
						switch (operationCode){
						case(1):
							solvedVector = solvedVector.plus(vectorSelector);
						break;
						case(2):
							solvedVector = solvedVector.minus(vectorSelector);
						break;					
						case(3):
							scalar = solvedVector.dot(vectorSelector);
							operationText.setText( operationText.getText().toString() + "<" + vectorSelector.toStringX() + "," + vectorSelector.toStringY() + "," + vectorSelector.toStringZ() + ">" );
							answerText.setText(String.valueOf(scalar));
							solvedVector = null;
							return;
						case(4):
							solvedVector = solvedVector.cross(vectorSelector);
						break;					
						}
					}
					else
					solvedVector = vectorSelector.clone();
		//			if( operationList.isEmpty() || operationList.get(operationList.size() - 1).getClass() != Vector.class){
				//	if (takesVector == true || solvedVector == null )	
					
					operationList.add(vectorSelector.clone());
					operationText.setText( "(" + operationText.getText().toString() + "<" + vectorSelector.toStringX() + "," + vectorSelector.toStringY() + "," + vectorSelector.toStringZ() + ">" + ")");
					//answerText.setText("");
					answerText.setText( "<" + solvedVector.toStringX() + "," + solvedVector.toStringY() + "," + solvedVector.toStringZ() + ">" );
				}	
				
			}	
		});	
		
		xText.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(!hasFocus)
					save();
			}
		});
		
		yText.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(!hasFocus)
					save();
			}
		});
		
		zText.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(!hasFocus)
					save();	
			}
		});
		
	} 

	public void save(){			
			if (xText.getText().toString().matches("") )
				xString = "0.0";
			else	
				xString = xText.getText().toString();
			if ( yText.getText().toString().matches("") )
				yString = "0.0";
			else	
				yString = yText.getText().toString();	
			if ( zText.getText().toString().matches("") )
				zString = "0.0";
			else	
				zString = zText.getText().toString();							
			if (vectorSelector != null)
				vectorSelector.setVector(Double.parseDouble(xText.getText().toString()), Double.parseDouble(yText.getText().toString()), Double.parseDouble(zText.getText().toString()));		
	}

	public void setVectorLabelFromIndex(int i){
		if (i == 1)
			mVectorSelectorLabel.setText("<A>");
		else if (i == 2)
			mVectorSelectorLabel.setText("<B>");		
	}
	
	public Vector getVectorFromIndex(int n){
		switch(n){
			case 1:return a;
			case 2:return b;
			case 3:return c;
			case 4:return d;
			case 5:return e;
			case 6:return f;
			case 7:return g;
			case 8:return h;
			case 9:return i;
			case 10:return j;
			default: return null;
		}
	}
	
	public int indexVectorLabel(Vector v){
		if (v == a)
			return 1;
		else if (v == b)
			return 2;
		else if (v == c)
			return 3;
		else if (v == d)
			return 4;
		else if (v == e)
			return 5;
		else if (v == f)
			return 6;
		else if (v == g)
			return 7;
		else if (v == h)
			return 8;		
		else if (v == i)
			return 9;
		else if (v == j)
			return 10;			
		return 0;	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState){
		super.onSaveInstanceState(savedInstanceState);
		//operation = operationText.getText().toString();
		savedInstanceState.putBoolean("takesVector", takesVector);
		savedInstanceState.putInt("operationCode", operationCode);
		//operationCode
		savedInstanceState.putString("ANSWER", answerText.getText().toString());
		Log.i(TAG, answerText.getText().toString() + " saved to ANSWER");
		savedInstanceState.putString("OPERATION", operationText.getText().toString());
		Log.i(TAG, operationText.getText().toString() + " saved to OPERATION");
		savedInstanceState.putInt("SELECTORLABEL", indexVectorLabel(vectorSelector));
		savedInstanceState.putParcelableArrayList(OPERATION_ARRAYLIST, (ArrayList<? extends Parcelable>) operationList.clone());
			vectorList.add(null);
			vectorList.add(a); vectorList.add(b); vectorList.add(c); vectorList.add(d); vectorList.add(e); 
			vectorList.add(f); vectorList.add(g); vectorList.add(h); vectorList.add(i); vectorList.add(j);
			vectorList.add(solvedVector);
		savedInstanceState.putParcelableArrayList(VECTOR_ARRAYLIST, (ArrayList<? extends Parcelable>) vectorList.clone());
		//solvedVector vectorSelector a-j
	}
	
	public void onRestoreInstanceState(Bundle savedInstanceState) {  
	  super.onRestoreInstanceState(savedInstanceState);
	  takesVector = savedInstanceState.getBoolean("takesVector");
	  operationCode = savedInstanceState.getInt("operationCode");
      operation = savedInstanceState.getString("OPERATION");
      //Log.i(TAG, OPERATION + " got from Bundle ");
      operationText.setText(operation);  
      answerText.setText(savedInstanceState.getString("ANSWER"));
      //Log.i(TAG, "ANSWER" + " set to TEXTBOX ");
      operationList = (ArrayList<Object>) savedInstanceState.getParcelableArrayList(OPERATION_ARRAYLIST).clone();
      vectorList = (ArrayList<Object>) savedInstanceState.getParcelableArrayList(VECTOR_ARRAYLIST).clone();
	      	a = (Vector) vectorList.get(1); b = (Vector) vectorList.get(2); c = (Vector) vectorList.get(3); d = (Vector) vectorList.get(4); e = (Vector) vectorList.get(5);
	      	f = (Vector) vectorList.get(6); g = (Vector) vectorList.get(7); h = (Vector) vectorList.get(8); i = (Vector) vectorList.get(9); j = (Vector) vectorList.get(10);
	      	vectorSelector = getVectorFromIndex(savedInstanceState.getInt("SELECTORLABEL")); setVectorLabelFromIndex(savedInstanceState.getInt("SELECTORLABEL"));
	      	solvedVector = (Vector) vectorList.get(11);
      Log.i(TAG, solvedVector + " saved to SOLVEDVECTOR");
	}	
	

}

package com.juan.vectorcalc;

import android.os.Parcel;
import android.os.Parcelable;

public class Vector implements Parcelable{
	public double x;
	public double y;
	public double z;
	
	public Vector(){
        x = y = z = 0;
    }
	
	public Vector(double xx){
        x = xx;
        y = z = 0;
    }
	
	public Vector(double xx, double yy){
        x = xx;
        y = yy;
        z = 0;
    }
	
	public Vector(double xx, double yy, double zz){
        x = xx;
        y = yy;
        z = zz;
    }
	
	public Vector(Parcel source) {
		// TODO Auto-generated constructor stub
		x = source.readDouble();
		y = source.readDouble();
		z = source.readDouble();
	}

	public void setVector(double xx, double yy, double zz){
        this.x = xx;
        this.y = yy;
        z = zz;
    }	
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public String toStringX() {
		return (Double.toString(this.x));
	}
	
	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String toStringY() {
		return (Double.toString(this.y));
	}
	
	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public String toStringZ() {
		return (Double.toString(this.z));
	}	
	
	public Vector plus(Vector vB){		
		double xx=0, yy=0, zz=0;
		
		xx = this.getX() + vB.getX();
		yy = this.getY() + vB.getY();;
		zz = this.getZ() + vB.getZ();;
		
		Vector vc = new Vector(xx,yy,zz);
		
		return (vc);
	}
	
	public Vector minus(Vector vB){		
		double xx=0, yy=0, zz=0;
		
		xx = this.getX() - vB.getX();
		yy = this.getY() - vB.getY();;
		zz = this.getZ() - vB.getZ();;
		
		Vector vc = new Vector(xx,yy,zz);
		
		return (vc);
	}	
	
	public double dot(Vector vB){
		double xx=0, yy=0, zz=0;
		
		xx = this.getX()*vB.getX();
		yy = this.getY()*vB.getY();
		zz = this.getZ()*vB.getZ();
		
		return (xx + yy + zz);
	}
	
	public Vector cross(Vector vB){		
		double xx=0, yy=0, zz=0;
		
		xx = this.getY()*vB.getZ() - (this.getZ()*vB.getY());
		yy = this.getZ()*vB.getX() - (this.getX()*vB.getZ());
		zz = this.getX()*vB.getY() - (this.getY()*vB.getX());
		
		Vector vc = new Vector(xx,yy,zz);
		
		return (vc);
	}
	
	public String toString(Vector v){
		return ( "<" + v.toStringX() + "," + v.toStringY() + "," + v.toStringZ() + ">"  );		
	}
	
	public Vector clone(){
		Vector clone = new Vector(this.x, this.y, this.z);
		return clone;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		///dest.writeString(this.toStringX());
		//dest.writeString(this.toStringY());
		//dest.writeString(this.toStringZ());
		dest.writeDouble(x);
		dest.writeDouble(y);
		dest.writeDouble(z);
		//dest.writeStringArray(new String[] {this.toStringX(), this.toStringY(), this.toStringZ()});
	}

	public void readFromParcel(Parcel in){
		// TODO Auto-generated method stub
		in.writeDouble(x);
		in.writeDouble(y);
		in.writeDouble(z);
	}	
	
	public static final Parcelable.Creator<Vector> CREATOR = new Parcelable.Creator<Vector>() {

		@Override
		public Vector createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			//return null;
			return new Vector(source);
		}

		@Override
		public Vector[] newArray(int size) {
			// TODO Auto-generated method stub
			//return null;
			return new Vector[size];
		}
		
	};
	
}
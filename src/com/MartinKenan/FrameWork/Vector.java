package com.MartinKenan.FrameWork;

public class Vector {
	
	public float x, y; //x och y positioner
	

	public Vector(float x_pos, float y_pos)
	{
		x = x_pos;
		y = y_pos;
	}
	
	public float getXPosition()
	{
		return x;
	}
	public float getYPosition()
	{
		return y;
	}
	
	public float dotProduct(Vector v1, Vector v2)
	{
		//Denna matematiska operation returnerar ett värde mellan -1 och 1. Om värdet (angle) är mindre än 0 pekar vektorerna mot/bort från
		//varandra
		
		float angle;
		angle = v1.x*v2.x + v1.y*v2.y;
		return angle;
	}
	
	public Vector addVectors(Vector v1, Vector v2)
	{
		//Addition
		return new Vector((v1.x + v2.x), (v1.x + v2.y));
		
	}
	
	public Vector subVectors(Vector v1, Vector v2)
	{
		//Subtraktion
		return new Vector((v1.x - v1.x), (v1.y - v2.y));
	}
	
	public float vectorDistans(Vector v)
	{
		//"Längden" av en vektor (t.ex beräkna vektorn mellan 2 punkter, och använd denna för att få distansen)
		return (float)Math.sqrt((v.x * v.x) + (v.y * v.y));
	
	}
	
	public Vector UnitVect(Vector v)
	{
		//Normalisering av vektor. JÄVLIGT VIKTIGT!
		float magnitude = vectorDistans(v);
		return new Vector((v.x/magnitude),(v.y/magnitude)); 
	}
}

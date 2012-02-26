package de.makiart.engine.view;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public abstract class Shape extends ViewComponent {
	
	//	Buffers
	public 		FloatBuffer 	verticesBuffer;
	public 		ShortBuffer 	indicesBuffer;
	public	 	FloatBuffer 	colorBuffer;
	public	 	float[]			rgba = new float[4];	
	private 	int 			numOfIndices;
	
	//	Translate params
	private		float			x 	= 	0;
	private 	float			y	=	0;
	private		float			z	=	0;
	
	//	Rotate Perams
	private 	float			rx	=	0;
	private		float			ry	=	0;
	private		float			rz	=	0;
	
	

	protected void setVertices(float[] vertices) {
		// a float is 4 bytes, therefore we multiply the number if
		// vertices with 4.
		ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
		vbb.order(ByteOrder.nativeOrder());
		verticesBuffer = vbb.asFloatBuffer();
		verticesBuffer.put(vertices);
		verticesBuffer.position(0);
	}
	 
	protected void setIndices(short[] indices) {
		// short is 2 bytes, therefore we multiply the number if
		// vertices with 2.
		ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);
		ibb.order(ByteOrder.nativeOrder());
		indicesBuffer = ibb.asShortBuffer();
		indicesBuffer.put(indices);
		indicesBuffer.position(0);
		numOfIndices = indices.length;
	}
	 
    protected void setColor(float red, float green, float blue, float alpha) {
        // Setting the flat color.
        rgba[0] = red;
        rgba[1] = green;
        rgba[2] = blue;
        rgba[3] = alpha;
    }	 
    
	/*
    protected void setColors(float[] colors) {
		// float has 4 bytes.
		ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length * 4);
		cbb.order(ByteOrder.nativeOrder());
		colorBuffer = cbb.asFloatBuffer();
		colorBuffer.put(colors);
		colorBuffer.position(0);
    }
    */
    
   @Override
   protected void draw(GL10 gl) {
	   gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
	   gl.glVertexPointer(3, GL10.GL_FLOAT, 0, verticesBuffer);
    // gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
	   gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
	   gl.glColor4f(rgba[0], rgba[1], rgba[2], rgba[3]);
   	
   

	   gl.glDrawElements(GL10.GL_TRIANGLES, numOfIndices, GL10.GL_UNSIGNED_SHORT, indicesBuffer);
   	
   	//	Disable the client state before leaving
    // 	gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

   }

    public void setPosition( int X, int Y) {
    	x = X;
    	y = Y;    	
    }
    
    public float getX() {
    	return x;
    }
    
    public float getY() {
    	return y;
    }
    

}
